package me.Delocaz.ServerBlox;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SBCmd implements CommandExecutor, Listener {
	String perm = "";
	String cmd = "";
	public SBLang lng;
	public SBPlayerData spd;
	public ServerBlox sb;
	public SBCmd(String cmd, String perm, ServerBlox sb) {
		this.cmd = cmd;
		this.perm = perm;
		this.sb = sb;
		spd = sb.spd;
		lng = sb.lng;
	}
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if (arg0 instanceof Player) {
			Player p = (Player) arg0;
			if (!p.hasPermission(perm) && !p.isOp()) {
				arg0.sendMessage(lng.noPerms);
				return true;
			}
			player(p, arg3);
			both(arg0, arg3);
		} else {
			console((ConsoleCommandSender) arg0, arg3);
			both(arg0, arg3);
		}
		return true;
	}
	public void console(ConsoleCommandSender s, String[] args) {
	}
	public void both(CommandSender s, String[] args) {
	}
	public void player(Player s, String[] args) {
	}
	public void addPlayerData(Player p, String n, Object o) {
		spd.put(p, n, o);
	}
	public Object getPlayerData(Player p, String n) {
		return spd.get(p, n);
	}
}
