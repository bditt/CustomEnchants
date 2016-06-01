package com.bditt.CustomEnchants.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignWrite implements Listener {

	@EventHandler
	public void signWriteEvent(SignChangeEvent e) {
		if(e.getLine(0).equalsIgnoreCase("SignWrite")) {
			e.setLine(0, "Sign Changed...");
			e.setLine(1,"Complete!");
		}
	}
}