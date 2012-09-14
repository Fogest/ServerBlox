package me.Delocaz.ServerBlox.Exceptions;

import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.SBException;
import me.Delocaz.ServerBlox.SBHelp;
import me.Delocaz.ServerBlox.SBUtils;

public class WrongArgsException extends SBException {
	private static final long serialVersionUID = 629476305382647260L;
	public WrongArgsException(Player p, SBCmd cmd, String error) {
		p.sendMessage(SBUtils.colorize("&c")+new SBHelp().getString(cmd.cmd+".usage"));
		p.sendMessage(SBUtils.colorize("&c")+new SBHelp().getString(cmd.cmd+".description"));
		p.sendMessage(SBUtils.colorize("&cError: ")+error);
	}
}
