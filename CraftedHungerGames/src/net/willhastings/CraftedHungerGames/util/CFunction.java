package net.willhastings.CraftedHungerGames.util;

import net.willhastings.CraftedHungerGames.Main;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CFunction 
{
	public static boolean hasPermission(CommandSender sender, String perm)
	{
		if(sender instanceof Player) return hasPermission((Player) sender, perm);
		else return sender.isOp();
	}
	
	
	public static boolean hasPermission(Player player, String perm)
	{
		if (player.isOp()) return true;	
		else return (Main.permission.has(player, perm) || Main.permission.has(player, "*"));
	}
}
