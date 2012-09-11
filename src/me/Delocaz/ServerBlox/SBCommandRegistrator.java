package me.Delocaz.ServerBlox;

import java.util.ArrayList;
import java.util.List;

import me.Delocaz.ServerBlox.Commands.Home;
import me.Delocaz.ServerBlox.Commands.SetHome;
import me.Delocaz.ServerBlox.Commands.SetSpawn;
import me.Delocaz.ServerBlox.Commands.Spawn;
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
		r.add(new CommandLog());
		r.add(new ChatLog());
		for (SBBase b : r) {
			register(b);
		}
	}
	public void register(SBBase b) {
		if (b instanceof SBFeature) {
			sb.regFeat((SBFeature) b);
		}
		if (b instanceof SBCmd) {
			sb.regCmd((SBCmd) b);
		}
	}
}
