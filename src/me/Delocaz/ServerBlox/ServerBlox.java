package me.Delocaz.ServerBlox;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import me.Delocaz.ServerBlox.Commands.Home;
import me.Delocaz.ServerBlox.Commands.SetHome;
import me.Delocaz.ServerBlox.Features.ChatLog;
import me.Delocaz.ServerBlox.Features.CommandLog;

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
		 regThings();
	}
	public void regThings() {
		regCmd(new Home("home", "serverblox.home.tp", this));
		regCmd(new SetHome("sethome", "serverblox.home.set", this));
		regFeat(new CommandLog());
		regFeat(new ChatLog());
	}
	public void regCmd(SBCmd s) {
		getCommand(s.cmd).setExecutor(s);
		getServer().getPluginManager().registerEvents(s, this);
	}
	public void regFeat(SBFeature s) {
		getServer().getPluginManager().registerEvents(s, this);
	}
}
