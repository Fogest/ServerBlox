package me.Delocaz.ServerBlox;

import java.util.List;

import info.somethingodd.OddItem.OddItem;
import info.somethingodd.OddItem.OddItemBase;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;

import com.google.common.collect.Lists;

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
	public static String nameToDisplayName(String p) {
		return Bukkit.getPlayer(p).getDisplayName();
	}
	public static String assemble(String[] args, int start) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < args.length; ++i) {
			buf.append(args[i]);
		}
		return buf.toString();
	}
	public static String assemble(String[] args) {
		return assemble(args, 0);
	}
	public static Material getItem(String s) {
		OddItemBase oi = (OddItemBase) Bukkit.getPluginManager().getPlugin("OddItem");
		if (oi == null) {
			return Material.matchMaterial(s);
		}
		return OddItem.getItemStack(s).getType();
	}
	public static void console(String s) {
		getPlugin().getLogger().info(s);
	}
	public static boolean hasPlayed(String s) {
		return getPlugin().getConfig().getStringList("players").contains(s);
	}
	public static boolean isIP(String s) {
		String[] parts = s.split(".");
		if (parts.length != 4) {
			return false;
		}
		for (String p : parts) {
			if (!isInt(p)) {
				return false;
			}
			if (Integer.parseInt(p) > 255) {
				return false;
			}
		}
		return true;
	}
	public static boolean isInt(String s) {
		return org.apache.commons.lang.StringUtils.isNumeric(s);
	}
	@SuppressWarnings("unchecked")
	public static List<OfflinePlayer> playersWithIP(List<String> ips) {
		List<OfflinePlayer> l = Lists.newArrayList();
		for (String ip : ips) {
			for (String s : getPlugin().getConfig().getStringList("players")) {
				if (((List<String>)SBPlayerData.getStatic(Bukkit.getOfflinePlayer(s), "ips")).contains(ip)) {
					l.add(Bukkit.getOfflinePlayer(s));
				}
			}
		}
		return l;
	}
	public static List<OfflinePlayer> playersWithIP(String ip) {
		List<String> l = Lists.newArrayList();
		l.add(ip);
		return playersWithIP(l);
	}
}
