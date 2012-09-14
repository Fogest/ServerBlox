package me.Delocaz.ServerBlox.Commands;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.ServerBlox;

public class SetHome extends SBCmd {
	public SetHome(String cmd, String perm, ServerBlox sb) {
		super(cmd, perm, sb);
	}
	public void player(Player p, String[] args) {
		Location l = p.getLocation();
		addPlayerData(p, "home.x", l.getX());
		addPlayerData(p, "home.y", l.getY());
		addPlayerData(p, "home.z", l.getZ());
		addPlayerData(p, "home.pitch", l.getPitch());
		addPlayerData(p, "home.yaw", l.getYaw());
		addPlayerData(p, "home.world", l.getWorld().getName());
		p.sendMessage(lng.get("homeSet"));
	}
}
