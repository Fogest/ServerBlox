package me.Delocaz.ServerBlox.Features;

import java.util.List;

import me.Delocaz.ServerBlox.SBFeature;
import me.Delocaz.ServerBlox.SBPlayerData;
import me.Delocaz.ServerBlox.SBUtils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import com.google.common.collect.Lists;

public class PlayerLog extends SBFeature {
	public PlayerLog(String string) {
		super(string);
	}
	public void init() {
	}
	@SuppressWarnings("unchecked")
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		List<String> players = (List<String>) SBPlayerData.getStatic(p, "ips");
		if (players == null) {
			players = Lists.newArrayList();
		}
		players.add(p.getName());
		SBUtils.getPlugin().getConfig().set("players", players);
	}
}
