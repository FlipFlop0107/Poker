
/**
 * Klasse dient als Modell für einen Spieler. 
 * 
 * @author Philipp Dobieszewski
 *
 */

public class Player
{
	private boolean sBlind;
	private boolean bBlind;
	private boolean inGame;
	private int balance;
	private Card [] pocket;
	
	/**
	 * Konstruktor gibt dem Spieler eine Startguthaben.
	 */
	public Player ()
	{
		setSBlind(false);
		setBBlind(false);
		setInGame(true);
		balance = 200;
		pocket = new Card [2];
	}
	
	/**
	 * Setzt einen Einsatz.
	 * 
	 * @param bet Einsatz
	 * @return Einsatz
	 */
	
	public int bet (int bet)
	{	
		if (isInGame())
		{
			balance = balance - bet;
			return bet;
		}
		else return 0;
	}
	
	/**
	 * Gibt Karten des Spielers zurück.
	 * 
	 * @return Karten
	 */
	
	public Card [] getPocket ()
	{
		return pocket;
	}
	
	/**
	 * Setzt Spielerkarten.
	 * 
	 * @param pocket Spielerkarten
	 */
	
	public void setPocket (List<Card> pocket)
	{
		pocket.toFirst();
		this.pocket [0] = pocket.getContent();
		pocket.next();
		this.pocket [1] = pocket.getContent();
	}
	
	/**
	 * Gibt Spielerguthaben zurück.
	 * 
	 * @return Guthaben
	 */
	
	public int getBalance ()
	{
		return balance;
	}
	
	/**
	 * Setzt Spielerguthaben.
	 * 
	 * @param balance Guthaben
	 */
	
	public void setBalance (int balance)
	{
		this.balance = this.balance + balance;
	}

	/**
	 * Gibt den Small-Blind-Status zurück.
	 * 
	 * @return Status
	 */
	
	public boolean isSBlind()
	{
		return sBlind;
	}

	/**
	 * Setzt den Small-Blind-Status.
	 * 
	 * @param sBlind Small-Blind
	 */
	
	public void setSBlind(boolean sBlind)
	{
		this.sBlind = sBlind;
	}

	/**
	 * Gibt den Big-Blind-Status zurück.
	 * 
	 * @return Status
	 */
	
	public boolean isBBlind()
	{
		return bBlind;
	}

	/**
	 * Setzt den Big-Blind-Status.
	 * 
	 * @param bBlind Big-Blind
	 */
	
	public void setBBlind(boolean bBlind)
	{
		this.bBlind = bBlind;
	}
	
	/**
	 * Gibt den Spielstatus zurück.
	 * 
	 * @return Spielstatus
	 */
	
	public boolean isInGame()
	{
		return inGame;
	}
	
	/**
	 * Setzt den Spielstatus.
	 * 
	 * @param inGame Spielstatus
	 */
	
	public void setInGame(boolean inGame)
	{
		this.inGame = inGame;
	}
	
	/**
	 * Setzt Spielstatus auf false.
	 */
	
	public void fold()
	{
		setInGame(false);
	}
	
	/**
	 * Konvertiert {@link Card}-Array zu {@link List}.
	 * @return {@link List} aus {@link Card}s
	 */
	
	public List<Card> pocketToList ()
	{
		List<Card> temp = new List<Card> ();
		temp.append(pocket[0]);
		temp.append(pocket[1]);
		return temp;
	}
	
	/**
	 * Überprüft Karten auf Regeln.
	 * 
	 * @param cCards Karten
	 * @return Regel
	 */
	public String checkCards (List<Card> cCards)
	{
		/*List<Card> temp = new List<Card> ();
		for (int x = 9; x < 14; x++)
		{
			temp.append(new Card(x, 2));
		}*/
		return new Rules (cCards/*temp*/, pocketToList()).checkCards(); 
	}
}
