package me.Delocaz.ServerBlox.Commands;

import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;

public class ClearScreen extends SBCmd {
	public ClearScreen(String cmd) {
		super(cmd);
	}
	public void player(Player p, String[] args) {
		for (int i=0;i<100;i++) {
			p.sendMessage("");
		}
	}
}
