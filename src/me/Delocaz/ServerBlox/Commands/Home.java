package me.Delocaz.ServerBlox.Commands;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.SBUtils;

public class Home extends SBCmd {
	public Home(String cmd) {
		super(cmd);
	}
	public void player(Player p, String[] args) {
		if (getPlayerData(p, "home.x") != null) {
			tpToHome(p);
		} else {
			p.sendMessage(lng.get("noHome"));
		}
	}
	@EventHandler
	public void onPlayerRespawn(final PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		if (getPlayerData(p, "home.x") != null) {
			tpToHome(p);
		}
	}
	public void tpToHome(Player p) {
		Location l = SBUtils.toLoc(getPlayerData(p, "home.world"),getPlayerData(p, "home.x"),getPlayerData(p, "home.y"),getPlayerData(p, "home.z"),getPlayerData(p, "home.pitch"),getPlayerData(p, "home.yaw"));
		if (l != null) {
			p.teleport(l);
			p.sendMessage(lng.get("homeTp"));
		}
	}
}
