package me.Delocaz.ServerBlox.Commands;

import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.ServerBlox;

public class TpHere extends SBCmd {
	public TpHere(String cmd, String perm, ServerBlox sb) {
		super(cmd, perm, sb);
	}
	public void player(Player p, String[] args) {
		if (args.length == 0) {
			p.sendMessage(lng.wrongArgs);
		}
		Player pp = matchPlayer(args[0]);
		if (pp == null) {
			p.sendMessage(lng.noMatch.replaceAll("%player", args[0]));
		}
		pp.teleport(p);
		p.sendMessage(lng.tpHere.replaceAll("%player", pp.getDisplayName()));
	}
}
