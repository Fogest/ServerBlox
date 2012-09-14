package me.Delocaz.ServerBlox.Commands;

import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.ServerBlox;
import me.Delocaz.ServerBlox.Exceptions.WrongArgsException;

public class FakeOp extends SBCmd {
	public FakeOp(String cmd, String perm, ServerBlox sb) {
		super(cmd, perm, sb);
	}
	public void player(Player p, String[] args) throws WrongArgsException {
		if (args.length == 0) {
			throw new WrongArgsException(p, this, lng.get("enterPlayer"));
		}
		Player pp = matchPlayer(args[0]);
		if (pp == null) {
			throw new WrongArgsException(p, this, lng.get("noMatch").replaceAll("%player", args[0]));
		}
		pp.sendMessage(lng.get("fakeOp").replaceAll("%player", pp.getDisplayName()));
		p.sendMessage(lng.get("opSent"));
	}
}
