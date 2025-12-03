package com.example.advancedenchantments.enchantments.weapon;

import com.example.advancedenchantments.enchantments.BaseEnchantment;
import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.TridentItem;
import net.minecraft.server.world.ServerWorld;

public class LightningStrikeEnchantment extends BaseEnchantment {
	public static final LightningStrikeEnchantment INSTANCE = new LightningStrikeEnchantment();
	
	private LightningStrikeEnchantment() {
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
		if (!target.getWorld().isClient && user.getWorld() instanceof ServerWorld serverWorld && target.getRandom().nextFloat() < 0.1f * level) {
			LightningEntity lightning = new LightningEntity(net.minecraft.entity.EntityType.LIGHTNING_BOLT, serverWorld);
			lightning.refreshPositionAfterTeleport(target.getX(), target.getY(), target.getZ());
			serverWorld.spawnEntity(lightning);
		}
	}
}

