package com.example.advancedenchantments.events;

import com.example.advancedenchantments.enchantments.armor.*;
import com.example.advancedenchantments.enchantments.bane.BaneEnchantmentBase;
import com.example.advancedenchantments.enchantments.tool.*;
import com.example.advancedenchantments.enchantments.weapon.*;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;

public class EnchantmentEvents {
	
	public static void register() {
		// Handle weapon enchantments on attack
		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (!world.isClient && entity instanceof LivingEntity target && player instanceof PlayerEntity) {
				ItemStack stack = player.getStackInHand(hand);
				
				if (!stack.isEmpty()) {
					// Weapon enchantments
					int lifeSteal = EnchantmentHelper.getLevel(LifeStealEnchantment.INSTANCE, stack);
					if (lifeSteal > 0) {
						LifeStealEnchantment.INSTANCE.onTargetDamaged((LivingEntity) player, target, lifeSteal);
					}
					
					int poisonAspect = EnchantmentHelper.getLevel(PoisonAspectEnchantment.INSTANCE, stack);
					if (poisonAspect > 0) {
						PoisonAspectEnchantment.INSTANCE.onTargetDamaged((LivingEntity) player, target, poisonAspect);
					}
					
					int lightning = EnchantmentHelper.getLevel(LightningStrikeEnchantment.INSTANCE, stack);
					if (lightning > 0) {
						LightningStrikeEnchantment.INSTANCE.onTargetDamaged((LivingEntity) player, target, lightning);
					}
					
					int teleport = EnchantmentHelper.getLevel(TeleportStrikeEnchantment.INSTANCE, stack);
					if (teleport > 0) {
						TeleportStrikeEnchantment.INSTANCE.onTargetDamaged((LivingEntity) player, target, teleport);
					}
					
					int explosive = EnchantmentHelper.getLevel(ExplosiveEnchantment.INSTANCE, stack);
					if (explosive > 0) {
						ExplosiveEnchantment.INSTANCE.onTargetDamaged((LivingEntity) player, target, explosive);
					}
					
					int vampirism = EnchantmentHelper.getLevel(VampirismEnchantment.INSTANCE, stack);
					if (vampirism > 0) {
						VampirismEnchantment.INSTANCE.onTargetDamaged((LivingEntity) player, target, vampirism);
					}
					
					int heavy = EnchantmentHelper.getLevel(HeavyEnchantment.INSTANCE, stack);
					if (heavy > 0) {
						HeavyEnchantment.INSTANCE.onTargetDamaged((LivingEntity) player, target, heavy);
					}
					
					int wither = EnchantmentHelper.getLevel(WitherAspectEnchantment.INSTANCE, stack);
					if (wither > 0) {
						WitherAspectEnchantment.INSTANCE.onTargetDamaged((LivingEntity) player, target, wither);
					}
					
					// Bane enchantments damage
					for (var entry : EnchantmentHelper.get(stack).entrySet()) {
						if (entry.getKey() instanceof BaneEnchantmentBase baneEnchant) {
							float extraDamage = baneEnchant.getExtraDamage(target, entry.getValue());
							if (extraDamage > 0) {
								target.damage(world.getDamageSources().magic(), extraDamage);
							}
						}
					}
				}
			}
			return ActionResult.PASS;
		});
		
		// Handle armor tick effects
		ServerTickEvents.START_PLAYER_TICK.register(player -> {
			if (player.age % 20 == 0) {
				// Check each armor slot
				for (EquipmentSlot slot : new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}) {
					ItemStack armor = player.getEquippedStack(slot);
					if (!armor.isEmpty()) {
						int nightVision = EnchantmentHelper.getLevel(NightVisionEnchantment.INSTANCE, armor);
						if (nightVision > 0 && slot == EquipmentSlot.HEAD) {
							NightVisionEnchantment.INSTANCE.onArmorTick(player, armor, nightVision);
						}
						
						int waterBreathing = EnchantmentHelper.getLevel(WaterBreathingEnchantment.INSTANCE, armor);
						if (waterBreathing > 0 && slot == EquipmentSlot.HEAD) {
							WaterBreathingEnchantment.INSTANCE.onArmorTick(player, armor, waterBreathing);
						}
						
						int speed = EnchantmentHelper.getLevel(SpeedEnchantment.INSTANCE, armor);
						if (speed > 0 && slot == EquipmentSlot.FEET) {
							SpeedEnchantment.INSTANCE.onArmorTick(player, armor, speed);
						}
						
						int regeneration = EnchantmentHelper.getLevel(RegenerationEnchantment.INSTANCE, armor);
						if (regeneration > 0 && slot == EquipmentSlot.CHEST) {
							RegenerationEnchantment.INSTANCE.onArmorTick(player, armor, regeneration);
						}
						
						int fireResistance = EnchantmentHelper.getLevel(FireResistanceEnchantment.INSTANCE, armor);
						if (fireResistance > 0) {
							FireResistanceEnchantment.INSTANCE.onArmorTick(player, armor, fireResistance);
						}
						
						int jumpBoost = EnchantmentHelper.getLevel(JumpBoostEnchantment.INSTANCE, armor);
						if (jumpBoost > 0 && slot == EquipmentSlot.FEET) {
							JumpBoostEnchantment.INSTANCE.onArmorTick(player, armor, jumpBoost);
						}
						
						int tank = EnchantmentHelper.getLevel(TankEnchantment.INSTANCE, armor);
						if (tank > 0 && slot == EquipmentSlot.CHEST) {
							TankEnchantment.INSTANCE.onArmorTick(player, armor, tank);
						}
					}
				}
				
				// Check main hand tool
				ItemStack tool = player.getMainHandStack();
				if (!tool.isEmpty()) {
					int haste = EnchantmentHelper.getLevel(HasteEnchantment.INSTANCE, tool);
					if (haste > 0) {
						HasteEnchantment.INSTANCE.onToolTick(player, tool, haste);
					}
				}
			}
		});
	}
}

