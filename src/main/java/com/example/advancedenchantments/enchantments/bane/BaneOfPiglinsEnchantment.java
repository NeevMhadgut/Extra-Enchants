package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinEntity;

public class BaneOfPiglinsEnchantment extends BaneEnchantmentBase {
	public static final BaneOfPiglinsEnchantment INSTANCE = new BaneOfPiglinsEnchantment();
	
	private BaneOfPiglinsEnchantment() {
		super(EnchantmentRarity.UNCOMMON);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof PiglinEntity;
	}
}

