package me.Delocaz.ServerBlox;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;

public class SBUtils {
	public static String colorize(String s) {
		s = ChatColor.translateAlternateColorCodes('&', s);
		s = s.replaceAll("&k", ChatColor.MAGIC.toString());
		s = s.replaceAll("&l", ChatColor.BOLD.toString());
		s = s.replaceAll("&o", ChatColor.ITALIC.toString());
		s = s.replaceAll("&n", ChatColor.UNDERLINE.toString());
		s = s.replaceAll("&m", ChatColor.STRIKETHROUGH.toString());
		s = s.replaceAll("&r", ChatColor.RESET.toString());
		return s;
	}
	public static Location toLoc(Object w, Object x, Object y, Object z, Object p, Object ya) {
		Location l = new Location(Bukkit.getServer().getWorld((String) w), (Double) x,(Double) y, (Double) z);
		l.setPitch(((Double) p).floatValue());
		l.setYaw(((Double) ya).floatValue());
		return l;
	}
	public static ServerBlox getPlugin() {
		return (ServerBlox) Bukkit.getPluginManager().getPlugin("ServerBlox");
	}
}
