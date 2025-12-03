package com.example.advancedenchantments.enchantments.weapon;

import com.example.advancedenchantments.enchantments.BaseEnchantment;
import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.TridentItem;

public class LifeStealEnchantment extends BaseEnchantment {
	public static final LifeStealEnchantment INSTANCE = new LifeStealEnchantment();
	
	private LifeStealEnchantment() {
		super(EnchantmentRarity.RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	}
	
	@Override
	public int getMinPower(int level) {
		return 15 + (level - 1) * 9;
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
	
	public void onTargetDamaged(LivingEntity user, LivingEntity target, int level) {
		if (user instanceof PlayerEntity player && !player.getWorld().isClient) {
			float damageDealt = target.getHealth() < target.getMaxHealth() ? target.getMaxHealth() - target.getHealth() : 1.0f;
			float healAmount = Math.min(damageDealt * 0.1f * level, player.getMaxHealth() - player.getHealth());
			if (healAmount > 0) {
				player.heal(healAmount);
			}
		}
	}
}

