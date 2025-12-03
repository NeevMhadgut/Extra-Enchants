package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.ShulkerEntity;

public class BaneOfShulkersEnchantment extends BaneEnchantmentBase {
	public static final BaneOfShulkersEnchantment INSTANCE = new BaneOfShulkersEnchantment();
	
	private BaneOfShulkersEnchantment() {
		super(EnchantmentRarity.UNCOMMON);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof ShulkerEntity;
	}
}

