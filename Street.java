package monopolyGame;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Street implements Property
{
	private String name;
	private String setName;
	private int cost;
	private int setNum;
	private int rent;
	private int rent1House;
	private int rent2House;
	private int rent3House;
	private int rent4House;
	private int rentHotel;
	private int houses;
	private int houseCost;
	private Player owner;

	public Street(String aName, String aSetName, int aSetNum,
		int aRent, int aRent1House,	int aRent2House,
			int aRent3House, int aRent4House, int aRentHotel, int aHouseCost, int aCost)
	{
		name = aName;
		setName = aSetName;
		setNum = aSetNum;
		rent = aRent;
		rent1House = aRent1House;
		rent2House = aRent2House;
		rent3House = aRent3House;
		rent4House = aRent4House;
		rentHotel = aRentHotel;
		houses = 0;
		owner = null;
		houseCost = aHouseCost;
		cost = aCost;
	}

	public String getName()
	{
		return name;
	}

	public void affect(Player p)
	{
		if (!(owner==null) && !(p.equals(owner)))
		{
			if (isMonopoly() && houses == 0)
				p.pay(owner,rent*2);
			else
				p.pay(owner,rent);
		}
	}

	public void addHouse()
	{
		if(houses <5)
		{
			if (houses == 0)
			rent = rent1House;
			if (houses == 1)
			rent = rent2House;
			if (houses == 2)
			rent = rent3House;
			if (houses == 3)
			rent = rent4House;
			if (houses == 4)
			rent = rentHotel;
			houses++;
			owner.pay(houseCost);
		}
	}

	public String getSet()
	{
		return setName;
	}

	public Player getOwner()
	{
		return owner;
	}

	public Boolean isMonopoly()
	{
		if(!(owner==null))
		{
			int count = 0;
			for(Property p : owner.getProps())
				if (p.getSet().equals(setName))
					count ++;
			return (count == setNum);
		}
		else return false;
	}
	
	public String getText()
	{
		return " pays " + rent + " to " + getOwner().getName(); 
	}
	
	public int getRent()
	{
		return rent;
	}

	public int getCost()
	{
		return cost;
	}
	
	public int getHouses()
	{
		return houses;
	}
	
	public void setOwner(Player p)
	{
		owner = p;
	}
}
