
public class Player
{
	private boolean sBlind;
	private boolean bBlind;
	private int balance;
	private Card [] pocket;
	
	
	public Player ()
	{
		setSBlind(false);
		setBBlind(false);
		balance = 0;
		pocket = new Card [2];
	}
	
	
	public int bet (int pBet)
	{	
		int bet = pBet;
		balance = balance - bet;
		return bet;
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
		for (int x = 1; x < 6; x++)
		{
			temp.append(new Card(x, 2));
		}*/
		
		return new Rules (cCards/*temp*/, pocketToList()).checkCards(); 
	}
}
