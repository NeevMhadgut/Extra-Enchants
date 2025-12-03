package com.example.advancedenchantments;

import com.example.advancedenchantments.enchantments.EnchantmentRegistry;
import com.example.advancedenchantments.events.EnchantmentEvents;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdvancedEnchantmentsMod implements ModInitializer {
	public static final String MOD_ID = "advanced-enchantments";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Advanced Enchantments Mod!");
		
		// Register all enchantments
		EnchantmentRegistry.register();
		
		// Register event handlers
		EnchantmentEvents.register();
		
		LOGGER.info("Registered {} enchantments!", EnchantmentRegistry.getEnchantmentCount());
	}
}

