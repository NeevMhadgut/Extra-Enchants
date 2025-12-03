package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.WardenEntity;

public class BaneOfWardensEnchantment extends BaneEnchantmentBase {
	public static final BaneOfWardensEnchantment INSTANCE = new BaneOfWardensEnchantment();
	
	private BaneOfWardensEnchantment() {
		super(EnchantmentRarity.RARE);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof WardenEntity;
	}
}

