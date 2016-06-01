package com.bditt.CustomEnchants.Enchants;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.bditt.CustomEnchants.API;

import adx.audioxd.customenchantmentapi.enchantment.Enchantment;
import adx.audioxd.customenchantmentapi.enchantment.event.EnchantmentEventHandler;
import adx.audioxd.customenchantmentapi.enums.ItemType;
import adx.audioxd.customenchantmentapi.events.bow.EArrowHitEvent;
import adx.audioxd.customenchantmentapi.events.damage.EOwnerDamagesEntityEvent;

public class Blinding extends Enchantment {
	public Blinding() {
		super(ChatColor.GRAY + "Blinding" + ChatColor.GRAY, ItemType.ALL_OFF_THE_ABOVE, 40);
	}
	
	@EnchantmentEventHandler
	  public void EOwnerDamagesEntityEvent(EOwnerDamagesEntityEvent event,int lvl){
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
		((Player) event.getVictim()).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, lvl-1));
		((LivingEntity) event.getVictim()).addPotionEffect(new PotionEffect (PotionEffectType.BLINDNESS, 200, lvl-1));
		}
	}
	@EnchantmentEventHandler 
	public void onArrowHit(EArrowHitEvent event) {
		((LivingEntity) event.getTarget()).addPotionEffect(new PotionEffect (PotionEffectType.BLINDNESS, 200, 0));
		((Player) event.getTarget()).addPotionEffect(new PotionEffect (PotionEffectType.BLINDNESS, 200, 0));
	}
}