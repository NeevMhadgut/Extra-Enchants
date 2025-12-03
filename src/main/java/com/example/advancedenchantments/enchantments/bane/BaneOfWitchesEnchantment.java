package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.WitchEntity;

public class BaneOfWitchesEnchantment extends BaneEnchantmentBase {
	public static final BaneOfWitchesEnchantment INSTANCE = new BaneOfWitchesEnchantment();
	
	private BaneOfWitchesEnchantment() {
		super(EnchantmentRarity.UNCOMMON);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof WitchEntity;
	}
}

