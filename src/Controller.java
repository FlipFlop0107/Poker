import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Controller extends MouseAdapter implements ActionListener/*, MouseListener*/
{
	private GUI gui;
	private Table table;
	private int a = 0;
	private int playerBet = 0;
	
	
	public Controller ()
	{
		gui = new GUI ();
		gui.setActionListeners(this);
		gui.setMouseListeners(this);
	}
	
	public static void main(String[] args)
	{
		new Controller ();
	}
	
	
	public void mouseClicked (MouseEvent e)
	{
		switch (e.getComponent().getName())
		{
		case "1": 	      if (e.getButton() == e.BUTTON3 && playerBet >= 1) 
						  {
							  playerBet--;
							  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
						  }
			              else if (e.getButton() == e.BUTTON1 && table.getPlayerBalance() >= 1)
			              {
			            	  playerBet++; 
			            	  gui.updateBalanceStats(table.getPlayerBalance() - playerBet, playerBet);
			              } 
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
						  break;
		}
		
	}
	
	
	public void actionPerformed (ActionEvent e)
	{
		if (e.getActionCommand().equals("Start New Game"))
		{
			gui.setCL("start options");
		}
		
		else if (e.getActionCommand().equals("Continue"))
		{
			new Help ("");
		}
		
		else if (e.getActionCommand().equals("Options"))
		{
			gui.setCL("options");
		}
		else if (e.getActionCommand().equals("Start Game"))
		{
			boolean done = false;
			while (!done)
			{
				try
				{
					if (gui.getSIofAmount() != 0 && gui.getSIofDifficulty() != 0)
					{
						table = new Table (gui.getSIofAmount()+1, gui.getSIofDifficulty());
						table.preflop();
						gui.setCL("game");
						gui.setTextFields(table.getCCards(), table.getPPocket());
						gui.visualiseBotStats(gui.getSIofAmount()+1, table.getBots());
						done = true;
					}
					else new Help ("");
				}
				catch (NullPointerException ex)
				{
					System.out.println("Restart");
				}
			}
		}
		else if (e.getActionCommand().equals("checkCards"))
		{
			gui.setTextFields2(table.checkPCards());
		}
		else if (e.getActionCommand().equals("Next"))
		{
			switch (a)
			{
			case 0: table.setCCard("flop");
					a++;
					gui.setTextFields(table.getCCards(), table.getPPocket());
					break;
			case 1: table.setCCard("turn");
					a++;
					List<Card> temp2 = table.getCCards();
					temp2.toLast();
					gui.nextRound("turn", temp2.getContent());
					break;
			case 2: table.setCCard("river");
					a++;
					List<Card> temp = table.getCCards();
					temp.toLast();
					gui.nextRound("river", temp.getContent());
					break;
			default: new Help ("");
			}
		}
		else if (e.getActionCommand().equals("Reset"))
		{
			table = null;
			gui.resetGame();
			gui.setCL("main menu");
			a = 0;
			playerBet = 0;
		}
		else if (e.getActionCommand().equals("Bet"))
		{
			table.playerBet(playerBet);
			playerBet = 0;
		}
	}
}
