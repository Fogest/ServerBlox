package me.Delocaz.ServerBlox;

import java.util.HashMap;

public class SBLang {                                                    
	public SBConfig lngf;                                                
	public HashMap<String, String> lng = new HashMap<String, String>();
	public SBLang() {                                                    
		lngf = new SBConfig("lang");
		addAll();
		lngf.options().copyDefaults(true);
		lngf.load();
		lngf.save();
		int i = 0;
		for (String s : lngf.getValues(true).keySet()) {
			lng.put(s, lngf.getString(s));
			i++;
		}
		SBUtils.console(lng.get("langReg").replace("%amount", i+""));
	}
	public void add(String key, String value) {
		lngf.addDefault(key, SBUtils.colorize(value));
	}
	public void addAll() {
		add("noConsole", "&cSorry, this command is for players only.");
		add("homeSet", "&aYour home has been set!");
		add("noPerms", "&cSorry, you don't have permission.");
		add("noHome", "&cSorry, you haven't defined a home yet!");
		add("homeTp", "&aYou have been teleported to your home!");
		add("warpSet", "&aYour warp has been set!");
		add("noWarp", "&cSorry, you haven't defined that warp yet!");
		add("warpTp", "&aYou have been teleported to your warp!");
		add("noMatch", "&aNo player matched %player!");
		add("tpTo", "&aYou have been teleported to %player!");
		add("tp2p", "&%player1 have been teleported to %player2!");
		add("nickOff", "&aYour nick has been turned off!");
		add("nickSet", "&aYour nick has been set as %nick!");
		add("tpHere", "&a%player have been teleported to you!");
		add("wrongArgs", "&cSorry, you have entered the wrong arguments!");
		add("spawnSet", "&aYou have set the spawn!");
		add("spawnTp", "&aYou have been teleported to the spawn!");
		add("timeSet", "&aYou have set the time to %time!");
		add("tpAll", "&aYou have teleported everyone to you!");
		add("hatSet", "&aYou have put your hat on!");
		add("invClear", "&aYour inventory has been cleared!");
		add("meText", "&7* %player %text");
		add("itemAdd", "&aAdded %item to your inventory!");
		add("noItem", "&cThat item was not found!");
		add("cmdReg", "&aRegistered %amount commands!");
		add("langReg", "&aRegistered %amount language entries!");
		add("featReg", "&aRegistered %amount features!");
		add("cmdInfo", "&cType /help <command> for more info about a command!");
		add("badCommand", "&cThe \"command\" you entered is actually not a command!");
		add("enterItem", "&cYou didn't enter an item!");
		add("enterMsg", "&cYou didn't enter a message!");
		add("enterWarp", "&cYou didn't enter a warp!");
		add("enterPlayer", "&cYou didn't enter a player!");
		add("enterPlayers", "&cYou didn't enter enough players!");
		add("opSent", "&aYour Fake OP message has been sent!");
		add("fakeOp", "&o&7[CONSOLE: Opped %player]");
		add("errPrefix", "&cError:");
		add("splitter", "&c===============");
		add("playerIgnored", "&aYou have ignored %player!");
		add("alreadyPlayer", "&cThat player is already online!");
		add("altsOf", "&2Possible alternate accounts of %player:");
		add("ipsOf", "&2IPs of %player:");
		add("playersWithIP", "&2Players with %ip:");
	}
}                                                                        
