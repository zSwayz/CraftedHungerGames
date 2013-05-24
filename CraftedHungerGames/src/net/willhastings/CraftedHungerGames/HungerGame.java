package net.willhastings.CraftedHungerGames;

import java.util.ArrayList;

import org.bukkit.World;
import org.bukkit.WorldCreator;

import net.willhastings.CraftedHungerGames.util.User;

public class HungerGame 
{
	private String prevWinner, worldString;
	private World world;
	private int maxTributes;
	private boolean canEdit, locked = false;
	private ArrayList<User> tribute = new ArrayList<User>();
	private ArrayList<Kit> kit = new ArrayList<Kit>();
	
	/**
	 * 
	 * @param max Max amount of tributes for this game.
	 * @param worldName the name of the world to use.
	 * @param edit allow tributes to edit the world. True = allow edit, False = no editing allowed.
	 * 
	 */
	public HungerGame(int max, String worldName, boolean edit) 
	{
		this.setMaxTributes(max);
		
		this.worldString = worldName;
		this.world = this.loadWorld();
		
		this.setWorldEdit(edit);
	}
	
	private World loadWorld()
	{
		Main.getPlugin().getServer().createWorld(new WorldCreator(this.worldString));
		return Main.getPlugin().getServer().getWorld(this.worldString);
	}
	
	/**
	 * 
	 * @return return the World that is in use by the hungergame
	 * 
	 */
	
	public World getWorld()
	{
		return this.world;
	}
	
	/**
	 * 
	 * @param val True = locks hungergame, False = unlocks hungergame.
	 * 
	 */
	public void setLoacked(boolean val)
	{
		this.locked = val;
	}
	
	/**
	 * 
	 * @return if the HungerGame is locked or not.
	 * 
	 */
	public boolean isLocked()
	{
		return this.locked;
	}
	
	/**
	 * 
	 * @param val true/false value if tributes will be allowed to edit the world.
	 * 
	 */
	public void setWorldEdit(boolean val)
	{
		this.canEdit = val;
	}
	
	/**
	 * 
	 * @return if tributes can edit the terrain/map
	 *
	 */	
	public boolean canEdit()
	{
		return this.canEdit;
	}
	
	/**
	 * 
	 * @param num sets the max number of tributes. -1 for infinite.
	 * 
	 */
	public void setMaxTributes(int num)
	{
		this.maxTributes = num;
	}
	
	/**
	 * 
	 * @return returns the max tributes for this game.
	 * 
	 */
	public int getMaxTributes()
	{
		return this.maxTributes;
	}

	/**
	 * 
	 * @return returns the tributes in this game.
	 * 
	 */
	public ArrayList<User> getTributes()
	{
		return this.tribute;
	}
	
	/**
	 * 
	 * @return returns how many tributes are currently in the game.
	 * 
	 */
	public int getNumOfTributes()
	{
		return this.tribute.size();
	}
	
	/**
	 * 
	 * @param tribute tribute to be added.
	 * @return true if successfully added, false if not.
	 * 
	 */
	public boolean addTribute(User tribute)
	{
		return this.tribute.add(tribute);
	}
	
	/**
	 * 
	 * @param tribute will remove the tribute from the game.
	 * @return returns true if the user was succefuly remove from the game.
	 * 
	 */
	public boolean removeTribute(User tribute)
	{
		return this.tribute.remove(tribute);
	}
	
	/**
	 * 
	 * @param name set the winner of the previous match.
	 * 
	 */
	public void setPrevWinner(String name)
	{
		this.prevWinner = name;
	}
	
	/**
	 * 
	 * @return the previous winners name.
	 * 
	 */
	public String getPrevWinner()
	{
		return this.prevWinner;
	}
	
	/**
	 * 
	 * @param kit Will link a kit to the game.
	 * @return returns true if the kit was successfully added.
	 * 
	 */
	public boolean addKit(Kit kit)
	{
		return this.kit.add(kit);
	}
	
	/**
	 * 
	 * @return returns the kits linked to the game.
	 * 
	 */
	public ArrayList<Kit> getKits()
	{
		return this.kit;
	}
	
	/**
	 * 
	 * @return returns the number of kits in the game.
	 * 
	 */
	public int getNumOfKits()
	{
		return this.kit.size();
	}
}
