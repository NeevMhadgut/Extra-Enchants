package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.EvokerEntity;

public class BaneOfEvokersEnchantment extends BaneEnchantmentBase {
	public static final BaneOfEvokersEnchantment INSTANCE = new BaneOfEvokersEnchantment();
	
	private BaneOfEvokersEnchantment() {
		super(EnchantmentRarity.RARE);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof EvokerEntity;
	}
}

