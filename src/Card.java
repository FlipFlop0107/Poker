
public class Card
{
	private int ID;
	private int rank;
	private int suit;
	
	
	public Card (int rank, int suit)
	{
		this.rank = rank;
		this.suit = suit;
	}


	public int getID ()
	{
		ID = suit*100+rank;
		return ID;
	}
	
	public int getRank()
	{
		return rank;
	}

	public int getSuit()
	{
		return suit; //1 = Clubs, 2 = Diamonds, 3 = Hearts, 4 = Spades
	}
}
