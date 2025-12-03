package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.SkeletonEntity;

public class BaneOfSkeletonsEnchantment extends BaneEnchantmentBase {
	public static final BaneOfSkeletonsEnchantment INSTANCE = new BaneOfSkeletonsEnchantment();
	
	private BaneOfSkeletonsEnchantment() {
		super(EnchantmentRarity.UNCOMMON);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof SkeletonEntity;
	}
}

