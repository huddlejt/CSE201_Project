import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

import javax.management.ListenerNotFoundException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import java.awt.List;

public class FoodiUI {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton accountBtn;
	private JButton btnEntrees;
	private JButton btnAppetizers;
	private JButton btnBeverages;
	private JButton btnDesserts;
	private List listFoodItems;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodiUI window = new FoodiUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FoodiUI() {
		initialize();
		testPopulate();
	}

	/**
	 * Initialize the contents of the frame.  Add in all elements
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(514, 6, 130, 26);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(514, 34, 130, 26);
		frame.getContentPane().add(passwordField);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginBtn.setBackground(Color.WHITE);
		loginBtn.setBounds(547, 68, 72, 20);
		frame.getContentPane().add(loginBtn);
		
		accountBtn = new JButton("Account");
		accountBtn.setBounds(6, 97, 96, 29);
		frame.getContentPane().add(accountBtn);
		
		btnEntrees = new JButton("Entrees");
		btnEntrees.setBounds(114, 97, 117, 29);
		frame.getContentPane().add(btnEntrees);
		
		btnAppetizers = new JButton("Appetizers");
		btnAppetizers.setBounds(243, 97, 117, 29);
		frame.getContentPane().add(btnAppetizers);
		
		btnBeverages = new JButton("Beverages");
		btnBeverages.setBounds(372, 97, 117, 29);
		frame.getContentPane().add(btnBeverages);
		
		btnDesserts = new JButton("Desserts");
		btnDesserts.setBounds(501, 97, 117, 29);
		frame.getContentPane().add(btnDesserts);
		
		listFoodItems = new List();
		listFoodItems.setBounds(226, 132, 393, 236);
		frame.getContentPane().add(listFoodItems);
		frame.setVisible(true);
	}
	
	private void testPopulate() {
		listFoodItems.add("item 1");
		listFoodItems.add("item 2");
		listFoodItems.add("item 3");
	}
}
