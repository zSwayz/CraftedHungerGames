package net.willhastings.CraftedHungerGames.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.text.MessageFormat;
import java.util.HashMap;

import net.willhastings.CraftedHungerGames.Main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

public class MessageHandler 
{	
	private HashMap<String, String> msg = new HashMap<String, String>();
	private HashMap<String, String> defaults = new HashMap<String, String>();
	private Plugin plugin;
	private String FILE_PATH; 
	private String FILE_NAME;
	
	/**
	 * 
	 * @param plgin plugin
	 * 
	 */
	public MessageHandler(Main plgin)
	{
		plugin = plgin;
		FILE_PATH = plugin.getDataFolder().getPath();
		FILE_NAME = "messages.properties";
		
		boolean a = this.loadFile();
		boolean b = this.loadDefaults();
		
		if(!a) plugin.getLogger().severe("MessageHandler: messages.properties has failed to load!");
		if(!b) plugin.getLogger().severe("MessageHandler: failed to load defaults!");
	}
	
	/**
	 * 
	 * @param key message to retrieve
	 * @param prefix add plugin prefix in front of message.
	 * @return returns the message from the map
	 * 
	 */
	public String getMessage(String key, boolean prefix)
	{
		String temp;
		if(msg.containsKey(key))
		{
			temp = ChatColor.translateAlternateColorCodes('&', msg.get(key));
		}
		else if(defaults.containsKey(key))
		{
			temp = ChatColor.translateAlternateColorCodes('&', defaults.get(key));
			plugin.getLogger().severe("Missing message <" + key + "> in messages.properties!");
			plugin.getLogger().info("Default was found!");
		}
		else
		{
			temp = "Missing message <" + key + "> in messages.properties!";
			plugin.getLogger().severe(temp);
			prefix = true;
		}
		if(prefix) temp = this.getMessage("server.prefix", false) + " " + temp;
		return temp;
	}
	
	/**
	 * 
	 * @param key message to be retrieved
	 * @param prefix add plugin prefix to message
	 * @param params parameters
	 * @return returns the string with the needed parameters
	 * 
	 */
	public String getFormatedMessage(String key, boolean prefix, Object ... params)
	{
		String temp;
		if(msg.containsKey(key))
		{
			temp = ChatColor.translateAlternateColorCodes('&', msg.get(key));
			temp = MessageFormat.format(temp, params);
		}
		else if(defaults.containsKey(key))
		{
			temp = ChatColor.translateAlternateColorCodes('&', defaults.get(key));
			temp = MessageFormat.format(temp, params);
			plugin.getLogger().severe("Missing message <" + key + "> in messages.properties!");
			plugin.getLogger().info("Default was found!");
		}
		else
		{
			temp = "Missing message <" + key + "> in messages.properties!";
			plugin.getLogger().severe(temp);
			prefix = true;
		}
		if(prefix) temp = this.getMessage("server.prefix", false) + " " + temp;
		return temp;
	}
	
	/**
	 * 
	 * @return return true if messages.properties reloaded successfully.
	 * 
	 */
	public boolean reload()
	{
		msg.clear();
		return loadFile();
	}
	
	public void resetFile()
	{
		if(!new File(FILE_PATH).exists())
		{
			new File(FILE_PATH).mkdir();
		}
		
		if(!new File(FILE_PATH + File.separator + FILE_NAME).exists())
		{
			plugin.saveResource(FILE_NAME, true);
		}
	}
	
	private boolean loadFile()
	{
		try
		{	
			if(!new File(FILE_PATH).exists())
			{
				new File(FILE_PATH).mkdir();
			}
			
			if(!new File(FILE_PATH + File.separator + FILE_NAME).exists())
			{
				plugin.saveResource(FILE_NAME, true);
			}
			
			BufferedReader in = new BufferedReader(new FileReader(FILE_PATH + File.separator + FILE_NAME));
			String line;
			String[] parse;
			while((line = in.readLine()) != null)
			{
				if(!line.equals(""))
				{
					parse = line.split("=");
					msg.put(parse[0], parse[1]);
				}
			}
			in.close();
		}
		catch (Exception e)
		{
			System.out.println("[CraftedHungerGames] Has failed to load the 'messages.properties' file:" + e.toString());
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("deprecation")
	private boolean loadDefaults()
	{
		try 
		{
			DataInputStream in = new DataInputStream(plugin.getResource(FILE_NAME));
			String line;
			String[] parse;
			
			while(in.available() != 0)
			{
				line = in.readLine();
				
				if(!line.equals(""))
				{
					parse = line.split("=");		
					defaults.put(parse[0], parse[1]);
				}
			}
		} 
		catch (Exception e) 
		{
			return false;
		}
		return true;
	}
}
