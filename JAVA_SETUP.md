# Java 21 Setup Required

Your system currently has Java 17 installed, but this mod requires **Java 21** to build.

## Quick Fix: Install Java 21

### Option 1: Download and Install Java 21

1. **Download Java 21:**
   - Visit: https://adoptium.net/temurin/releases/?version=21
   - Download the **JDK 21** for Windows (x64)
   - Install it

2. **Set JAVA_HOME:**
   - Open System Properties → Environment Variables
   - Add a new System Variable:
     - Variable name: `JAVA_HOME`
     - Variable value: `C:\Program Files\Eclipse Adoptium\jdk-21.x.x` (or wherever you installed it)
   - Add to PATH: `%JAVA_HOME%\bin`

3. **Verify Installation:**
   ```powershell
   java -version
   ```
   Should show version 21

4. **Restart your terminal/IDE** and try building again:
   ```powershell
   .\gradlew.bat build
   ```

### Option 2: Use Gradle Toolchain (May Auto-Download)

The build is configured to try to download Java 21 automatically. However, this requires:
- Internet connection
- Gradle 8.5+ (which you have)

Try running the build again - it may download Java 21 automatically on first run.

If it still fails, use Option 1 above.

## Alternative: Downgrade to Minecraft 1.20.x

If you prefer to use Java 17, you can modify the mod to target Minecraft 1.20.6, which works with Java 17. However, this requires changing several version numbers in `gradle.properties`.

