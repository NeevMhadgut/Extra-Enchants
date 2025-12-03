package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.SlimeEntity;

public class BaneOfSlimesEnchantment extends BaneEnchantmentBase {
	public static final BaneOfSlimesEnchantment INSTANCE = new BaneOfSlimesEnchantment();
	
	private BaneOfSlimesEnchantment() {
		super(EnchantmentRarity.UNCOMMON);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof SlimeEntity;
	}
}

