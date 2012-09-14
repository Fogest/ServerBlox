package me.Delocaz.ServerBlox;

import java.util.ArrayList;
import java.util.List;

import me.Delocaz.ServerBlox.Commands.Clear;
import me.Delocaz.ServerBlox.Commands.FakeOp;
import me.Delocaz.ServerBlox.Commands.Hat;
import me.Delocaz.ServerBlox.Commands.Help;
import me.Delocaz.ServerBlox.Commands.Home;
import me.Delocaz.ServerBlox.Commands.Item;
import me.Delocaz.ServerBlox.Commands.Me;
import me.Delocaz.ServerBlox.Commands.Nick;
import me.Delocaz.ServerBlox.Commands.SetHome;
import me.Delocaz.ServerBlox.Commands.SetSpawn;
import me.Delocaz.ServerBlox.Commands.SetWarp;
import me.Delocaz.ServerBlox.Commands.Spawn;
import me.Delocaz.ServerBlox.Commands.Time;
import me.Delocaz.ServerBlox.Commands.Tp;
import me.Delocaz.ServerBlox.Commands.Tp2p;
import me.Delocaz.ServerBlox.Commands.TpAll;
import me.Delocaz.ServerBlox.Commands.TpHere;
import me.Delocaz.ServerBlox.Commands.Warp;
import me.Delocaz.ServerBlox.Features.ChatColor;
import me.Delocaz.ServerBlox.Features.ChatLog;
import me.Delocaz.ServerBlox.Features.CommandLog;

public class SBCommandRegistrator {
	ServerBlox sb;
	public List<SBCmd> cmds;
	int feat = 0;
	int cmd = 0;
	public SBCommandRegistrator(ServerBlox serverBlox) {
		sb = serverBlox;
	}
	public void register() {
		List<SBBase> r = new ArrayList<SBBase>();
		r.add(new Home("home", "serverblox.tp.home", sb));
		r.add(new SetHome("sethome", "serverblox.tp.sethome", sb));
		r.add(new Spawn("spawn", "serverblox.tp.spawn", sb));
		r.add(new SetSpawn("setspawn", "serverblox.tp.setspawn", sb));
		r.add(new Warp("warp", "serverblox.tp.warp", sb));
		r.add(new SetWarp("setwarp", "serverbloxtp.setwarp", sb));
		r.add(new Nick("nick", "serverblox.player.nick", sb));
		r.add(new Tp("tp", "serverblox.tp.tp", sb));
		r.add(new Tp2p("tp2p", "serverblox.tp.tp2p", sb));
		r.add(new TpHere("tphere", "serverblox.tp.tphere", sb));
		r.add(new Time("time", "serverblox.world.time", sb));
		r.add(new TpAll("tpall", "serverblox.player.tpall", sb));
		r.add(new Hat("hat", "serverblox.player.hat", sb));
		r.add(new Clear("clear", "serverblox.player.clear", sb));
		r.add(new Me("me", "serverblox.chat.me", sb));
		r.add(new Item("item", "serverblox.player.item", sb));
		r.add(new Help("help", "serverblox.chat.help", sb));
		r.add(new FakeOp("fakeop", "serverblox.player.fakeop", sb));
		r.add(new CommandLog("CommandLog"));
		r.add(new ChatLog("ChatLog"));
		r.add(new ChatColor("ChatColor"));
		cmds = new ArrayList<SBCmd>();
		for (SBBase b : r) {
			register(b);
		}
		done();
	}
	public void register(SBBase b) {
		if (b instanceof SBFeature) {
			sb.regFeat((SBFeature) b);
			feat++;
		}
		if (b instanceof SBCmd) {
			cmds.add((SBCmd) b);
			sb.regCmd((SBCmd) b);
			cmd++;
		}
	}
	public void done() {
		if (sb.cfg.getBoolean("showRegisters")) {
			SBUtils.console(sb.lng.lng.get("cmdReg").replace("%amount", cmd+""));
			SBUtils.console(sb.lng.lng.get("featReg").replace("%amount", feat+""));
		}
	}
}
