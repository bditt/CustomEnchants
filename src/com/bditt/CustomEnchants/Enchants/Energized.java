package com.bditt.CustomEnchants.Enchants;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import adx.audioxd.customenchantmentapi.enchantment.Enchantment;
import adx.audioxd.customenchantmentapi.enchantment.event.EnchantmentEventHandler;
import adx.audioxd.customenchantmentapi.enchantment.event.forhelp.Lvl;
import adx.audioxd.customenchantmentapi.enums.ItemType;
import adx.audioxd.customenchantmentapi.events.inventory.EEquipEvent;
import adx.audioxd.customenchantmentapi.events.inventory.EUnequipEvent;

@SuppressWarnings("unused")
public class Energized extends Enchantment {

	public Energized() {
		super(ChatColor.GRAY + "Energized" + ChatColor.GRAY, ItemType.ALL_OFF_THE_ABOVE, 40);
	}

	@EnchantmentEventHandler public void onEquip(EEquipEvent event,int lvl) {
		if (event.getOwner() instanceof Player) {
			Player player = (Player) event.getOwner();
		}
		event.getOwner().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 720000, lvl-1));
	}

	@EnchantmentEventHandler public void onUnequip(EUnequipEvent event) {
		if (event.getOwner() instanceof Player) {
			Player player = (Player) event.getOwner();
		}
		event.getOwner().removePotionEffect(PotionEffectType.SPEED);
	}
}