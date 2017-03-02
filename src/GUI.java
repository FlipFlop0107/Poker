import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;

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
	
	private JLabel cCard1;
	private JLabel cCard2;
	private JLabel cCard3;
	private JLabel cCard4;
	private JLabel cCard5;
	private JLabel pocket1;
	private JLabel pocket2;
	
	private JLabel bet1;
	private JLabel bet5;
	private JLabel bet10;
	private JLabel bet25;
	private JLabel bet50;
	private JLabel bet100;
	private JLabel bet500;
	private JLabel bet1000;
	private JLabel bet5000;
	private JLabel bet10000;
	
	private List <JLabel> card;
	private List <Component> gui_elements;
	private List <JLabel> chips;
	
	private JButton mm_continue;
	private JButton mm_new;
	private JButton mm_options;
	private JButton startGame;
	
	private JComboBox botAmount;
	private JComboBox botDifficulty;
	
	private JTextField txt_playerBalance;
	private JTextField txt_playerBet;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public GUI ()
	{
		setResizable(false);
		setBounds(420, 180, 1080, 720);
		setTitle("Texas Hold'em  -  Poker");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/images/chips/10000.png")));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		card = new List <JLabel> ();
		gui_elements = new List <Component> ();
		chips = new List <JLabel> ();
		
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
		try 
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException ie)
		{
			
		}
		
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
		
		txt_playerBalance = new JTextField ();
		txt_playerBalance.setBounds(434, 479, 86, 20);
		game.add(txt_playerBalance);
		txt_playerBalance.setColumns(10);
		
		txt_playerBet = new JTextField ();
		txt_playerBet.setBounds(434, 509, 86, 20);
		game.add(txt_playerBet);
		txt_playerBet.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(360, 248, 200, 20);
		game.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(434, 448, 86, 20);
		game.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(152, 407, 100, 20);
		game.add(textField_2);
		textField_2.setColumns(10);
		
		cCard1 = new JLabel ();
		cCard1.setBounds(166, 108, 86, 127);
		game.add(cCard1);
		card.append(cCard1);
		
		cCard2 = new JLabel ();
		cCard2.setBounds(262, 108, 88, 127);
		game.add(cCard2);
		card.append(cCard2);
		
		cCard3 = new JLabel ();
		cCard3.setBounds(360, 110, 86, 127);
		game.add(cCard3);
		card.append(cCard3);
		
		cCard4 = new JLabel ();
		cCard4.setBounds(472, 110, 88, 127);
		game.add(cCard4);
		card.append(cCard4);
		
		cCard5 = new JLabel ();
		cCard5.setBounds(578, 108, 88, 127);
		game.add(cCard5);
		card.append(cCard5);
		
		pocket1 = new JLabel ();
		pocket1.setBounds(358, 310, 88, 127);
		game.add(pocket1);
		
		pocket2 = new JLabel ();
		pocket2.setBounds(472, 310, 88, 127);
		game.add(pocket2);
		
		bet1 = new JLabel ();
		bet1.setBounds(50, 551, 70, 70);
		bet1.setIcon(new ImageIcon (scaledImage(chip1.getImage(), bet1.getWidth(), bet1.getHeight())));
		bet1.setName("1");
		game.add(bet1);
		chips.append(bet1);
		
		bet5 = new JLabel ();
		bet5.setBounds(150, 551, 70, 70);
		bet5.setIcon(new ImageIcon (scaledImage(chip5.getImage(), bet5.getWidth(), bet5.getHeight())));
		bet5.setName("5");
		game.add(bet5);
		chips.append(bet5);
		
		bet10 = new JLabel ();
		bet10.setBounds(250, 551, 70, 70);
		bet10.setIcon(new ImageIcon (scaledImage(chip10.getImage(), bet10.getWidth(), bet10.getHeight())));
		bet10.setName("10");
		game.add(bet10);
		chips.append(bet10);
		
		/*bet25 = new JLabel ();
		bet25.setBounds(350, 551, 70, 70);
		bet25.setIcon(new ImageIcon (scaledImage(chip25.getImage(), bet25.getWidth(), bet25.getHeight())));
		bet25.setName("25");
		game.add(bet25);
		chips.append(bet25);
		
		bet50 = new JLabel ();
		bet50.setBounds(450, 551, 70, 70);
		bet50.setIcon(new ImageIcon (scaledImage(chip50.getImage(), bet50.getWidth(), bet50.getHeight())));
		bet50.setName("50");
		game.add(bet50);
		chips.append(bet50);
		
		bet100 = new JLabel ();
		bet100.setBounds(550, 551, 70, 70);
		bet100.setIcon(new ImageIcon (scaledImage(chip100.getImage(), bet100.getWidth(), bet100.getHeight())));
		bet100.setName("100");
		game.add(bet100);
		chips.append(bet100);
		
		bet500 = new JLabel ();
		bet500.setBounds(650, 551, 70, 70);
		bet500.setIcon(new ImageIcon (scaledImage(chip500.getImage(), bet500.getWidth(), bet500.getHeight())));
		bet500.setName("500");
		game.add(bet500);
		chips.append(bet500);
		
		bet1000 = new JLabel ();
		bet1000.setBounds(750, 551, 70, 70);
		bet1000.setIcon(new ImageIcon (scaledImage(chip1000.getImage(), bet1000.getWidth(), bet1000.getHeight())));
		bet1000.setName("1000");
		game.add(bet1000);
		chips.append(bet1000);
		
		bet5000 = new JLabel ();
		bet5000.setBounds(850, 551, 70, 70);
		bet5000.setIcon(new ImageIcon (scaledImage(chip5000.getImage(), bet5000.getWidth(), bet5000.getHeight())));
		bet5000.setName("5000");
		game.add(bet5000);
		chips.append(bet5000);
		
		bet10000 = new JLabel ();
		bet10000.setBounds(950, 551, 70, 70);
		bet10000.setIcon(new ImageIcon (scaledImage(chip10000.getImage(), bet10000.getWidth(), bet10000.getHeight())));
		bet10000.setName("10000");
		game.add(bet10000);
		chips.append(bet10000);*/
		
		
		JButton button = new JButton ("checkCards");
		button.setBounds(23, 397, 111, 40);
		game.add(button);
		gui_elements.append(button);
		
		JButton button2 = new JButton("Next");
		button2.setBounds(804, 421, 126, 57);
		game.add(button2);
		gui_elements.append(button2);
		
		JButton button3 = new JButton("Reset");
		button3.setBounds(804, 350, 126, 34);
		game.add(button3);
		gui_elements.append(button3);
		
		game.add(background);
	}
	
	
	@SuppressWarnings("rawtypes")
	public void setActionListeners (ActionListener ac)
	{
		gui_elements.toFirst ();
	    while (gui_elements.hasAccess ())
	    {
	        if (gui_elements.getContent () instanceof AbstractButton)
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
	
	public void setMouseListeners (MouseAdapter l)
	{
		chips.toFirst ();
		while (chips.hasAccess ())
		{
			chips.getContent ().addMouseListener(l);
			chips.next();
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
		pocket1.setIcon(pocket[0].getIcon(pocket1.getWidth(), pocket2.getHeight()));
		pocket2.setIcon(pocket[1].getIcon(pocket2.getWidth(), pocket2.getHeight()));
	}
	
	public void setTextFields2 (String a)
	{
		textField_2.setText(a);
	}
	
	public void nextRound (String a, Card card)
	{
		switch (a)
		{
		case "turn":  cCard4.setIcon(card.getIcon(cCard4.getWidth(), cCard4.getHeight()));
					  textField.setText(textField.getText()+",  "+card.getID());
					  break;
		case "river": cCard5.setIcon(card.getIcon(cCard5.getWidth(), cCard5.getHeight()));
		              textField.setText(textField.getText()+",  "+card.getID());
		              break;
		}
	}
	
	public void updateUI (int balance, int bet)
	{
		/*if (balance < 10000) bet10000.setVisible(false);
		else bet10000.setVisible(true);
		
		if (balance < 5000) bet5000.setVisible(false);
		else bet5000.setVisible(true);
		
		if (balance < 1000) bet1000.setVisible(false);
		else bet1000.setVisible(true);
		
		if (balance < 500) bet500.setVisible(false);
		else bet500.setVisible(true);
		
		if (balance < 100) bet100.setVisible(false);
		else bet100.setVisible(true);
		
		if (balance < 50) bet50.setVisible(false);
		else bet50.setVisible(true);
		
		if (balance < 25) bet25.setVisible(false);
		else bet25.setVisible(true);
		
		if (balance < 10) bet10.setVisible(false);
		else bet10.setVisible(true);
		
		if (balance < 5) bet5.setVisible(false);
		else bet5.setVisible(true);
		
		if (balance < 1) bet1.setVisible(false);
		else bet1.setVisible(true);*/
	}
	
	public void updateBalanceStats (int balance, int bet)
	{
		txt_playerBalance.setText(""+balance);
		txt_playerBet.setText(""+bet);
	}

	public void visualiseBotStats (int amount, List <Bot> bots)
	{
		bots.toFirst();
		JTextField[] textFields = new JTextField[amount];
		for (int i = 0; i < amount; i++)
		{
			textFields[i] = new JTextField (""+bots.getContent().getBalance());
			textFields[i].setBounds(10+(i*75), 10, 60, 20);
			game.add(textFields[i]);
			bots.next();
		}
	}
	
	public void resetGame ()
	{
		txt_playerBalance.setText(null);
		txt_playerBet.setText(null);
		textField.setText(null);
		textField_1.setText(null);
		textField_2.setText(null);
		cCard1.setIcon(null);
		cCard2.setIcon(null);
		cCard3.setIcon(null);
		cCard4.setIcon(null);
		cCard5.setIcon(null);
		pocket1.setIcon(null);
		pocket2.setIcon(null);
		botAmount.setSelectedIndex(0);
		botDifficulty.setSelectedIndex(0);
	}
	
	public int getSIofAmount ()
	{
		return botAmount.getSelectedIndex();
	}
	
	public int getSIofDifficulty ()
	{
		return botDifficulty.getSelectedIndex();
	}
	
	private Image scaledImage (Image img, int w, int h)
	{
		BufferedImage resizedImage = new BufferedImage (w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImage.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(img, 0, 0, w, h, null);
		g2.dispose();
		return resizedImage;
	}
}