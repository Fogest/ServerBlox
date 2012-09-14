package me.Delocaz.ServerBlox;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class ServerBlox extends JavaPlugin {
	public SBLang lng;
	public SBPlayerData spd;
	public SBConfig cfg;
	public SBCommandRegistrator scr;
	public void onEnable() {
		new File("plugins/ServerBlox").mkdirs();
		lng = new SBLang();
		spd = new SBPlayerData(this);
		cfg = new SBConfig("config");
		config();
		scr = new SBCommandRegistrator(this);
		scr.register();
	}
	public void regCmd(SBCmd s) {
		getCommand("sbx_"+s.cmd).setExecutor(s);
		getServer().getPluginManager().registerEvents(s, this);
	}
	public void regFeat(SBFeature s) {
		getServer().getPluginManager().registerEvents(s, this);
	}
	public void config() {
		cfg.addDefault("showRegisters", true);
		cfg.addDefault("afkTimer", 60000);
		cfg.addDefault("defaultItemAmount", 64);
		cfg.options().copyDefaults(true);
		cfg.save();
	}
}
