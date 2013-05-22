package net.willhastings.CraftedHungerGames;

public class Kit 
{
	private String description;
	
	/**
	 * 
	 * @param desc description of the kit
	 * 
	 */
	public Kit(String desc)
	{
		this.setDescription(desc);
	}
	
	/**
	 * 
	 * @param desc sets this description of the kit
	 * 
	 */
	public void setDescription(String desc)
	{
		this.description = desc;
	}
	
	/**
	 * 
	 * @return returns the kits description
	 * 
	 */
	public String getDescription()
	{
		return this.description;
	}
}
