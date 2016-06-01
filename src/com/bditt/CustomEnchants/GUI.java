package com.bditt.CustomEnchants;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public abstract class GUI implements Listener {

	private final String title;
	private final int ySize;
	private final Map<Integer, GUIOption> options;

	private int largestSlot = 0;

// Constructor
	public GUI(String title) {
		options = new HashMap<>();
		this.title = title;

		registerGUIOptions();
		largestSlot++;
		ySize = (largestSlot / 9) + (((largestSlot % 9) == 0) ? 0 : 1);
	}

	public abstract void registerGUIOptions();

	public final void openGUI(Player player) {
		Inventory inventory = Bukkit.createInventory(player, ySize * 9, title);

		for(int slot : options.keySet()) {
			if(slot <= inventory.getSize() - 1)
				inventory.setItem(slot, options.get(slot).getIcon());
		}
		player.openInventory(inventory);
	}

	public final boolean addGUIOption(GUIOption option) {
		if(!options.containsKey(option.getSlot())) {
			options.put(option.getSlot(), option);

			if(option.getSlot() > largestSlot)
				largestSlot = option.getSlot();
			return true;
		}
		return false;
	}

	@EventHandler
	public final void executeOptionsOnClick(InventoryClickEvent event) {
		Inventory inventory = event.getInventory();
		if(inventory == null) return;
		if(!inventory.getTitle().equals(title)) return;
		if(!(event.getWhoClicked() instanceof Player)) return;

		event.setCancelled(true);

		if(options.containsKey(event.getSlot())) {
			GUIOption option = options.get(event.getSlot());
			if(option == null) return;
			option.onClick((Player) event.getWhoClicked());
		}
	}

	public void activate(Plugin plugin) {
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	// The GUI Option class
	public static class GUIOption {
		private final ItemStack icon;
		private final int slot;
		private final GUIRunnable onClick;

// Constructor
		public GUIOption(int slot, ItemStack icon, GUIRunnable onClick) {
			this.icon = icon;
			this.slot = slot;
			this.onClick = onClick;
		}

		public final void onClick(Player owner) {
			if(onClick != null)
				onClick.run(owner);
		}

// Getters
		public final ItemStack getIcon() {
			return icon;
		}

		public final int getSlot() {
			return slot;
		}
	}

	public static abstract class GUIRunnable {
		public abstract void run(Player owner);
	}
}
