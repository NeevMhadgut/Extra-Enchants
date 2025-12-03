package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PhantomEntity;

public class BaneOfPhantomsEnchantment extends BaneEnchantmentBase {
	public static final BaneOfPhantomsEnchantment INSTANCE = new BaneOfPhantomsEnchantment();
	
	private BaneOfPhantomsEnchantment() {
		super(EnchantmentRarity.UNCOMMON);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof PhantomEntity;
	}
}

