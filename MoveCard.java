package monopolyGame;
//EDIT THIS CLASS
//CREATE ANOTHER CLASS THAT IS FOR LOCATION MOVE CARDS
public class MoveCard extends Card
{
	public MoveCard(String anAction, int aMove, Property[] anArrayIn)
	{
		super(anAction);
		move = aMove;
		arrayIn = anArrayIn;
	}
	
	public void affect(Player p)
	{
		p.setLoc(p.getLoc() + move);
	}

	private int move;
	private Property[] arrayIn;
}