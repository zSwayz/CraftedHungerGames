package net.willhastings.CraftedHungerGames.command;

import net.willhastings.CraftedHungerGames.Main;
import net.willhastings.CraftedHungerGames.util.CFunction;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GameCommand implements CommandExecutor 
{	
	private void invalidCommand(CommandSender sender)
	{
		sender.sendMessage(Main.messageHandler.getMessage("server.prefix", false) + ChatColor.RED + " Invalid or Missing Sub-Command!");
		if(CFunction.hasPermission(sender, "cm.command.reaction.force"))
		{
			sender.sendMessage(Main.messageHandler.getMessage("server.prefix", false) + "/reaction force [top|reaction]");
		}
		sender.sendMessage(Main.messageHandler.getMessage("server.prefix", false) + "/reaction top");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) 
	{
		try 
		{
			if(args.length == 0)
			{
				this.invalidCommand(sender);
				return false;
			}
			
			switch(SubCommands.valueOf(args[0].toString().toUpperCase())) 
			{
				case NEW:
				{
					//Create a new hunger game instance
					break;
				}
				case JOIN:
				{
					//Join a hunger game instance
					break;
				}
				case INFO:
				{
					//Info of a current hunger game instance
					break;
				}
				case FORCE:
				{
					//force a game to start/end
					break;
				}
			}
		}
		catch(Exception e) 
		{
			return false;
		}
		return true;	
	}

	enum SubCommands
	{
		NEW,
		JOIN,
		INFO,
		FORCE
	}
}
