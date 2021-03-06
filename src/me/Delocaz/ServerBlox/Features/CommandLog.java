package me.Delocaz.ServerBlox.Features;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import me.Delocaz.ServerBlox.SBFeature;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandLog extends SBFeature {
	public CommandLog(String string) {
		super(string);
	}
	public void init() {
		File f = new File("plugins/ServerBlox/command.log");
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@EventHandler
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
		try {
			FileWriter fw = new FileWriter(new File("plugins/ServerBlox/command.log"), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("["+new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date(System.currentTimeMillis()))+"] <"+e.getPlayer().getName()+"> "+e.getMessage());
			System.out.println("[PlayerCommand] <"+e.getPlayer().getName()+"> "+e.getMessage());
			bw.newLine();
			bw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
