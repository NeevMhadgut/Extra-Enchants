# Finding Your Compiled Mod JAR

After a successful build with Java 21, your mod JAR should be located at:

## Main Output Location:
```
build\libs\advanced-enchantments-1.0.0.jar
```

This is the **remapped JAR** that you can use in Minecraft.

## If the JAR isn't there:

1. **Make sure you ran the full build:**
   ```powershell
   .\gradlew.bat build
   ```
   This runs all tasks including `remapJar`.

2. **Or run remapJar directly:**
   ```powershell
   .\gradlew.bat remapJar
   ```

3. **Check for errors:**
   Even if it says "BUILD SUCCESSFUL", check the end of the output for warnings about missing files.

4. **Check all JAR files created:**
   ```powershell
   Get-ChildItem -Path build\libs -Filter "*.jar" | Format-Table Name, Length, LastWriteTime
   ```

## What JAR files you might see:

- `advanced-enchantments-1.0.0.jar` - The main remapped JAR (use this one!)
- `advanced-enchantments-1.0.0-sources.jar` - Source code JAR
- `advanced-enchantments-1.0.0-dev.jar` - Development (unmapped) JAR

## Using the Mod:

Copy `advanced-enchantments-1.0.0.jar` to your Minecraft's `mods` folder:
- Windows: `%appdata%\.minecraft\mods\`
- Or your Fabric server's `mods` folder

