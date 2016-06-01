package com.bditt.CustomEnchants.Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.bditt.CustomEnchants.Enchants.CustomEnchants;

public class PlayerInteract implements Listener {
	
	public Inventory signInv = Bukkit.createInventory(null, 9, "Sign Inventory");
	
	@SuppressWarnings("unused")
	private CustomEnchants plugin;
	
	public PlayerInteract(CustomEnchants plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(e.getClickedBlock().getState() instanceof Sign) {
				Sign sign = (Sign) e.getClickedBlock().getState();
				if(sign.getLine(0).equals("Sign Changed...")) {
					addItems();
					e.getPlayer().openInventory(signInv);
				}
			}
		}
	}
	
	public void addItems() {
		signInv.setItem(0, new ItemStack(Material.GOLD_BLOCK, 1));
		signInv.setItem(2, new ItemStack(Material.DIAMOND_BLOCK, 3));
		signInv.setItem(4, new ItemStack(Material.IRON_BLOCK, 5));
	}

}
