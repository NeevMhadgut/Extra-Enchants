package com.example.advancedenchantments.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentRarity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public abstract class BaseEnchantment extends Enchantment {
	protected BaseEnchantment(EnchantmentRarity weight, EquipmentSlot[] slotTypes) {
		super(Enchantment.definition(weight, slotTypes));
	}
	
	@Override
	public boolean isAvailableForEnchantedBookOffer() {
		return true;
	}
	
	@Override
	public boolean isAvailableForRandomSelection() {
		return true;
	}
	
	@Override
	public boolean isTreasure() {
		return false;
	}
	
	@Override
	public boolean isCursed() {
		return false;
	}
	
	@Override
	protected String getOrCreateTranslationKey() {
		Registry<Enchantment> registry = Registries.ENCHANTMENT;
		Identifier id = registry.getId(this);
		if (id != null) {
			return "enchantment." + id.getNamespace() + "." + id.getPath();
		}
		return "enchantment.advancedenchantments.unknown";
	}
}
