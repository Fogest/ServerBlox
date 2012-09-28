package me.Delocaz.ServerBlox.Commands;

import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;

public class Clear extends SBCmd {
	public Clear(String cmd) {
		super(cmd);
	}
	public void player(Player p, String[] args) {
		p.getInventory().clear();
		p.sendMessage(lng.get("invClear"));
	}
}
