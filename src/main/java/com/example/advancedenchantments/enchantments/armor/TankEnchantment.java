package com.example.advancedenchantments.enchantments.armor;

import com.example.advancedenchantments.enchantments.BaseEnchantment;
import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;

public class TankEnchantment extends BaseEnchantment {
	public static final TankEnchantment INSTANCE = new TankEnchantment();
	
	private TankEnchantment() {
		super(EnchantmentRarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.CHEST});
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
		return 5;
	}
	
	public void onArmorTick(LivingEntity entity, ItemStack stack, int level) {
		if (!entity.getWorld().isClient && entity instanceof net.minecraft.entity.player.PlayerEntity player) {
			EntityAttributeInstance maxHealth = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
			if (maxHealth != null) {
				net.minecraft.entity.attribute.EntityAttributeModifier modifier = getModifier(level);
				if (!maxHealth.hasModifier(modifier.id())) {
					maxHealth.addPersistentModifier(modifier);
				}
			}
		}
	}
	
	private net.minecraft.entity.attribute.EntityAttributeModifier getModifier(int level) {
		return new net.minecraft.entity.attribute.EntityAttributeModifier(
			java.util.UUID.fromString("a1b2c3d4-e5f6-7890-abcd-ef1234567890"),
			"tank_enchantment",
			level * 2.0,
			net.minecraft.entity.attribute.EntityAttributeModifier.Operation.ADD_VALUE
		);
	}
}

