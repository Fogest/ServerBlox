package me.Delocaz.ServerBlox;

import java.util.ArrayList;
import java.util.List;

import me.Delocaz.ServerBlox.Commands.Home;
import me.Delocaz.ServerBlox.Commands.Nick;
import me.Delocaz.ServerBlox.Commands.SetHome;
import me.Delocaz.ServerBlox.Commands.SetSpawn;
import me.Delocaz.ServerBlox.Commands.SetWarp;
import me.Delocaz.ServerBlox.Commands.Spawn;
import me.Delocaz.ServerBlox.Commands.Time;
import me.Delocaz.ServerBlox.Commands.Tp;
import me.Delocaz.ServerBlox.Commands.Tp2p;
import me.Delocaz.ServerBlox.Commands.TpHere;
import me.Delocaz.ServerBlox.Commands.Warp;
import me.Delocaz.ServerBlox.Features.ChatColor;
import me.Delocaz.ServerBlox.Features.ChatLog;
import me.Delocaz.ServerBlox.Features.CommandLog;

public class SBCommandRegistrator {
	ServerBlox sb;
	public SBCommandRegistrator(ServerBlox serverBlox) {
		sb = serverBlox;
	}
	public void register() {
		List<SBBase> r = new ArrayList<SBBase>();
		r.add(new Home("home", "serverblox.home.tp", sb));
		r.add(new SetHome("sethome", "serverblox.home.set", sb));
		r.add(new Spawn("spawn", "serverblox.spawn.tp", sb));
		r.add(new SetSpawn("setspawn", "serverblox.spawn.set", sb));
		r.add(new Warp("warp", "serverblox.warp.tp", sb));
		r.add(new SetWarp("setwarp", "serverblox.warp.set", sb));
		r.add(new Nick("nick", "serverblox.nick", sb));
		r.add(new Tp("tp", "serverblox.tp.to", sb));
		r.add(new Tp2p("tp2p", "serverblox.tp.other", sb));
		r.add(new TpHere("tphere", "serverblox.tp.here", sb));
		r.add(new Time("time", "serverblox.time.set", sb));
		r.add(new CommandLog("CommandLog"));
		r.add(new ChatLog("ChatLog"));
		r.add(new ChatColor("ChatColor"));
		for (SBBase b : r) {
			register(b);
		}
	}
	public void register(SBBase b) {
		if (b instanceof SBFeature) {
			sb.regFeat((SBFeature) b);
			sb.getLogger().info("Registered feature: "+((SBFeature) b).name);
		}
		if (b instanceof SBCmd) {
			sb.regCmd((SBCmd) b);
			sb.getLogger().info("Registered command: sbx_"+((SBCmd) b).cmd);
		}
	}
}
