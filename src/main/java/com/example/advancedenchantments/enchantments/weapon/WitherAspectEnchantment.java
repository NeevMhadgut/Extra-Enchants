package com.example.advancedenchantments.enchantments.weapon;

import com.example.advancedenchantments.enchantments.BaseEnchantment;
import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.TridentItem;

public class WitherAspectEnchantment extends BaseEnchantment {
	public static final WitherAspectEnchantment INSTANCE = new WitherAspectEnchantment();
	
	private WitherAspectEnchantment() {
		super(EnchantmentRarity.RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
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
		return stack.getItem() instanceof SwordItem || stack.getItem() instanceof TridentItem;
	}
	
	public void onTargetDamaged(LivingEntity user, LivingEntity target, int level) {
		if (!target.getWorld().isClient && target.isAlive()) {
			target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 100 * level, level - 1));
		}
	}
}

