package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.raid.RavagerEntity;

public class BaneOfRavagersEnchantment extends BaneEnchantmentBase {
	public static final BaneOfRavagersEnchantment INSTANCE = new BaneOfRavagersEnchantment();
	
	private BaneOfRavagersEnchantment() {
		super(EnchantmentRarity.RARE);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof RavagerEntity;
	}
}

