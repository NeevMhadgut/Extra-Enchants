package com.example.advancedenchantments.enchantments.tool;

import com.example.advancedenchantments.enchantments.BaseEnchantment;
import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.AxeItem;

public class ExperienceEnchantment extends BaseEnchantment {
	public static final ExperienceEnchantment INSTANCE = new ExperienceEnchantment();
	
	private ExperienceEnchantment() {
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
	
	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		return stack.getItem() instanceof PickaxeItem || 
			   stack.getItem() instanceof ShovelItem || 
			   stack.getItem() instanceof AxeItem;
	}
	
	public void onBlockMined(PlayerEntity player, int level) {
		if (!player.getWorld().isClient) {
			int xp = 1 + (level / 2);
			player.addExperience(xp);
		}
	}
}

