package me.Delocaz.ServerBlox;

public class SBLang {                                                    
	public SBConfig lngf;                                                
	public String noConsole;                                             
	public String homeSet;                                               
	public String noPerms;                                               
	public String noHome;
	public String homeTp;
	public SBLang() {                                                    
		lngf = new SBConfig("lang");                                     
		lngf.addDefault("noConsole", "&cSorry, this command is for players only.");
		lngf.addDefault("homeSet", "&aYour home has been set!");
		lngf.addDefault("noPerms", "&cSorry, you don't have permission."); 
		lngf.addDefault("noHome", "&cSorry, you haven't defined a home yet!"); 
		lngf.addDefault("homeTp", "&aYou have been teleported to your home!");
		lngf.options().copyDefaults(true);
		lngf.save();
		noConsole = SBUtils.colorize(lngf.getString("noConsole"));
		homeSet = SBUtils.colorize(lngf.getString("homeSet"));
		noPerms = SBUtils.colorize(lngf.getString("noPerms"));
		noHome = SBUtils.colorize(lngf.getString("noHome"));
		homeTp = SBUtils.colorize(lngf.getString("homeTp"));
	}                                                                    
}                                                                        
