package me.Delocaz.ServerBlox.Commands;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.google.common.collect.Lists;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.Exceptions.WrongArgsException;

public class Ignore extends SBCmd {
	public Ignore(String cmd) {
		super(cmd);
	}
	@SuppressWarnings("unchecked")
	public void player(Player p, String[] args) throws WrongArgsException {
		if (args.length == 0) {
			throw new WrongArgsException(p, this, lng.get("enterPlayer"));
		}
		Player i = matchPlayer(args[0]);
		if (i == null) {
			throw new WrongArgsException(p, this, lng.get("noMatch").replaceAll("%player", args[0]));
		}
		List<String> l = (List<String>) getPlayerData(p, "ignored");
		if (l == null) {
			l = Lists.newArrayList();
		}
		l.add(i.getName());
		addPlayerData(p, "ignored", l);
	}
	@SuppressWarnings("unchecked")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		e.setCancelled(true);
		Player s = e.getPlayer();
		for (Player r : sb.getServer().getOnlinePlayers()) {
			List<String> ignored = (List<String>) getPlayerData(r, "ignored");
			if (!(ignored != null && ignored.contains(s.getName()))) {
				r.sendMessage(e.getFormat() + e.getMessage());
			}
		}
	}
}
