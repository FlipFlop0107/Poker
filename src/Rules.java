public class Rules
{
	private Card [] cards;
	
	
	public Rules (List<Card> cCards, List<Card> pocket)
	{
		pocket.concat(cCards);
		pocket.toFirst();
		cards = new Card [7];
		for (int i = 0; i < 7; i++)
		{
			cards [i] = pocket.getContent();
			pocket.next();
		}
	}
	
	
	public String checkCards ()
	{
		sort(1);
		String i = "highest"+cards[0].getRank();
		
		if (checkRoyalFlush() != 0) return "royal";
		//else if (checkStraightFlush() != 0) return "straightflush"+checkStraightFlush();
		//else if (checkFourOfAKind() != 0) return "four"+checkFourOfAKind();
		//else if (checkFullHouse() != 0) return "full"+checkFullHouse();
		//else if (checkFlush() != 0) return "flush"+checkFlush();
		//else if (checkStraight() != 0) return "straight"+checkStraight();
		//else if (checkThreeOfAKind() != 0) return "three"+checkThreeOfAKind();
		//else if (checkTwoPair() != 0) return "two"+checkTwoPair();
		else if (checkOnePair() != 0) return "one"+checkOnePair();
		
		return i;
	}
	
	private int checkRoyalFlush ()
	{
		sort(1);
		for (int i = 0; i < 5; i++)
		{
			if (cards[i].getID() != cards[i+1].getID()+1) return 0;
		}
		return 1;
	}
	
	/*private int checkStraightFlush ()
	{
		
	}*/
	
	/*private int checkFourOfAKind ()
	{
		
	}*/
	
	/*private int checkFullHouse ()
	{
		checkOnePair();
		checkThreeOfAKind();
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
	
	private int checkOnePair ()
	{
		int i = 0;
		for (int x = 0; x < 7; x++)
		{
			for (int y = 0; y < 7; y++)
			{
				if (cards[x].getRank() == cards[y].getRank() && cards[x] != cards[y])
				{
					return cards[x].getRank();
				}
			}
		}
		return i;
	}
	
	private void deltaExchange (int a, int b)
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
						deltaExchange (x,i);
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
						deltaExchange (x,i);
					}
				}
			}
			break;
		}
	}
}
