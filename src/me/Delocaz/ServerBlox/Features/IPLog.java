package me.Delocaz.ServerBlox.Features;

import java.util.List;

import me.Delocaz.ServerBlox.SBFeature;
import me.Delocaz.ServerBlox.SBPlayerData;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import com.google.common.collect.Lists;

public class IPLog extends SBFeature {
	public IPLog(String string) {
		super(string);
	}
	public void init() {
	}
	@SuppressWarnings("unchecked")
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String ip = p.getAddress().getAddress().getHostAddress();
		List<String> prevIP = (List<String>) SBPlayerData.getStatic(p, "ips");
		if (prevIP == null) {
			prevIP = Lists.newArrayList();
		}
		prevIP.add(ip);
		SBPlayerData.putStatic(p, "ips", prevIP);
	}
}
