package com.example.advancedenchantments.enchantments.armor;

import com.example.advancedenchantments.enchantments.BaseEnchantment;
import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

public class JumpBoostEnchantment extends BaseEnchantment {
	public static final JumpBoostEnchantment INSTANCE = new JumpBoostEnchantment();
	
	private JumpBoostEnchantment() {
		super(EnchantmentRarity.UNCOMMON, new EquipmentSlot[]{EquipmentSlot.FEET});
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
	
	public void onArmorTick(LivingEntity entity, ItemStack stack, int level) {
		if (!entity.getWorld().isClient && entity.age % 20 == 0) {
			entity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 100, level - 1, true, false));
		}
	}
}

