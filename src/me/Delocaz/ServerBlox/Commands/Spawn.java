package me.Delocaz.ServerBlox.Commands;

import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.ServerBlox;

public class Spawn extends SBCmd {
	public Spawn(String cmd, String perm, ServerBlox sb) {
		super(cmd, perm, sb);
	}
	public void player(Player p, String[] args) {
		p.teleport(p.getWorld().getSpawnLocation());
		p.sendMessage(lng.spawnTp);
	}
}
