package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PillagerEntity;

public class BaneOfPillagersEnchantment extends BaneEnchantmentBase {
	public static final BaneOfPillagersEnchantment INSTANCE = new BaneOfPillagersEnchantment();
	
	private BaneOfPillagersEnchantment() {
		super(EnchantmentRarity.UNCOMMON);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof PillagerEntity;
	}
}

