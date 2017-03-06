import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Die Klasse reagiert auf Nutzereingaben und setzt diese um. Sie extendet vom {@link MouseAdapter} und implementeirt den {@link ActionListener}.
 * 
 * @author Philipp Dobieszewski
 *
 */

public class Controller extends MouseAdapter implements ActionListener/*, MouseListener*/
{
	private GUI gui;
	private Table table;
	private int a = 0;
	private int playerBet = 0;
	
	
	/**
	 * Konstruktor instanziiert die GUI und über gibt die Action- und MouseListener.
	 */
	public Controller ()
	{
		gui = new GUI ();
		gui.setActionListeners(this);
		gui.setMouseListeners(this);
	}
	
	/**
	 * Instanziiert den {@link Controller}.
	 * 
	 * @param args Kommandozeilenparameter
	 */
	public static void main(String[] args)
	{
		new Controller ();
	}
	
	/**
	 * Führt Aktionen bei einem Mausklick aus.
	 */
	
	@SuppressWarnings("static-access")
	public void mouseClicked (MouseEvent e)
	{
		switch (e.getComponent().getName())
		{
		case "1": 	      if (e.getButton() == e.BUTTON3 && playerBet >= 1) 
						  {
							  playerBet--;
							  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
						  }
			              else if (e.getButton() == e.BUTTON1 && table.getPlayerBalance() - playerBet >= 1)
			              {
			            	  playerBet++; 
			            	  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
			              } 
						  gui.updateChips(table.getPlayerBalance());
						  break;
		case "5": 	 	  if (e.getButton() == e.BUTTON3) 
						  {
							  if (playerBet >= 5)
							  {
								  playerBet = playerBet - 5;
							  	  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
							  else 
							  {
								  playerBet = 0;
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
						  }
	        			  else if (e.getButton() == e.BUTTON1 && table.getPlayerBalance() >= 5)
				          {
	        				  if (table.getPlayerBalance() - playerBet < 5)
	        				  {
	        					  playerBet = table.getPlayerBalance();
	        					  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
	        				  }
	        				  else
	        				  {
	        					  playerBet = playerBet + 5; 
		        				  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);  
	        				  }
				          } 
				          gui.updateChips(table.getPlayerBalance());
						  break;
		case "10": 	 	  if (e.getButton() == e.BUTTON3) 
						  {
							  if (playerBet >= 10)
							  {
								  playerBet = playerBet - 10;
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
							  else 
							  {
								  playerBet = 0;
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
						  }
						  else if (e.getButton() == e.BUTTON1 && table.getPlayerBalance() >= 10)
				          {
							  if (table.getPlayerBalance() - playerBet < 10)
							  {
								  playerBet = table.getPlayerBalance();
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
							  else
							  {
								  playerBet = playerBet + 10; 
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
				          } 
				          gui.updateChips(table.getPlayerBalance());
						  break;
	    case "25": 	 	  if (e.getButton() == e.BUTTON3) 
						  {
							  if (playerBet >= 25)
							  {
								  playerBet = playerBet - 25;
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
							  else 
							  {
								  playerBet = 0;
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
						  }
						  else if (e.getButton() == e.BUTTON1 && table.getPlayerBalance() >= 25)
				          {
							  if (table.getPlayerBalance() - playerBet < 25)
							  {
								  playerBet = table.getPlayerBalance();
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
							  else
							  {
								  playerBet = playerBet + 25; 
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
				          } 
				          gui.updateChips(table.getPlayerBalance());
						  break;
		case "50": 	 	  if (e.getButton() == e.BUTTON3) 
						  {
							  if (playerBet >= 50)
							  {
								  playerBet = playerBet - 50;
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
							  else 
							  {
								  playerBet = 0;
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
						  }
						  else if (e.getButton() == e.BUTTON1 && table.getPlayerBalance() >= 50)
				          {
							  if (table.getPlayerBalance() - playerBet < 50)
							  {
								  playerBet = table.getPlayerBalance();
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
							  else
							  {
								  playerBet = playerBet + 50; 
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
				          } 
				          gui.updateChips(table.getPlayerBalance());
						  break;
	  case "100": 	 	  if (e.getButton() == e.BUTTON3) 
						  {
							  if (playerBet >= 100)
							  {
								  playerBet = playerBet - 100;
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
							  else 
							  {
								  playerBet = 0;
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
						  }
						  else if (e.getButton() == e.BUTTON1 && table.getPlayerBalance() >= 100)
				          {
							  if (table.getPlayerBalance() - playerBet < 100)
							  {
								  playerBet = table.getPlayerBalance();
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
							  else
							  {
								  playerBet = playerBet + 100; 
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
				          } 
				          gui.updateChips(table.getPlayerBalance());
						  break;
	   case "500": 	 	  if (e.getButton() == e.BUTTON3) 
						  {
							  if (playerBet >= 500)
							  {
								  playerBet = playerBet - 500;
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
							  else 
							  {
								  playerBet = 0;
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
						  }
						  else if (e.getButton() == e.BUTTON1 && table.getPlayerBalance() >= 500)
				          {
							  if (table.getPlayerBalance() - playerBet < 500)
							  {
								  playerBet = table.getPlayerBalance();
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
							  else
							  {
								  playerBet = playerBet + 500; 
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
				          } 
				          gui.updateChips(table.getPlayerBalance());
						  break;
	  case "1000": 	 	  if (e.getButton() == e.BUTTON3) 
						  {
							  if (playerBet >= 1000)
							  {
								  playerBet = playerBet - 1000;
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
							  else 
							  {
								  playerBet = 0;
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
						  }
						  else if (e.getButton() == e.BUTTON1 && table.getPlayerBalance() >= 1000)
				          {
							  if (table.getPlayerBalance() - playerBet < 1000)
							  {
								  playerBet = table.getPlayerBalance();
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
							  else
							  {
								  playerBet = playerBet + 1000; 
								  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
							  }
				          } 
				          gui.updateChips(table.getPlayerBalance());
						  break;
		}	
	}
	
	/**
	 * Führt Aktionen bei einem Button-{@link ActionEvent} aus.
	 */
	
	public void actionPerformed (ActionEvent e)
	{
		if (e.getActionCommand().equals("Start New Game"))
		{
			gui.setCL("start options");
		}
		
		else if (e.getActionCommand().equals("Continue"))
		{
			new Help ("continue");
		}
		
		else if (e.getActionCommand().equals("Options"))
		{
			new Help ("options");
		}
		else if (e.getActionCommand().equals("Start Game"))
		{
			if (gui.getSIofAmount() != 0 && gui.getSIofDifficulty() != 0)
			{
				table = new Table (gui.getSIofAmount()+1, gui.getSIofDifficulty());
				//table.setRndBlinds();
				gui.setCL("game");
				gui.visualiseBotStats(gui.getSIofAmount()+1, table.getBots());
				gui.disableChips();
						
			}
			else new Help ("start game");
			gui.updateChips(table.getPlayerBalance());
		}
		else if (e.getActionCommand().equals("Reset"))
		{
			table = null;
			gui.resetGame();
			gui.setCL("main menu");
			gui.showStart(true);
			a = 0;
			playerBet = 0;
		}
		else if (e.getActionCommand().equals("confirmBet"))
		{
			if (playerBet == 0) new Help ("bet");
			else
			{
				table.botBet();
				table.playerBet(playerBet);
				playerBet = 0;
				gui.disableChips();
				gui.countDown();
				gui.updateBotStats(gui.getSIofAmount()+1, table.getBots());
				switch (a)
				{
				case 0: table.setCCard("flop");
						a++;
						gui.setFlopIcons(table.getCCards());
						gui.enableChips();
						break;
				case 1: table.setCCard("turn");
						a++;
						List<Card> turn = table.getCCards();
						turn.toLast();
						gui.setTurnOrRiverIcon("turn", turn.getContent());
						gui.enableChips();
						break;
				case 2: table.setCCard("river");
						a++;
						List<Card> river = table.getCCards();
						river.toLast();
						gui.setTurnOrRiverIcon("river", river.getContent());
						gui.enableChips();
						break;
				default: new Help ("");
				}
			}
		}
		else if (e.getActionCommand().equals("nextRound") && a > 2)
		{
			a = 0;
			table.newDeck();
		}
		else if (e.getActionCommand().equals("Start")) 
		{
			table.preflop();
			gui.showStart(false);
			gui.setPocketIcons(table.getPPocket());
			gui.enableChips();
		}
	}
}
