package me.Delocaz.ServerBlox.Commands;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.Exceptions.WrongArgsException;

public class SetWarp extends SBCmd {
	public SetWarp(String cmd) {
		super(cmd);
	}
	public void player(Player p, String[] args) throws WrongArgsException {
		Location l = p.getLocation();
		if (args.length == 0) {
			throw new WrongArgsException(p, this, lng.get("enterWarp"));
		}
		String warp = args[0];
		cfg.set("warps."+warp+".x", l.getX());
		cfg.set("warps."+warp+".y", l.getY());
		cfg.set("warps."+warp+".z", l.getZ());
		cfg.set("warps."+warp+".pitch", l.getPitch());
		cfg.set("warps."+warp+".yaw", l.getYaw());
		cfg.set("warps."+warp+".world", l.getWorld().getName());
		cfg.save();
		p.sendMessage(lng.get("warpSet"));
	}
}
