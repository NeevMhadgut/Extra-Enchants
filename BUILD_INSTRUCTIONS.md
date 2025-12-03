# How to Build the Mod

## Prerequisites
- Java 21 or later installed
- You're on Windows (using PowerShell or Command Prompt)

## Step 1: Download the Gradle Wrapper JAR

The Gradle wrapper needs a JAR file to work. You have two options:

### Option A: If you have Gradle installed globally
1. Open PowerShell or Command Prompt in this directory
2. Run: `gradle wrapper`
3. This will download the required files automatically

### Option B: Download manually
1. Go to: https://services.gradle.org/distributions/gradle-8.7-bin.zip
2. Or visit: https://gradle.org/releases/ and download Gradle 8.7
3. Extract it and run: `gradle-8.7\bin\gradle wrapper` from this directory

### Option C: Download just the wrapper JAR
1. Download from: https://raw.githubusercontent.com/gradle/gradle/master/gradle/wrapper/gradle-wrapper.jar
2. Save it as: `gradle\wrapper\gradle-wrapper.jar`

## Step 2: Build the Mod

Once the wrapper JAR is in place:

1. Open PowerShell or Command Prompt in this directory:
   ```
   cd "d:\Server Files\Minecraft Mod Testing"
   ```

2. Run the build command:
   ```
   .\gradlew.bat build
   ```
   (Note: I also noticed a typo in the README - it should be `build`, not `buid`)

3. Wait for the build to complete. The first time may take a few minutes as it downloads dependencies.

4. Find your compiled mod at: `build\libs\advanced-enchantments-1.0.0.jar`

## Troubleshooting

- **"JAVA_HOME is not set"**: Make sure Java 21+ is installed and JAVA_HOME environment variable points to your Java installation
- **"gradlew.bat not found"**: Make sure you're in the correct directory (`d:\Server Files\Minecraft Mod Testing`)
- **Build fails**: Check that you have internet connection (first build downloads dependencies)

## Quick Start (After wrapper JAR is in place)

```powershell
cd "d:\Server Files\Minecraft Mod Testing"
.\gradlew.bat build
```

