import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Login extends Frame 
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
