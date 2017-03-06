import java.util.Random;

/**
 * Die Klassse Bot simuliert das Spielverhalten eines Spielers. Er reagiert auf logisch auf den Spielablauf. Er extendet von der Klasse {@link Player}
 * 
 * @author Philipp Dobieszewski 
 *
 */

public class Bot extends Player
{
	private int lastBet;
	private int difficulty;
	private String name;
	
	public Bot (int difficulty)
	{	
		this.difficulty = difficulty;
		System.out.println(getDifficulty());
		name = "-  N. N.  -";
	}
	
	
	/**
	 * Gibt den zur Schwierigkeits-ID zugehörigen Schwierigkeitsnamen zurück.
	 * 
	 * @return Name der Schwierigkeit
	 */
	
	public String getDifficulty ()
	{
		switch (difficulty)
		{
		case 1: return "easy";
		case 2: return "medium";
		case 3: return "hard";
		default: return "invalid difficulty";
		}
	}
	
	/*
	 * Reagiert auf eine Kartenfolge je nach Schwierigkeitsstufe.
	 */
	
	public void botBet (List<Card> cCards)
	{
		if (isInGame())
		{
			Random rndGen = new Random();
			int rnd;
			double balance = getBalance();
			switch (difficulty)
			{
			case 1: if (checkCards(cCards).contains("royal")) lastBet = bet((int) balance);
					else if (checkCards(cCards).contains("straightFlush")) lastBet = bet((int) (balance*0.9));
					else if (checkCards(cCards).contains("four")) lastBet = bet((int) (balance*0.8));
					else if (checkCards(cCards).contains("full")) lastBet = bet((int) (balance*0.7));
					else if (checkCards(cCards).contains("flush")) lastBet = bet((int) (balance*0.6));
					else if (checkCards(cCards).contains("straight")) lastBet = bet((int) (balance*0.5));
					else if (checkCards(cCards).contains("three")) lastBet = bet((int) (balance*0.4));
					else if (checkCards(cCards).contains("two")) lastBet = bet((int) (balance*0.3));
					else if (checkCards(cCards).contains("one")) lastBet = bet((int) (balance*0.2));
					else fold(); lastBet = bet(20);
			/*case 2: if (checkCards(cCards).contains("royal")) bet((int) balance);
					else if (checkCards(cCards).contains("straightFlush"))
					{
						rnd = rndGen.nextInt(100);
						if (rnd > 70) bet((int) balance);
						else bet((int) (balance/2));
					}
					else if (checkCards(cCards).contains("four"))
					{
						rnd = rndGen.nextInt(100);
						if (rnd > bet(balance));
						else bet(balance/3);
					}
					else if (checkCards(cCards).contains("full"))
					{
						rnd = rndGen.nextInt(100);
						if (rnd > 65) bet(balance);
						else bet(balance/5);
					}
					else if (checkCards(cCards).contains("flush"))
					{
						rnd = rndGen.nextInt(100);
						if (rnd > 65) bet(balance);
						else bet(balance/5);
					}
					else if (checkCards(cCards).contains("straight"))
					{
						rnd = rndGen.nextInt(100);
						if (rnd > 65) bet(balance);
						else bet(balance/5);
					}
					else if (checkCards(cCards).contains("three"))
					{
						rnd = rndGen.nextInt(100);
						if (rnd > 65) bet(balance);
						else bet(balance/5);
					}
					else if (checkCards(cCards).contains("two"))
					{
						rnd = rndGen.nextInt(100);
						if (rnd > 65) bet(balance);
						else bet(balance/5);
					}
					else if (checkCards(cCards).contains("one"))
					{
						rnd = rndGen.nextInt(100);
						if (rnd > 65) bet(balance);
						else bet(balance/5);
					}
					else if (checkCards(cCards).contains("highest"))
					{
						rnd = rndGen.nextInt();
						if (rnd > 65) bet(getBalance()/10);
						else fold();
					}
				    break;
			case 3: if (checkCards(cCards).contains("royal")) bet(balance);
					else if (checkCards(cCards).contains("straightFlush"))
					{
						rnd = rndGen.nextInt(100);
						if (rnd > 70) bet(balance);
						else bet(balance/2);
					}
					else if (checkCards(cCards).contains("four"))
					{
						rnd = rndGen.nextInt(100);
						if (rnd > bet(balance));
						else bet(balance/3);
					}
					else if (checkCards(cCards).contains("full"))
					{
						rnd = rndGen.nextInt(100);
						if (rnd > 65) bet(balance);
						else bet(balance/5);
					}
					else if (checkCards(cCards).contains("flush"))
					{
						rnd = rndGen.nextInt(100);
						if (rnd > 65) bet(balance);
						else bet(balance/5);
					}
					else if (checkCards(cCards).contains("straight"))
					{
						rnd = rndGen.nextInt(100);
						if (rnd > 65) bet(balance);
						else bet(balance/5);
					}
					else if (checkCards(cCards).contains("three"))
					{
						rnd = rndGen.nextInt(100);
						if (rnd > 65) bet(balance);
						else bet(balance/5);
					}
					else if (checkCards(cCards).contains("two"))
					{
						rnd = rndGen.nextInt(100);
						if (rnd > 65) bet(balance);
						else bet(balance/5);
					}
					else if (checkCards(cCards).contains("one"))
					{
						rnd = rndGen.nextInt(100);
						if (rnd > 65) bet(balance);
						else bet(balance/5);
					}
					else if (checkCards(cCards).contains("highest"))
					{
						rnd = rndGen.nextInt();
						if (rnd > 65) bet(getBalance()/10);
						else fold();
					}
					break;*/
			default: lastBet = bet (10);
			}
		}
	}
	
	/**
	 * Gibt den letzten Einsatz zurück.
	 * 
	 * @return letzter Einsatz
	 */
	
	public int getLastBet ()
	{
		return lastBet;
	}
	
	/**
	 * Gibt den Bot-Namen zurück.
	 * 
	 * @return Bot-Name
	 */
	
	public String getName ()
	{
		return name;
	}
	
	/**
	 * Weist den Bot einen von 23 Namen zu. 
	 * 
	 * @param rnd Zufallszahl für die Namensauswahl
	 */
	
	public void setName (int rnd)
	{
		switch (rnd)
		{
		case 0: name = "Peter"; break;
		case 1: name = "Jürgen"; break;
		case 2: name = "Udo"; break;
		case 3: name = "Gertrude"; break;
		case 4: name = "Britta"; break;
		case 5: name = "Tine"; break;
		case 6: name = "Brigitte"; break;
		case 7: name = "Ursula"; break;
		case 8: name = "Johannes"; break;
		case 9: name = "Klaus"; break;
		case 10: name = "Herbert"; break;
		case 11: name = "Frank"; break;
		case 12: name = "Horst"; break;
		case 13: name = "Randolf"; break;
		case 14: name = "Siegfried"; break;
		case 15: name = "Hildegard"; break;
		case 16: name = "Mathilda"; break;
		case 17: name = "Rosalinda"; break;
		case 18: name = "Sandra"; break;
		case 19: name = "Maria"; break;
		case 20: name = "Amadeus"; break;
		case 21: name = "Günther"; break;
		case 22: name = "Sabrina"; break;
		}
	}
}
