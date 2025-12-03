package com.example.advancedenchantments.enchantments.armor;

import com.example.advancedenchantments.enchantments.BaseEnchantment;
import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public class ThornsEnchantment extends BaseEnchantment {
	public static final ThornsEnchantment INSTANCE = new ThornsEnchantment();
	
	private ThornsEnchantment() {
		super(EnchantmentRarity.UNCOMMON, new EquipmentSlot[]{
			EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET
		});
	}
	
	@Override
	public int getMinPower(int level) {
		return 10 + (level - 1) * 10;
	}
	
	@Override
	public int getMaxPower(int level) {
		return this.getMinPower(level) + 50;
	}
	
	@Override
	public int getMaxLevel() {
		return 3;
	}
	
	public void onUserDamaged(LivingEntity user, LivingEntity attacker, int level, DamageSource source) {
		if (attacker != null && !user.getWorld().isClient && user.getRandom().nextFloat() < 0.15f * level) {
			attacker.damage(user.getDamageSources().thorns(user), 1.0f + level);
		}
	}
}

