package com.example.advancedenchantments.enchantments.weapon;

import com.example.advancedenchantments.enchantments.BaseEnchantment;
import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.TridentItem;
import net.minecraft.util.math.Vec3d;

public class TeleportStrikeEnchantment extends BaseEnchantment {
	public static final TeleportStrikeEnchantment INSTANCE = new TeleportStrikeEnchantment();
	
	private TeleportStrikeEnchantment() {
		super(EnchantmentRarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	}
	
	@Override
	public int getMinPower(int level) {
		return 20 + (level - 1) * 15;
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
		if (!target.getWorld().isClient && user.getRandom().nextFloat() < 0.15f * level) {
			Vec3d targetPos = target.getPos();
			Vec3d userPos = user.getPos();
			Vec3d direction = targetPos.subtract(userPos).normalize();
			Vec3d teleportPos = targetPos.add(direction.multiply(-1));
			user.teleport(teleportPos.x, teleportPos.y, teleportPos.z);
		}
	}
}

