package com.bditt.CustomEnchants.Enchants;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import adx.audioxd.customenchantmentapi.enchantment.Enchantment;
import adx.audioxd.customenchantmentapi.enchantment.event.EnchantmentEventHandler;
import adx.audioxd.customenchantmentapi.enums.ItemType;
import adx.audioxd.customenchantmentapi.events.bow.EArrowHitEvent;
import adx.audioxd.customenchantmentapi.events.bow.EArrowLandEvent;
import adx.audioxd.customenchantmentapi.events.bow.EBowShootEvent;
import adx.audioxd.customenchantmentapi.events.damage.EOwnerDamagedByEntityEvent;
import adx.audioxd.customenchantmentapi.events.damage.EOwnerDamagedEvent;
import adx.audioxd.customenchantmentapi.events.damage.EOwnerDamagesEntityEvent;
import adx.audioxd.customenchantmentapi.events.inventory.EEquipEvent;
import adx.audioxd.customenchantmentapi.events.inventory.EUnequipEvent;
import adx.audioxd.customenchantmentapi.events.inventory.hand.EItemInHandEvent;
import adx.audioxd.customenchantmentapi.events.inventory.hand.EItemNotInHandEvent;
import adx.audioxd.customenchantmentapi.events.world.EBlockBreakEvent;
import adx.audioxd.customenchantmentapi.events.world.EBlockPlaceEvent;
import adx.audioxd.customenchantmentapi.events.world.EInteractEvent;

public class Debug extends Enchantment {

	public Debug() {
		super(ChatColor.GREEN + "Debug Test", ItemType.ALL_OFF_THE_ABOVE, 100);
	}

	@EnchantmentEventHandler
	public void onItemInHand(EItemInHandEvent event) {
		Bukkit.broadcastMessage("[EnchantItemInHandEvent]" + event + " ==== " + event.getHandType());
	}

	@EnchantmentEventHandler
	public void onItemNotInHand(EItemNotInHandEvent event) {
		Bukkit.broadcastMessage("[EnchantItemNotInHandEvent]" + event + " ==== " + event.getHandType());
	}

	@EnchantmentEventHandler
	public void onEquip(EEquipEvent event) {
		Bukkit.broadcastMessage("[EnchantEnquipEvent]" + event);
	}

	@EnchantmentEventHandler
	public void onUnequip(EUnequipEvent event) {
		Bukkit.broadcastMessage("[EnchantUnequipEvent]" + event);
	}

	@EnchantmentEventHandler
	public void whenOwnerIsDamagedByEntity(EOwnerDamagedByEntityEvent event) {
		Bukkit.broadcastMessage("[EnchantOwnerDamagedByEntityEvent]" + event);
	}

	@EnchantmentEventHandler
	public void whenOwnerDamagesAnEntity(EOwnerDamagesEntityEvent event) {
		Bukkit.broadcastMessage("[EnchantOwnerDamagesEntityEvent]" + event);
	}

	@EnchantmentEventHandler
	public void whenOwnerIsDamaged(EOwnerDamagedEvent event) {
		Bukkit.broadcastMessage("[EnchantOwnerDamagedEvent]" + event);
	}

	@EnchantmentEventHandler
	public void onInteract(EInteractEvent event) {
		Bukkit.broadcastMessage("[EnchantInteractEvent]" + event);
	}

	@EnchantmentEventHandler
	public void onBowShoot(EBowShootEvent event) {
		Bukkit.broadcastMessage("[EnchantBowShootEvent]" + event);
	}

	@EnchantmentEventHandler
	public void onArrowHit(EArrowHitEvent event) {
		Bukkit.broadcastMessage("[EnchantArrowHitEvent]" + event);
	}

	@EnchantmentEventHandler
	public void onArrowLand(EArrowLandEvent e) {
		Bukkit.broadcastMessage("[EnchantArrowLandEvent]" + e);
	}

	@EnchantmentEventHandler
	public void onBlockPlace(EBlockPlaceEvent event) {
		Bukkit.broadcastMessage("[EnchantBlockPlaceEvent]" + event);
	}

	@EnchantmentEventHandler
	public void onBlockBreak(EBlockBreakEvent event) {
		Bukkit.broadcastMessage("[EnchantBlockBreakEvent]" + event);
	}

}