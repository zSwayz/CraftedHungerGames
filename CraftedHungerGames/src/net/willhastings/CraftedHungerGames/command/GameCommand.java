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
		if(CFunction.hasPermission(sender, "hg.command.game.force"))
		{
			sender.sendMessage(Main.messageHandler.getMessage("server.prefix", false) + "/game new [HungerGame name]");
		}
		if(CFunction.hasPermission(sender, "hg.command.game.new"))
		{
			sender.sendMessage(Main.messageHandler.getMessage("server.prefix", false) + "/game force [start|stop]");
		}
		sender.sendMessage(Main.messageHandler.getMessage("server.prefix", false) + "/reaction join [game]");
		sender.sendMessage(Main.messageHandler.getMessage("server.prefix", false) + "/reaction info [game]");
		sender.sendMessage(Main.messageHandler.getMessage("server.prefix", false) + "/reaction list");
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
					if(!CFunction.hasPermission(sender, "hg.command.game.new")) this.invalidCommand(sender);
					else
					{
						if(args.length < 1) this.invalidCommand(sender);
						else if(CFunction.hGameExists(args[1]))
						{
							sender.sendMessage(Main.messageHandler.getMessage("server.prefix", false) + "A game is already running with the name '"
									+ ChatColor.GOLD + args[1] + ChatColor.WHITE + "'");
							break;
						}
						else
						{
							sender.sendMessage(Main.messageHandler.getMessage("server.prefix", false) + "Creating a hunger game with name '"
									+ ChatColor.GOLD + args[1] + ChatColor.WHITE + "'");
							// start hGame
						}
						
					}
					break;
				}
				case JOIN:
				{
					if(args.length < 1) this.invalidCommand(sender);
					else if(!CFunction.hGameExists(args[1]))
					{
						sender.sendMessage(Main.messageHandler.getMessage("server.prefix", false) + "A game could not be found with name '"
								+ ChatColor.GOLD + args[1] + ChatColor.WHITE + "'");
					}
					else
					{
						//add use to game
					}
					break;
				}
				case INFO:
				{
					if(args.length < 1) this.invalidCommand(sender);
					else if(!CFunction.hGameExists(args[1]))
					{
						sender.sendMessage(Main.messageHandler.getMessage("server.prefix", false) + "A game could not be found with name '"
								+ ChatColor.GOLD + args[1] + ChatColor.WHITE + "'");
					}
					else
					{
						//show game info
					}
					break;
				}
				case LIST:
				{
					//list hungergames
				}
				case FORCE:
				{
					if(!CFunction.hasPermission(sender, "hg.command.game.force")) this.invalidCommand(sender);
					else
					{
						if(args.length < 2) this.invalidCommand(sender);
						else if(args[1].equalsIgnoreCase("START"))
						{
							//forcefully start the game
						}
						else if(args[2].equalsIgnoreCase("STOP"))
						{
							//forcefully stop the game
						}
						else this.invalidCommand(sender);
					}
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
		LIST,
		FORCE
	}
}
