package me.Delocaz.ServerBlox.Commands;

import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;

public class TpAll extends SBCmd {
	public TpAll(String cmd) {
		super(cmd);
	}
	public void player(Player p, String[] args) {
		for (Player pp : sb.getServer().getOnlinePlayers()) {
			pp.teleport(p);
		}
		p.sendMessage(lng.get("tpAll"));
	}
}
