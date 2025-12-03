# Extra Enchants Mod

A Minecraft Fabric mod for Minecraft 1.21.1 that adds unique enchantments to enhance your gameplay experience!

## Features

This mod adds a comprehensive collection of enchantments across multiple categories:

### Weapon Enchantments
- **Life Steal** - Restores health when dealing damage
- **Poison Aspect** - Poisons enemies on hit
- **Lightning Strike** - Strikes lightning on hit
- **Teleport Strike** - Teleports behind enemies on hit
- **Explosive** - Creates explosions on hit
- **Vampirism** - Steals life from enemies
- **Rage** - Increases damage when low on health
- **Berserker** - Grants attack speed boost
- **Assassin** - Increases damage from behind
- **Heavy** - Knocks enemies up on hit
- **Wither Aspect** - Applies wither effect on hit
- **Beheading** - Chance to drop mob heads
- **Strength** - Increases weapon damage

### Armor Enchantments
- **Thorns** - Damages attackers
- **Shield Bash** - Knocks back enemies when blocking
- **Night Vision** - Grants night vision effect
- **Water Breathing** - Grants water breathing effect
- **Speed** - Grants speed boost
- **Regeneration** - Gradually restores health
- **Fire Resistance** - Grants fire resistance effect
- **Jump Boost** - Increases jump height
- **Damage Reduction** - Reduces incoming damage
- **Tank** - Increases max health

### Tool Enchantments
- **Experience** - Grants extra experience when mining
- **Magnetism** - Attracts dropped items
- **Haste** - Increases mining speed
- **Frost Walker** - Freezes water when walking

### Bane Enchantments
Specialized enchantments that deal extra damage to specific mob types:
- Bane of Illagers, Creepers, Endermen, Blazes, Skeletons, Zombies
- Bane of Spiders, Slimes, Witches, Phantoms
- Bane of Piglins, Hoglins, Guardians, Shulkers
- Bane of Wardens, Elder Guardians, Ravagers
- Bane of Vexes, Evokers, Vindicators, Pillagers

## Installation

1. Make sure you have Minecraft 1.21.1 installed
2. Install [Fabric Loader](https://fabricmc.net/use/) 0.16.11 or later
3. Install [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api)
4. Download the mod JAR file
5. Place it in your `mods` folder
6. Launch Minecraft

## Building from Source

1. Clone this repository
2. Run `./gradlew build` (Linux/Mac) or `gradlew.bat build` (Windows)
3. Find the compiled mod in `build/libs/`

## Requirements

- Minecraft 1.21.1
- Fabric Loader 0.16.11+
- Fabric API
- Java 21+

## Adding More Enchantments

This mod is designed to be easily expandable. To add a new enchantment:

1. Create a new enchantment class extending `BaseEnchantment` or an appropriate base class
2. Add it to the appropriate registration method in `EnchantmentRegistry`
3. Add event handling in `EnchantmentEvents` if needed
4. Add translation keys to `en_us.json`

### Example:

```java
public class MyNewEnchantment extends BaseEnchantment {
    public static final MyNewEnchantment INSTANCE = new MyNewEnchantment();
    
    private MyNewEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }
    
    @Override
    public int getMinPower(int level) {
        return 10 + (level - 1) * 10;
    }
    
    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 50;
    }
    
    @Override
    public int getMaxLevel() {
        return 5;
    }
}
```

## License

MIT License - Feel free to use this mod in your modpacks and modify it as needed!

## Contributing

Contributions are welcome! Feel free to submit pull requests or open issues for bugs and feature requests.

## Credits

Inspired by the AdvancedEnchantments plugin for Bukkit/Spigot.


