package me.Delocaz.ServerBlox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class SBConfig extends YamlConfiguration {
	File f;
	public SBConfig(String name) {
		f = new File("plugins/ServerBlox/"+name+".yml");
		f.mkdirs();
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void load() {
		try {
			load(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
	public void save() {
		try {
			save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
