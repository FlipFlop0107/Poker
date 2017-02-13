import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

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
	
	public ImageIcon getIcon (int w, int h)
	{
		switch (getID())
		{
			case 101: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/2_of_clubs.png")).getImage(), w, h));
			case 102: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/3_of_clubs.png")).getImage(), w, h));
			case 103: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/4_of_clubs.png")).getImage(), w, h));
			case 104: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/5_of_clubs.png")).getImage(), w, h));
			case 105: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/6_of_clubs.png")).getImage(), w, h));
			case 106: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/7_of_clubs.png")).getImage(), w, h));
			case 107: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/8_of_clubs.png")).getImage(), w, h));
			case 108: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/9_of_clubs.png")).getImage(), w, h));
			case 109: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/10_of_clubs.png")).getImage(), w, h));
			case 110: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/jack_of_clubs.png")).getImage(), w, h));
			case 111: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/queen_of_clubs.png")).getImage(), w, h));
			case 112: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/king_of_clubs.png")).getImage(), w, h));
			case 113: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/ace_of_diamonds.png")).getImage(), w, h));
			case 201: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/2_of_diamonds.png")).getImage(), w, h));
			case 202: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/3_of_diamonds.png")).getImage(), w, h));
			case 203: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/4_of_diamonds.png")).getImage(), w, h));
			case 204: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/5_of_diamonds.png")).getImage(), w, h));
			case 205: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/6_of_diamonds.png")).getImage(), w, h));
			case 206: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/7_of_diamonds.png")).getImage(), w, h));
			case 207: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/8_of_diamonds.png")).getImage(), w, h));
			case 208: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/9_of_diamonds.png")).getImage(), w, h));
			case 209: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/10_of_diamonds.png")).getImage(), w, h));
			case 210: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/jack_of_diamonds.png")).getImage(), w, h));
			case 211: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/queen_of_diamonds.png")).getImage(), w, h));
			case 212: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/king_of_diamonds.png")).getImage(), w, h));
			case 213: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/ace_of_diamonds.png")).getImage(), w, h));
			case 301: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/2_of_hearts.png")).getImage(), w, h));
			case 302: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/3_of_hearts.png")).getImage(), w, h));
			case 303: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/4_of_hearts.png")).getImage(), w, h));
			case 304: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/5_of_hearts.png")).getImage(), w, h));
			case 305: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/6_of_hearts.png")).getImage(), w, h));
			case 306: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/7_of_hearts.png")).getImage(), w, h));
			case 307: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/8_of_hearts.png")).getImage(), w, h));
			case 308: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/9_of_hearts.png")).getImage(), w, h));
			case 309: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/10_of_hearts.png")).getImage(), w, h));
			case 310: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/jack_of_hearts.png")).getImage(), w, h));
			case 311: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/queen_of_hearts.png")).getImage(), w, h));
			case 312: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/king_of_hearts.png")).getImage(), w, h));
			case 313: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/ace_of_hearts.png")).getImage(), w, h));
			case 401: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/2_of_spades.png")).getImage(), w, h));
			case 402: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/3_of_spades.png")).getImage(), w, h));
			case 403: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/4_of_spades.png")).getImage(), w, h));
			case 404: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/5_of_spades.png")).getImage(), w, h));
			case 405: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/6_of_spades.png")).getImage(), w, h));
			case 406: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/7_of_spades.png")).getImage(), w, h));
			case 407: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/8_of_spades.png")).getImage(), w, h));
			case 408: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/9_of_spades.png")).getImage(), w, h));
			case 409: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/10_of_spades.png")).getImage(), w, h));
			case 410: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/jack_of_spades.png")).getImage(), w, h));
			case 411: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/queen_of_spades.png")).getImage(), w, h));
			case 412: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/king_of_spades.png")).getImage(), w, h));
			case 413: return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/ace_of_spades.png")).getImage(), w, h));
			default:  return new ImageIcon (scaledImage(new ImageIcon (Card.class.getResource("/images/cards/ace_of_spades.png")).getImage(), w, h));
		}
	}
	
	private Image scaledImage (Image img, int w, int h)
	{
		BufferedImage resizedImage = new BufferedImage (w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = resizedImage.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(img, 0, 0, w, h, null);
		g2.dispose();
		return resizedImage;
	}
}
