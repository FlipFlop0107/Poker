
public class Table
{
	private int pot;
	private List<Card> cCards;
	
	
	public Table ()
	{
		pot = 0;
		cCards = new List<Card> ();
	}
	
	public void setCCard (List<Card> cards)
	{
		cCards.concat(cards);;
	}
	
	public List<Card> getCCards ()
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
