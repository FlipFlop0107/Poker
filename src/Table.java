
public class Table
{
	private int pot;
	private List<Card> cCards;
	private List<Player> players;
	private Player player;
	
	public Table (int botAmount, int botDifficulty)
	{
		pot = 0;
		cCards = new List<Card> ();
		players = new List<Player> ();
		for (int i = 0; i < botAmount; i++)
		{
			players.append(new Bot(botDifficulty));
		}
		players.append(player);
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
