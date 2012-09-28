package me.Delocaz.ServerBlox.Commands;

import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.SBUtils;
import me.Delocaz.ServerBlox.Exceptions.WrongArgsException;

public class Me extends SBCmd {
	public Me(String cmd) {
		super(cmd);
	}
	public void player(Player p, String[] args) throws WrongArgsException {
		if (args.length == 0) {
			throw new WrongArgsException(p, this, lng.get("noMessage"));
		}
		sb.getServer().broadcastMessage(lng.get("meText").replaceAll("%player", p.getDisplayName()).replaceAll("%text", SBUtils.assemble(args)));
	}
}
