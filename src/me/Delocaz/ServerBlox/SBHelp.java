package me.Delocaz.ServerBlox;

import org.bukkit.configuration.file.YamlConfiguration;

public class SBHelp extends SBConfig {
	public String getDesc(String s) {
		return getDescription(s);
	}
	public String getDescription(String s) {
		return getString(s+".desc");
	}
	public String getUsage(String s) {
		return getString(s+".usage");
	}
	public SBHelp() {                                                    
		super("help");                                     
		addDefaults(YamlConfiguration.loadConfiguration(getClass().getResourceAsStream("res/help.yml")));
		options().copyDefaults(true);
		save();
	}
}
