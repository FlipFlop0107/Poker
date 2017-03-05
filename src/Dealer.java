
public class Dealer
{
	private Deck deck;
	
	public Dealer ()
	{
		deck = new Deck ();
	}
	
	@SuppressWarnings("rawtypes")
	public List getCards (String a)
	{
		switch (a)
		{
		case "pocket": List<Card> pocket = new List<Card> ();
					   for (int i = 0; i < 2; i++) pocket.append(deck.getCard());
					   return pocket;
		case "flop":   deck.deck.pop();
				 	   List<Card> flop = new List<Card> ();
					   for (int i = 0; i < 3; i++) flop.append(deck.getCard());
					   return flop;
		case "turn":   deck.deck.pop();
					   List<Card> turn = new List<Card> ();
					   turn.append(deck.getCard());
					   return turn;
		case "river":  deck.deck.pop();
					   List<Card> river = new List<Card> ();
					   river.append(deck.getCard());
				       return river;
		default:       return null;
		}	
	}
	
	public void newDeck ()
	{
		deck = new Deck ();
	}
}
