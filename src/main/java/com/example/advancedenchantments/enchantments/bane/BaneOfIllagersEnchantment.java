package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.IllagerEntity;

public class BaneOfIllagersEnchantment extends BaneEnchantmentBase {
	public static final BaneOfIllagersEnchantment INSTANCE = new BaneOfIllagersEnchantment();
	
	private BaneOfIllagersEnchantment() {
		super(EnchantmentRarity.UNCOMMON);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof IllagerEntity;
	}
}

