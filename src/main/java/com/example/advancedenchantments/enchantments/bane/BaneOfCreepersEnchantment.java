package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.enchantment.EnchantmentRarity;

public class BaneOfCreepersEnchantment extends BaneEnchantmentBase {
	public static final BaneOfCreepersEnchantment INSTANCE = new BaneOfCreepersEnchantment();
	
	private BaneOfCreepersEnchantment() {
		super(EnchantmentRarity.UNCOMMON);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof CreeperEntity;
	}
}

