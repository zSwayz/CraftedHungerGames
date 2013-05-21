package net.willhastings.CraftedHungerGames;

import java.util.ArrayList;

import net.willhastings.CraftedHungerGames.util.User;

public class HungerGame 
{
	private String prevWinner;
	private ArrayList<User> member = new ArrayList<User>();
	private ArrayList<Kit> kit = new ArrayList<Kit>();
	
	public HungerGame()
	{
		//to-do
	}
	
	public ArrayList<User> getMembers()
	{
		return this.member;
	}
	
	public int getNumOfPlayers()
	{
		return this.member.size();
	}
	
	public boolean addMember(User user)
	{
		return this.member.add(user);
	}
	
	public boolean removeMember(User user)
	{
		return this.member.remove(user);
	}
	
	public void setPrevWinner(String name)
	{
		this.prevWinner = name;
	}
	
	public String getPrevWinner()
	{
		return this.prevWinner;
	}
	
	public boolean addKit(Kit kit)
	{
		return this.kit.add(kit);
	}
	
	public ArrayList<Kit> getKits()
	{
		return this.kit;
	}
	
	public int getNumOfKits()
	{
		return this.kit.size();
	}
}
