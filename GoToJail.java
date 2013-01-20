package monopolyGame;

public class GoToJail implements Property
{
	private Player banker = new Player();
	public void affect(Player p)
	{
		p.jail();
	}
	
	public Player getOwner()
	{
		return banker;
	}
	
	public String getSet()
	{
		return null;
	}
	
	public String getName()
	{
		return null;
	}
	
	public void setOwner(Player p)
	{
	}
	
	public String getText()
	{
		return " is sent to jail.";
	}
	
	public int getCost()
	{
		return 50;
	}
}