package com.bditt.CustomEnchants;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Trash extends GUI {
	private static Trash i = new Trash();

	public static Trash get() {return i;}

	public Trash() {
		super(ChatColor.GREEN + "Trash Can");
	}

	@Override
	public void registerGUIOptions() {
			}
}
