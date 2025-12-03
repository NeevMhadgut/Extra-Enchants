package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.VexEntity;

public class BaneOfVexesEnchantment extends BaneEnchantmentBase {
	public static final BaneOfVexesEnchantment INSTANCE = new BaneOfVexesEnchantment();
	
	private BaneOfVexesEnchantment() {
		super(EnchantmentRarity.UNCOMMON);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof VexEntity;
	}
}

