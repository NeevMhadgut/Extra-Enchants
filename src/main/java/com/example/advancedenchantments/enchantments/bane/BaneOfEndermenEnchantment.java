package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.enchantment.EnchantmentRarity;

public class BaneOfEndermenEnchantment extends BaneEnchantmentBase {
	public static final BaneOfEndermenEnchantment INSTANCE = new BaneOfEndermenEnchantment();
	
	private BaneOfEndermenEnchantment() {
		super(EnchantmentRarity.UNCOMMON);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof EndermanEntity;
	}
}

