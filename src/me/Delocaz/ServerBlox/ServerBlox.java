package me.Delocaz.ServerBlox;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import me.Delocaz.ServerBlox.Features.ChatLog;
import me.Delocaz.ServerBlox.Features.CommandLog;

import org.bukkit.plugin.java.JavaPlugin;

public class ServerBlox extends JavaPlugin {
	List<SBCmd> cmds;
	public void onEnable() {
		 cmds = new ArrayList<SBCmd>();
		 new File("plugins/ServerBlox").mkdirs();
		 regThings();
	}
	public void regThings() {
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
