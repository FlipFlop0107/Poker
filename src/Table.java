
public class Table
{
	private Dealer dealer;
	private int pot;
	private List<Card> cCards;
	private List<Player> players;
	private Player player;
	
	public Table (int botAmount, int botDifficulty)
	{
		pot = 0;
		player = new Player ();
		dealer = new Dealer ();
		cCards = new List<Card> ();
		players = new List<Player> ();
		for (int i = 0; i < botAmount; i++)
		{
			players.append(new Bot(botDifficulty));
		}
	}
	
	@SuppressWarnings("unchecked")
	public void setCCard (String a)
	{
		cCards.concat(dealer.getCards(a));
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
	
	public Card[] getPPocket ()
	{
		return player.getPocket();
	}
	
	@SuppressWarnings("unchecked")
	public void preflop()
	{
		players.toFirst();
		while (players.hasAccess())
		{
			players.getContent().setPocket(dealer.getCards("pocket"));
			players.next();
		}
		player.setPocket(dealer.getCards("pocket"));
	}
	
	public String checkPCards ()
	{
		return player.checkCards(cCards);
	}
}
