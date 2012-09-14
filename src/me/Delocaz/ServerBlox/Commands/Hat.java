package me.Delocaz.ServerBlox.Commands;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.ServerBlox;

public class Hat extends SBCmd {
	public Hat(String cmd, String perm, ServerBlox sb) {
		super(cmd, perm, sb);
	}
	public void player(Player p, String[] args) {
		ItemStack h = p.getInventory().getHelmet();
		p.getInventory().setHelmet(p.getItemInHand());
		p.getInventory().setItemInHand(h);
		p.sendMessage(lng.get("hatSet"));
	}
}
