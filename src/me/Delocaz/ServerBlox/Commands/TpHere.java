package me.Delocaz.ServerBlox.Commands;

import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.Exceptions.WrongArgsException;

public class TpHere extends SBCmd {
	public TpHere(String cmd) {
		super(cmd);
	}
	public void player(Player p, String[] args) throws WrongArgsException {
		if (args.length == 0) {
			throw new WrongArgsException(p, this, lng.get("enterPlayer"));
		}
		Player pp = matchPlayer(args[0]);
		if (pp == null) {
			throw new WrongArgsException(p, this, lng.get("noMatch").replaceAll("%player", args[0]));
		}
		pp.teleport(p);
		p.sendMessage(lng.get("tpHere").replaceAll("%player", pp.getDisplayName()));
	}
}
