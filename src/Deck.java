import java.util.Random;

/**
 * Die Klasse verwaltet alle Spielkarten. Sie stellt sicher das jede Karte nur einmal vorhanden ist.
 * 
 * @author Philipp Dobieszewski
 *
 */

public class Deck
{
	public Stack<Card> deck;
	private Card [] cards;
	
	/**
	 * Methode instanziiert ein Karten-Array mit jeder möglichen Kombination aus Kartenfarbe und Kartenwert
	 * und vermischt diese.
	 */
	
	public Deck ()
	{
		cards = new Card [52];
		deck = new Stack<Card> ();
		
		int counter = 0;
		for (int x = 1; x < 5; x++)
		{
			for (int y = 1; y < 14 ; y++)
			{
				cards [counter] = new Card (y, x);
				counter++;
			}
		}
		
		for (int i = 0; i < cards.length; i++)
		{
			deck.push(cards [i]);
		}
		mix();
	}
	
	/**
	 * Methode mischt die Karten.
	 */
	public void mix ()
	{
		Random rndGen = new Random ();
		int rnd;
		Stack<Card> stack1 = new Stack<Card> ();
		Stack<Card> stack2 = new Stack<Card> ();
		
		for (int x = 0; x < 50; x++)
		{	
			while (!deck.isEmpty())
		    {
		    	rnd = rndGen.nextInt(3) +1;
		    	for (int i = 0; i < rnd; i++)
		    	{
		    		stack1.push(deck.top());
		    		deck.pop();
		    	}
		    	
		    	rnd = rndGen.nextInt(3) +1;
		    	for (int i = 0; i < rnd; i++)
		    	{
		    		stack2.push(deck.top());
		    		deck.pop();
		    	}
		    }
			
		    while (!stack1.isEmpty() && !stack2.isEmpty())
		    {
		    	rnd = rndGen.nextInt(3) +1;
		    	for (int i = 0; i < rnd; i++)
		    	{
		    		deck.push(stack1.top());
		    		stack1.pop();
		    	}
		    	
		    	rnd = rndGen.nextInt(3) +1;
		    	for (int i = 0; i < rnd; i++)
		    	{
		    		deck.push(stack2.top());
		    		stack2.pop();
		    	}
		    }
		    
		} 
	}
	
	/**
	 * Methode gibt die oberste Karte zurück und entfernt sie.
	 * 
	 * @return Karte
	 */
	
	public Card getCard ()
	{
		Card card = deck.top();
		deck.pop();
		return card;
	}
}
