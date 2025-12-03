package com.example.advancedenchantments.enchantments.armor;

import com.example.advancedenchantments.enchantments.BaseEnchantment;
import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

public class DamageReductionEnchantment extends BaseEnchantment {
	public static final DamageReductionEnchantment INSTANCE = new DamageReductionEnchantment();
	
	private DamageReductionEnchantment() {
		super(EnchantmentRarity.RARE, new EquipmentSlot[]{
			EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET
		});
	}
	
	@Override
	public int getMinPower(int level) {
		return 15 + (level - 1) * 10;
	}
	
	@Override
	public int getMaxPower(int level) {
		return this.getMinPower(level) + 50;
	}
	
	@Override
	public int getMaxLevel() {
		return 5;
	}
}

