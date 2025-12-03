# Journey Mode

[![Minecraft](https://img.shields.io/badge/Minecraft-1.21.x-green.svg)](https://www.minecraft.net/)
[![Fabric](https://img.shields.io/badge/Fabric-0.16.9-blue.svg)](https://fabricmc.net/)
[![NeoForge](https://img.shields.io/badge/NeoForge-21.1.80-orange.svg)](https://neoforged.net/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

> **Note:** This is an improved fork with critical bug fixes and quality-of-life features for Fabric 1.21.x. See [CHANGELOG.md](CHANGELOG.md) for detailed changes.

## 🎮 What is Journey Mode?

Journey Mode is a Minecraft mod that introduces a Terraria-inspired research and duplication system. Collect items through normal gameplay, deposit them to "research" them, and once unlocked, obtain infinite copies without using resources!

Perfect for builders, redstone engineers, and anyone who wants to focus on creativity rather than resource gathering.

## 🌟 Fork Improvements (v1.6.1-fabric)

This fork addresses critical stability issues and adds requested features:

### 🔧 Critical Fixes
- ✅ **Data Persistence:** Player progress now properly saves and loads (JSON-based system)
- ✅ **Crash Prevention:** Fixed packet registration errors that caused crashes
- ✅ **Menu Opening:** Resolved GUI not appearing when pressing 'J' key
- ✅ **Item Overflow:** Excess items now correctly remain in deposit slot

### ✨ New Features
- 🔊 **Custom Sounds:** 3-sound system with random progress sounds
- 🔍 **Better UX:** Fixed search box keyboard conflicts
- 📝 **Translations:** Added missing menu title translation

**Full details:** [CHANGELOG.md](CHANGELOG.md)

---

## 📸 Screenshots

| Deposit Tab - Empty | Deposit Tab - With Item | Journey Tab - Unlocked Items |
|:---:|:---:|:---:|
| ![Deposit Empty](https://via.placeholder.com/250x150?text=Deposit+Empty) | ![Deposit Item](https://via.placeholder.com/250x150?text=Deposit+Item) | ![Journey Tab](https://via.placeholder.com/250x150?text=Journey+Items) |

## ✨ Features

### Core Gameplay
- **Research System:** Deposit items to unlock infinite duplication
- **Threshold-Based:** Each item has a unique research requirement (auto-calculated from recipes)
- **Two Tabs:**
  - **Deposit:** Place items to research them
  - **Journey:** Access and duplicate unlocked items

### Player Control
- **Keybinding:** Press `J` to open the Journey Mode menu (configurable)
- **Commands:**
  - `/journeymode on` - Enable Journey Mode
  - `/journeymode off` - Disable Journey Mode
  - `/journeymode status` - Check current status

### Configuration
- **Custom Thresholds:** Override default item requirements
- **Blacklist System:** Prevent specific items from being researched
- **JSON-Based:** Easy configuration files in `config/journeymode/`

### Multi-Loader Support
- ✅ **Fabric** 1.21.x (Stable)
- ✅ **NeoForge** 1.21.1 (Stable)

## 📦 How It Works

1. **Collect Items:** Play normally and gather items
2. **Open Menu:** Press `J` to open Journey Mode
3. **Deposit Items:** Place items in the deposit slot
4. **Research Progress:** Each item has a threshold (e.g., 32 for common items, 192+ for rare ones)
5. **Unlock:** Once threshold is met, the item is permanently unlocked
6. **Duplicate:** Access unlocked items infinitely from the Journey tab

**Threshold Calculation:**
- Recipe depth (crafting complexity)
- Item rarity
- Stack size
- Custom overrides (configurable)

## 🚀 Installation

### Requirements
- Minecraft 1.21+ / 1.21.1
- Fabric Loader 0.16.9+ or NeoForge 21.1.80+
- Fabric API (if using Fabric)

### Download
1. Download the latest release from [Releases](https://github.com/Aryangpt007/Journey-Mode/releases)
   - `journey-mode-1.6.1-fabric.jar` for Fabric
   - `journey-mode-1.6.0-neoforge.jar` for NeoForge

### Installation Steps
1. Install [Fabric](https://fabricmc.net/use/) or [NeoForge](https://neoforged.net/)
2. Place the mod JAR in `.minecraft/mods/`
3. Launch Minecraft
4. Press `J` in-game to open Journey Mode!

## 📖 How to Use

### Getting Started
1. Enable Journey Mode: `/journeymode on`
2. Press `J` to open the menu
3. Switch to **Deposit** tab
4. Place an item in the deposit slot
5. Click **Submit** button
6. Watch progress towards unlocking!

### Understanding Thresholds
- **Common Items:** 32-64 items
- **Intermediate Items:** 64-128 items
- **Complex Items:** 128-256 items
- **Rare/End-game Items:** 256+ items

Check threshold in real-time by hovering over items in the deposit slot!

### Commands
```
/journeymode on      # Enable Journey Mode
/journeymode off     # Disable Journey Mode
/journeymode status  # Check if enabled
```

## ⚙️ Configuration

Configuration files are located in `config/journeymode/`:

### `blacklist.json`
```json
{
  "blacklisted_items": [
    "minecraft:bedrock",
    "minecraft:command_block"
  ]
}
```

### `custom_thresholds.json`
```json
{
  "minecraft:diamond": 64,
  "minecraft:netherite_ingot": 256
}
```

## 🗺️ Roadmap

### Current Status
- ✅ Core research system (Stable)
- ✅ Data persistence (Fixed in v1.6.1)
- ✅ Multi-loader support
- ✅ Custom sounds system
- ✅ Configuration system

### Future Plans
- 🔄 Creative mode integration
- 🔄 Statistics tracking
- 🔄 Multiplayer sync improvements
- 🔄 Item categories/filters

## 📊 Version Support Matrix

| Minecraft | Fabric | NeoForge | Status |
|:---------:|:------:|:--------:|:------:|
| 1.21.x | ✅ v1.6.1 | ✅ v1.6.0 | **Stable** |
| 1.20.x | ❌ | ❌ | Not Supported |

## 🔧 Development Setup

### Prerequisites
- JDK 21
- Gradle (included via wrapper)

### Building from Source
```bash
# Clone the repository
git clone https://github.com/Aryangpt007/Journey-Mode.git
cd Journey-Mode

# Build Fabric version
./gradlew :fabric-1.21.x:build

# Build NeoForge version
./gradlew :neoforge-1.21.1:build

# Output JARs will be in:
# fabric-1.21.x/build/libs/
# neoforge-1.21.1/build/libs/
```

### Running in Development
```bash
# Fabric
./gradlew :fabric-1.21.x:runClient

# NeoForge
./gradlew :neoforge-1.21.1:runClient
```

### Project Structure
```
Journey-Mode/
├── common/              # Shared code (data, logic, config)
├── fabric-1.21.x/      # Fabric-specific implementation
├── neoforge-1.21.1/    # NeoForge-specific implementation
└── gradle/             # Build configuration
```

## 🐛 Known Issues

See [Issues](https://github.com/Aryangpt007/Journey-Mode/issues) for active bugs and feature requests.

**Reporting Bugs:** Please include:
- Minecraft version
- Mod loader + version
- Crash logs (if applicable)
- Steps to reproduce

## 🤝 Contributing

Contributions are welcome! Please read [CONTRIBUTING.md](CONTRIBUTING.md) first.

**Quick Start:**
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a Pull Request

## 📋 Changelog

See [CHANGELOG.md](CHANGELOG.md) for detailed version history.

## 📄 License

This project is licensed under the MIT License - see [LICENSE](LICENSE) for details.

## 🔗 Links

- **Original Repository:** [Aryangpt007/Journey-Mode](https://github.com/Aryangpt007/Journey-Mode)
- **Issues:** [Report Bugs](https://github.com/Aryangpt007/Journey-Mode/issues)
- **Discussions:** [Community Forum](https://github.com/Aryangpt007/Journey-Mode/discussions)

## 👤 Author

**Original Creator:** Aryangpt007
- GitHub: [@Aryangpt007](https://github.com/Aryangpt007)

**Fork Maintainer:** SuperBearxD
- Contributions: v1.6.1 stability improvements

## 🙏 Acknowledgments

- Inspired by **Terraria's Journey Mode**
- Thanks to the Fabric and NeoForge communities
- Special thanks to all contributors and testers

---

**⭐ If this mod helps your builds, consider starring the repo!**
