package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.ZombieEntity;

public class BaneOfZombiesEnchantment extends BaneEnchantmentBase {
	public static final BaneOfZombiesEnchantment INSTANCE = new BaneOfZombiesEnchantment();
	
	private BaneOfZombiesEnchantment() {
		super(EnchantmentRarity.UNCOMMON);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof ZombieEntity;
	}
}

