<img src="https://raw.githubusercontent.com/MojoLauncher/MojoLauncher/master/app_pojavlauncher/src/main/res/mipmap-xxxhdpi/ic_launcher.png" width="48" height="48" alt="XunLauncher Icon"> XunLauncher

### **Minecraft: Java Edition на Android — с улучшенной графикой**

[![GitHub release](https://img.shields.io/github/v/release/Hinderchik/XunLauncher?style=for-the-badge&logo=github)](https://github.com/Hinderchik/XunLauncher/releases)
[![GitHub Actions Workflow Status](https://img.shields.io/github/actions/workflow/status/Hinderchik/XunLauncher/build.yml?style=for-the-badge&logo=githubactions)](https://github.com/Hinderchik/XunLauncher/actions)
[![License](https://img.shields.io/badge/License-LGPL%20v3-blue.svg?style=for-the-badge&logo=gnu)](https://www.gnu.org/licenses/lgpl-3.0.html)

---

## 🚀 О проекте

**XunLauncher** — это мощный форк [MojoLauncher](https://github.com/MojoLauncher/MojoLauncher), созданный для того, чтобы выжать максимум из вашего Android-устройства в Minecraft: Java Edition.

### ✨ Ключевые особенности

- 🎮 **Запуск почти всех версий** — от rd-132211 до последних снапшотов 26.x
- 📦 **Поддержка модлоадеров** — Forge, Fabric и другие через `.jar`-установщики
- 🖥️ **Полноценный рендеринг** — LWJGL2, LWJGL3, GLFW
- 🌍 **Мультиязычность** — интерфейс на многих языках мира

---

## 🔥 Что нового в XunLauncher?

### ⚡ Интеграция MobileGlues

Этот форк включает **MobileGlues** — библиотеку, которая значительно расширяет графические возможности:

- ✅ **Более широкая совместимость** с различными GPU и драйверами
- ✅ **Улучшенная производительность** за счёт оптимизаций рендеринга
- ✅ **Поддержка сложных шейдеров** и текстурных атласов, которые ранее могли работать некорректно
- ✅ **Стабильность** на устройствах с экзотическими графическими чипами

Теперь вы можете наслаждаться тяжёлыми модпаками и красивой графикой без лишних «артефактов» и тормозов!

---

## 📥 Скачать

Вы можете получить XunLauncher несколькими способами:

| Способ | Описание |
|--------|----------|
| [**Releases**](https://github.com/Hinderchik/XunLauncher/releases) | Стабильные сборки |
| **Google Play** | (скоро) |
| [**GitHub Actions**](https://github.com/Hinderchik/XunLauncher/actions) | Свежие ночные сборки |
| **Сборка из исходников** | Инструкции ниже |

---

## 🛠️ Сборка из исходников

Для сборки вам потребуется JDK 17+ и Android SDK.

### На Linux / macOS
```bash
./gradlew :app_pojavlauncher:assembleDebug
```

### На Windows
```bash
.\gradlew.bat :app_pojavlauncher:assembleDebug
```

Сборка автоматически загрузит все необходимые компоненты (OpenJDK, библиотеки рендеринга и т.д.).

---

## 📋 Текущий план развития

- [x] Интеграция MobileGlues
- [ ] Полноценная система инстансов вместо профилей
- [ ] Поддержка 1.21.5 «из коробки»
- [ ] Импорт модпаков `.mrpack` и CurseForge `.zip`
- [ ] Исправление проблем с Create и другими сложными модами
- [ ] Улучшенный менеджер модов и модпаков

---

## ⚠️ Известные проблемы

- На некоторых физических мышах скорость курсора может быть низкой
- На некоторых устройствах с Holy GL4ES могут быть искажения больших текстурных атласов
- Остальные баги — см. [Issues](https://github.com/Hinderchik/XunLauncher/issues)

---

## 🤝 Участие в разработке

Мы приветствуем любые вклады!

- 🐛 **Сообщайте об ошибках** — создавайте Issues
- 🌐 **Помогайте с переводами** — мы используем Crowdin
- 💻 **Присылайте Pull Requests** — с описанием изменений

---

## 📜 Лицензия

Проект распространяется под лицензией **GNU LGPLv3**.

### Благодарности и сторонние компоненты

| Компонент | Лицензия |
|-----------|----------|
| [PojavLauncher](https://github.com/PojavLauncherTeam/PojavLauncher) | GNU LGPLv3 |
| [MojoLauncher](https://github.com/MojoLauncher/MojoLauncher) | GNU LGPLv3 |
| [MobileGlues](https://github.com/mobileglues/mobileglues) | MIT |
| OpenJDK | GNU GPLv2 |
| GLFW | zlib |
| LWJGL2 / LWJGL3 | BSD |
| Mesa 3D | MIT |
| Authlib-Injector | AGPL-3.0 |
| И другие... | См. полный список в LICENSE |

---

## 📱 Скриншоты

> *Скоро здесь появятся скриншоты с демонстрацией работы MobileGlues!*

---

## 📧 Контакты

- **GitHub Issues** — для багов и предложений
- **Telegram** — (скоро)

---

<p align="center">
  <b>Играйте в Minecraft на Android с XunLauncher — графикой, которую вы заслуживаете!</b>
</p>

<p align="center">
  <a href="https://github.com/Hinderchik/XunLauncher">
    <img src="https://img.shields.io/badge/⭐%20Star%20on%20GitHub-30363D?style=for-the-badge&logo=github" alt="Star on GitHub">
  </a>
</p>

---

Этот README готов к использованию. Вы можете дополнить его реальными скриншотами и ссылками по мере развития проекта.
