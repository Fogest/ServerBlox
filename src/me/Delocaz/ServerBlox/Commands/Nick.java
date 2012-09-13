package me.Delocaz.ServerBlox.Commands;

import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.ServerBlox;

public class Nick extends SBCmd {
	public Nick(String cmd, String perm, ServerBlox sb) {
		super(cmd, perm, sb);
	}
	public void player(Player p, String[] args) {
		if (args.length == 0) {
			p.setDisplayName(p.getName());
			p.sendMessage(lng.nickOff);
		} else {
			p.setDisplayName(args[0]);
			p.sendMessage(lng.nickSet.replaceAll("&nick", args[0]));
		}
	}
}
