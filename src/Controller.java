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
		
		gui.setActionListeners(this);
		gui.setTextFields();
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		new Controller ();
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
			if (gui.getSIofAmount() != 0 && gui.getSIofDifficulty() != 0)
			{
				new Table (gui.getSIofAmount()+1, gui.getSIofDifficulty());
				gui.setCL("game");
			}
			else new Help ("");
		}
	}
	
	@SuppressWarnings("unchecked")
	public void setCCard ()
	{
		table.setCCard(dealer.getCCards(5));
	}
}
