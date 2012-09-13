package me.Delocaz.ServerBlox.Commands;

import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.ServerBlox;

public class Time extends SBCmd {
	public Time(String cmd, String perm, ServerBlox sb) {
		super(cmd, perm, sb);
	}
	public void player(Player p, String[] args) {
		int time = 0;
		String txtTime = "";
		if (args.length != 0) {
			if (args[0] == "day") {
				time = 500;
				txtTime = "day";
			}
			if (args[0] == "night") {
				time = 14000;
				txtTime = "night";
			}
			if (args[0] == "noon") {
				time = 6000;
				txtTime = "noon";
			}
			if (args[0] == "midnight") {
				time = 18000;
				txtTime = "midnight";
			}
			if (args[0] == "sunrise") {
				time = 0;
				txtTime = "sunrise";
			}
			if (args[0] == "sunset") {
				time = 12500;
				txtTime = "sunset";
			}
			if (txtTime == "") {
				int i = 0;
				try {
					i = Integer.parseInt(args[0]);
				} catch (Exception e) {
					p.sendMessage(lng.wrongArgs);
					return;
				}
				txtTime = i+"";
			}
		} else {
			time = 500;
			txtTime = "day";
		}
		p.getWorld().setTime(time);
		p.sendMessage(lng.timeSet.replaceAll("%time", txtTime));
	}
}
