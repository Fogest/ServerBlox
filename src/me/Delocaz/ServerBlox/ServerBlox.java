package me.Delocaz.ServerBlox;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import org.bukkit.plugin.java.JavaPlugin;

public class ServerBlox extends JavaPlugin {
	List<SBCmd> cmds;
	public SBLang lng;
	public SBPlayerData spd;
	public void onEnable() {
		 cmds = new ArrayList<SBCmd>();
		 new File("plugins/ServerBlox").mkdirs();
		 lng = new SBLang();
		 spd = new SBPlayerData(this);
		 new SBCommandRegistrator(this).register();
	}
	public void regCmd(SBCmd s) {
		getCommand("sbx_"+s.cmd).setExecutor(s);
		getServer().getPluginManager().registerEvents(s, this);
	}
	public void regFeat(SBFeature s) {
		getServer().getPluginManager().registerEvents(s, this);
	}
}
