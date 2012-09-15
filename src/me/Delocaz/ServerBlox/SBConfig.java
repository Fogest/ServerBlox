package me.Delocaz.ServerBlox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;

public class SBConfig extends FileConfiguration {
	File f;
	public SBConfig(String name) {
		f = new File("plugins/ServerBlox/"+name+".yml");
		f.getParentFile().mkdirs();
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
	@Override
	protected String buildHeader() {
		return null;
	}
	@Override
	public void loadFromString(String arg0)
			throws InvalidConfigurationException {		
	}
	@Override
	public String saveToString() {
		return null;
	}
}
