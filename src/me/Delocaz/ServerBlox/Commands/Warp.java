package me.Delocaz.ServerBlox.Commands;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.ServerBlox;
import me.Delocaz.ServerBlox.Exceptions.WrongArgsException;

public class Warp extends SBCmd {
	public Warp(String cmd, String perm, ServerBlox sb) {
		super(cmd, perm, sb);
	}
	public void player(Player p, String[] args) throws WrongArgsException {
		if (args.length == 0) {
			throw new WrongArgsException(p, this, lng.get("enterWarp"));
		}
		tpToWarp(p, args[0]);
	}
	public void tpToWarp(Player p, String warp) throws WrongArgsException {
		if (cfg.getString("warps."+warp+".world") == null) {
			throw new WrongArgsException(p, this, lng.get("noWarp"));
		}
		Location l = new Location(sb.getServer().getWorld(cfg.getString("warps."+warp+".world")), cfg.getDouble("warps."+warp+".x"), cfg.getDouble("warps."+warp+".y"), cfg.getDouble("warps."+warp+".z"));
		l.setPitch(((Double)cfg.getDouble("warps."+warp+".pitch")).floatValue());
		l.setYaw(((Double)cfg.getDouble("warps."+warp+".yaw")).floatValue());
		if (l != null) {
			p.teleport(l);
			p.sendMessage(lng.get("warpTp"));
		}
	}
}
