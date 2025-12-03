package com.example.advancedenchantments.enchantments.weapon;

import com.example.advancedenchantments.enchantments.BaseEnchantment;
import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.TridentItem;

public class BeheadingEnchantment extends BaseEnchantment {
	public static final BeheadingEnchantment INSTANCE = new BeheadingEnchantment();
	
	private BeheadingEnchantment() {
		super(EnchantmentRarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	}
	
	@Override
	public int getMinPower(int level) {
		return 25 + (level - 1) * 15;
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
		return stack.getItem() instanceof SwordItem || stack.getItem() instanceof TridentItem;
	}
}

