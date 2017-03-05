import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Help extends JFrame
{
	List <JButton> buttons;
	JPanel contP;
	
	
	public Help (String name)
	{
		setResizable(false);
		setAlwaysOnTop(true);
		setBounds(700, 350, 312, 234);
		getContentPane().setLayout(null);
		contP = new JPanel ();
		contP.setBounds(0, 0, 306, 205);
		contP.setLayout(null);
		getContentPane().add(contP);
		buttons = new List <JButton> ();
		
		switch (name)
		{
			case "continue": JLabel lbl_continue = new JLabel ();
							 lbl_continue.setText("*Continue* currently not available.");
							 lbl_continue.setBounds(20, 80, 250, 30);
							 contP.add(lbl_continue);
							 break;	
			case "options": JLabel lbl_options = new JLabel ();
							lbl_options.setText("*Options* currently not available.");
							lbl_options.setBounds(20, 80, 250, 30);
							contP.add(lbl_options);
							break;
			case "start game": JLabel lbl_startGame = new JLabel ();
							   lbl_startGame.setText("<html><body>Please select the AMOUNT OF BOTS<br>and their DIFFICULTY</body></html>");
							   lbl_startGame.setBounds(20, 80, 250, 30);
							   contP.add(lbl_startGame);
							   break;
			case "bet": JLabel lbl_bet = new JLabel ();
						lbl_bet.setText("Please select your bet");
						lbl_bet.setBounds(20, 80, 250, 30);
						contP.add(lbl_bet);
						break;
		}
		
		
		setVisible(true);
	}
}
