
public class Controller
{
	//private Login login;
	private GUI gui;
	private Dealer dealer;
	private Table table;

	
	public Controller ()
	{
		//login = new Login ("Login");
		gui = new GUI ("Poker");
		dealer = new Dealer ();
		table = new Table ();
	}
	
	public static void main(String[] args)
	{
		new Controller (); 
	}
	
	@SuppressWarnings("unchecked")
	public void setTcards ()
	{
		table.setCards(dealer.getCards(5));
	}
	

}
