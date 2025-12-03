package com.example.advancedenchantments.enchantments.tool;

import com.example.advancedenchantments.enchantments.BaseEnchantment;
import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

public class HasteEnchantment extends BaseEnchantment {
	public static final HasteEnchantment INSTANCE = new HasteEnchantment();
	
	private HasteEnchantment() {
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
	
	public void onToolTick(LivingEntity entity, ItemStack stack, int level) {
		if (!entity.getWorld().isClient && entity instanceof net.minecraft.entity.player.PlayerEntity && entity.age % 20 == 0) {
			entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 100, level - 1, true, false));
		}
	}
}

