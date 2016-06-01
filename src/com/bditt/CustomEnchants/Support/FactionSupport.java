package com.bditt.CustomEnchants.Support;

import org.bukkit.entity.Player;

import com.bditt.CustomEnchants.API;
import com.massivecraft.factions.Rel;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;

public class FactionSupport 
{
		  public static boolean isFriendly(Player P, Player O)
		  {
		    Player player = P;
		    Player other = O;
		    Faction p = MPlayer.get(player).getFaction();
		    Faction o = MPlayer.get(other).getFaction();
		    Rel r = MPlayer.get(player).getRelationTo(MPlayer.get(other));
		    if (API.removeColor(o.getName()).equalsIgnoreCase("Wilderness")) {
		      return false;
		    }
		    if (!r.isFriend()) {
		      return false;
		    }
		    if (r.isFriend()) {
		      return true;
		    }
		    if (p == o) {
		      return true;
		    }
		    return false;
		  }
		}
