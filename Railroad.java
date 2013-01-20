package monopolyGame;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Railroad implements Property
{
	private String name;
	private Player owner;

	public Railroad(String aName)
	{
		name = aName;
		owner = null;
	}

	public String getName()
	{
		return name;
	}

	public Player getOwner()
	{
		return owner;
	}

	public int getRent()
	{
		int count = 0;
		for(Property p : owner.getProps())
			if (p.getSet().equals("RailRoad"))
				count ++;
		if (count == 1)
			return 25;
		else if (count == 2)
			return 50;
		else if (count == 3)
			return 100;
		else
			return 200;
	}
	public String getText()
	{
		return " pays " + getRent() + " to " + getOwner().getName();
	}
	public String getSet()
	{
		return "RailRoad";
	}

	public void affect(Player p)
	{
		if (!(owner==null) && !(owner.equals(p)))
		{
			p.pay(owner,getRent());
		}
	}
	public void setOwner(Player p)
	{
		owner = p;
	}
	public int getCost()
	{
		return 200;
	}
}
