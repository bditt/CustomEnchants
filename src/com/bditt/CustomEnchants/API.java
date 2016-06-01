package com.bditt.CustomEnchants;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.bditt.CustomEnchants.Enchants.CustomEnchants;
import com.bditt.CustomEnchants.Support.FactionSupport;
import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.flags.StateFlag;

public class API 
{
	  public static boolean allowsPVP(Entity en)
	  {
	    if ((Bukkit.getServer().getPluginManager().getPlugin("WorldEdit") != null) && (Bukkit.getServer().getPluginManager().getPlugin("WorldGuard") != null))
	    {
	      int x = en.getLocation().getBlockX();
	      int y = en.getLocation().getBlockY();
	      int z = en.getLocation().getBlockZ();
	      Location loc = new Location(en.getWorld(), x, y, z);
	      ApplicableRegionSet set = WGBukkit.getPlugin().getRegionManager(en.getWorld()).getApplicableRegions(loc);
	      if (set.queryState(null, new StateFlag[] { DefaultFlag.PVP }) == StateFlag.State.DENY) {
	        return false;
	      }
	    }
	    return true;
	  }
	  
	  public static Player getPlayer(String name)
	  {
	    return Bukkit.getServer().getPlayer(name);
	  }
	  
	  public static Location getLoc(Player player)
	  {
	    return player.getLocation();
	  }
	  
	  public static void runCMD(Player player, String CMD)
	  {
	    player.performCommand(CMD);
	  }
	  
	  static double getMoney(Player player){
			return CustomEnchants.econ.getBalance(player);
	  }
	  
	  static int getXPLvl(Player player){
			return player.getLevel();
		}
	  
	  public static void takeLvlXP(Player player, int amount){
			player.setLevel(player.getLevel() - amount);
	  }
	  
	  public static int getTotalExperience(Player player){// https://www.spigotmc.org/threads/72804
			int experience = 0;
			int level = player.getLevel();
			if(level >= 0 && level <= 15) {
				experience = (int) Math.ceil(Math.pow(level, 2) + (6 * level));
				int requiredExperience = 2 * level + 7;
				double currentExp = Double.parseDouble(Float.toString(player.getExp()));
				experience += Math.ceil(currentExp * requiredExperience);
				return experience;
			} else if(level > 15 && level <= 30) {
				experience = (int) Math.ceil((2.5 * Math.pow(level, 2) - (40.5 * level) + 360));
				int requiredExperience = 5 * level - 38;
				double currentExp = Double.parseDouble(Float.toString(player.getExp()));
				experience += Math.ceil(currentExp * requiredExperience);
				return experience;
			} else {
				experience = (int) Math.ceil(((4.5 * Math.pow(level, 2) - (162.5 * level) + 2220)));
				int requiredExperience = 9 * level - 158;
				double currentExp = Double.parseDouble(Float.toString(player.getExp()));
				experience += Math.ceil(currentExp * requiredExperience);
				return experience;       
			}
		}
	  
		public static void takeTotalXP(Player player, int amount){
			int total = getTotalExperience(player) - amount;
			player.setTotalExperience(0);
	        player.setTotalExperience(total);
	        player.setLevel(0);
	        player.setExp(0);
	        for(;total > player.getExpToLevel();){
	            total -= player.getExpToLevel();
	            player.setLevel(player.getLevel()+1);
	        }
	        float xp = (float)total / (float)player.getExpToLevel();
	        player.setExp(xp);
		}
		
		public static boolean isInvFull(Player player){
			if(player.getInventory().firstEmpty()==-1){
				return true;
			}
			return false;
		}
		  public static String removeColor(String msg)
		  {
		    msg = ChatColor.stripColor(msg);
		    return msg;
		  }
		  public static boolean isFriendly(Entity P, Entity O)
		  {
		    if (((P instanceof Player)) && ((O instanceof Player)) && 
		      (Bukkit.getServer().getPluginManager().getPlugin("Factions") != null))
		    {
		      Plugin factions = Bukkit.getServer().getPluginManager().getPlugin("Factions");
		      Player player = (Player)P;
		      Player other = (Player)O;
		      if (factions.getDescription().getWebsite().equalsIgnoreCase("https://www.massivecraft.com/factions"))
		      {
		        if (FactionSupport.isFriendly(player, other)) {
		          return true;
		        }
		        if (!FactionSupport.isFriendly(player, other)) {
		          return false;
		        }
		      }
		    }
		    return false;
		  }
}

