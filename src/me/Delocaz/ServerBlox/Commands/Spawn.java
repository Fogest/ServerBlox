package me.Delocaz.ServerBlox.Commands;

import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;

public class Spawn extends SBCmd {
	public Spawn(String cmd) {
		super(cmd);
	}
	public void player(Player p, String[] args) {
		p.teleport(p.getWorld().getSpawnLocation());
		p.sendMessage(lng.get("spawnTp"));
	}
}
