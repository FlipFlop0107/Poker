
public class Player
{
	private boolean sBlind;
	private boolean bBlind;
	private boolean inGame;
	private int balance;
	private Card [] pocket;
	
	
	public Player ()
	{
		setSBlind(false);
		setBBlind(false);
		setInGame(true);
		balance = 200;
		pocket = new Card [2];
	}
	
	
	public int bet (int bet)
	{	
		if (isInGame())
		{
			balance = balance - bet;
			return bet;
		}
		else return 0;
	}
	
	public Card [] getPocket ()
	{
		return pocket;
	}
	
	public void setPocket (List<Card> pocket)
	{
		pocket.toFirst();
		this.pocket [0] = pocket.getContent();
		pocket.next();
		this.pocket [1] = pocket.getContent();
	}
	
	public int getBalance ()
	{
		return balance;
	}
	
	public void setBalance (int balance)
	{
		this.balance = this.balance + balance;
	}

	public boolean isSBlind()
	{
		return sBlind;
	}

	public void setSBlind(boolean sBlind)
	{
		this.sBlind = sBlind;
	}

	public boolean isBBlind()
	{
		return bBlind;
	}

	public void setBBlind(boolean bBlind)
	{
		this.bBlind = bBlind;
	}
	
	public boolean isInGame()
	{
		return inGame;
	}
	
	public void setInGame(boolean inGame)
	{
		this.inGame = inGame;
	}
	
	public void fold()
	{
		setInGame(true);
	}
	
	public List<Card> pocketToList ()
	{
		List<Card> temp = new List<Card> ();
		temp.append(pocket[0]);
		temp.append(pocket[1]);
		return temp;
	}
	
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
