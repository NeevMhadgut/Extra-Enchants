package com.example.advancedenchantments.enchantments.weapon;

import com.example.advancedenchantments.enchantments.BaseEnchantment;
import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.TridentItem;
import net.minecraft.util.math.Vec3d;

public class AssassinEnchantment extends BaseEnchantment {
	public static final AssassinEnchantment INSTANCE = new AssassinEnchantment();
	
	private AssassinEnchantment() {
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
		return 5;
	}
	
	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		return stack.getItem() instanceof SwordItem || stack.getItem() instanceof TridentItem;
	}
	
	public float getDamageMultiplier(LivingEntity attacker, LivingEntity target, int level) {
		Vec3d attackerLook = attacker.getRotationVec(1.0f);
		Vec3d toTarget = target.getPos().subtract(attacker.getPos()).normalize();
		double dot = attackerLook.dotProduct(toTarget);
		
		// If attacking from behind (dot product close to -1)
		if (dot < -0.5) {
			return 1.0f + (level * 0.25f);
		}
		return 1.0f;
	}
}

