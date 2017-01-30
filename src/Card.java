
public class Card
{
	private String rank;
	private String suit;
	
	
	public enum Rank
	{
		TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
	}
	
	public enum Suit
	{
		CLUBS, DIAMONDS, HEARTS, SPADES;
	}
	
	
	public Card (String pRank, String pSuit)
	{
		rank = pRank;
		suit = pSuit;
	}


	public String getRank()
	{
		return rank;
	}

	public String getSuit()
	{
		return suit;
	}
}
