# Script to fix all enchantment files for Minecraft 1.21.1 API

$files = Get-ChildItem -Path "src\main\java\com\example\advancedenchantments\enchantments" -Recurse -Filter "*.java"

foreach ($file in $files) {
    $content = Get-Content $file.FullName -Raw
    $modified = $false
    
    # Remove EnchantmentTarget import
    if ($content -match "import net\.minecraft\.enchantment\.EnchantmentTarget;") {
        $content = $content -replace "import net\.minecraft\.enchantment\.EnchantmentTarget;\r?\n", ""
        $modified = $true
    }
    
    # Add Enchantment import if needed
    if ($content -match "super\(Rarity\." -and $content -notmatch "import net\.minecraft\.enchantment\.Enchantment;") {
        $content = $content -replace "(import com\.example\.advancedenchantments\.enchantments\.BaseEnchantment;)", "`$1`nimport net.minecraft.enchantment.Enchantment;"
        $modified = $true
    }
    
    # Replace EnchantmentTarget.* with Enchantment.Effect.*
    $content = $content -replace "EnchantmentTarget\.WEAPON", "Enchantment.Effect.WEAPON"
    $content = $content -replace "EnchantmentTarget\.ARMOR", "Enchantment.Effect.ARMOR"
    $content = $content -replace "EnchantmentTarget\.ARMOR_HEAD", "Enchantment.Effect.ARMOR_HEAD"
    $content = $content -replace "EnchantmentTarget\.ARMOR_CHEST", "Enchantment.Effect.ARMOR_CHEST"
    $content = $content -replace "EnchantmentTarget\.ARMOR_FEET", "Enchantment.Effect.ARMOR_FEET"
    $content = $content -replace "EnchantmentTarget\.DIGGER", "Enchantment.Effect.DIGGER"
    $content = $content -replace "EnchantmentTarget\.BREAKABLE", "Enchantment.Effect.BREAKABLE"
    
    # Replace Rarity.* with Enchantment.Rarity.*
    $content = $content -replace "\bRarity\.COMMON\b", "Enchantment.Rarity.COMMON"
    $content = $content -replace "\bRarity\.UNCOMMON\b", "Enchantment.Rarity.UNCOMMON"
    $content = $content -replace "\bRarity\.RARE\b", "Enchantment.Rarity.RARE"
    $content = $content -replace "\bRarity\.VERY_RARE\b", "Enchantment.Rarity.VERY_RARE"
    
    # Replace .world. with .getWorld().
    $content = $content -replace "\.world\.isClient", ".getWorld().isClient"
    $content = $content -replace "\.world instanceof", ".getWorld() instanceof"
    $content = $content -replace "user\.world", "user.getWorld()"
    $content = $content -replace "target\.world", "target.getWorld()"
    $content = $content -replace "entity\.world", "entity.getWorld()"
    
    if ($modified -or $content -match "Enchantment\.Effect\.|Enchantment\.Rarity\.|\.getWorld\(\)") {
        Set-Content -Path $file.FullName -Value $content -NoNewline
        Write-Host "Fixed: $($file.Name)"
    }
}

Write-Host "Done fixing enchantment files!"

