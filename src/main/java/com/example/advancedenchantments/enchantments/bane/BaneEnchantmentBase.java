package com.example.advancedenchantments.enchantments.bane;

import com.example.advancedenchantments.enchantments.BaseEnchantment;
import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public abstract class BaneEnchantmentBase extends BaseEnchantment {
	protected BaneEnchantmentBase(EnchantmentRarity rarity) {
		super(rarity, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	}
	
	@Override
	public int getMinPower(int level) {
		return 5 + (level - 1) * 10;
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
		return stack.getItem() instanceof SwordItem;
	}
	
	public abstract boolean isEffectiveAgainst(LivingEntity target);
	
	public float getExtraDamage(LivingEntity target, int level) {
		if (isEffectiveAgainst(target)) {
			return level * 2.5f;
		}
		return 0.0f;
	}
}
