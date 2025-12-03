package com.example.advancedenchantments.enchantments;

import com.example.advancedenchantments.AdvancedEnchantmentsMod;
import com.example.advancedenchantments.enchantments.weapon.*;
import com.example.advancedenchantments.enchantments.armor.*;
import com.example.advancedenchantments.enchantments.tool.*;
// import com.example.advancedenchantments.enchantments.bow.*; // Bow enchantments not implemented yet
import com.example.advancedenchantments.enchantments.bane.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class EnchantmentRegistry {
	private static final List<Enchantment> ENCHANTMENTS = new ArrayList<>();
	
	public static void register() {
		AdvancedEnchantmentsMod.LOGGER.info("Registering enchantments...");
		
		// Register weapon enchantments
		registerWeaponEnchantments();
		
		// Register armor enchantments
		registerArmorEnchantments();
		
		// Register tool enchantments
		registerToolEnchantments();
		
		// Register bow enchantments
		registerBowEnchantments();
		
		// Register bane enchantments
		registerBaneEnchantments();
		
		AdvancedEnchantmentsMod.LOGGER.info("Finished registering enchantments!");
	}
	
	private static void registerWeaponEnchantments() {
		register("lifesteal", LifeStealEnchantment.INSTANCE);
		register("poison_aspect", PoisonAspectEnchantment.INSTANCE);
		register("lightning", LightningStrikeEnchantment.INSTANCE);
		register("teleport_strike", TeleportStrikeEnchantment.INSTANCE);
		register("explosive", ExplosiveEnchantment.INSTANCE);
		register("vampirism", VampirismEnchantment.INSTANCE);
		register("rage", RageEnchantment.INSTANCE);
		register("berserker", BerserkerEnchantment.INSTANCE);
		register("assassin", AssassinEnchantment.INSTANCE);
		register("heavy", HeavyEnchantment.INSTANCE);
		register("wither", WitherAspectEnchantment.INSTANCE);
		register("beheading", BeheadingEnchantment.INSTANCE);
		register("strength", StrengthEnchantment.INSTANCE);
	}
	
	private static void registerArmorEnchantments() {
		register("thorns", ThornsEnchantment.INSTANCE);
		register("shield_bash", ShieldBashEnchantment.INSTANCE);
		register("night_vision", NightVisionEnchantment.INSTANCE);
		register("water_breathing", WaterBreathingEnchantment.INSTANCE);
		register("speed", SpeedEnchantment.INSTANCE);
		register("regeneration", RegenerationEnchantment.INSTANCE);
		register("fire_resistance", FireResistanceEnchantment.INSTANCE);
		register("jump_boost", JumpBoostEnchantment.INSTANCE);
		register("damage_reduction", DamageReductionEnchantment.INSTANCE);
		register("tank", TankEnchantment.INSTANCE);
	}
	
	private static void registerToolEnchantments() {
		register("experience", ExperienceEnchantment.INSTANCE);
		register("magnetism", MagnetismEnchantment.INSTANCE);
		register("haste", HasteEnchantment.INSTANCE);
		register("frost_walker", FrostWalkerEnchantment.INSTANCE);
	}
	
	private static void registerBowEnchantments() {
		// Bow-specific enchantments can be added here
	}
	
	private static void registerBaneEnchantments() {
		register("bane_of_illagers", BaneOfIllagersEnchantment.INSTANCE);
		register("bane_of_creepers", BaneOfCreepersEnchantment.INSTANCE);
		register("bane_of_endermen", BaneOfEndermenEnchantment.INSTANCE);
		register("bane_of_blazes", BaneOfBlazesEnchantment.INSTANCE);
		register("bane_of_skeletons", BaneOfSkeletonsEnchantment.INSTANCE);
		register("bane_of_zombies", BaneOfZombiesEnchantment.INSTANCE);
		register("bane_of_spiders", BaneOfSpidersEnchantment.INSTANCE);
		register("bane_of_slimes", BaneOfSlimesEnchantment.INSTANCE);
		register("bane_of_witches", BaneOfWitchesEnchantment.INSTANCE);
		register("bane_of_phantoms", BaneOfPhantomsEnchantment.INSTANCE);
		register("bane_of_piglins", BaneOfPiglinsEnchantment.INSTANCE);
		register("bane_of_hoglins", BaneOfHoglinsEnchantment.INSTANCE);
		register("bane_of_guardians", BaneOfGuardiansEnchantment.INSTANCE);
		register("bane_of_shulkers", BaneOfShulkersEnchantment.INSTANCE);
		register("bane_of_wardens", BaneOfWardensEnchantment.INSTANCE);
		register("bane_of_elder_guardians", BaneOfElderGuardiansEnchantment.INSTANCE);
		register("bane_of_ravagers", BaneOfRavagersEnchantment.INSTANCE);
		register("bane_of_vexes", BaneOfVexesEnchantment.INSTANCE);
		register("bane_of_evokers", BaneOfEvokersEnchantment.INSTANCE);
		register("bane_of_vindicators", BaneOfVindicatorsEnchantment.INSTANCE);
		register("bane_of_pillagers", BaneOfPillagersEnchantment.INSTANCE);
	}
	
	private static void register(String name, Enchantment enchantment) {
		Registry<Enchantment> registry = Registries.ENCHANTMENT;
		Registry.register(registry, Identifier.of(AdvancedEnchantmentsMod.MOD_ID, name), enchantment);
		ENCHANTMENTS.add(enchantment);
	}
	
	public static int getEnchantmentCount() {
		return ENCHANTMENTS.size();
	}
}
