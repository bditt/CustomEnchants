package com.bditt.CustomEnchants.Enchants;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import adx.audioxd.customenchantmentapi.enchantment.Enchantment;
import adx.audioxd.customenchantmentapi.enchantment.event.EnchantmentEventHandler;
import adx.audioxd.customenchantmentapi.enums.ItemType;
import adx.audioxd.customenchantmentapi.events.inventory.EEquipEvent;
import adx.audioxd.customenchantmentapi.events.inventory.EUnequipEvent;

@SuppressWarnings("unused")
public class Tank extends Enchantment {

	public Tank() {
		super(ChatColor.GRAY + "Tank" + ChatColor.GRAY, ItemType.ALL_OFF_THE_ABOVE, 40);
	}

	@EnchantmentEventHandler public void onEquip(EEquipEvent event) {
		if (event.getOwner() instanceof Player) {
			Player player = (Player) event.getOwner();
		}
		event.getOwner().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 720000, 2));
		event.getOwner().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 720000, 1));
		event.getOwner().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 720000, 0));
	}

	@EnchantmentEventHandler public void onUnequip(EUnequipEvent event) {
		if (event.getOwner() instanceof Player) {
			Player player = (Player) event.getOwner();
		}
		event.getOwner().removePotionEffect(PotionEffectType.SLOW);
		event.getOwner().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		event.getOwner().removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
	}
}