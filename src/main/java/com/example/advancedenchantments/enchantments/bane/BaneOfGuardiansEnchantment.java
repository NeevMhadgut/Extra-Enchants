package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.GuardianEntity;

public class BaneOfGuardiansEnchantment extends BaneEnchantmentBase {
	public static final BaneOfGuardiansEnchantment INSTANCE = new BaneOfGuardiansEnchantment();
	
	private BaneOfGuardiansEnchantment() {
		super(EnchantmentRarity.UNCOMMON);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof GuardianEntity;
	}
}

