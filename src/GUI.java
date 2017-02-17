import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.AbstractButton;
import javax.swing.Icon;
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
	private JLabel lbl;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	
	private List<JLabel> card;
	private List<Component> gui_elements;
	private JButton mm_continue;
	private JButton mm_new;
	private JButton mm_options;
	private JButton startGame;
	private JComboBox botAmount;
	private JComboBox botDifficulty;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public GUI () throws InterruptedException   
	{
		setResizable(false);
		setBounds(360, 200, 960, 540);
		setTitle("Texas Hold'em  -  Poker");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/images/chips/10000.png")));
		
		card = new List<JLabel> ();
		gui_elements = new List<Component> ();
		mm_font = new Font ("Adobe Arabic", Font.BOLD, 23);
		table = new ImageIcon (GUI.class.getResource("/images/table.jpg"));
		chip1 = new ImageIcon (GUI.class.getResource("/images/chips/1.png"));
		chip5 = new ImageIcon (GUI.class.getResource("/images/chips/5.png"));
		chip10 = new ImageIcon (GUI.class.getResource("/images/chips/10.png"));
		chip25 = new ImageIcon (GUI.class.getResource("/images/chips/25.png"));
		chip50 = new ImageIcon (GUI.class.getResource("/images/chips/50.png"));
		chip100 = new ImageIcon (GUI.class.getResource("/images/chips/100.png"));
		chip500 = new ImageIcon (GUI.class.getResource("/images/chips/500.png"));
		chip1000 = new ImageIcon (GUI.class.getResource("/images/chips/1000.png"));
		chip5000 = new ImageIcon (GUI.class.getResource("/images/chips/5000.png"));
		chip10000 = new ImageIcon (GUI.class.getResource("/images/chips/10000.png"));
		
		cl = new CardLayout();
		contP = new JPanel();
		contP.setLayout(cl);
		getContentPane().add(contP);
		
		
		intro = new JPanel();
		contP.add(intro, "intro");
		intro.setLayout(null);
		
		logo = new JLabel();
		logo.setIcon(new ImageIcon(GUI.class.getResource("/images/chips/10000.png")));
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
		//mainMenu.add(background);
		
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
		textField.setBounds(332, 189, 200, 20);
		game.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(332, 310, 86, 20);
		game.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 255, 168, 20);
		game.add(textField_2);
		textField_2.setColumns(10);
		
		lbl = new JLabel ();
		lbl.setBounds(166, 29, 86, 127);
		game.add(lbl);
		card.append(lbl);
		
		lbl2 = new JLabel ();
		lbl2.setBounds(262, 29, 88, 127);
		game.add(lbl2);
		card.append(lbl2);
		
		lbl3 = new JLabel ();
		lbl3.setBounds(360, 29, 86, 127);
		game.add(lbl3);
		card.append(lbl3);
		
		lbl4 = new JLabel ();
		lbl4.setBounds(466, 29, 88, 127);
		game.add(lbl4);
		card.append(lbl4);
		
		lbl5 = new JLabel ();
		lbl5.setBounds(575, 29, 88, 127);
		game.add(lbl5);
		card.append(lbl5);
		
		lbl6 = new JLabel ();
		lbl6.setBounds(466, 310, 88, 127);
		game.add(lbl6);
		
		lbl7 = new JLabel ();
		lbl7.setBounds(575, 310, 88, 127);
		game.add(lbl7);
		
		JButton button = new JButton ("checkCards");
		button.setBounds(49, 339, 221, 72);
		game.add(button);
		gui_elements.append(button);
		
		JButton button2 = new JButton("Next");
		button2.setBounds(794, 218, 126, 57);
		game.add(button2);
		gui_elements.append(button2);
		
		game.add(background);
	}
	
	
	@SuppressWarnings("rawtypes")
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
	
	public void setTextFields (List<Card> cCards, Card[] pocket)
	{
		String a = "";
		cCards.toFirst();
		while (cCards.hasAccess())
		{
			a = a+",  "+cCards.getContent().getID();
			cCards.next();
		}
		textField.setText(a);
		textField_1.setText(""+pocket[0].getID()+"  ,"+pocket[1].getID());
		
		cCards.toFirst();
		card.toFirst();
		while (cCards.hasAccess() && card.hasAccess())
		{
			card.getContent().setIcon(cCards.getContent().getIcon(card.getContent().getWidth(), card.getContent().getHeight()));
			cCards.next();
			card.next();
		}
		lbl6.setIcon(pocket[0].getIcon(lbl6.getWidth(), lbl6.getHeight()));
		lbl7.setIcon(pocket[1].getIcon(lbl7.getWidth(), lbl7.getHeight()));
	}
	
	public void setTextFields2 (String a)
	{
		textField_2.setText(a);
	}
	
	public void setTextFields3 (String a, Card card)
	{
		switch (a)
		{
		case "turn":  lbl4.setIcon(card.getIcon(lbl4.getWidth(), lbl4.getHeight()));
					  textField.setText(textField.getText()+",  "+card.getID());
					  break;
		case "river": lbl5.setIcon(card.getIcon(lbl5.getWidth(), lbl5.getHeight()));
		              textField.setText(textField.getText()+",  "+card.getID());
		              break;
		}
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