package monopolyGame;

import javax.swing.JOptionPane;
public class Utility implements Property
{
	private String name;
	private Player owner;

	public Utility(String aName)
	{
		name = aName;
	}

	public String getName()
	{
		return name;
	}

	public String getSet()
	{
		return "Utility";
	}

	public Player getOwner()
	{
		return owner;
	}

	public void affect(Player p)
	{
		if (!(owner==null) && !(owner.equals(p)))
		{
			p.pay(owner,getRent());
		}
	}

	public int getRent()
	{
		Die d = new Die(6);
		int count = 0;
		for(Property p : owner.getProps())
			if (p.getSet().equals("RailRoad"))
				count ++;
		if (count == 0)
			return (d.cast() + d.cast()) * 4;
		else
			return (d.cast() + d.cast()) * 10;
	}
	
	public String getText()
	{
		return " pays " + getRent() + " to " + getOwner().getName();
	}
	
	public int getCost()
	{
		return 150;
	}
	
	public void setOwner(Player p)
	{
		owner = p;
	}

}