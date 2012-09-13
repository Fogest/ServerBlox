package me.Delocaz.ServerBlox.Commands;

import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.ServerBlox;

public class Tp2p extends SBCmd {
	public Tp2p(String cmd, String perm, ServerBlox sb) {
		super(cmd, perm, sb);
	}
	public void player(Player p, String[] args) {
		if (args.length < 2) {
			p.sendMessage(lng.wrongArgs);
		}
		Player p1 = matchPlayer(args[0]);
		Player p2 = matchPlayer(args[1]);
		if (p1 == null) {
			p.sendMessage(lng.noMatch.replaceAll("%player", args[0]));
		}
		if (p2 == null) {
			p.sendMessage(lng.noMatch.replaceAll("%player", args[1]));
		}
		p1.teleport(p2);
		p.sendMessage(lng.tp2p.replaceAll("%player1", p1.getDisplayName()).replaceAll("%player2", p2.getDisplayName()));
	}
}
