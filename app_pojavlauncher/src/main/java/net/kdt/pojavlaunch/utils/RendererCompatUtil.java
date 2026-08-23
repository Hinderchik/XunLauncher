package net.kdt.pojavlaunch.utils;

import static android.os.Build.VERSION.SDK_INT;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;

import net.kdt.pojavlaunch.Architecture;
import net.kdt.pojavlaunch.Tools;
import net.kdt.pojavlaunch.plugins.LibraryPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import git.artdeell.mojo.R;

public class RendererCompatUtil {
    private static RenderersList sCompatibleRenderers;

    public static boolean checkVulkanSupport(PackageManager packageManager) {
        if(SDK_INT >= Build.VERSION_CODES.N) {
            return packageManager.hasSystemFeature(PackageManager.FEATURE_VULKAN_HARDWARE_LEVEL) &&
                    packageManager.hasSystemFeature(PackageManager.FEATURE_VULKAN_HARDWARE_VERSION);
        }
        return false;
    }

    private static String findVirGLPath() {
        String[] paths = {"/vendor/lib64/libvirglrenderer.so", "/system/lib64/libvirglrenderer.so", "/vendor/lib/libvirglrenderer.so", "/system/lib/libvirglrenderer.so"};
        for (int i = 0; i < paths.length; i++) {
            if (new File(paths[i]).exists()) return paths[i];
        }   
        return null;
    }

    private static String findSwiftShaderPath() {
        String[] paths = {"/system/lib64/libswiftshader_libGLESv2.so", "/system/lib/libswiftshader_libGLESv2.so", "/vendor/lib64/libswiftshader_libGLESv2.so", "/vendor/lib/libswiftshader_libGLESv2.so"};
        for (int i = 0; i < paths.length; i++) {
            if (new File(paths[i]).exists()) return paths[i];
        }   
        return null;
    }   

    private static String findPanfrostPath() {
        String[] paths = {"/vendor/lib64/libPanfrost.so", "/system/lib64/libPanfrost.so", "/vendor/lib/libPanfrost.so", "/system/lib/libPanfrost.so"};
        for (int i = 0; i < paths.length; i++) {
            if (new File(paths[i]).exists()) return paths[i];
        }   
        return null;
    }

    private static String findTurnipPath() {
        String[] paths = {"/vendor/lib64/libvulkan_turnip.so", "/system/lib64/libvulkan_turnip.so", "/vendor/lib/libvulkan_turnip.so", "/system/lib/libvulkan_turnip.so"};
        for (int i = 0; i < paths.length; i++) {
            if (new File(paths[i]).exists()) return paths[i];
        }           
        return null;
    }

    private static String findLLVMpipePath() {
        String[] paths = {"/vendor/lib64/libllvmpipe.so", "/system/lib64/libllvmpipe.so", "/vendor/lib/libllvmpipe.so", "/system/lib/libllvmpipe.so"};
        for (int i = 0; i < paths.length; i++) {
            if (new File(paths[i]).exists()) return paths[i];
        } 
        return null;
    }

    /** Return the renderers that are compatible with this device */
    public static RenderersList getCompatibleRenderers(Context context) {
        if(sCompatibleRenderers != null) return sCompatibleRenderers;
        Resources resources = context.getResources();
        String[] defaultRenderers = resources.getStringArray(R.array.renderer_values);
        String[] defaultRendererNames = resources.getStringArray(R.array.renderer);
        boolean deviceHasVulkan = checkVulkanSupport(context.getPackageManager());
        // Current Mesa requires API29+
        boolean deviceCompatibleMesa = SDK_INT >= 29 && new File(Tools.NATIVE_LIB_DIR, "libEGL_mesa.so").exists();
        boolean deviceHasOpenGLES3 = JREUtils.getDetectedVersion() >= 3;
        // LTW is an optional dependency
        boolean appHasLtw = new File(Tools.NATIVE_LIB_DIR, "libltw.so").exists();
        LibraryPlugin mobileGlues = LibraryPlugin.discoverPlugin(context, LibraryPlugin.ID_MOBILEGLUES_PLUGIN);
        boolean hasMobileGlues = mobileGlues != null && mobileGlues.checkLibraries("libmobileglues.so");
        LibraryPlugin anglePlugin = LibraryPlugin.discoverPlugin(context, "com.google.angle");
        boolean hasAngle = anglePlugin != null && anglePlugin.checkLibraries("libGLESv2_angle.so");
        boolean hasVirGL = findVirGLPath() != null;
        boolean hasSwiftShader = findSwiftShaderPath() != null;
        boolean hasPanfrost = findPanfrostPath() != null;
        boolean hasTurnip = findTurnipPath() != null;
        boolean hasLLVMpipe = findLLVMpipePath() != null;
        boolean isMali = GLInfoUtils.getGlInfo().isArm();
        boolean isAdreno = GLInfoUtils.getGlInfo().isAdreno();
        List<String> rendererIds = new ArrayList<>(defaultRenderers.length);
        List<String> rendererNames = new ArrayList<>(defaultRendererNames.length);
        for(int i = 0; i < defaultRenderers.length; i++) {
            String rendererId = defaultRenderers[i];
            if(rendererId.contains("vulkan") && !deviceHasVulkan) continue;
            if(rendererId.contains("zink") && !deviceCompatibleMesa) continue;
            // freedreno is available only on Adreno GPUs
            if(rendererId.contains("freedreno") && (!(GLInfoUtils.getGlInfo().isAdreno()) || !deviceCompatibleMesa)) continue;
            if(rendererId.contains("ltw") && (!deviceHasOpenGLES3 || !appHasLtw)) continue;
            if(rendererId.contains("mobileglues") && (!deviceHasOpenGLES3 || !hasMobileGlues)) continue;
            if(rendererId.contains("angle") && !hasAngle) continue;
            if(rendererId.contains("virgl") && !hasVirGL) continue;
            if(rendererId.contains("swiftshader") && !hasSwiftShader) continue;
            if(rendererId.contains("panfrost") && (!hasPanfrost || !isMali)) continue;
            if(rendererId.contains("turnip") && (!hasTurnip || !isAdreno)) continue;
            if(rendererId.contains("llvmpipe") && !hasLLVMpipe) continue;
            rendererIds.add(rendererId);
            rendererNames.add(defaultRendererNames[i]);
        }
        sCompatibleRenderers = new RenderersList(rendererIds,
                rendererNames.toArray(new String[0]));

        return sCompatibleRenderers;
    }

    /** Checks if the renderer Id is compatible with the current device */
    public static boolean checkRendererCompatible(Context context, String rendererName) {
         return getCompatibleRenderers(context).rendererIds.contains(rendererName);
    }

    /** Releases the cache of compatible renderers. */
    public static void releaseRenderersCache() {
        sCompatibleRenderers = null;
        System.gc();
    }

    public static class RenderersList {
        public final List<String> rendererIds;
        public final String[] rendererDisplayNames;

        public RenderersList(List<String> rendererIds, String[] rendererDisplayNames) {
            this.rendererIds = rendererIds;
            this.rendererDisplayNames = rendererDisplayNames;
        }
    }
}
