package me.Delocaz.ServerBlox;

import org.bukkit.entity.Player;

public class SBPlayerData {
	SBConfig pd;
	ServerBlox sb;
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
}
