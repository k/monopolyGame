package monopolyGame;

public class BankCard extends Card
{
	public BankCard(String anAction, int anAmount)
	{
		super(anAction);
		amount = anAmount;
	}
	
	public void affect(Player p)
	{
		p.earn(amount);
	}
	private int amount;
}