package me.Delocaz.ServerBlox.Commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.Delocaz.ServerBlox.SBCmd;
import me.Delocaz.ServerBlox.SBUtils;
import me.Delocaz.ServerBlox.ServerBlox;
import me.Delocaz.ServerBlox.Exceptions.WrongArgsException;

public class Item extends SBCmd {
	public Item(String cmd, String perm, ServerBlox sb) {
		super(cmd, perm, sb);
	}
	public void player(Player p, String[] args) throws WrongArgsException {
		if (args.length == 0) {
			throw new WrongArgsException(p, this, lng.get("enterItem"));
		}
		Material m = SBUtils.getItem(args[0]);
		if (m == null) {
			throw new WrongArgsException(p, this, lng.get("noItem"));
		}
		ItemStack i = new ItemStack(m);
		int am = cfg.getInt("defaultItemAmount");
		if (args.length > 1) {
			try {
			    am = Integer.parseInt(args[1]);
			} catch (Exception ex) {
			}
		}
		i.setAmount(am);
		p.sendMessage(lng.get("itemAdd").replaceAll("%item", i.getAmount() + " " + i.getType().toString()));
	}
}
