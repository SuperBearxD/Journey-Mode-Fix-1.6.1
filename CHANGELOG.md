# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.6.1-fabric] - 2025-12-03

### Fixed
- 🔧 **Critical:** Fixed `ClassCastException` when opening Journey Mode menu
  - Corrected packet registration order (PayloadTypes before handlers)
  - Added missing `OpenJourneyMenuPacket` registration
  - Fixed `StreamCodec` implementation for empty packets in Minecraft 1.21.x
- 🔧 **Critical:** Fixed data persistence bug causing player progress loss on server restart
  - Implemented file-based JSON storage system (`<world>/journeymode/<player-uuid>.json`)
  - Added proper lifecycle event handlers (JOIN, DISCONNECT, SERVER_STOPPING)
  - Migrated from in-memory HashMap to persistent file storage
- 🔧 Fixed item overflow handling - remainder now correctly stays in deposit slot
  - Calculates exact items needed vs. threshold
  - Only consumes required amount, preserves excess
- 🔧 Fixed search box keyboard conflict
  - Pressing 'E' while typing no longer closes the GUI
  - ESC key unfocuses search box instead of closing menu
- 🔧 Fixed missing `MenuScreens` registration
  - Journey Mode GUI now opens correctly when pressing 'J' key
- 🔧 Fixed missing menu title translation (`journeymode.menu.title`)

### Added
- ✨ **Feature:** Custom sound system with intelligent playback
  - `research_sound.ogg` - Plays on research completion (unlock)
  - `pre-research1.ogg` - Random progress sound option 1
  - `pre-research2.ogg` - Random progress sound option 2
  - Random selection between pre-research sounds for variety
- ✨ Added comprehensive sound registry (`sounds.json`)
- ✨ Added `ModSounds` class for centralized sound management
- ✨ Created `fabric.mod.json` with proper entrypoints configuration
- ✨ Created `JourneyModeClient` class for client-side initialization
- ✨ Added English translation file (`en_us.json`)

### Changed
- ⚙️ **Breaking:** Switched data persistence from NBT to JSON format
  - Old NBT data will not automatically migrate
  - New format: `<world>/journeymode/<player-uuid>.json`
- ⚙️ Improved Fabric 1.21.x build configuration
  - Added Fabric Maven repository
  - Configured Mojang mappings instead of Yarn
  - Added `include project(':common')` for proper JAR bundling
  - Fixed Java toolchain configuration
- ⚙️ Refactored packet handling for better reliability
  - Consolidated duplicate registration code
  - Removed deprecated `FabricNetworkHandler` dependencies
  - Streamlined client-server communication

### Technical Details
- **Files Modified:** 15+ core files
- **Lines Changed:** ~500+ LOC
- **Build Status:** ✅ All tests passing
- **Compatibility:** Fabric 1.21.x, Minecraft 1.21+

---

## [1.0.0-fabric] - 2025-10-31 (Original Release)

### Added
- Initial Fabric 1.21.x port from NeoForge
- Journey Mode menu with Deposit and Journey tabs
- Item research and unlock system
- Threshold-based progression
- Command system (`/journeymode`)
- Basic data persistence

---

## Versioning Note

This fork follows semantic versioning:
- **MAJOR:** Incompatible API changes
- **MINOR:** Backwards-compatible functionality
- **PATCH:** Backwards-compatible bug fixes
- **Suffix:** `-fabric` or `-neoforge` for loader-specific versions

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines on submitting fixes and features.

## Credits

- **Original Author:** [Aryangpt007](https://github.com/Aryangpt007)
- **Repository:** [Journey-Mode](https://github.com/Aryangpt007/Journey-Mode)
- **Fork Contributions:** Bug fixes, stability improvements, and feature additions for Fabric 1.21.x
