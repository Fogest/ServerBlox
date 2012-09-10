package me.Delocaz.ServerBlox;

import java.lang.reflect.Field;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.SimplePluginManager;

public class SBCmd implements CommandExecutor, Listener {
	String perm = "";
	String cmd = "";
	ServerBlox sb;
	public SBCmd(String cmd, String perm, ServerBlox sb) {
		this.cmd = cmd;
		this.perm = perm;
		this.sb = sb;
		registerCmd();
	}
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if (arg0 instanceof Player) {
			Player p = (Player) arg0;
			if (!p.hasPermission(perm)) {
				return true;
			}
			player(p);
			both(arg0);
		} else {
			console((ConsoleCommandSender) arg0);
			both(arg0);
		}
		return true;
	}
	public void console(ConsoleCommandSender s) {
	}
	public void both(CommandSender s) {
	}
	public void player(Player s) {
	}
	private void registerCmd() {
		CommandMap commandMap = null;
		try{
			Field field = SimplePluginManager.class.getDeclaredField("commandMap");
			field.setAccessible(true);
			commandMap = (CommandMap)(field.get(sb.getServer().getPluginManager()));
		}catch(NoSuchFieldException e){
			e.printStackTrace();
		}
		catch(IllegalAccessException e){
			e.printStackTrace();
		}
		String[] aliases = {cmd};
		SBDynCommand com = new SBDynCommand(aliases, "", "", this);
		commandMap.register("_", com);
	}
}
