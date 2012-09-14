package me.Delocaz.ServerBlox.Commands;

import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.SBHelp;
import me.Delocaz.ServerBlox.SBUtils;
import me.Delocaz.ServerBlox.ServerBlox;
import me.Delocaz.ServerBlox.Exceptions.WrongArgsException;

public class Help extends SBCmd {
	public Help(String cmd, String perm, ServerBlox sb) {
		super(cmd, perm, sb);
	}
	public void player(Player p, String[] args) throws WrongArgsException {
		SBHelp hlp = new SBHelp();
		p.sendMessage(SBUtils.colorize("&c==============="));
		if (args.length == 0) {
			for (SBCmd cmd : sb.scr.cmds) {
				if (p.hasPermission(cmd.perm)) {
					String des = hlp.getDesc(cmd.cmd);
					p.sendMessage(SBUtils.colorize("&c/"+cmd.cmd+" - "+des.replaceAll(" (.*", "")));
				}
			}
			p.sendMessage(lng.get("cmdInfo"));
		} else {
			String des = hlp.getDesc(args[0]);
			String usa = hlp.getUsage(args[0]);
			if (des == null || usa == null) {
				throw new WrongArgsException(p, this, lng.get("badCommand"));
			}
			p.sendMessage(SBUtils.colorize("&c/"+args[0]+" - "+des.replaceAll(" (.*", "")));
		}
		p.sendMessage(SBUtils.colorize("&c==============="));
	}
}
