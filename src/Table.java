import java.util.Random;

public class Table
{
	private Dealer dealer;
	private int pot;
	private List <Card> cCards;
	private List <Bot> bots;
	private Player player;
	private int botAmount;
	
	public Table (int botAmount, int botDifficulty)
	{
		this.botAmount = botAmount;
		pot = 0;
		player = new Player ();
		dealer = new Dealer ();
		cCards = new List <Card> ();
		bots = new List <Bot> ();
		for (int i = 0; i < botAmount; i++)
		{
			bots.append(new Bot(botDifficulty));
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
	
	public List<Bot> getBots ()
	{
		return bots;
	}
	
	public void setRndBlinds ()
	{
		Random rndGen = new Random ();
		int rnd = rndGen.nextInt(botAmount);
		if (rnd == botAmount)
		{
			player.setSBlind(true);
			bots.toFirst();
			bots.getContent().setBBlind(true);
		}
		else 
		{
			bots.toFirst();
			for (int i = 0; i < rnd; i++)
			{
				if (i != 0)bots.next();
			}
			bots.getContent().setSBlind(true);
			bots.next();
			if (bots.hasAccess()) bots.getContent().setBBlind(true);
			else player.setBBlind(true);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void preflop()
	{
		bots.toFirst();
		while (bots.hasAccess())
		{
			bots.getContent().setPocket(dealer.getCards("pocket"));
			bots.next();
		}
		player.setPocket(dealer.getCards("pocket"));
	}
	
	public int getPlayerBalance ()
	{
		return player.getBalance();
	}
	
	public int[] getBotBalances ()
	{
		int[] balances = new int[botAmount];
		int a = 0;
		bots.toFirst();
		while (bots.hasAccess())
		{
			balances[a] = bots.getContent().getBalance();
			bots.next();
			a++;
		}
		return balances;
	}
	
	public void playerBet (int bet)
	{
		player.bet(bet);
	}
	
	public void botBet ()
	{
		bots.toFirst();
		while (bots.hasAccess())
		{
			bots.getContent().botBet(cCards);
			bots.next();
		}
	}
	
	public String checkPCards ()
	{
		return player.checkCards(cCards);
	}
	
	public void newDeck ()
	{
		dealer.newDeck();
	}
}
