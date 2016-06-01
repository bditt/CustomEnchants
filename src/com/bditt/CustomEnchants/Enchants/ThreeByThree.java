package com.bditt.CustomEnchants.Enchants;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;

import adx.audioxd.customenchantmentapi.enchantment.Enchantment;
import adx.audioxd.customenchantmentapi.enchantment.event.EnchantmentEventHandler;
import adx.audioxd.customenchantmentapi.enums.ItemType;
import adx.audioxd.customenchantmentapi.events.world.EBlockBreakEvent;

public class ThreeByThree extends Enchantment {

	public ThreeByThree() {
		super(ChatColor.GRAY + "ThreeByThree", ItemType.ALL_OFF_THE_ABOVE, 1);
	}

	@EnchantmentEventHandler
	public void explode(EBlockBreakEvent event) {
		if(!(event.getOwner() instanceof Player)) return;

		Player owner = (Player) event.getOwner();
			Location blockLocation = event.getBlock().getLocation();

			int radius = 1;
			List<Block> blocks = new ArrayList<>();
			for(int x = (blockLocation.getBlockX() - radius); x <= (blockLocation.getBlockX() + radius); x++) {
				for(int y = (blockLocation.getBlockY() - radius); y <= (blockLocation.getBlockY() + radius); y++) {
					for(int z = (blockLocation.getBlockZ() - radius); z <= (blockLocation.getBlockZ() + radius); z++) {
						Block block = blockLocation.getWorld().getBlockAt(x, y, z);
						blocks.add(block);
					}
				}
			}

			EntityExplodeEvent e = new EntityExplodeEvent(null, blockLocation, blocks, 0);
			Bukkit.getPluginManager().callEvent(e);
			if(!e.isCancelled()) {

				for(Block block : e.blockList()) {
					for(ItemStack item : block.getDrops()) {
						owner.getInventory().addItem(item);
					}
					block.setType(Material.AIR);
				}

				owner.updateInventory();
			}
		}

	}
