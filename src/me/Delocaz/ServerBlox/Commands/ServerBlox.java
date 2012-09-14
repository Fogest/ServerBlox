package me.Delocaz.ServerBlox.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;

public class ServerBlox extends SBCmd {
	public ServerBlox(String cmd, String perm, me.Delocaz.ServerBlox.ServerBlox sb) {
		super(cmd, perm, sb);
	}
	public void player(Player p, String[] args) {
		if (args.length == 0) {
			p.sendMessage("ServerBlox v"+ChatColor.GRAY+sb.getDescription().getVersion());
			return;
		}
		if (args[0] == "reload") {
			cfg.load();
		}
	}
}
