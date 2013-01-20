package monopolyGame;

public class CardStack implements Property
{
	private String name;
	private Player banker;
	public CardStack(Card[] aStack)
	{
		stack = aStack;
		topCard = 0;
		banker = new Player();
	}
	
	public void affect(Player p)
	{
		stack[topCard].affect(p);
		topCard = (topCard+1)%stack.length;
	}
	
	public Player getOwner()
	{
		return banker;
	}
	
	public String getName()
	{
		return null;
	}
	
	public String getSet()
	{
		return null;
	}
	
	public void setOwner(Player p)
	{
	}
	
	public int getCost()
	{
		return 0;
	}
	
	public String getText()
	{
		return stack[topCard].getAction();
	}
	
	private int topCard;
	private Card[] stack;
}