# Commit Message Template

Use this template for committing changes to Journey Mode:

```
feat(fabric): Fabric 1.21.x stability and sound system

Critical bug fixes and quality-of-life improvements for Fabric implementation:

### Fixed
- Packet registration errors causing ClassCastException crashes
- Data persistence bug - player progress now properly saves/loads
- Item overflow handling - excess items remain in deposit slot
- Search box keyboard conflicts (E key no longer closes GUI)
- Missing MenuScreens registration preventing GUI from opening
- Missing menu title translation

### Added
- Custom sound system with 3 sounds (completion + 2 random progress sounds)
- Comprehensive sound registry and ModSounds class
- File-based JSON persistence system
- Client-side initialization (JourneyModeClient)
- English translations (en_us.json)
- Professional documentation (CHANGELOG.md, CONTRIBUTING.md, README.md)

### Changed
- Migrated from NBT to JSON for data storage
- Improved build configuration for Fabric 1.21.x
- Refactored packet handling for reliability
- Consolidated duplicate network registration code

### Technical
- Files modified: 15+
- Lines changed: ~500+
- Build status: ✅ All tests passing
- Compatibility: Fabric 1.21.x, Minecraft 1.21+

Co-authored-by: Aryangpt007 <original-author>
```

---

## For Pull Request

### Title
```
[Fabric 1.21.x] Critical Fixes + Sound System
```

### Description
```markdown
## Summary
This PR addresses critical stability issues in the Fabric 1.21.x implementation and adds a requested custom sound system.

## Critical Fixes
- ✅ **Data Loss Prevention:** Implemented proper JSON-based persistence
- ✅ **Crash Prevention:** Fixed packet registration causing crashes
- ✅ **GUI Not Opening:** Resolved MenuScreens registration issue
- ✅ **Item Overflow:** Excess items now remain in slot

## New Features
- 🔊 Custom 3-sound system with random progress sounds
- 🔍 Improved UX with keyboard handling fixes

## Testing
- [x] Single-player tested
- [x] Multiplayer tested  
- [x] Data persistence verified (restart test)
- [x] All sounds play correctly
- [x] Build passes on Fabric 1.21.x

## Breaking Changes
⚠️ Data format changed from NBT to JSON. Old player data will not migrate automatically.

## Documentation
- Added CHANGELOG.md
- Added CONTRIBUTING.md
- Updated README.md with fork information

## Related Issues
Fixes #[issue-number-if-applicable]

## Screenshots/Videos
[Add gameplay footage or screenshots if available]
```

---

## Alternative Short Version

For smaller commits:

```
fix(fabric): resolve critical data persistence bug

Implemented JSON-based storage to prevent player progress loss on restart.

- Added file-based persistence (<world>/journeymode/<uuid>.json)
- Registered proper lifecycle events (JOIN, DISCONNECT, STOPPING)
- Migrated from in-memory HashMap to persistent files

Fixes #[issue]
```
