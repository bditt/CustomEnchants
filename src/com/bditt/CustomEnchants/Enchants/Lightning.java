package com.bditt.CustomEnchants.Enchants;

import java.util.Random;

import org.bukkit.ChatColor;
import com.bditt.CustomEnchants.API;

import adx.audioxd.customenchantmentapi.enchantment.Enchantment;
import adx.audioxd.customenchantmentapi.enchantment.event.EnchantmentEventHandler;
import adx.audioxd.customenchantmentapi.enums.ItemType;
import adx.audioxd.customenchantmentapi.events.damage.EOwnerDamagesEntityEvent;

public class Lightning extends Enchantment {
	public Lightning() {
		super(ChatColor.GRAY + "Lightning" + ChatColor.GRAY, ItemType.ALL_OFF_THE_ABOVE, 40);
	}
	
	@EnchantmentEventHandler
	  public void EOwnerDamagesEntityEvent(EOwnerDamagesEntityEvent event){
		if (!API.allowsPVP(event.getVictim())) {
		      return;
		}
		if (!API.allowsPVP(event.getOwner())) {
		      return;
		}
		if (API.isFriendly(event.getOwner(), event.getVictim())){
		      return;
		}
		if (event.isCancelled()) {
		      return;
		}
		if(new Random().nextInt(100) < 25) {
		event.getVictim().getWorld().strikeLightning(event.getVictim().getLocation());
		}
	}
	}
