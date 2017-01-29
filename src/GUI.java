import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GUI extends JFrame 
{
	public GUI (String title)
	{
		super (title);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/images/10000.png")));
		setTitle("Texas Hold'em  -  Poker");
		addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent evt) { dispose(); }
		});
		setSize(960, 540);
		setLocation(350, 200);
		getContentPane().setLayout(new CardLayout(0, 0));
		setVisible(true);
	}    
}

