package com.bditt.CustomEnchants.Enchants;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import adx.audioxd.customenchantmentapi.enchantment.Enchantment;
import adx.audioxd.customenchantmentapi.enchantment.event.EnchantmentEventHandler;
import adx.audioxd.customenchantmentapi.enums.ItemType;
import adx.audioxd.customenchantmentapi.events.inventory.hand.EItemInHandEvent;
import adx.audioxd.customenchantmentapi.events.inventory.hand.EItemNotInHandEvent;

public class Haste extends Enchantment {
	public Haste() {
		super(ChatColor.GRAY + "Haste" + ChatColor.GRAY, ItemType.ALL_OFF_THE_ABOVE, 40);
	}
	
	@SuppressWarnings("unused")
	@EnchantmentEventHandler public void onHold(EItemInHandEvent event,int lvl) {
		if (event.getOwner() instanceof Player) {
			Player player = (Player) event.getOwner();
		}
		event.getOwner().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 720000, lvl-1));
	}
	
	@SuppressWarnings("unused")
	@EnchantmentEventHandler public void onNotInHand(EItemNotInHandEvent event) {
		if (event.getOwner() instanceof Player) {
			Player player = (Player) event.getOwner();
		}
		event.getOwner().removePotionEffect(PotionEffectType.FAST_DIGGING);
	}
}
