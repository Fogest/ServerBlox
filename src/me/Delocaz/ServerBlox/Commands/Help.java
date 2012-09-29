package me.Delocaz.ServerBlox.Commands;

import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.SBHelp;
import me.Delocaz.ServerBlox.SBUtils;
import me.Delocaz.ServerBlox.Exceptions.WrongArgsException;

public class Help extends SBCmd {
	public Help(String cmd) {
		super(cmd);
	}
	public void player(Player p, String[] args) throws WrongArgsException {
		p.sendMessage(SBUtils.colorize(lng.get("splitter")));
		if (args.length == 0) {
			for (SBCmd cmd : sb.scr.cmds) {
				if (p.hasPermission(cmd.perm)) {
					String des = SBHelp.getDesc(cmd.cmd);
					p.sendMessage(SBUtils.colorize("&a/"+cmd.cmd+"&c - "+des.replaceAll(" \\(.*", "")));
				}
			}
			p.sendMessage(lng.get("cmdInfo"));
		} else {
			String des = SBHelp.getDesc(args[0]);
			String usa = SBHelp.getUsage(args[0]);
			if (des == null || usa == null) {
				throw new WrongArgsException(p, this, lng.get("badCommand"));
			}
			p.sendMessage(SBUtils.colorize("&a"+usa));
			p.sendMessage(SBUtils.colorize("&c"+des.replaceAll(" \\(.*", "")));
		}
		p.sendMessage(SBUtils.colorize(lng.get("splitter")));
	}
}
