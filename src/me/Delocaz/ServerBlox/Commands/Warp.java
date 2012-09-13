package me.Delocaz.ServerBlox.Commands;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.ServerBlox;

public class Warp extends SBCmd {
	public Warp(String cmd, String perm, ServerBlox sb) {
		super(cmd, perm, sb);
	}
	public void player(Player p, String[] args) {
		if (args.length == 0) {
			p.sendMessage(lng.wrongArgs);
		}
		tpToWarp(p, args[0]);
	}
	public void tpToWarp(Player p, String warp) {
		if (cfg.getString("warps."+warp+".world") == null) {
			p.sendMessage(lng.noWarp);
			return;
		}
		Location l = new Location(sb.getServer().getWorld(cfg.getString("warps."+warp+".world")), cfg.getDouble("warps."+warp+".x"), cfg.getDouble("warps."+warp+".y"), cfg.getDouble("warps."+warp+".z"));
		l.setPitch(((Double)cfg.getDouble("warps."+warp+".pitch")).floatValue());
		l.setYaw(((Double)cfg.getDouble("warps."+warp+".yaw")).floatValue());
		if (l != null) {
			p.teleport(l);
			p.sendMessage(lng.warpTp);
		}
	}
}
