package me.Delocaz.ServerBlox;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class SBLang {                                                    
	public SBConfig lngf;                                                
	public HashMap<String, String> lng = new HashMap<String, String>();
	public SBLang() {                                                    
		lngf = new SBConfig("lang");
		YamlConfiguration df = new YamlConfiguration();
		try {
			df.loadFromString(Files.toString(new File(getClass().getResource("lang.yml").getFile()), Charsets.UTF_8));
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		lngf.addDefaults(df);
		lngf.options().copyDefaults(true);
		lngf.save();
		int i = 0;
		for (String s : lngf.getValues(true).keySet()) {
			lng.put(s, lngf.getString(s));
			i++;
		}
		System.out.println(lng.get("langReg"));
		SBUtils.console(lng.get("langReg").replace("%amount", i+""));
	}
}                                                                        
