package com.example.advancedenchantments.enchantments.weapon;

import com.example.advancedenchantments.enchantments.BaseEnchantment;
import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.TridentItem;

public class StrengthEnchantment extends BaseEnchantment {
	public static final StrengthEnchantment INSTANCE = new StrengthEnchantment();
	
	private StrengthEnchantment() {
		super(EnchantmentRarity.UNCOMMON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
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
		return 5;
	}
	
	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		return stack.getItem() instanceof SwordItem || stack.getItem() instanceof TridentItem;
	}
}

