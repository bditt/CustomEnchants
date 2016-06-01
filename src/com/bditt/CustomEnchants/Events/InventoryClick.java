package com.bditt.CustomEnchants.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.bditt.CustomEnchants.Enchants.CustomEnchants;

public class InventoryClick implements Listener {
	
	private CustomEnchants plugin;

	public InventoryClick(CustomEnchants plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(e.getWhoClicked() instanceof Player) {
			Player p = (Player) e.getWhoClicked();
			if(e.getInventory().getName().equals(plugin.pInteract.signInv.getName())) {
				if(!e.getCurrentItem().getType().equals(Material.AIR)) {
					p.sendMessage("You have clicked " + e.getCurrentItem().getType().toString());
					e.setCancelled(true);
				}
			}
		}
	}

}
