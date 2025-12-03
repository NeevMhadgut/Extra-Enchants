package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HoglinEntity;

public class BaneOfHoglinsEnchantment extends BaneEnchantmentBase {
	public static final BaneOfHoglinsEnchantment INSTANCE = new BaneOfHoglinsEnchantment();
	
	private BaneOfHoglinsEnchantment() {
		super(EnchantmentRarity.UNCOMMON);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof HoglinEntity;
	}
}

