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
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GUI extends JFrame
{
	private int playerAmount;
	private int difficulty;
	private CardLayout cl;
	private Font mm_font;
	private ImageIcon table;
	private ImageIcon chip1;
	private ImageIcon chip5;
	private ImageIcon chip10;
	private ImageIcon chip25;
	private ImageIcon chip50;
	private ImageIcon chip100;
	private ImageIcon chip500;
	private ImageIcon chip1000;
	private ImageIcon chip5000;
	private ImageIcon chip10000;
	
	private JPanel contP;
	private JPanel intro;
	private JPanel mainMenu;
	private JPanel options;
	private JPanel startOptions;
	private JPanel game;
	
	private JLabel logo;
	private JLabel intro_text;
	private JLabel background;
	
	private List<Component> gui_elements;
	private JButton mm_continue;
	private JButton mm_new;
	private JButton mm_options;
	private JButton startGame;
	private JComboBox botAmount;
	private JComboBox botDifficulty;
	private JTextField textField;
	private JTextField textField_1;
	
	public GUI () throws InterruptedException   
	{
		setResizable(false);
		setBounds(360, 200, 960, 540);
		setTitle("Texas Hold'em  -  Poker");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/images/10000.png")));
		
		gui_elements = new List<Component> ();
		mm_font = new Font ("Adobe Arabic", Font.BOLD, 23);
		table = new ImageIcon (GUI.class.getResource("/images/table.jpg"));
		chip1 = new ImageIcon (GUI.class.getResource("/images/1.png"));
		chip5 = new ImageIcon (GUI.class.getResource("/images/5.png"));
		chip10 = new ImageIcon (GUI.class.getResource("/images/10.png"));
		chip25 = new ImageIcon (GUI.class.getResource("/images/25.png"));
		chip50 = new ImageIcon (GUI.class.getResource("/images/50.png"));
		chip100 = new ImageIcon (GUI.class.getResource("/images/100.png"));
		chip500 = new ImageIcon (GUI.class.getResource("/images/500.png"));
		chip1000 = new ImageIcon (GUI.class.getResource("/images/1000.png"));
		chip5000 = new ImageIcon (GUI.class.getResource("/images/5000.png"));
		chip10000 = new ImageIcon (GUI.class.getResource("/images/10000.png"));
		
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
		mm_continue.setFont(mm_font);
		mm_continue.setBounds(90, 70, 200, 40);
		mainMenu.add(mm_continue);
		gui_elements.append(mm_continue);
		
		mm_new = new JButton("Start New Game");
		mm_new.setFont(mm_font);
		mm_new.setBounds(90, 140, 200, 40);
		mainMenu.add(mm_new);
		gui_elements.append(mm_new);
		
		mm_options = new JButton("Options");
		mm_options.setFont(mm_font);
		mm_options.setBounds(90, 210, 200, 40);
		mainMenu.add(mm_options);
		gui_elements.append(mm_options);
		
		background = new JLabel ();
		background.setBounds(0, 0, 960, 540);
		background.setIcon(table);
		mainMenu.add(background);
		
		cl.show(contP, "main menu");
		
		
		options = new JPanel ();
		contP.add(options, "options");
		options.setLayout(null);
		
		
		startOptions = new JPanel ();
		contP.add(startOptions, "start options");
		startOptions.setLayout(null);
		
		String[] amount = {"Bot Amount?", "2", "3", "4", "5", "6"};
		botAmount = new JComboBox(amount);
		botAmount.setBounds(191, 188, 86, 20);
		startOptions.add(botAmount);
		gui_elements.append(botAmount);
		
		String[] difficulty = {"Difficulty?", "Easy", "Medium", "Hard"};
		botDifficulty = new JComboBox(difficulty);
		botDifficulty.setBounds(377, 188, 113, 20);
		startOptions.add(botDifficulty);
		gui_elements.append(botDifficulty);
		
		startGame = new JButton("Start Game");
		startGame.setBounds(191, 316, 516, 70);
		startOptions.add(startGame);
		gui_elements.append(startGame);
		
		
		game = new JPanel();
		contP.add(game, "game");
		game.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(332, 189, 86, 20);
		game.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(332, 310, 86, 20);
		game.add(textField_1);
		textField_1.setColumns(10);
		
		
		
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
	
	public int getDifficulty ()
	{
		return difficulty;
	}
	
	public void setDificulty (int difficulty)
	{
		this.difficulty = difficulty;
	}
	
	public int getPlayerAmount ()
	{
		return playerAmount;
	}
	
	public void setPlayerAmount (int amount)
	{
		playerAmount = amount;
	}
	
	public void setTextFields ()
	{
		/*String a = "";
		List<Card> temp = Controller.table.getCCards();
		temp.toFirst();
		for (int i = 0; i < 5; i++)
		{
			a = a + "  ,"+temp.getContent().getID();
			temp.next();
			
		}
		textField.setText(a);*/
	}
	
	public int getSIofAmount ()
	{
		return botAmount.getSelectedIndex();
	}
	
	public int getSIofDifficulty ()
	{
		return botDifficulty.getSelectedIndex();
	}
}