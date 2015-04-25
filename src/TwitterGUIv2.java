import jaco.mp3.player.MP3Player;

import java.applet.AudioClip;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JFormattedTextField;

import twitter4j.IDs;
import twitter4j.PagableResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.BasicAuthorization;
import twitter4j.auth.OAuth2Token;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import javazoom.jl.player.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Scanner;
import java.awt.event.MouseAdapter;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;
import javax.swing.JComboBox;

public class TwitterGUIv2 {


	
	private JFrame frmTwitterToolsV;
	private JTextField textField;
	private JTextField userName;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	
	private int currentIndex;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TwitterGUIv2 window = new TwitterGUIv2();
					window.frmTwitterToolsV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @wbp.parser.entryPoint
	 */
	public TwitterGUIv2() throws SQLException {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws SQLException {
		TwitterDB database = new TwitterDB();
		System.out.println( database.getUsername(3) );
		System.out.println( database.getUserID(3) );
		System.out.println( database.getToken(3) );
		System.out.println( database.getTokenSecret(3) );
		Twitter twitter = TwitterFactory.getSingleton();
		frmTwitterToolsV = new JFrame();
		frmTwitterToolsV.setBackground(Color.WHITE);
		frmTwitterToolsV.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DjCedrics\\Eclipse\\TwitterTest\\twitterlogo.png"));
		frmTwitterToolsV.setTitle("Twitter Tools v1.0");
		frmTwitterToolsV.setBounds(100, 100, 621, 421);
		frmTwitterToolsV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTwitterToolsV.getContentPane().setLayout(new CardLayout(0, 0));
		JPanel retweet = new JPanel();
		JPanel follow = new JPanel();
		JPanel mainMenu = new JPanel();
		JPanel credits = new JPanel();
		JPanel multiFollow = new JPanel();
		JPanel spamTweet = new JPanel();
		credits.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}
		});
		mainMenu.setBackground(Color.WHITE);
		frmTwitterToolsV.getContentPane().add(mainMenu, "name_6719149309836");
		mainMenu.setLayout(null);
		JLabel lblTwitterTools = new JLabel("Twitter Tools");
		lblTwitterTools.setForeground(SystemColor.scrollbar);
		lblTwitterTools.setHorizontalAlignment(SwingConstants.CENTER);
		lblTwitterTools.setFont(new Font("Adobe Caslon Pro", lblTwitterTools.getFont().getStyle(), 32));
		lblTwitterTools.setBounds(176, 13, 256, 46);
		mainMenu.add(lblTwitterTools);
		JPanel unfollow = new JPanel();
		JButton btnFollow = new JButton("Follow");
		btnFollow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu.setVisible(false);
				follow.setVisible(true);
			}
		});
		btnFollow.setBounds(73, 108, 97, 25);
		mainMenu.add(btnFollow);
		JPanel favorite = new JPanel();
		JButton btnUnfollow = new JButton("Unfollow");
		btnUnfollow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				unfollow.setVisible( true );
				mainMenu.setVisible( false );
			}
		});
		btnUnfollow.setBounds(73, 70, 97, 25);
		mainMenu.add(btnUnfollow);
		
		JButton btnFavorite = new JButton("Favorite");
		btnFavorite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainMenu.setVisible( false );
				favorite.setVisible( true );
			}
		});
		btnFavorite.setBounds(73, 146, 97, 25);
		mainMenu.add(btnFavorite);
		
		JButton btnRetweet = new JButton("Retweet");
		btnRetweet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainMenu.setVisible ( false );
				retweet.setVisible( true );
				
			}
		});
		btnRetweet.setBounds(73, 184, 97, 25);
		mainMenu.add(btnRetweet);
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if ( e.getKeyChar() == 'S' )
				{
					credits.setVisible(false);
					mainMenu.setVisible( true );
				}
				
				
			}
		});
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainMenu.setVisible( false );
				credits.setVisible( true );
				new MP3Player(new File("sawarim.mp3")).play();
				
				
			}
		});
		btnCredits.setBounds(261, 300, 97, 25);
		mainMenu.add(btnCredits);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(261, 338, 97, 25);
		mainMenu.add(btnExit);
		
		JButton btnMultiFollow = new JButton("Multi Follow");
		btnMultiFollow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu.setVisible( false );
				multiFollow.setVisible( true );
			}
		});
		btnMultiFollow.setBounds(424, 106, 117, 29);
		mainMenu.add(btnMultiFollow);
		
		JButton btnSpamTweet = new JButton("Spam Tweet");
		btnSpamTweet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu.setVisible( false );
				spamTweet.setVisible( true );
			}
		});
		btnSpamTweet.setBounds(424, 72, 117, 29);
		mainMenu.add(btnSpamTweet);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("background.png"));
		lblNewLabel.setBounds(0, 0, 603, 376);
		mainMenu.add(lblNewLabel);
		
		frmTwitterToolsV.getContentPane().add(follow, "name_6719163685498");
		follow.setLayout(null);	
		
	
		

		
		JFormattedTextField frmtdtxtfldExampleFiratsivrikaya = new JFormattedTextField();
		frmtdtxtfldExampleFiratsivrikaya.setBackground(SystemColor.textHighlight);
		frmtdtxtfldExampleFiratsivrikaya.setToolTipText("Example: firatsivrikaya");
		frmtdtxtfldExampleFiratsivrikaya.setBounds(220, 225, 185, 22);
		follow.add(frmtdtxtfldExampleFiratsivrikaya);
		
		JLabel lblEnterUsernameTo = new JLabel("Enter username to be followed");
		lblEnterUsernameTo.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblEnterUsernameTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterUsernameTo.setBounds(187, 181, 255, 31);
		follow.add(lblEnterUsernameTo);
		
		
		JButton btnFollow_1 = new JButton("Follow");
		btnFollow_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					twitter.createFriendship( frmtdtxtfldExampleFiratsivrikaya.getText() );
					 JOptionPane.showMessageDialog(null, "Followed @" + frmtdtxtfldExampleFiratsivrikaya.getText() , "Done!", JOptionPane.INFORMATION_MESSAGE );
					
				} catch (TwitterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnFollow_1.setBounds(268, 286, 97, 25);
		follow.add(btnFollow_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				follow.setVisible(false);
				mainMenu.setVisible(true);
			}
		});
		btnBack.setBounds(268, 324, 97, 25);
		follow.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("resources/background.png"));
		label.setBounds(0, 0, 1920, 1200);
		follow.add(label);
		
		
		frmTwitterToolsV.getContentPane().add(favorite, "name_6725328149119");
		favorite.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Tweet ID to be favorited");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(209, 220, 223, 16);
		favorite.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.menu);
		textField.setBounds(258, 249, 116, 22);
		favorite.add(textField);
		textField.setColumns(10);
		
		JButton btnFavorite_1 = new JButton("Favorite");
		btnFavorite_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Long tweetId = Long.parseLong(textField.getText());
					twitter.createFavorite( tweetId );
					JOptionPane.showMessageDialog(null, "Favorited Tweet ID:" + tweetId , "Done!", JOptionPane.INFORMATION_MESSAGE );
				} catch (TwitterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnFavorite_1.setBounds(270, 300, 97, 25);
		favorite.add(btnFavorite_1);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				favorite.setVisible( false );
				mainMenu.setVisible( true );
			}
		});
		btnBack_1.setBounds(270, 338, 97, 25);
		favorite.add(btnBack_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(-685, 0, 1920, 1200);
		lblNewLabel_1.setIcon(new ImageIcon("resources/background.png"));
		favorite.add(lblNewLabel_1);
		
		credits.setVisible( false );
		frmTwitterToolsV.getContentPane().add(unfollow, "name_10758969194209");
		unfollow.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Enter username to be unfollowed: ");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(171, 190, 300, 44);
		unfollow.add(lblNewLabel_4);
		
		userName = new JTextField();
		userName.setBounds(271, 247, 116, 22);
		unfollow.add(userName);
		userName.setColumns(10);
		
		JButton btnUnfollow_1 = new JButton("Unfollow");
		btnUnfollow_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String unfollowName = userName.getText();
					twitter.destroyFriendship( unfollowName );
					JOptionPane.showMessageDialog(null, "Unfollowed @" + unfollowName , "Done!", JOptionPane.INFORMATION_MESSAGE );
				} catch (TwitterException e1) {
					
					e1.printStackTrace();
				}				
				
			}
		});
		btnUnfollow_1.setBounds(279, 282, 97, 25);
		unfollow.add(btnUnfollow_1);
		
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unfollow.setVisible( false );
				mainMenu.setVisible( true );
			}
		});
		btnBack_2.setBounds(279, 320, 97, 25);
		unfollow.add(btnBack_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("resources/background.png"));
		lblNewLabel_3.setBounds(0, 0, 603, 376);
		unfollow.add(lblNewLabel_3);
		

		frmTwitterToolsV.getContentPane().add(retweet, "name_11204350288740");
		retweet.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(268, 265, 116, 22);
		retweet.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Enter Tweet ID to be retweeted");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(190, 228, 270, 16);
		retweet.add(lblNewLabel_6);
		
		JButton btnRetweet_1 = new JButton("Retweet");
		btnRetweet_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Long tweetId = Long.parseLong(textField_1.getText());
					twitter.retweetStatus( tweetId );
					JOptionPane.showMessageDialog(null, "Retweeted Tweet ID:" + tweetId , "Done!", JOptionPane.INFORMATION_MESSAGE );
				} catch (TwitterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRetweet_1.setBounds(279, 300, 97, 25);
		retweet.add(btnRetweet_1);
		
		JButton btnBack_3 = new JButton("Back");
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				retweet.setVisible(false);
				mainMenu.setVisible( true );
			}
		});
		btnBack_3.setBounds(279, 338, 97, 25);
		retweet.add(btnBack_3);
			
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("resources/background.png"));
		lblNewLabel_5.setBounds(-290, 0, 893, 560);
		retweet.add(lblNewLabel_5);
		
		JLabel label_1 = new JLabel("");
		credits.addKeyListener(new KeyAdapter() {
			

			Player playMP3;
			public void keyPressed(KeyEvent ev) {
				//new MP3Player(new File("sawarim.mp3")).play();
				try {
				    FileInputStream fis = new FileInputStream("");
				    playMP3 = new Player(fis);

					playMP3.play();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
	
				

			}
		});
		frmTwitterToolsV.getContentPane().add(credits, "name_11588079144980");
		credits.setLayout(null);
		
		
		label_1.setIcon(null);
		label_1.setBackground(Color.BLACK);
		label_1.setBounds(0, 0, 432, 265);
		credits.add(label_1);
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBackground(new Color(0, 0, 0));
		lblNewLabel_7.setIcon(new ImageIcon("/Users/djcedrics/Documents/Eclipse Workspace/TwitterTest/isis1.png"));
		lblNewLabel_7.setBounds(36, 0, 432, 265);
		credits.add(lblNewLabel_7);
		
		
		frmTwitterToolsV.getContentPane().add(multiFollow, "name_13051290953258");
		multiFollow.setLayout(null);
		
		JLabel lblSendFollowersTo = new JLabel("Enter username whose followers will be copied");
		lblSendFollowersTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSendFollowersTo.setBounds(138, 110, 311, 16);
		multiFollow.add(lblSendFollowersTo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(246, 153, 134, 28);
		multiFollow.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnDoTheHarlem = new JButton("Do the harlem shake");
		btnDoTheHarlem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccessToken token = new AccessToken( database.getToken(3), database.getTokenSecret(3) );
				Twitter twitter = new TwitterFactory().getInstance( token );
				int followerCount = -1;
				try {
					followerCount = Integer.parseInt( textField_6.getText() );
					PagableResponseList<User> followers = twitter.getFollowersList( textField_2.getText(), -1, followerCount );
					
					System.out.println( "User: " + textField_2.getText()); 
					System.out.println( followers );
					for ( int i = 0; i < followerCount; i++  )
					{
						System.out.println( followers.get(i));
						twitter.createFriendship( followers.get(i).getScreenName() );
						
					}
					
					
					
				} catch (TwitterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

				
				
				JOptionPane.showMessageDialog(null, "Copied last" + followerCount + " followers of @" + textField_2.getText(), "Done!", JOptionPane.INFORMATION_MESSAGE );
				mainMenu.setVisible( true );
				multiFollow.setVisible( false );
//				
//				ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
//			     configurationBuilder.setOAuthConsumerKey("Vuo8Fv149xRrXazLhELphk8YN");
//			     configurationBuilder.setOAuthConsumerSecret("HJPxgUOh41dpPmmfPiniDpukDWqs7wLYv2KPDCuncnwFJMdoWv");
//			     Configuration configuration = configurationBuilder.build();
//				
//				
//				Scanner scan = new Scanner( System.in );
//				try {
//					scan = new Scanner ( new File( "acc.txt") );
//				} catch (FileNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				while ( scan.hasNextLine() )
//				{
//					String data = scan.nextLine();
//					String username = "";
//					String password = "";
//					boolean udone = false;
//					boolean pdone = false;
//					int usernamelength = data.length();
//					for ( int i = 0 ; i < usernamelength ; i++ )
//					{
//						if ( data.charAt(i) != ':' && !udone )
//						{
//							username = username + data.charAt(i);
//						}
//						
//						else if ( data.charAt(i) == ':' )
//						{
//							udone = true;
//							usernamelength = username.length();
//						}
//					}
//					
//					for ( int i = usernamelength + 1 ; i < data.length() ; i++ )
//					{
//						if ( data.charAt(i) != ' ')
//						password = password + data.charAt( i );
//					}
//				System.out.println(  username + "\n" + password );
//					Twitter twitter = new TwitterFactory(configuration).getInstance( new BasicAuthorization(username, password) );
//				    AccessToken token = null;
//					try {
//						token = twitter.getOAuthAccessToken();
//					} catch (TwitterException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
//				     System.out.println("Access Token " + token );
//					
//					try {
//						twitter.createFriendship( textField_2.getText() );
//					} catch (TwitterException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					
//				}
//				scan.close();
//				//TODO: Get the twitter account details from text file
//				//Read them and authenticate each
//				//For each account
//				//createFriendship with specified account
//				
			}
		});
		btnDoTheHarlem.setBounds(216, 292, 174, 29);
		multiFollow.add(btnDoTheHarlem);
		
		JButton btnBack_4 = new JButton("Back");
		btnBack_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				multiFollow.setVisible( false );
				mainMenu.setVisible( true );
			}
		});
		btnBack_4.setBounds(246, 334, 117, 29);
		multiFollow.add(btnBack_4);
		
		JLabel lblEnterHowMany_1 = new JLabel("Enter how many followers will be copied");
		lblEnterHowMany_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterHowMany_1.setBounds(174, 194, 275, 50);
		multiFollow.add(lblEnterHowMany_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(246, 257, 116, 22);
		multiFollow.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("resources/background.png"));
		lblNewLabel_8.setBounds(0, 0, 481, 278);
		multiFollow.add(lblNewLabel_8);
		
		
		frmTwitterToolsV.getContentPane().add(spamTweet, "name_14422591201835");
		spamTweet.setLayout(null);
		
		JLabel lblEnterUsernameWhose = new JLabel("Enter username whose followers would be spam tweeted");
		lblEnterUsernameWhose.setBounds(144, 64, 355, 16);
		spamTweet.add(lblEnterUsernameWhose);
		
		textField_3 = new JTextField();
		textField_3.setBounds(243, 93, 134, 28);
		spamTweet.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblEnterHowMany = new JLabel("Enter how many followers would be spam tweeted");
		lblEnterHowMany.setBounds(158, 134, 355, 16);
		spamTweet.add(lblEnterHowMany);
		
		textField_4 = new JTextField();
		textField_4.setBounds(243, 170, 134, 28);
		spamTweet.add(textField_4);
		textField_4.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// EXPLICITLY PLUS 1 IN ORDER TO MATCH DATABASE!!!!!!!
				currentIndex = comboBox.getSelectedIndex() + 1;
				System.out.println( "Current index " + comboBox.getSelectedIndex() );
			}
		});
		comboBox.setBounds(243, 29, 134, 22);
		System.out.println( "Linecount: " + database.getLineCount() );
		for ( int i = 1 ; i <= database.getLineCount() ; i++ )
		{
			comboBox.addItem( database.getUsername(i));
			
		}
		
		spamTweet.add(comboBox);
		
		
		
		JLabel lblEnterTweet = new JLabel("Enter tweet");
		lblEnterTweet.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterTweet.setBounds(268, 212, 94, 16);
		spamTweet.add(lblEnterTweet);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int count = Integer.parseInt( textField_4.getText() );
				String username = textField_3.getText();
				String tweet = textField_5.getText();
				
				try {
					AccessToken token = new AccessToken( database.getToken(currentIndex), database.getTokenSecret(currentIndex) );
					Twitter twitter = new TwitterFactory().getInstance( token );
					System.out.println( "Connected to " + database.getUsername(currentIndex) + " successfully!" );
					PagableResponseList<User> followers = twitter.getFollowersList( username, -1, count );
					
					for ( int i = 0 ; i < count ; i++ )
					{
						
						try{

							  Thread.sleep(5000);
							  twitter.updateStatus( "@"+followers.get(i).getScreenName()+" "+tweet+" " + (int)(Math.random()*500)    );
							}catch(InterruptedException ex){
								
							} 
					}
				} catch (TwitterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Spamming " + count + " followers of @" + username + " successful!", "Done!", JOptionPane.INFORMATION_MESSAGE );
				
				
			}
		});
		btnConfirm.setBounds(257, 292, 117, 29);
		spamTweet.add(btnConfirm);
		
		JButton btnBack_5 = new JButton("Back");
		btnBack_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spamTweet.setVisible( false );
				mainMenu.setVisible( true );
			}
		});
		btnBack_5.setBounds(257, 334, 117, 29);
		spamTweet.add(btnBack_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(243, 241, 134, 28);
		spamTweet.add(textField_5);
		textField_5.setColumns(10);
		

		
		JLabel lblSelectInstance = new JLabel("Select instance");
		lblSelectInstance.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectInstance.setBounds(243, 13, 134, 16);
		spamTweet.add(lblSelectInstance);

		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("resources/background.png"));
		lblNewLabel_9.setBounds(0, 0, 603, 376);
		spamTweet.add(lblNewLabel_9);
	}
}
