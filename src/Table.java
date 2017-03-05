import java.util.Random;

/**
 * Die Klasse dient als Spielfeld des Spiels. 
 * Sie verwaltet sämtliche Spieler und den Dealer und sorgt für deren Kommunikation.
 * 
 * @author Philipp Dobieszweski
 *
 */

public class Table
{
	private Dealer dealer;
	private int pot;
	private List <Card> cCards;
	private List <Bot> bots;
	private Player player;
	private int botAmount;
	
	/**
	 * Konstruktor wird die Anzahl der Bots und die Schwierigkeits-ID übergeben.
	 * Er instanziiert die Objekte {@link Player}, {@link Dealer} und eine {@link List} aus Objekten vom Typ {@link Card}.
	 * Des Weiteren wird eine {@link List} aus Objekten vom Typ {@link Bot} instanziiert.
	 * 
	 * @param botAmount gewünschte Anzahl der Bots
	 * @param botDifficulty Schwierigkeits-ID
	 */
	
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
	
	/**
	 * Erhält je nach Kartenstapeltyp die Karten von dem {@link Dealer}.
	 * 
	 * @param a
	 */
	
	@SuppressWarnings("unchecked")
	public void setCCard (String a)
	{
		cCards.concat(dealer.getCards(a));
	}
	
	/**
	 * Gibt die Karten zurück.
	 * 
	 * @return
	 */
	
	public List<Card> getCCards ()
	{
		return cCards; 
	}
	
	/**
	 * Gibt den Pot zurück.
	 * 
	 * @return Pot
	 */
	
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
