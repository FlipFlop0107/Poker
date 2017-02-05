import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

@SuppressWarnings("serial")
public class Help extends JFrame
{
	private JPanel help;
	
	
	public Help (String name)
	{
		setResizable(false);
		setAlwaysOnTop(true);
		
		help = new JPanel ();
		
		switch (name)
		{
			case "continue":
			
			break;	
			case "new game":
				
			break;
			case "exit":
				
			break;
			default: 
			setBounds(684, 344, 312, 234);
			getContentPane().add(help);
			
		
		}
		
		
		
		setVisible(true);
	}
}
