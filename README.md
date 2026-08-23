<p align="center">
  <img src="https://raw.githubusercontent.com/Hinderchik/XunLauncher/master/app_pojavlauncher/src/main/res/drawable-xxxhdpi/notif_icon.png" width="96" height="96" alt="XunLauncher Icon">
</p>

<h1 align="center">XunLauncher</h1>
<h3 align="center">Minecraft: Java Edition на Android — с расширенной графикой</h3>

<p align="center">
  <a href="https://github.com/Hinderchik/XunLauncher/releases">
    <img src="https://img.shields.io/github/v/release/Hinderchik/XunLauncher?style=for-the-badge&logo=github&color=blue" alt="GitHub release">
  </a>
  <a href="https://github.com/Hinderchik/XunLauncher/actions">
    <img src="https://img.shields.io/github/actions/workflow/status/Hinderchik/XunLauncher/build.yml?style=for-the-badge&logo=githubactions&color=orange" alt="Build Status">
  </a>
  <a href="https://www.gnu.org/licenses/lgpl-3.0.html">
    <img src="https://img.shields.io/badge/License-LGPL%20v3-blue.svg?style=for-the-badge&logo=gnu&color=green" alt="License">
  </a>
  <a href="https://github.com/Hinderchik/XunLauncher/stargazers">
    <img src="https://img.shields.io/github/stars/Hinderchik/XunLauncher?style=for-the-badge&logo=github&color=yellow" alt="Stars">
  </a>
</p>

---

## 🎮 О проекте

**XunLauncher** — это форк [MojoLauncher](https://github.com/MojoLauncher/MojoLauncher), который позволяет запускать **Minecraft: Java Edition** на устройствах с **Android**.

Главное отличие — **расширенная поддержка графических рендеров**, включая **MobileGlues** и множество других бэкендов для максимальной совместимости и производительности.

---

## ✨ Возможности

| | |
|---|---|
| 🚀 | Запуск почти всех версий Minecraft — от rd-132211 до 26.x снапшотов |
| 📦 | Установка Forge, Fabric, NeoForge и других модлоадеров |
| 🖥️ | Полноценная поддержка LWJGL2, LWJGL3 и GLFW |
| 🌍 | Мультиязычный интерфейс |
| ⚡ | **12+ графических рендеров** на выбор |

---

## 🎨 Поддерживаемые рендеры

| Рендер | Описание | Рекомендация |
|--------|----------|--------------|
| **Holy GL4ES** | Стандартный рендер, работает на всех устройствах | 🟢 Универсальный |
| **Zink (Vulkan)** | Рендеринг через Vulkan | 🟡 Для современных устройств |
| **Freedreno** | Open-source драйвер для Adreno GPU | 🟢 Для Snapdragon |
| **LTW** | OpenGL Core на GLES-обёртке | 🟢 Для 1.17+ |
| **MobileGlues** | OpenGL 4.0 на GLES 3 | 🟢 С поддержкой шейдеров |
| **ANGLE (Vulkan)** | Google-реализация GLES через Vulkan | 🟡 Экспериментальный |
| **ANGLE (DirectX)** | Google-реализация GLES через DirectX | 🟡 Для эмуляции |
| **VirGL** | Виртуальный GPU (для эмуляторов) | 🟡 Для VM |
| **SwiftShader** | Программный рендеринг на CPU | 🔴 Для отладки |
| **Panfrost** | Open-source драйвер для Mali GPU | 🟢 Для Mali |
| **Turnip** | Open-source драйвер для Adreno GPU | 🟢 Для Snapdragon |
| **LLVMpipe** | Программный рендеринг (CPU) | 🔴 Для отладки |

---

## 📥 Скачать

| Способ | Ссылка |
|--------|--------|
| **Стабильные сборки** | [Releases](https://github.com/Hinderchik/XunLauncher/releases) |
| **Ночные сборки** | [GitHub Actions](https://github.com/Hinderchik/XunLauncher/actions) |
| **Google Play** | *Скоро* |

---

## 🛠️ Сборка из исходников

### Требования
- JDK 17+
- Android SDK

### Команды

#### Linux / macOS
```bash
./gradlew :app_pojavlauncher:assembleDebug
```

#### Windows
```bash
.\gradlew.bat :app_pojavlauncher:assembleDebug
```

Все необходимые компоненты загрузятся автоматически.

---

## 📋 План развития

- [x] Интеграция MobileGlues
- [x] Добавление 7 новых рендеров
- [ ] Система инстансов вместо профилей
- [ ] Поддержка 1.21.5 «из коробки»
- [ ] Импорт `.mrpack` и CurseForge `.zip`
- [ ] Исправление проблем с модом Create
- [ ] Менеджер модов и модпаков

---

## ⚠️ Известные проблемы

| Проблема | Решение / Статус |
|----------|------------------|
| Низкая скорость мыши на некоторых физических мышах | В работе |
| Искажения текстурных атласов на Holy GL4ES | В работе |
| Другие баги | См. [Issues](https://github.com/Hinderchik/XunLauncher/issues) |

---

## 🤝 Участие в разработке

Мы открыты к сотрудничеству!

- 🐛 **Баги** — создавайте Issues с подробным описанием
- 🌐 **Переводы** — помогайте через Crowdin
- 💻 **Код** — присылайте Pull Requests

---

## 📜 Лицензия и благодарности

**Лицензия**: GNU LGPLv3

### Использованные проекты

| Проект | Лицензия |
|--------|----------|
| [PojavLauncher](https://github.com/PojavLauncherTeam/PojavLauncher) | GNU LGPLv3 |
| [MojoLauncher](https://github.com/MojoLauncher/MojoLauncher) | GNU LGPLv3 |
| [MobileGlues](https://github.com/mobileglues/mobileglues) | GNU LGPL-2.1 |
| OpenJDK | GNU GPLv2 |
| GLFW | zlib |
| LWJGL2 / LWJGL3 | BSD |
| Mesa 3D | MIT |
| Authlib-Injector | AGPL-3.0 |

Полный список — в файле LICENSE.

---

## 📱 Скриншоты

> *Скоро появятся скриншоты с демонстрацией работы XunLauncher и всех рендеров!*

---

## 📬 Связь

- [Issues](https://github.com/Hinderchik/XunLauncher/issues) — баги и предложения

---

<p align="center">
  <a href="https://github.com/Hinderchik/XunLauncher">
    <img src="https://img.shields.io/badge/⭐%20Star%20on%20GitHub-30363D?style=for-the-badge&logo=github" alt="Star on GitHub">
  </a>
  <a href="https://github.com/Hinderchik/XunLauncher/fork">
    <img src="https://img.shields.io/badge/🍴%20Fork%20on%20GitHub-30363D?style=for-the-badge&logo=github" alt="Fork on GitHub">
  </a>
</p>

---

<p align="center">
  <b>С XunLauncher ваш Android — это полноценная платформа для Minecraft: Java Edition!</b>
</p>
