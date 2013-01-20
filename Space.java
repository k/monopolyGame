package monopolyGame;

public class Space implements Property
{
	private int amount;
	private String name;
	private Player banker = new Player();
	public Space(String theName, int mon)
	{
		name = theName;
		amount = mon;
			
	}

	public String getSet()
	{
		return null;
	}

	public Player getOwner()
	{
		return banker;
	}

	public void affect(Player p)
	{
		p.earn(amount);
	}

	public String getName()
	{
		return name;
	}

	public void setOwner(Player p)
	{
		
	}

	public int getAmount()
	{
		return amount;
	}

	public int getCost()
	{
		return amount;
	}

	public String getText()
	{
		if (name.equals("Jail")) return " is Just Visiting.";
		else if (amount > 0) return " gains " + amount + ".";
		else return " loses " + amount + ".";
	}
}