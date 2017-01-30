
public class Table
{
	private int pot;
	private List<Card> cCards;
	
	
	public Table ()
	{
		pot = 0;
		cCards = new List<Card> ();
	}
	
	public void setCards (List<Card> cards)
	{
		cCards = cards;
	}
	
	public List<Card> getCards ()
	{
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
