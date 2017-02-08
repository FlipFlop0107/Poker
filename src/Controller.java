import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Controller implements ActionListener
{
	private GUI gui;
	private Dealer dealer;
	private Table table;

	
	public Controller () throws InterruptedException
	{
		gui = new GUI ();
		dealer = new Dealer ();
		table = new Table ();
		
		gui.setActionListeners(this);
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		new Controller ();
	}
	
	
	public void actionPerformed (ActionEvent e)
	{
		if (e.getActionCommand().equals("Start New Game"))
		{
			gui.setCL("game");
		}
		
		else if (e.getActionCommand().equals("Continue"))
		{
			new Help ("");
		}
		
		else if (e.getActionCommand().equals("Options"))
		{
			gui.setCL("options");
		}
	}
	
	@SuppressWarnings("unchecked")
	public void setCCards ()
	{
		table.setCCards(dealer.getCards(5));
	}
}
