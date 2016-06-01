package com.bditt.CustomEnchants.Enchants;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.bditt.CustomEnchants.API;

import adx.audioxd.customenchantmentapi.enchantment.Enchantment;
import adx.audioxd.customenchantmentapi.enchantment.event.EnchantmentEventHandler;
import adx.audioxd.customenchantmentapi.enums.ItemType;
import adx.audioxd.customenchantmentapi.events.damage.EOwnerDamagesEntityEvent;

public class Fling extends Enchantment {
	public Fling() {
		super(ChatColor.GRAY + "Fling" + ChatColor.GRAY, ItemType.ALL_OFF_THE_ABOVE, 40);
	}
	
	@EnchantmentEventHandler
	  public void EOwnerDamagesEntityEvent(EOwnerDamagesEntityEvent event,Vector v){
		Player at = (Player) event.getOwner();
		Player p = (Player) event.getVictim();
		if (!API.allowsPVP(event.getVictim())) {
		      return;
		}
		if (!API.allowsPVP(event.getOwner())) {
		      return;
		}
		if (event.isCancelled()) {
		      return;
		}
		at.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 0.001F);
		p.getExp();
		p.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "You have just been flung");
		}
}
