package me.Delocaz.ServerBlox;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class SBPlayerData {
	SBConfig pd;
	ServerBlox sb;
	public static SBConfig getPD() {
		return new SBConfig("playerdata");
	}
	public SBPlayerData(ServerBlox sb) {
		pd = new SBConfig("playerdata");
		this.sb = sb;
	}
	public Object get(Player p, String n) {
		pd.load();
		return pd.get(p.getName() + "." + n);
	}
	public void put(Player p, String n, Object o) {
		pd.set(p.getName() + "." + n, o);
		pd.save();
	}
	public static Object getStatic(OfflinePlayer offlinePlayer, String n) {
		SBConfig pd = getPD();
		pd.load();
		return pd.get(offlinePlayer.getName() + "." + n);
	}
	public static void putStatic(Player p, String n, Object o) {
		SBConfig pd = getPD();
		pd.set(p.getName() + "." + n, o);
		pd.save();
	}
}
