import java.util.Random;

public class Deck
{
	public Stack<Card> deck;
	private Card [] cards;
	
	
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
	
	public Card getCard ()
	{
		Card card = deck.top();
		deck.pop();
		return card;
	}
}
