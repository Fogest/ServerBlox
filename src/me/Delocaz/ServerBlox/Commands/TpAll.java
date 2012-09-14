package me.Delocaz.ServerBlox.Commands;

import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.ServerBlox;

public class TpAll extends SBCmd {
	public TpAll(String cmd, String perm, ServerBlox sb) {
		super(cmd, perm, sb);
	}
	public void player(Player p, String[] args) {
		for (Player pp : sb.getServer().getOnlinePlayers()) {
			pp.teleport(p);
		}
		p.sendMessage(lng.get("tpAll"));
	}
}
