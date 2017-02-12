import javax.swing.ImageIcon;

public class Card
{
	private int ID;
	private int rank;
	private int suit;
	
	
	public Card (int rank, int suit)
	{
		this.rank = rank;
		this.suit = suit;
	}


	public int getID ()
	{
		ID = suit*100+rank;
		return ID;
	}
	
	public int getRank()
	{
		return rank;
	}

	public int getSuit()
	{
		return suit; //1 = Clubs, 2 = Diamonds, 3 = Hearts, 4 = Spades
	}
	
	public ImageIcon getIcon ()
	{
		switch (getID())
		{
			case 101: return new ImageIcon (Card.class.getResource("/images/cards/2_of_clubs.png"));
			case 102: return new ImageIcon (Card.class.getResource("/images/cards/3_of_clubs.png"));
			case 103: return new ImageIcon (Card.class.getResource("/images/cards/4_of_clubs.png"));
			case 104: return new ImageIcon (Card.class.getResource("/images/cards/5_of_clubs.png"));
			case 105: return new ImageIcon (Card.class.getResource("/images/cards/6_of_clubs.png"));
			case 106: return new ImageIcon (Card.class.getResource("/images/cards/7_of_clubs.png"));
			case 107: return new ImageIcon (Card.class.getResource("/images/cards/8_of_clubs.png"));
			case 108: return new ImageIcon (Card.class.getResource("/images/cards/9_of_clubs.png"));
			case 109: return new ImageIcon (Card.class.getResource("/images/cards/10_of_clubs.png"));
			case 110: return new ImageIcon (Card.class.getResource("/images/cards/jack_of_clubs.png"));
			case 111: return new ImageIcon (Card.class.getResource("/images/cards/queen_of_clubs.png"));
			case 112: return new ImageIcon (Card.class.getResource("/images/cards/king_of_clubs.png"));
			case 113: return new ImageIcon (Card.class.getResource("/images/cards/ace_of_diamonds.png"));
			case 201: return new ImageIcon (Card.class.getResource("/images/cards/2_of_diamonds.png"));
			case 202: return new ImageIcon (Card.class.getResource("/images/cards/3_of_diamonds.png"));
			case 203: return new ImageIcon (Card.class.getResource("/images/cards/4_of_diamonds.png"));
			case 204: return new ImageIcon (Card.class.getResource("/images/cards/5_of_diamonds.png"));
			case 205: return new ImageIcon (Card.class.getResource("/images/cards/6_of_diamonds.png"));
			case 206: return new ImageIcon (Card.class.getResource("/images/cards/7_of_diamonds.png"));
			case 207: return new ImageIcon (Card.class.getResource("/images/cards/8_of_diamonds.png"));
			case 208: return new ImageIcon (Card.class.getResource("/images/cards/9_of_diamonds.png"));
			case 209: return new ImageIcon (Card.class.getResource("/images/cards/10_of_diamonds.png"));
			case 210: return new ImageIcon (Card.class.getResource("/images/cards/jack_of_diamonds.png"));
			case 211: return new ImageIcon (Card.class.getResource("/images/cards/queen_of_diamonds.png"));
			case 212: return new ImageIcon (Card.class.getResource("/images/cards/king_of_diamonds.png"));
			case 213: return new ImageIcon (Card.class.getResource("/images/cards/ace_of_diamonds.png"));
			case 301: return new ImageIcon (Card.class.getResource("/images/cards/2_of_hearts.png"));
			case 302: return new ImageIcon (Card.class.getResource("/images/cards/3_of_hearts.png"));
			case 303: return new ImageIcon (Card.class.getResource("/images/cards/4_of_hearts.png"));
			case 304: return new ImageIcon (Card.class.getResource("/images/cards/5_of_hearts.png"));
			case 305: return new ImageIcon (Card.class.getResource("/images/cards/6_of_hearts.png"));
			case 306: return new ImageIcon (Card.class.getResource("/images/cards/7_of_hearts.png"));
			case 307: return new ImageIcon (Card.class.getResource("/images/cards/8_of_hearts.png"));
			case 308: return new ImageIcon (Card.class.getResource("/images/cards/9_of_hearts.png"));
			case 309: return new ImageIcon (Card.class.getResource("/images/cards/10_of_hearts.png"));
			case 310: return new ImageIcon (Card.class.getResource("/images/cards/jack_of_hearts.png"));
			case 311: return new ImageIcon (Card.class.getResource("/images/cards/queen_of_hearts.png"));
			case 312: return new ImageIcon (Card.class.getResource("/images/cards/king_of_hearts.png"));
			case 313: return new ImageIcon (Card.class.getResource("/images/cards/ace_of_hearts.png"));
			case 401: return new ImageIcon (Card.class.getResource("/images/cards/2_of_spades.png"));
			case 402: return new ImageIcon (Card.class.getResource("/images/cards/3_of_spades.png"));
			case 403: return new ImageIcon (Card.class.getResource("/images/cards/4_of_spades.png"));
			case 404: return new ImageIcon (Card.class.getResource("/images/cards/5_of_spades.png"));
			case 405: return new ImageIcon (Card.class.getResource("/images/cards/6_of_spades.png"));
			case 406: return new ImageIcon (Card.class.getResource("/images/cards/7_of_spades.png"));
			case 407: return new ImageIcon (Card.class.getResource("/images/cards/8_of_spades.png"));
			case 408: return new ImageIcon (Card.class.getResource("/images/cards/9_of_spades.png"));
			case 409: return new ImageIcon (Card.class.getResource("/images/cards/10_of_spades.png"));
			case 410: return new ImageIcon (Card.class.getResource("/images/cards/jack_of_spades.png"));
			case 411: return new ImageIcon (Card.class.getResource("/images/cards/queen_of_spades.png"));
			case 412: return new ImageIcon (Card.class.getResource("/images/cards/king_of_spades.png"));
			case 413: return new ImageIcon (Card.class.getResource("/images/cards/ace_of_spades.png"));
			default:  return new ImageIcon (Card.class.getResource("/images/cards/ace_of_spades.png"));
		}
	}
}
