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

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import javazoom.jl.player.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.MouseAdapter;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

public class TwitterGUI {


	
	JFrame frmTwitterToolsV;
	private JTextField textField;
	private JTextField userName;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TwitterGUI window = new TwitterGUI();
//					window.frmTwitterToolsV.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public TwitterGUI() {
		initialize();
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Twitter twitter = TwitterFactory.getSingleton();
		frmTwitterToolsV = new JFrame();
		frmTwitterToolsV.setBackground(Color.WHITE);
		frmTwitterToolsV.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DjCedrics\\Eclipse\\TwitterTest\\twitterlogo.png"));
		frmTwitterToolsV.setTitle("Twitter Tools v1.0");
		frmTwitterToolsV.setBounds(100, 100, 450, 300);
		frmTwitterToolsV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTwitterToolsV.getContentPane().setLayout(new CardLayout(0, 0));
		JPanel retweet = new JPanel();
		JPanel mainMenu = new JPanel();
		JPanel credits = new JPanel();
		credits.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new MP3Player(new File("sawarim.mp3")).play();
			}
		});
		mainMenu.setBackground(Color.WHITE);
		frmTwitterToolsV.getContentPane().add(mainMenu, "name_6719149309836");
		mainMenu.setLayout(null);
		JPanel follow = new JPanel();
		frmTwitterToolsV.getContentPane().add(follow, "name_6719163685498");
		follow.setLayout(null);	
		JLabel lblTwitterTools = new JLabel("Twitter Tools");
		lblTwitterTools.setForeground(SystemColor.scrollbar);
		lblTwitterTools.setHorizontalAlignment(SwingConstants.CENTER);
		lblTwitterTools.setFont(new Font("Adobe Caslon Pro", lblTwitterTools.getFont().getStyle(), 32));
		lblTwitterTools.setBounds(83, 13, 256, 46);
		mainMenu.add(lblTwitterTools);
		JPanel unfollow = new JPanel();
		JButton btnFollow = new JButton("Follow");
		btnFollow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu.setVisible(false);
				follow.setVisible(true);
			}
		});
		btnFollow.setBounds(51, 88, 97, 25);
		mainMenu.add(btnFollow);
		JPanel favorite = new JPanel();
		JButton btnUnfollow = new JButton("Unfollow");
		btnUnfollow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				unfollow.setVisible( true );
				mainMenu.setVisible( false );
			}
		});
		btnUnfollow.setBounds(278, 88, 97, 25);
		mainMenu.add(btnUnfollow);
		
		JButton btnFavorite = new JButton("Favorite");
		btnFavorite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainMenu.setVisible( false );
				favorite.setVisible( true );
			}
		});
		btnFavorite.setBounds(51, 126, 97, 25);
		mainMenu.add(btnFavorite);
		
		JButton btnRetweet = new JButton("Retweet");
		btnRetweet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainMenu.setVisible ( false );
				retweet.setVisible( true );
			}
		});
		btnRetweet.setBounds(278, 126, 97, 25);
		mainMenu.add(btnRetweet);
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainMenu.setVisible( false );
				credits.setVisible( true );
				
				
			}
		});
		btnCredits.setBounds(166, 160, 97, 25);
		mainMenu.add(btnCredits);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(166, 198, 97, 25);
		mainMenu.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DjCedrics\\Eclipse\\TwitterTest\\background.png"));
		lblNewLabel.setBounds(0, 0, 432, 277);
		mainMenu.add(lblNewLabel);
		
	
		

		
		JFormattedTextField frmtdtxtfldExampleFiratsivrikaya = new JFormattedTextField();
		frmtdtxtfldExampleFiratsivrikaya.setBackground(SystemColor.textHighlight);
		frmtdtxtfldExampleFiratsivrikaya.setToolTipText("Example: firatsivrikaya");
		frmtdtxtfldExampleFiratsivrikaya.setBounds(122, 123, 185, 22);
		follow.add(frmtdtxtfldExampleFiratsivrikaya);
		
		JLabel lblEnterUsernameTo = new JLabel("Enter username to be followed");
		lblEnterUsernameTo.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblEnterUsernameTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterUsernameTo.setBounds(85, 79, 255, 31);
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
		btnFollow_1.setBounds(166, 169, 97, 25);
		follow.add(btnFollow_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				follow.setVisible(false);
				mainMenu.setVisible(true);
			}
		});
		btnBack.setBounds(166, 207, 97, 25);
		follow.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\DjCedrics\\Eclipse\\TwitterTest\\background.png"));
		label.setBounds(0, 0, 1920, 1200);
		follow.add(label);
		
		
		frmTwitterToolsV.getContentPane().add(favorite, "name_6725328149119");
		favorite.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Tweet ID to be favorited");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(117, 101, 223, 16);
		favorite.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.menu);
		textField.setBounds(160, 130, 116, 22);
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
		btnFavorite_1.setBounds(170, 165, 97, 25);
		favorite.add(btnFavorite_1);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				favorite.setVisible( false );
				mainMenu.setVisible( true );
			}
		});
		btnBack_1.setBounds(170, 203, 97, 25);
		favorite.add(btnBack_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(-685, 0, 1920, 1200);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DjCedrics\\Eclipse\\TwitterTest\\background.png"));
		favorite.add(lblNewLabel_1);
		
		credits.setVisible( false );
		frmTwitterToolsV.getContentPane().add(unfollow, "name_10758969194209");
		unfollow.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Enter username to be unfollowed: ");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(76, 93, 300, 44);
		unfollow.add(lblNewLabel_4);
		
		userName = new JTextField();
		userName.setBounds(167, 138, 116, 22);
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
				
			}
		});
		btnUnfollow_1.setBounds(179, 173, 97, 25);
		unfollow.add(btnUnfollow_1);
		
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unfollow.setVisible( false );
				mainMenu.setVisible( true );
			}
		});
		btnBack_2.setBounds(179, 211, 97, 25);
		unfollow.add(btnBack_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\DjCedrics\\Eclipse\\TwitterTest\\background.png"));
		lblNewLabel_3.setBounds(0, 0, 432, 255);
		unfollow.add(lblNewLabel_3);
		

		frmTwitterToolsV.getContentPane().add(retweet, "name_11204350288740");
		retweet.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(163, 124, 116, 22);
		retweet.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Enter Tweet ID to be retweeted");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(88, 97, 270, 16);
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
		btnRetweet_1.setBounds(173, 159, 97, 25);
		retweet.add(btnRetweet_1);
		
		JButton btnBack_3 = new JButton("Back");
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				retweet.setVisible(false);
				mainMenu.setVisible( true );
			}
		});
		btnBack_3.setBounds(173, 199, 97, 25);
		retweet.add(btnBack_3);
			
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\DjCedrics\\Eclipse\\TwitterTest\\background.png"));
		lblNewLabel_5.setBounds(-290, 0, 722, 560);
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
		lblNewLabel_7.setIcon(new ImageIcon("user\documents\Eclipse\TwitterTest\isis1.png"));
		lblNewLabel_7.setBounds(36, 0, 432, 265);
		credits.add(lblNewLabel_7);
	}
}
