package me.Delocaz.ServerBlox.Commands;

import org.bukkit.entity.Player;

import me.Delocaz.ServerBlox.SBCmd;

public class Time extends SBCmd {
	public Time(String cmd) {
		super(cmd);
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
					i = 500;
				}
				txtTime = i+"";
			}
		} else {
			time = 500;
			txtTime = "day";
		}
		p.getWorld().setTime(time);
		p.sendMessage(lng.get("timeSet").replaceAll("%time", txtTime));
	}
}
