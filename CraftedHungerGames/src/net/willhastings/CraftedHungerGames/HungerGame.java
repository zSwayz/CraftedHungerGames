package net.willhastings.CraftedHungerGames;

import java.util.ArrayList;

import net.willhastings.CraftedHungerGames.util.User;

public class HungerGame 
{
	private String prevWinner;
	private int maxTributes;
	private ArrayList<User> tribute = new ArrayList<User>();
	private ArrayList<Kit> kit = new ArrayList<Kit>();
	
	public HungerGame()
	{
		this(-1);
	}
	
	/**
	 * 
	 * @param max Max amount of tributes for this game.
	 * 
	 */
	public HungerGame(int max) 
	{
		this.setMaxTributes(max);
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
