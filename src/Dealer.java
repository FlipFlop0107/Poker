
public class Dealer
{
	private Deck deck;
	
	public Dealer ()
	{
		deck = new Deck ();
	}
	
	@SuppressWarnings("rawtypes")
	public List getCards (int amount)
	{	
		List<Card> cards = new List<Card> ();
		for (int i = 0; i < amount; i++)
		{
			cards.append(deck.getCard());
		}
		return cards;
	}
}
