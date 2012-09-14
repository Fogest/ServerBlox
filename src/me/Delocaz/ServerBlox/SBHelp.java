package me.Delocaz.ServerBlox;

import org.bukkit.configuration.file.YamlConfiguration;

public class SBHelp extends SBConfig {
	public SBHelp() {                                                    
		super("help");                                     
		addDefaults(YamlConfiguration.loadConfiguration(getClass().getResourceAsStream("/help.yml")));
		options().copyDefaults(true);
		save();
	}
}
