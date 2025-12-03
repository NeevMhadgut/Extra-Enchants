package com.example.advancedenchantments.enchantments.weapon;

import com.example.advancedenchantments.enchantments.BaseEnchantment;
import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.TridentItem;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class ExplosiveEnchantment extends BaseEnchantment {
	public static final ExplosiveEnchantment INSTANCE = new ExplosiveEnchantment();
	
	private ExplosiveEnchantment() {
		super(EnchantmentRarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
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
		return 3;
	}
	
	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		return stack.getItem() instanceof SwordItem || stack.getItem() instanceof TridentItem;
	}
	
	public void onTargetDamaged(LivingEntity user, LivingEntity target, int level) {
		if (!target.getWorld().isClient && user.getRandom().nextFloat() < 0.1f * level) {
			World world = target.getWorld();
			world.createExplosion(null, target.getX(), target.getY(), target.getZ(), level * 0.5f, World.ExplosionSourceType.NONE);
		}
	}
}

