
public class Rules
{
	private Card [] cards;
	
	
	public Rules (List<Card> cCards, List<Card> pocket)
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
		sort(1);
		int i = cards[0].getRank();
		
		//if (checkRoyalFlush() != 0) return checkRoyalFlush();
		//else if (checkStraightFlush() != 0) return checkStraightFlush();
		//else if (checkFourOfAKind() != 0) return checkFourOfAKind();
		//else if (checkFullHouse() != 0) return checkFullHouse();
		//else if (checkFlush() != 0) return checkFlush();
		//else if (checkStraight() != 0) return checkStraight();
		//else if (checkThreeOfAKind() != 0) return checkThreeOfAKind();
		//else if (checkTwoPair() != 0) return checkTwoPair();
		if (checkOnePair() != 0) return checkOnePair();
		
		
		
		return i;
	}
	
	/*private int checkRoyalFlush ()
	{
		
	}*/
	
	/*private int checkStraightFlush ()
	{
		
	}*/
	
	/*private int checkFourOfAKind ()
	{
		
	}*/
	
	/*private int checkFullHouse ()
	{
		
	}*/
	
	/*private int checkStraight ()
	{
		
	}*/
	
	/*private int checkThreeOfAKind ()
	{
		
	}*/
	
	/*private int checkTwoPair ()
	{
		
	}*/
	/*private int checkStraightFlush ()
	{
		
	}*/
	
	private int checkOnePair ()
	{
		int i = 0;
		for (int x = 0; x < 7; x++)
		{
			for (int y = 0; y < 7; y++)
			{
				if (cards[x].getRank() == cards[y].getRank() && cards[x].getID() != cards[y].getID())
				{
					return cards[x].getRank();
				}
			}
		}
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
					if (cards[x].getRank() > cards[i].getRank())
					{
						dreieckstausch(x,i);
					}
				}
			}
			break;
		case 1:
			for (int i=1; i < cards.length; i++)
			{
				for (int x=0; x < i; x++)
				{
					if (cards[x].getRank() < cards[i].getRank())
					{
						dreieckstausch(x,i);
					}
				}
			}
			break;
		}
	}
}
