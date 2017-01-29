
public class Table
{
	private int pot;
	private Card [] cCards;
	
	
	public Table ()
	{
		pot = 0;
		cCards = new Card [5];
	}
	
	public void setCards (List<Card> cards)
	{
		int i = 0;
		cards.toFirst();
		while (cards.hasAccess())
		{
			cCards [i] = cards.getContent();
			cards.next();
			i++;
		}
	}
	
	public Card [] getCards ()
	{
		for (int i = 0; i < cCards.length; i++)
		{
			System.out.println(cCards [i].getSuit() + ",    " + cCards [i].getRank());
		}
		return cCards; 
	}
	
	public int getPot ()
	{
		return pot;
	}
	
	public void setPot (int bet)
	{
		pot = pot + bet;
	}
}
