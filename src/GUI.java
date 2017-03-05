import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
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
	
	private List <JLabel> card;
	private List <Component> gui_elements;
	private List <JLabel> chips;
	
	private JButton mm_continue;
	private JButton mm_new;
	private JButton mm_options;
	private JButton startGame;
	private JButton confirmBet;
	private JButton next;
	private JButton reset;
	
	//private JComboBox botAmount;
	private JComboBox botDifficulty;
	
	private JTextField txt_playerBalance;
	private JTextField txt_playerBet;
	
	private JSeparator sep;
	
	
	public GUI ()
	{
		int frameWidth = 1110;
		int frameHeight = 720;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = ((d.width - getSize().width) / 2);
	    int y = ((d.height - getSize().height) / 2);
	    setLocation(x, y);
		setResizable(false);
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
		
		cl = new CardLayout();
		contP = new JPanel();
		contP.setLayout(cl);
		getContentPane().add(contP);
		
		
		intro = new JPanel();
		contP.add(intro, "intro");
		intro.setLayout(null);
		
		logo = new JLabel();
		logo.setIcon(new ImageIcon(GUI.class.getResource("/images/chips/10000.png")));
		logo.setBounds(456, 175, 241, 241);
		intro.add(logo);
		
		intro_text = new JLabel();
		intro_text.setFont(new Font("Adobe Arabic", Font.BOLD, 36));
		intro_text.setBounds(325, 452, 550, 60);
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
		background.setBounds(0, 0, getContentPane().getWidth(), getContentPane().getHeight());
		background.setIcon(new ImageIcon (scaledImage(table.getImage(), background.getWidth(), background.getHeight())));
		//mainMenu.add(background);
		
		cl.show(contP, "main menu");
		
		
		options = new JPanel ();
		contP.add(options, "options");
		options.setLayout(null);
		
		
		startOptions = new JPanel ();
		contP.add(startOptions, "start options");
		startOptions.setLayout(null);
		
		/*String[] amount = {"Bot Amount?", "2", "3", "4", "5", "6"};
		botAmount = new JComboBox(amount);
		botAmount.setBounds(191, 188, 86, 20);
		startOptions.add(botAmount);
		gui_elements.append(botAmount);*/
		
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
		
		sep = new JSeparator ();
		sep.setBounds(0, 540, 1104, 20);
		game.add(sep);
		
		txt_playerBalance = new JTextField ();
		txt_playerBalance.setBounds(975, 608, 100, 20);
		txt_playerBalance.setEditable(false);
		game.add(txt_playerBalance);
		txt_playerBalance.setColumns(10);
		
		txt_playerBet = new JTextField ();
		txt_playerBet.setBounds(470, 661, 100, 20);
		txt_playerBet.setEditable(false);
		game.add(txt_playerBet);
		txt_playerBet.setColumns(10);
		
		
		int cardW = 90;
		int cardH = 130;
		
		cCard1 = new JLabel ();
		cCard1.setBounds(215, 348, cardW, cardH);
		game.add(cCard1);
		card.append(cCard1);
		
		cCard2 = new JLabel ();
		cCard2.setBounds(cCard1.getX() + 100, cCard1.getY(), cardW, cardH);
		game.add(cCard2);
		card.append(cCard2);
		
		cCard3 = new JLabel ();
		cCard3.setBounds(cCard2.getX() + 100, cCard1.getY(), cardW, cardH);
		game.add(cCard3);
		card.append(cCard3);
		
		cCard4 = new JLabel ();
		cCard4.setBounds(cCard3.getX() + 100, cCard1.getY(), cardW, cardH);
		game.add(cCard4);
		card.append(cCard4);
		
		cCard5 = new JLabel ();
		cCard5.setBounds(cCard4.getX() + 100, cCard1.getY(), cardW, cardH);
		game.add(cCard5);
		card.append(cCard5);
		
		pocket1 = new JLabel ();
		pocket1.setBounds(750, 551, cardW, cardH);
		game.add(pocket1);
		
		pocket2 = new JLabel ();
		pocket2.setBounds(pocket1.getX() + 100, pocket1.getY(), cardW, cardH);
		game.add(pocket2);
		
		
		int chipSize = 70;
		
		bet1 = new JLabel ();
		bet1.setBounds(150, 551, chipSize, chipSize);
		bet1.setIcon(new ImageIcon (scaledImage(chip1.getImage(), bet1.getWidth(), bet1.getHeight())));
		bet1.setName("1");
		game.add(bet1);
		chips.append(bet1);
		
		bet5 = new JLabel ();
		bet5.setBounds(bet1.getX() + 100, bet1.getY(), chipSize, chipSize);
		bet5.setIcon(new ImageIcon (scaledImage(chip5.getImage(), bet5.getWidth(), bet5.getHeight())));
		bet5.setName("5");
		game.add(bet5);
		chips.append(bet5);
		
		bet10 = new JLabel ();
		bet10.setBounds(bet5.getX() + 100, bet1.getY(), chipSize, chipSize);
		bet10.setIcon(new ImageIcon (scaledImage(chip10.getImage(), bet10.getWidth(), bet10.getHeight())));
		bet10.setName("10");
		game.add(bet10);
		chips.append(bet10);
		
		bet25 = new JLabel ();
		bet25.setBounds(bet10.getX() + 100, bet1.getY(), chipSize, chipSize);
		bet25.setIcon(new ImageIcon (scaledImage(chip25.getImage(), bet25.getWidth(), bet25.getHeight())));
		bet25.setName("25");
		game.add(bet25);
		chips.append(bet25);
		
		bet50 = new JLabel ();
		bet50.setBounds(bet25.getX() + 100, bet1.getY(), chipSize, chipSize);
		bet50.setIcon(new ImageIcon (scaledImage(chip50.getImage(), bet50.getWidth(), bet50.getHeight())));
		bet50.setName("50");
		game.add(bet50);
		chips.append(bet50);
		
		bet100 = new JLabel ();
		bet100.setBounds(bet50.getX() + 100, bet1.getY(), chipSize, chipSize);
		bet100.setIcon(new ImageIcon (scaledImage(chip100.getImage(), bet100.getWidth(), bet100.getHeight())));
		bet100.setName("100");
		game.add(bet100);
		chips.append(bet100);
		
		bet500 = new JLabel ();
		bet500.setBounds(bet1.getX() + 50, bet1.getY() + chipSize, chipSize, chipSize);
		bet500.setIcon(new ImageIcon (scaledImage(chip500.getImage(), bet500.getWidth(), bet500.getHeight())));
		bet500.setName("500");
		game.add(bet500);
		chips.append(bet500);
		
		bet1000 = new JLabel ();
		bet1000.setBounds(bet500.getX()+100, bet500.getY(), chipSize, chipSize);
		bet1000.setIcon(new ImageIcon (scaledImage(chip1000.getImage(), bet1000.getWidth(), bet1000.getHeight())));
		bet1000.setName("1000");
		game.add(bet1000);
		chips.append(bet1000);
		
		confirmBet = new JButton ("confirmBet");
		confirmBet.setBounds(585, 630, 120, 50);
		game.add(confirmBet);
		gui_elements.append(confirmBet);
		
		next = new JButton("Next");
		next.setBounds(804, 421, 126, 57);
		game.add(next);
		gui_elements.append(next);
		
		reset = new JButton("Reset");
		reset.setBounds(804, 350, 126, 34);
		game.add(reset);
		gui_elements.append(reset);
		
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
	
	public void setPocketIcons (Card[] pocket)
	{	
		pocket1.setIcon(pocket[0].getIcon(pocket1.getWidth(), pocket2.getHeight()));
		pocket2.setIcon(pocket[1].getIcon(pocket2.getWidth(), pocket2.getHeight()));
	}
	
	public void setFlopIcons (List<Card> cCards)
	{
		cCards.toFirst();
		card.toFirst();
		while (cCards.hasAccess() && card.hasAccess())
		{
			card.getContent().setIcon(cCards.getContent().getIcon(card.getContent().getWidth(), card.getContent().getHeight()));
			cCards.next();
			card.next();
		}
	}
	
	public void setTurnOrRiverIcon (String a, Card card)
	{
		switch (a)
		{
		case "turn":  cCard4.setIcon(card.getIcon(cCard4.getWidth(), cCard4.getHeight()));
					  break;
		case "river": cCard5.setIcon(card.getIcon(cCard5.getWidth(), cCard5.getHeight()));
		              break;
		}
	}
	
	public void updateUI (int balance)
	{
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
		else bet1.setVisible(true);
	}
	
	public void disableChips ()
	{
		chips.toFirst();
		while (chips.hasAccess())
		{
			chips.getContent().setEnabled(false);
			chips.next();
		}
		confirmBet.setEnabled(false);
	}
	
	public void enableChips ()
	{
		chips.toFirst();
		while (chips.hasAccess())
		{
			chips.getContent().setEnabled(true);
			chips.next();
		}
		confirmBet.setEnabled(true);
	}
	
	public void updateBalanceStats (int balance, int bet)
	{
		txt_playerBalance.setText("Balance:   "+balance);
		txt_playerBet.setText("Bet:    "+bet);
	}

	public void visualiseBotStats (int amount, List <Bot> bots)
	{
		Random rndGen = new Random ();
		int rnd;
		bots.toFirst();
		JTextField[] balances = new JTextField[amount];
		JTextField[] names = new JTextField[amount];
		JTextField[] bets = new JTextField[amount];
		for (int i = 0; i < amount; i++)
		{
			rnd = rndGen.nextInt(23);
			bots.getContent().setName(rnd);
			names[i] = new JTextField ("Name:   "+bots.getContent().getName());
			names[i].setBounds(10+(i*115), 10, 100, 20);
			names[i].setEditable(false);
			game.add(names[i]);
			balances[i] = new JTextField ("Balance:   "+bots.getContent().getBalance());
			balances[i].setBounds(10+(i*115), 40, 100, 20);
			balances[i].setEditable(false);
			game.add(balances[i]);
			bets[i] = new JTextField ();
			bots.next();
		}
	}
	
	public void resetGame ()
	{
		txt_playerBalance.setText(null);
		txt_playerBet.setText(null);
		cCard1.setIcon(null);
		cCard2.setIcon(null);
		cCard3.setIcon(null);
		cCard4.setIcon(null);
		cCard5.setIcon(null);
		pocket1.setIcon(null);
		pocket2.setIcon(null);
		//botAmount.setSelectedIndex(0);
		botDifficulty.setSelectedIndex(0);
	}
	
	/*public int getSIofAmount ()
	{
		return botAmount.getSelectedIndex();
	}*/
	
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