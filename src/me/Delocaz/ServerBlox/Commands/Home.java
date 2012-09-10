package me.Delocaz.ServerBlox.Commands;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.SBUtils;
import me.Delocaz.ServerBlox.ServerBlox;

public class Home extends SBCmd {
	public Home(String cmd, String perm, ServerBlox sb) {
		super(cmd, perm, sb);
	}
	public void player(Player p, String[] args) {
		Location l = SBUtils.toLoc(getPlayerData(p, "home.world"),getPlayerData(p, "home.x"),getPlayerData(p, "home.y"),getPlayerData(p, "home.z"),getPlayerData(p, "home.pitch"),getPlayerData(p, "home.yaw"));
		if (l != null) {
			p.teleport(l);
			p.sendMessage(lng.homeTp);
		}
	}
}
