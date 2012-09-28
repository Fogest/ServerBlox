package me.Delocaz.ServerBlox;

import java.util.HashMap;
import java.util.List;

import me.Delocaz.ServerBlox.Exceptions.WrongArgsException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SBCmd extends SBBase implements CommandExecutor, Listener {
	public String perm = "";
	public String cmd = "";
	public HashMap<String, String> lng;
	public SBPlayerData spd;
	public ServerBlox sb;
	public SBConfig cfg;
	public SBCmd(String cmd) {
		this.cmd = cmd;
	}
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if (arg0 instanceof Player) {
			Player p = (Player) arg0;
			if (!p.hasPermission(perm) && !p.isOp()) {
				arg0.sendMessage(lng.get("noPerms"));
				return true;
			}
			try {
				player(p, arg3);
			} catch (SBException e) {
			}
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
	public void player(Player s, String[] args) throws WrongArgsException {
	}
	public void addPlayerData(Player p, String n, Object o) {
		spd.put(p, n, o);
	}
	public Object getPlayerData(Player p, String n) {
		return spd.get(p, n);
	}
	public Player matchPlayer(String s) {
		List<Player> m = sb.getServer().matchPlayer(s);
		return m.isEmpty() ? null : m.get(0);
	}
	public void setParent(ServerBlox sb) {
		this.sb = sb;
		spd = sb.spd;
		lng = sb.lng.lng;
		cfg = sb.cfg;
	}
	public void setPerm(String perm) {
		this.perm = perm;
	}
}
