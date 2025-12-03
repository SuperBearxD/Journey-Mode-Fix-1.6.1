# Guía Completa: GitHub Fork y Pull Request para Principiantes

## 📚 Conceptos Básicos

### ¿Qué es un Fork?
**Fork** = Hacer una copia del proyecto de otra persona en tu cuenta de GitHub.
- Es como fotocopiar un libro para hacer anotaciones sin tocar el original
- Puedes modificar tu copia libremente
- El original no se afecta

### ¿Qué es un Pull Request (PR)?
**Pull Request** = Proponer tus cambios al proyecto original.
- Es como decir: "Mira, mejoré esto. ¿Lo quieres en tu proyecto?"
- El dueño original revisa tus cambios
- Puede aceptarlos, rechazarlos, o pedir modificaciones

---

## 🎯 Opción 1: Pull Request (Contribuir al Original)

**Usa esto si:** Quieres que Aryangpt007 incluya tus mejoras en el mod oficial.

### Paso 1: Crear una Cuenta en GitHub

1. Ve a: https://github.com
2. Click en "Sign Up"
3. Crea tu cuenta (gratis)
4. Verifica tu email

### Paso 2: Fork del Repositorio Original

1. Ve a: https://github.com/Aryangpt007/Journey-Mode
2. Click en el botón **"Fork"** (arriba a la derecha)
3. Selecciona tu cuenta como destino
4. Espera ~10 segundos
5. ✅ Ahora tienes: `https://github.com/TU-USUARIO/Journey-Mode`

### Paso 3: Conectar tu Código Local al Fork

```bash
# Navega a tu proyecto
cd "c:\MinecraftMods\Journey Modee"

# Verifica si ya tienes git inicializado
git status

# Si dice "not a git repository", inicializa:
git init

# Conecta tu fork (reemplaza TU-USUARIO)
git remote add origin https://github.com/TU-USUARIO/Journey-Mode.git

# Conecta el original (para actualizaciones futuras)
git remote add upstream https://github.com/Aryangpt007/Journey-Mode.git

# Verifica las conexiones
git remote -v
```

### Paso 4: Subir tus Cambios al Fork

```bash
# Agrega todos los archivos
git add .

# Crea el commit usando el template
git commit -m "feat(fabric): Fabric 1.21.x stability and sound system

Critical bug fixes and features:
- Fixed data persistence bug
- Fixed packet registration crashes
- Added custom sound system
- Created professional documentation

See CHANGELOG.md for details"

# Sube a tu fork
git push origin main
```

**Si pide credenciales:**
- Usuario: tu nombre de GitHub
- Contraseña: crear un **Personal Access Token**:
  1. GitHub → Settings → Developer settings → Personal access tokens → Tokens (classic)
  2. Generate new token
  3. Selecciona: `repo` (full control)
  4. Copia el token y úsalo como contraseña

### Paso 5: Crear Pull Request

1. Ve a tu fork: `https://github.com/TU-USUARIO/Journey-Mode`
2. Verás un banner amarillo: **"Compare & pull request"** → Click
3. Llena el formulario:
   - **Title:** `[Fabric 1.21.x] Critical Fixes + Sound System`
   - **Description:** Copia de `COMMIT_MESSAGE.md` (sección Pull Request)
4. Click **"Create pull request"**
5. ✅ Listo! Aryangpt007 recibirá la notificación

### Paso 6: Esperar Revisión

- Aryangpt007 revisará tus cambios
- Puede:
  - ✅ Aceptar (merge) - tus cambios van al original
  - 💬 Comentar - pedir cambios o explicaciones
  - ❌ Rechazar - con razones

---

## 🎯 Opción 2: Fork Público Independiente

**Usa esto si:** Quieres mantener tu propia versión mejorada del mod.

### Paso 1-3: Igual que Opción 1

Haz Fork y conecta tu código local (pasos 1-3 de arriba)

### Paso 4: Personaliza tu Fork

**Edita información:**
1. En GitHub, ve a tu fork
2. Click **"Settings"**
3. Cambia:
   - **Repository name:** `Journey-Mode-Enhanced` (ejemplo)
   - **Description:** "Journey Mode with stability fixes and custom sounds"
   - **Website:** Tu link si tienes
4. Agrega temas: `minecraft`, `fabric`, `mod`

### Paso 5: Actualiza el README

Edita `README.md` para indicar que es un fork:

```markdown
# Journey Mode Enhanced (Fork)

> **Fork of [Journey-Mode](https://github.com/Aryangpt007/Journey-Mode)**  
> This version includes critical stability fixes and custom sound system for Fabric 1.21.x

## Why This Fork?
- ✅ Fixed data persistence bug
- ✅ Fixed crashes
- ✅ Custom sounds
- ✅ Better UX

[Ver CHANGELOG.md para detalles]

## Credits
Original mod by [Aryangpt007](https://github.com/Aryangpt007)
```

### Paso 6: Sube a tu Fork

```bash
git add .
git commit -m "docs: Update README for fork"
git push origin main
```

### Paso 7: Crear un Release

1. En tu fork en GitHub: **Releases** → **Create a new release**
2. Tag: `v1.6.1-fabric`
3. Title: `Fabric 1.21.x Stability Release`
4. Description: Copia de CHANGELOG
5. Adjunta: `fabric-1.21.x/build/libs/journey-mode-1.6.0.jar`
6. Click **"Publish release"**

✅ Ahora otros pueden descargar tu versión mejorada!

---

## 🤔 ¿Cuál Opción Elegir?

### Opción 1 (Pull Request) - Recomendado si:
- ✅ Respetas al autor original
- ✅ Quieres que todos se beneficien
- ✅ No quieres mantener un fork a largo plazo
- ✅ Tus cambios mejoran el mod sin cambiar su visión

### Opción 2 (Fork Independiente) - Recomendado si:
- ✅ Quieres continuar desarrollo propio
- ✅ El autor original no acepta PRs
- ✅ Tienes una visión diferente del mod
- ✅ Quieres control total

**Puedes hacer AMBOS:**
1. Crear PR primero
2. Si es rechazado o ignorado → mantener fork público

---

## 🆘 Comandos Git Útiles

```bash
# Ver estado
git status

# Ver cambios
git diff

# Ver commits
git log --oneline

# Deshacer último commit (sin perder cambios)
git reset --soft HEAD~1

# Actualizar desde el original
git fetch upstream
git merge upstream/main

# Ver remotes
git remote -v
```

---

## 📝 Checklist Pre-Contribución

Antes de hacer PR o publicar fork:

- [x] Build exitoso (Fabric y NeoForge)
- [x] Changelog actualizado
- [x] README con información del fork
- [x] Código testeado en Minecraft
- [ ] Screenshots/video de las mejoras (opcional pero recomendado)
- [x] Commit message profesional
- [x] Créditos al autor original

---

## 🎓 Recursos Adicionales

- **GitHub Docs:** https://docs.github.com/es
- **Git Tutorial:** https://git-scm.com/book/es/v2
- **Markdown Guide:** https://www.markdownguide.org/

---

## ❓ Troubleshooting

**"Permission denied":**
- Usa Personal Access Token como contraseña
- O configura SSH keys

**"Conflict al hacer merge":**
- El original cambió mientras trabajabas
- Necesitas resolver conflictos manualmente

**"No puedo hacer push":**
- Verifica que sea TU fork, no el original
- `git remote -v` debe mostrar tu usuario

---

**¿Necesitas ayuda con algún paso específico?** 🚀
