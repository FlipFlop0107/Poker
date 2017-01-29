import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class GUI extends Frame 
{
	
	
	public GUI (String title)
	{
		super (title);
		addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent evt) { dispose(); }
		});
		int frameWidth = 600;
		int frameHeight = 600;
		setSize(frameWidth, frameHeight);
		setVisible(true);
	}    
}

