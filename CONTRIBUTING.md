# Contributing to Journey Mode

First off, thank you for considering contributing to Journey Mode! 🎉

## How to Contribute

### Reporting Bugs

Before creating bug reports, please check existing issues. When creating a bug report, include:

- **Minecraft Version:** (e.g., 1.21.1)
- **Mod Loader:** Fabric or NeoForge + version
- **Mod Version:** Journey Mode version
- **Description:** Clear description of the bug
- **Steps to Reproduce:** Step-by-step reproduction
- **Expected Behavior:** What should happen
- **Actual Behavior:** What actually happens
- **Logs:** Crash logs or relevant log snippets
- **Screenshots:** If applicable

### Suggesting Features

Feature requests are welcome! Please provide:

- **Clear description** of the feature
- **Use case** - why is it needed?
- **Expected behavior** - how should it work?
- **Alternatives** - other solutions you've considered

### Code Contributions

#### Setup

1. Fork the repository
2. Clone your fork:
   ```bash
   git clone https://github.com/YOUR-USERNAME/Journey-Mode.git
   cd Journey-Mode
   ```
3. Build the project:
   ```bash
   ./gradlew build
   ```

#### Making Changes

1. Create a feature branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```

2. Make your changes following these guidelines:
   - **Code Style:** Follow existing Java conventions
   - **Comments:** Document complex logic
   - **Commits:** Write clear, descriptive commit messages
   - **Testing:** Test both Fabric and NeoForge if applicable

3. Build and test:
   ```bash
   ./gradlew :fabric-1.21.x:build
   ./gradlew :neoforge-1.21.1:build
   ```

#### Commit Message Format

Use conventional commits:

```
<type>(<scope>): <subject>

<body>

<footer>
```

**Types:**
- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation changes
- `style`: Code style changes (formatting)
- `refactor`: Code refactoring
- `test`: Adding tests
- `chore`: Build process, dependencies

**Example:**
```
fix(fabric): resolve packet registration crash

- Fixed StreamCodec for empty packets
- Added missing OpenJourneyMenuPacket registration
- Reordered payload type registration

Fixes #123
```

#### Pull Request Process

1. Update CHANGELOG.md with your changes
2. Ensure all builds pass
3. Update documentation if needed
4. Create a Pull Request with:
   - Clear title describing the change
   - Detailed description of what was changed and why
   - Link to related issues
   - Screenshots/videos if UI changes

### Code Review Process

- Maintainers will review PRs within 1-2 weeks
- Address any requested changes
- Once approved, maintainers will merge

## Development Guidelines

### Project Structure

```
Journey-Mode/
├── common/              # Shared code between loaders
├── fabric-1.21.x/      # Fabric-specific implementation
└── neoforge-1.21.1/    # NeoForge-specific implementation
```

### Key Areas

- **Data Persistence:** `FabricDataHandler.java` / `NeoForgeDataHandler.java`
- **Networking:** `fabric/network/` / `neoforge/network/`
- **GUI:** `client/screen/JourneyModeScreen.java`
- **Menu Logic:** `menu/JourneyModeMenu.java`
- **Configuration:** `logic/ConfigHandler.java`

### Common Pitfalls

1. **Don't modify `common/` without coordinating both loaders**
2. **Test data persistence** - add items, restart, verify they persist
3. **Test networking** - verify client-server communication works
4. **Check both single-player and multiplayer**

## Questions?

- Open a discussion on GitHub
- Check existing issues and wiki
- Review the README.md for basic info

## License

By contributing, you agree that your contributions will be licensed under the MIT License.

## Thank You!

Your contributions make Journey Mode better for everyone! 🙏
