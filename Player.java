package monopolyGame;

import java.util.ArrayList;

public class Player
{
	private String name;
	private int money;
	private ArrayList<Property> myProps;
	private int loc;
	private Boolean inJail;
	private int time;
	private int number;
	private int doubles;
	private Boolean jailCard;
	private ArrayList<Card> cards;
	public static final int spaceTotal = 40;
	
	//creates a non playable player, used as place holders
	public Player()
	{
		//Variables Needed?
		name = "banker";
		money = 0;
		myProps = null;
		jailCard = false;
	}
	
	//creates a player
	public Player(String aName, int num)
	{
		name = aName;
		money = 1500;
		myProps = new ArrayList<Property>();
		loc = 0;
		inJail = false;
		time = 0;
		number = num;
		doubles = 0;
		jailCard = false;
		cards = new ArrayList<Card>();
	}
	
	//returns the player number
	public int getNum()
	{
		return number;
	}
	
	//returns the resulting move location
	public int move(int amount)
	{
		int loc1 = getLoc();
		loc = (amount+loc) % spaceTotal;
		if(loc<loc1)
			money+=200;
		return loc;

	}
	
	//adds an amount to money
	public void earn(int amount)
	{
		money+=amount;
	}
	
	//substracts an amount to money
	public void pay(int amount)
	{
		money-=amount;
	}
	
	//gives money to another player
	public void pay(Player p, int amount)
	{
		pay(amount);
		p.earn(amount);
	}
	
	//adds the property to the Player's array list
	public void get(Property p)
	{
		myProps.add(p);
	}
	
	//returns the amount of money the player owns
	public int getMoney()
	{
		return money;
	}
	
	//used when player rolls doubles, adds a counter until it reaches 3
	//then it marks the player as in Jail
	public void incrementDoubles()
	{
		doubles++;
		if(doubles >= 3)
			inJail = true;
	}
	
	//resets all counters
	public void reset()
	{
		doubles = 0;
	}
	
	//returns an ArrayList with the player's properties
	public ArrayList<Property> getProps()
	{
		return myProps;
	}

	//returns the player's name
	public String getName()
	{
		return name;
	}
	
	//return's the player's time in jail
	public int getTime()
	{
		return time;
	}
	
	//adds time to the jail timer
	public void addTime()
	{
		time++;
	}

	//returns the location the player is at
	public int getLoc()
	{
		return loc;
	}
	
	//changes the players location to location
	public void setLoc(int location)
	{
		loc = location;
	}

	//returns an array full of props able to have houses built on
	public Street[] buildableProps()
	{
		Street[] build;
		Street s;
		int count = 0;
		for(Property p : getProps())
		{
			if(p instanceof Street)
			{
				s = (Street) p;
				if(s.isMonopoly() && s.getHouses() <= 5)
				{
					count++;
				}
			}
		}
		if (count >0)
		{
			build = new Street[count-1];
			for(int a = 0; a<getProps().size(); a++)
			{
				if(getProps().get(a) instanceof Street)
				{
					s = (Street) getProps().get(a);
					if(s.isMonopoly() && s.getHouses() <= 5)
					{
						build[a] = s;
					}
				}
			}
		}
		else build = new Street[0];
		return build;

	}
	
	//returns true if the player has a jail card
	public Boolean hasJailCard()
	{
		if(cards.size()>0) {
			jailCard = true; 
			cards.remove(cards.size()-1);
			return true;
		}
		else{
			jailCard = false;
			return false;
		}
		
	}
	
	//uses the card to get out of jail
	public void giveCard(Card c)
	{
		cards.add(c);
		jailCard = true;
	}

	//marks the player as in jail
	public void jail()
	{
		loc = 10;
		inJail = true;
	}
	
	//marks the player as released from jail
	public void release()
	{
		inJail = false;
		time = 0;
	}
	
	//returns true if the player is jailed
	public Boolean isJailed()
	{
		return inJail;
	}

}
