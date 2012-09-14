package me.Delocaz.ServerBlox;

import java.util.HashMap;

import org.bukkit.configuration.file.YamlConfiguration;

public class SBLang {                                                    
	public SBConfig lngf;                                                
	public HashMap<String, String> lng = new HashMap<String, String>();
	public SBLang() {                                                    
		lngf = new SBConfig("lang");                                     
		lngf.addDefaults(YamlConfiguration.loadConfiguration(getClass().getResourceAsStream("/lang.yml")));
		lngf.options().copyDefaults(true);
		lngf.save();
		int i = 0;
		for (String s : lngf.getValues(true).keySet()) {
			lng.put(s, lngf.getString(s));
			i++;
		}
		SBUtils.console(lng.get("langReg").replace("%amount", i+""));
	}
}                                                                        
