
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
	
	public void setPocket (Card card1, Card card2)
	{
		pocket [0] = card1;
		pocket [1] = card2;
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
		String i = new Rules (cCards, pocketToList()).checkCards();
		return i; 
	}
}
