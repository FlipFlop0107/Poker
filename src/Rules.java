
public class Rules
{
	private Card [] cards;
	
	
	public Rules (List<Card> cCards, List<Card> pocket, int cardAmount)
	{
		pocket.concat(cCards);
		pocket.toFirst();
		cards = new Card [pocket.length()];
		for (int i = 0; i < cards.length; i++)
		{
			cards [i] = pocket.getContent();
			pocket.next();
		}
	}
	
	
	public int checkCards ()
	{
		int cards = 0;
		switch (checkRoyalFlush())
		{
			case 0:
			
			break;
			case 1:
			
			break;
			case 2:
			
			break;
			case 3:
			
			break;
			case 4:
			
			break;
		}
		
		
		
		return cards;
	}
	
	private int checkRoyalFlush ()
	{
		int i = 0;
		
		
		return i;
	}
	
	public int checkStraightFlush ()
	{
		int i = 0;
		sort(0);
		
		
		return i;
	}
	
	
	private void dreieckstausch(int a, int b)
	  {
	    Card temp;
	    temp = cards[a];
	    cards[a]= cards[b];
	    cards[b]= temp;
	  }
	
	private void sort (int a)
	{
		switch (a)
		{
			case 0:
			for (int i=1; i < cards.length; i++)
			{
				for (int x=0; x < i; x++)
			    {
			        if (cards[x].getID() > cards[i].getID())
			        {
			          dreieckstausch(x,i);
			        }
			    }
			}
		}
	}
}
