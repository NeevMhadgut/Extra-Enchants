@echo off
echo Checking Java version...
java -version
echo.
echo Building mod...
call gradlew.bat clean build
echo.
echo Checking for output JAR...
if exist "build\libs\advanced-enchantments-1.0.0.jar" (
    echo SUCCESS! Mod JAR found at: build\libs\advanced-enchantments-1.0.0.jar
    dir "build\libs\*.jar"
) else (
    echo WARNING: JAR not found in build\libs\
    echo Checking build\libs folder...
    if exist "build\libs" (
        dir "build\libs"
    ) else (
        echo build\libs folder doesn't exist. Build may have failed.
    )
)
pause

