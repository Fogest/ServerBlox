package me.Delocaz.ServerBlox.Commands;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.ServerBlox;

public class SetSpawn extends SBCmd {
	public SetSpawn(String cmd, String perm, ServerBlox sb) {
		super(cmd, perm, sb);
	}
	public void player(Player p, String[] args) {
		Location l = p.getLocation();
		l.getWorld().setSpawnLocation(l.getBlockX(), l.getBlockY(), l.getBlockZ());
		p.sendMessage(lng.get("spawnSet"));
	}
}
