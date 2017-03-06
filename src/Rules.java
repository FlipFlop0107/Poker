/**
 * Klasse überprüft, ob bei Karten bestimmte Regeln vorliegen. 
 * 
 * @author Philipp Dobieszewski
 *
 */

public class Rules
{
	private List<Card> cardlist;
	private Card [] cards;
	private int a;
	
	/**
	 * Konstruktor fügt Spielerkarten und Spielkarten in ein Array zusammen.
	 * 
	 * @param cCards Spielkarten
	 * @param pocket Spielerkarten
	 */
	public Rules (List<Card> cCards, List<Card> pocket)
	{
		pocket.concat(cCards);
		cardlist = pocket;
		a = length();
		cardlist.toFirst();
		cards = new Card [a];
		for (int i = 0; i < a; i++)
		{
			cards [i] = cardlist.getContent();
			cardlist.next();
		}
	}
	
	/**
	 * Überprüft die Karten auf Regeln.
	 * 
	 * @return Name der Regel
	 */
	public String checkCards ()
	{
		sort(1);
		String i = "highest"+cards[0].getRank();
		
		if (checkRoyalFlush() != 0 && a > 4) return "royal";
		//else if (checkStraightFlush() != 0 && a > 4) return "straightflush"+checkStraightFlush();
		//else if (checkFourOfAKind() != 0 && a > 3) return "four"+checkFourOfAKind();
		//else if (checkFullHouse() != 0 && a > 4) return "full"+checkFullHouse();
		//else if (checkFlush() != 0 && a > 4) return "flush"+checkFlush();
		//else if (checkStraight() != 0 && a > 4) return "straight"+checkStraight();
		//else if (checkThreeOfAKind() != 0 && a > 2) return "three"+checkThreeOfAKind();
		//else if (checkTwoPair() !=  && a > 3) return "two"+checkTwoPair();
		else if (checkOnePair() != 0) return "one"+checkOnePair();
		
		return i;
	}
	
	private int checkRoyalFlush () //Nicht richtig sortiert! Suit, Rank
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
		sort(1);
		for (int i = 0; i < 3; i++)
		{
			for (int x = i; x < 4+i; x++)
			{
				if (cards[x].getRank() != cards[x+1].getRank()+1) break;
				else if (x == 3+i) return cards[x-2-i].getRank();
			}
		}
		return 0;
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
		for (int x = 0; x < a; x++)
		{
			for (int y = 0; y < a; y++)
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
	
	private int length ()
	{
		int i = 0;
		cardlist.toFirst();
		while (cardlist.hasAccess())
		{
			i++;
			cardlist.next();
		}
		return i;
	}
}
