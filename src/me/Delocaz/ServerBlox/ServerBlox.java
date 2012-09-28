package me.Delocaz.ServerBlox;

import java.io.File;
import java.io.IOException;

import me.Delocaz.ServerBlox.Libraries.Metrics;
import me.Delocaz.ServerBlox.Libraries.Updater;

import org.bukkit.command.PluginCommand;
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
		try {
			libs();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scr = new SBCommandRegistrator(this);
		scr.register();
	}
	public void libs() throws IOException {
		if (getConfig().getBoolean("autoUpdate")) {
		    Updater updater = new Updater(this, "serverblox", this.getFile(), Updater.UpdateType.DEFAULT, false);
		    updater.hashCode();
		}
		Metrics metrics = new Metrics(this);
		metrics.start();
	}
	public void regCmd(SBCmd s) {
		PluginCommand cmd = getCommand("sbx_"+s.cmd);
		cmd.setExecutor(s);
		s.setPerm(cmd.getPermission());
		s.setParent(this);
		getServer().getPluginManager().registerEvents(s, this);
	}
	public void regFeat(SBFeature s) {
		getServer().getPluginManager().registerEvents(s, this);
	}
	public void config() {
		cfg.addDefault("showRegisters", true);
		cfg.addDefault("defaultItemAmount", 64);
		cfg.addDefault("autoUpdate", true);
		cfg.options().copyDefaults(true);
		cfg.load();
		cfg.save();
	}
}
