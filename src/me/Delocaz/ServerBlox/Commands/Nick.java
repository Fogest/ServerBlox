package me.Delocaz.ServerBlox.Commands;

import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.SBUtils;

public class Nick extends SBCmd {
	public Nick(String cmd) {
		super(cmd);
	}
	public void player(Player p, String[] args) {
		if (args.length == 0) {
			p.setDisplayName(p.getName());
			p.sendMessage(lng.get("nickOff"));
		} else {
			p.setDisplayName(args[0]);
			p.setPlayerListName(args[0]);
			p.sendMessage(lng.get("nickSet").replaceAll("%nick", SBUtils.colorize(args[0])));
		}
	}
}
