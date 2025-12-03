package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.BlazeEntity;

public class BaneOfBlazesEnchantment extends BaneEnchantmentBase {
	public static final BaneOfBlazesEnchantment INSTANCE = new BaneOfBlazesEnchantment();
	
	private BaneOfBlazesEnchantment() {
		super(EnchantmentRarity.UNCOMMON);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof BlazeEntity;
	}
}

