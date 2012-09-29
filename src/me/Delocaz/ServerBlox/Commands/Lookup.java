package me.Delocaz.ServerBlox.Commands;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.SBUtils;
import me.Delocaz.ServerBlox.Exceptions.WrongArgsException;

public class Lookup extends SBCmd {
	public Lookup(String cmd) {
		super(cmd);
	}
	public void player(Player p, String[] args) throws WrongArgsException {
		OfflinePlayer pp;
		if (args.length == 0) {
			pp = p;
		} else {
			pp = matchPlayer(args[0]);
		}
		if (pp == null) {
			if (SBUtils.hasPlayed(args[0])) {
				pp = sb.getServer().getOfflinePlayer(args[0]);
				lookupPlayer(pp, p);
			} else {
				if (!SBUtils.isIP(args[0])) {
					throw new WrongArgsException(p, this, lng.get("noPlayerIP"));
				}
				lookupIP(args[0], p);
			}
		} else {
			lookupPlayer(pp, p);
		}
	}
	@SuppressWarnings("unchecked")
	public void lookupPlayer(OfflinePlayer pp, Player p) {
		p.sendMessage(lng.get("splitter"));
		p.sendMessage(lng.get("ipsOf").replaceAll("%player", pp.getName()));
		for (String ip : ((List<String>) getPlayerData(p, "ips"))) {
			p.sendMessage(ChatColor.GREEN+ip);
		}
		p.sendMessage(lng.get("altsOf").replaceAll("%player", pp.getName()));
		for (OfflinePlayer ip : SBUtils.playersWithIP((List<String>) getPlayerData(p, "ips"))) {
			p.sendMessage(ChatColor.GREEN+ip.getName());
		}
		p.sendMessage(lng.get("splitter"));
	}
	public void lookupIP(String ip, Player p) {
		p.sendMessage(lng.get("splitter"));
		p.sendMessage(lng.get("playersWithIP").replaceAll("%ip", ip));
		for (OfflinePlayer pp : SBUtils.playersWithIP(ip)) {
			p.sendMessage(ChatColor.GREEN+pp.getName());
		}
		p.sendMessage(lng.get("splitter"));
	}
}
