package com.bditt.CustomEnchants.Enchants;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import com.bditt.CustomEnchants.IconMenu;
import com.bditt.CustomEnchants.Enchants.Poison;
import com.bditt.CustomEnchants.Events.InventoryClick;
import com.bditt.CustomEnchants.Events.PlayerInteract;
import com.bditt.CustomEnchants.Events.SignWrite;

import adx.audioxd.customenchantmentapi.EnchantmentRegistry;
import adx.audioxd.customenchantmentapi.enchantment.Enchantment;
import adx.audioxd.customenchantmentapi.plugin.CEPLPlugin;
import net.milkbowl.vault.economy.Economy;

public class CustomEnchants extends CEPLPlugin {
	public static Enchantment DEBUG = new Debug();
	public static Enchantment POISON = new Poison();
	public static Enchantment EXPLOSIVE = new Explosive();
	public static Enchantment SNEAKY = new Sneaky();
	public static Enchantment ENERGIZED = new Energized();
	public static Enchantment BLINDING = new Blinding();
	public static Enchantment HASTE = new Haste();
	public static Enchantment WITHER = new Wither();
	public static Enchantment THREEBYTHREE = new ThreeByThree();
	public static Enchantment WELLFED = new WellFed();
	public static Enchantment FISH = new Fish();
	public static Enchantment TANK = new Tank();
	public static Enchantment LIGHTNING = new Lightning();
	public static Economy econ = null;
	
	public static IconMenu im;
	public CustomEnchants plugin;
	public InventoryClick invClick;
	public PlayerInteract pInteract;

	@Override
	public void Enable() {
		if (!EnchantmentRegistry.register(this, DEBUG))
			getPluginLogger().severe("Culdn't enable " + DEBUG.getName() + " enchantmnt");
		if (!EnchantmentRegistry.register(this, POISON))
			getPluginLogger().severe("Culdn't enchable" + POISON.getName() + " enchantment");
		if (!EnchantmentRegistry.register(this, EXPLOSIVE))
			getPluginLogger().severe("Culdn't enchable" + EXPLOSIVE.getName() + " enchantment");
		if (!EnchantmentRegistry.register(this, SNEAKY))
			getPluginLogger().severe("Culdn't enchable" + SNEAKY.getName() + " enchantment");
		if (!EnchantmentRegistry.register(this, ENERGIZED))
			getPluginLogger().severe("Culdn't enchable" + ENERGIZED.getName() + " enchantment");
		if (!EnchantmentRegistry.register(this, BLINDING))
			getPluginLogger().severe("Culdn't enchable" + BLINDING.getName() + " enchantment");
		if (!EnchantmentRegistry.register(this, HASTE))
			getPluginLogger().severe("Culdn't enchable" + HASTE.getName() + " enchantment");
		if (!EnchantmentRegistry.register(this, WITHER))
			getPluginLogger().severe("Culdn't enchable" + WITHER.getName() + " enchantment");
		if (!EnchantmentRegistry.register(this, WELLFED))
			getPluginLogger().severe("Culdn't enchable" + WELLFED.getName() + " enchantment");
		if (!EnchantmentRegistry.register(this, THREEBYTHREE))
			getPluginLogger().severe("Culdn't enchable" + THREEBYTHREE.getName() + " enchantment");
		if (!EnchantmentRegistry.register(this, FISH))
			getPluginLogger().severe("Culdn't enchable" + FISH.getName() + " enchantment");
		if (!EnchantmentRegistry.register(this, TANK))
			getPluginLogger().severe("Culdn't enchable" + TANK.getName() + " enchantment");
		if (!EnchantmentRegistry.register(this, LIGHTNING))
			getPluginLogger().severe("Culdn't enchable" + LIGHTNING.getName() + " enchantment");
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new SignWrite(), this);
		pm.registerEvents(new PlayerInteract(this), this);
		pm.registerEvents(new InventoryClick(this), this);
		pm.registerEvents(im, this);
		
		invClick = new InventoryClick(this);
		pInteract = new PlayerInteract(this);
	}

	@Override
	public void Disable() {
		EnchantmentRegistry.unregisterAll(this);
	}
	 
	public boolean onCommand(CommandSender s, Command cmd, String cl, String[] args) {
	        Player p = (Player) s;
	 
	        if (cl.equalsIgnoreCase("TestGui")) {
	 
	            IconMenu menu = new IconMenu("My Fancy Menu", 9, new IconMenu.OptionClickEventHandler() {
	                @Override
	                public void onOptionClick(IconMenu.OptionClickEvent event) {
	                    event.getPlayer().sendMessage("You Have Chosen position" + event.getPosition());
	                    event.setWillClose(true);
	                }
	            }, this).setOption(3, new ItemStack(Material.APPLE, 64), "Food", "The food is delicious")
	            		.setOption(4, new ItemStack(Material.IRON_SWORD, 1), "Weapon", "Weapons are for awesome people")
	            		.setOption(5, new ItemStack(Material.EMERALD, 1), "Money", "Money brings happiness")
	            		.setOption(6,new ItemStack(Material.ENCHANTED_BOOK), "Enchantments", "Buy Normal Enchantments");
	 
	            menu.open(p);
	        }
	        return false;
	    }
}