package com.example.advancedenchantments.enchantments.armor;

import com.example.advancedenchantments.enchantments.BaseEnchantment;
import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

public class RegenerationEnchantment extends BaseEnchantment {
	public static final RegenerationEnchantment INSTANCE = new RegenerationEnchantment();
	
	private RegenerationEnchantment() {
		super(EnchantmentRarity.RARE, new EquipmentSlot[]{EquipmentSlot.CHEST});
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
	
	public void onArmorTick(LivingEntity entity, ItemStack stack, int level) {
		if (!entity.getWorld().isClient && entity.getHealth() < entity.getMaxHealth() && entity.age % (100 - level * 20) == 0) {
			entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, level - 1, true, false));
		}
	}
}

