package me.Delocaz.ServerBlox.Commands;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.ServerBlox;

public class SetWarp extends SBCmd {
	public SetWarp(String cmd, String perm, ServerBlox sb) {
		super(cmd, perm, sb);
	}
	public void player(Player p, String[] args) {
		Location l = p.getLocation();
		if (args.length == 0) {
			p.sendMessage(lng.wrongArgs);
		}
		String warp = args[0];
		cfg.set("warps."+warp+".x", l.getX());
		cfg.set("warps."+warp+".y", l.getY());
		cfg.set("warps."+warp+".z", l.getZ());
		cfg.set("warps."+warp+".pitch", l.getPitch());
		cfg.set("warps."+warp+".yaw", l.getYaw());
		cfg.set("warps."+warp+".world", l.getWorld().getName());
		p.sendMessage(lng.warpSet);
	}
}
