package com.example.advancedenchantments.enchantments.armor;

import com.example.advancedenchantments.enchantments.BaseEnchantment;
import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;

public class ShieldBashEnchantment extends BaseEnchantment {
	public static final ShieldBashEnchantment INSTANCE = new ShieldBashEnchantment();
	
	private ShieldBashEnchantment() {
		super(EnchantmentRarity.RARE, new EquipmentSlot[]{EquipmentSlot.OFFHAND});
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
		return 3;
	}
	
	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		return stack.getItem() instanceof ShieldItem;
	}
}

