package monopolyGame;

public class Card
{
	public Card(String anAction)
	{
		action = anAction;
	}
	
	public String getAction()
	{
		return action;
	}
	
	public void affect(Player p)
	{
		
	}
	
	private String action;
}