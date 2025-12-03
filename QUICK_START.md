# Quick Start Guide

## ⚠️ IMPORTANT: Java 21 Required

Your system has Java 17, but this mod **requires Java 21** to build.

## Install Java 21 (5 minutes)

1. **Download Java 21 JDK:**
   - Go to: https://adoptium.net/temurin/releases/?version=21
   - Click "JDK 21" → "Windows" → "x64" → Download the `.msi` installer

2. **Install:**
   - Run the downloaded `.msi` file
   - Follow the installation wizard (default settings are fine)
   - Make sure "Add to PATH" is checked during installation

3. **Verify Installation:**
   - Open a **NEW** PowerShell or Command Prompt window
   - Run: `java -version`
   - Should show: `openjdk version "21"` or similar

4. **If it still shows Java 17:**
   - Check your PATH environment variable - Java 21 should come before Java 17
   - Or set JAVA_HOME to Java 21's installation folder

## Build the Mod

Once Java 21 is installed and active:

```powershell
cd "d:\Server Files\Minecraft Mod Testing"
.\gradlew.bat build
```

The build will take a few minutes the first time (downloads dependencies).

## Find Your Compiled Mod

After successful build:
```
build\libs\advanced-enchantments-1.0.0.jar
```

Copy this JAR to your Minecraft `mods` folder to use it!

---

**Need Help?** 
- Check `JAVA_SETUP.md` for detailed Java setup instructions
- Make sure you opened a NEW terminal after installing Java 21

