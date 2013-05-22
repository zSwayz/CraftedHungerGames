package net.willhastings.CraftedHungerGames.util;

import net.willhastings.CraftedHungerGames.Main;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CFunction 
{
	public static boolean hGameExists(String game)
	{
		return Main.hGame.containsKey(game);
	}
	
	public static boolean isInteger(String toCheck)
	{
		try
		{
			Integer.parseInt(toCheck);
		}
		catch (NumberFormatException e) 
		{
			return false;
		}
		return true;
	}
	
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
