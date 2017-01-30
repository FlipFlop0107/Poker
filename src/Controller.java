
public class Controller
{
	private GUI gui;
	private Dealer dealer;
	private Table table;

	
	public Controller ()
	{
		gui = new GUI ("Poker");
		dealer = new Dealer ();
		table = new Table ();
	}
	
	public static void main(String[] args)
	{
		new Controller (); 
	}
	
	@SuppressWarnings("unchecked")
	public void setCCards ()
	{
		table.setCCards(dealer.getCards(5));
	}
}
