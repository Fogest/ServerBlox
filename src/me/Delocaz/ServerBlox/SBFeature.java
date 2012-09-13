package me.Delocaz.ServerBlox;

import org.bukkit.event.Listener;

public class SBFeature extends SBBase implements Listener {
	public String name;
	public SBFeature(String string) {
		name = string;
		init();
	}

	public void init() {
	}
}
