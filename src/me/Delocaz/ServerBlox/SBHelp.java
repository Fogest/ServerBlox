package me.Delocaz.ServerBlox;

import org.bukkit.command.PluginCommand;

public class SBHelp {
	public static String getDesc(String s) {
		return getDescription(s);
	}
	public static String getDescription(String s) {
		PluginCommand cmd = getCmd(s);
		return cmd == null ? null : cmd.getDescription();
	}
	public static String getUsage(String s) {
		PluginCommand cmd = getCmd(s);
		return cmd == null ? null : cmd.getUsage();
	}
	public static PluginCommand getCmd(String s) {
		return SBUtils.getPlugin().getCommand("sbx_"+s);
	}
}
