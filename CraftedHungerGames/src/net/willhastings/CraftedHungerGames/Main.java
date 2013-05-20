package net.willhastings.CraftedHungerGames;

import java.util.logging.Logger;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import net.willhastings.CraftedHungerGames.command.GameCommand;
import net.willhastings.CraftedHungerGames.util.MessageHandler;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	
    public static Permission permission = null;
    public static Economy economy = null;
    
    public static MessageHandler messageHandler;
    
	public Logger log = Logger.getLogger("Minecraft");
	
	public void onEnable()
	{
		log.info("|________ ..-' CraftedHungerGames - Loading '-..________|");
		
		log.info("|-Initilizing Commands                                  |");	
		this.getCommand("game").setExecutor(new GameCommand());
		
		log.info("|-Initilizing Vault interface for permissions & economy!|");
		this.setupPermissions();
		this.setupEconomy();
		if(permission == null || economy == null)
		{
			log.info("|-Failed to find permissions or economy plugin!         |");
			log.info("|-PLUGIN DISABLING ITSELF!                              |");
			this.getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		log.info("|-Loading Message.properties file                       |");
		messageHandler = new MessageHandler(this);
		
		log.info("|_______________________________________________________|");
	}
	
	public void onDisable()
	{
		
	}
	
	private boolean setupPermissions()
	{
	    RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
	    if (permissionProvider != null) 
	    {
	        permission = permissionProvider.getProvider();
			log.info("|-Permissions: Hooked                                  -|");
	    }
	    return (permission != null);
	}
	
	private boolean setupEconomy()
	{
	    RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
	    if (economyProvider != null) 
	    {
	        economy = economyProvider.getProvider();
	        log.info("|-Economy: Hooked                                      -|");
	    }
	
	    return (economy != null);
	}
}