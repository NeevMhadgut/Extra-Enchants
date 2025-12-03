package com.example.advancedenchantments.enchantments.bane;

import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.ElderGuardianEntity;

public class BaneOfElderGuardiansEnchantment extends BaneEnchantmentBase {
	public static final BaneOfElderGuardiansEnchantment INSTANCE = new BaneOfElderGuardiansEnchantment();
	
	private BaneOfElderGuardiansEnchantment() {
		super(EnchantmentRarity.RARE);
	}
	
	@Override
	public boolean isEffectiveAgainst(LivingEntity target) {
		return target instanceof ElderGuardianEntity;
	}
}

