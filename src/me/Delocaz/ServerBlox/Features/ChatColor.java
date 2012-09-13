package me.Delocaz.ServerBlox.Features;

import me.Delocaz.ServerBlox.SBFeature;
import me.Delocaz.ServerBlox.SBUtils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatColor extends SBFeature {
	public ChatColor(String string) {
		super(string);
	}
	public void init() {
	}
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if (e.getPlayer().hasPermission("serverblox.chat.color")) {
			e.setMessage(SBUtils.colorize(e.getMessage()));
		}
	}
}
