package net.willhastings.CraftedHungerGames.command;

import net.willhastings.CraftedHungerGames.HungerGame;
import net.willhastings.CraftedHungerGames.Main;
import net.willhastings.CraftedHungerGames.util.CFunction;

import org.bukkit.Bukkit;
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
			sender.sendMessage(Main.messageHandler.getMessage("server.prefix", false) + "/game new [HungerGame name] [Max Tributes]");
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
						if(args.length < 2) this.invalidCommand(sender);
						else if (CFunction.isInteger(args[2]))
						{
							sender.sendMessage(Main.messageHandler.getMessage("server.prefix", false) + "Invalid peramiter type: 'Max Tributes' is an integer value!");
							this.invalidCommand(sender);
							break;
						}
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
							Main.hGame.put(args[1], new HungerGame(Integer.parseInt(args[2])));
							Bukkit.broadcastMessage(Main.messageHandler.getFormatedMessage("game.new", true, args[1]));
						}
						
					}
					break;
				}
				case JOIN:
				{
					if(args.length < 1) this.invalidCommand(sender);
					else if(!CFunction.hGameExists(args[1]))
					{
						sender.sendMessage(Main.messageHandler.getFormatedMessage("game.not.found", true, args[1]));
					}
					else
					{
						HungerGame game = Main.hGame.get(args[1]);
						if(game.getNumOfTributes() < game.getMaxTributes())
						{
							//add tribute
						}
						else
						{
							sender.sendMessage(Main.messageHandler.getFormatedMessage("game.full", true, args[1]));
						}
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
