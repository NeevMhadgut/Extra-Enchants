package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.SpiderEntity;

public class BaneOfSpidersEnchantment extends BaneEnchantmentBase {
	public static final BaneOfSpidersEnchantment INSTANCE = new BaneOfSpidersEnchantment();
	
	private BaneOfSpidersEnchantment() {
		super(EnchantmentRarity.UNCOMMON);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof SpiderEntity;
	}
}

