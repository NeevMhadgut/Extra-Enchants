package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.VindicatorEntity;

public class BaneOfVindicatorsEnchantment extends BaneEnchantmentBase {
	public static final BaneOfVindicatorsEnchantment INSTANCE = new BaneOfVindicatorsEnchantment();
	
	private BaneOfVindicatorsEnchantment() {
		super(EnchantmentRarity.UNCOMMON);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof VindicatorEntity;
	}
}

