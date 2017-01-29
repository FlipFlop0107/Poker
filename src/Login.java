import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Login extends JFrame 
{	
	public Login (String title)
	{
		super (title);
		addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent evt) { dispose(); }
		});
		int frameWidth = 800;
		int frameHeight = 500;
		setSize(frameWidth, frameHeight);
		setVisible(true);
	}    
}
