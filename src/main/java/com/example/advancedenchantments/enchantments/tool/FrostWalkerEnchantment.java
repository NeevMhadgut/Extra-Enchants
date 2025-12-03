package com.example.advancedenchantments.enchantments.tool;

import com.example.advancedenchantments.enchantments.BaseEnchantment;
import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

public class FrostWalkerEnchantment extends BaseEnchantment {
	public static final FrostWalkerEnchantment INSTANCE = new FrostWalkerEnchantment();
	
	private FrostWalkerEnchantment() {
		super(EnchantmentRarity.RARE, new EquipmentSlot[]{EquipmentSlot.FEET});
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
		return 2;
	}
}

