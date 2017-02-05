import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUI extends JFrame
{
	private CardLayout cl;
	
	private JPanel contP;
	private JPanel intro;
	private JPanel mainMenu;
	private JPanel options;
	private JPanel game;
	
	private JLabel logo;
	private JLabel intro_text;
	private JLabel background;
	
	private List<Component> gui_elements;
	private JButton mm_continue;
	private JButton mm_new;
	private JButton mm_options;
	
	public GUI () throws InterruptedException   
	{
		setResizable(false);
		setBounds(360, 200, 960, 540);
		setTitle("Texas Hold'em  -  Poker");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/images/10000.png")));
		
		gui_elements = new List<Component> ();
		
		cl = new CardLayout();
		contP = new JPanel();
		contP.setLayout(cl);
		getContentPane().add(contP);
		
		
		intro = new JPanel();
		contP.add(intro, "intro");
		intro.setLayout(null);
		
		logo = new JLabel();
		logo.setIcon(new ImageIcon(GUI.class.getResource("/images/10000.png")));
		logo.setBounds(360, 50, 241, 241);
		intro.add(logo);
		
		intro_text = new JLabel();
		intro_text.setFont(new Font("Adobe Arabic", Font.BOLD, 36));
		intro_text.setBounds(205, 335, 550, 60);
		intro_text.setText("Texas Hold'em  -  Poker");
		intro.add(intro_text);
		
		
		setVisible(true);
		cl.show(contP, "intro");
		Thread.sleep(2000);
		
		
		mainMenu = new JPanel();
		contP.add(mainMenu, "main menu");
		mainMenu.setLayout(null);
		
		mm_continue = new JButton("Continue");
		mm_continue.setFont(new Font("Adobe Arabic", Font.BOLD, 23));
		mm_continue.setBounds(90, 70, 200, 40);
		mainMenu.add(mm_continue);
		gui_elements.append(mm_continue);
		
		mm_new = new JButton("Start New Game");
		mm_new.setFont(new Font("Adobe Arabic", Font.BOLD, 23));
		mm_new.setBounds(90, 140, 200, 40);
		mainMenu.add(mm_new);
		gui_elements.append(mm_new);
		
		mm_options = new JButton("Options");
		mm_options.setFont(new Font("Adobe Arabic", Font.BOLD, 23));
		mm_options.setBounds(90, 210, 200, 40);
		mainMenu.add(mm_options);
		gui_elements.append(mm_options);
		
		background = new JLabel ();
		background.setBounds(0, 0, 960, 540);
		background.setIcon(new ImageIcon(GUI.class.getResource("/images/table.jpg")));
		mainMenu.add(background);
		
		cl.show(contP, "main menu");
		
		
		options = new JPanel ();
		contP.add(options, "options");
		options.setLayout(null);
		
		
		
		options.add(background);
		
		
		game = new JPanel();
		contP.add(game, "game");
		game.setLayout(null);
		
		
		
		game.add(background);
	}
	
	
	public void setActionListeners (ActionListener ac)
	{
		gui_elements.toFirst ();
	    while (gui_elements.hasAccess ())
	    {
	        if(gui_elements.getContent () instanceof AbstractButton)
	        {
	            ((AbstractButton) gui_elements.getContent()).addActionListener(ac);
	        }
	        else if (gui_elements.getContent () instanceof JComboBox)
	        {
	            ((JComboBox) gui_elements.getContent()).addActionListener(ac);
	        } 
	        gui_elements.next();
	    }
	}
	
	public void setCL (String name)
	{
		cl.show(contP, name);
	}
}