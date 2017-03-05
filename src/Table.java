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
	 * @param a Kartenstapeltyp
	 */
	
	@SuppressWarnings("unchecked")
	public void setCCard (String a)
	{
		cCards.concat(dealer.getCards(a));
	}
	
	/**
	 * Gibt die Karten zurück.
	 * 
	 * @return Karten
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
	
	/**
	 * Fügt Einsatz zum Pot hinzu.
	 * 
	 * @param bet Einsatz
	 */
	
	public void setPot (int bet)
	{
		pot = pot + bet;
	}
	
	/**
	 * Gibt die Karten eines Spielers zurück.
	 * 
	 * @return Karten eines Spielers
	 */
	
	public Card[] getPPocket ()
	{
		return player.getPocket();
	}
	
	/**
	 * Gibt eine {@link List} aus Objekten vom Typ {@link Bot} zurück.
	 * 
	 * @return
	 */
	
	public List<Bot> getBots ()
	{
		return bots;
	}
	
	/**
	 * Setzt zufälligen Blind.
	 */
	
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
	
	/**
	 * Verteilt die Karten gleichmäßig auf die Spieler.
	 */
	
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
	
	/**
	 * Gibt das Guthaben der {@link Player} zurück.
	 * 
	 * @return Guthaben
	 */
	
	public int getPlayerBalance ()
	{
		return player.getBalance();
	}
	
	/**
	 * Gibt die Guthaben der Bots zurück.
	 * 
	 * @return Array aus Guthaben
	 */
	
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
	
	/**
	 * Setzt Spielereinsatz.
	 * 
	 * @param bet
	 */
	
	public void playerBet (int bet)
	{
		player.bet(bet);
	}
	
	/**
	 * Setzt Boteinsatz.
	 */
	
	public void botBet ()
	{
		bots.toFirst();
		while (bots.hasAccess())
		{
			bots.getContent().botBet(cCards);
			bots.next();
		}
	}
	
	/**
	 * Gibt Karten der Spieler zurück.
	 * 
	 * @return Karten
	 */
	
	public String checkPCards ()
	{
		return player.checkCards(cCards);
	}
	
	/**
	 * Setzt ein neues Deck.
	 */
	
	public void newDeck ()
	{
		dealer.newDeck();
	}
}
