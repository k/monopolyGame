package monopolyGame;

public interface Property
{
	void affect(Player p);
	Player getOwner();
	String getSet();
	String getName();
	String getText();
	int getCost();
	void setOwner(Player p);
}
