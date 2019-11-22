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
import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JTable;

public class FoodiUI {

	private JFrame frame;
	private JButton accountBtn;
	private JButton btnEntrees;
	private JButton btnAppetizers;
	private JButton btnBeverages;
	private JButton btnDesserts;
	private List listFoodItems;
	private JPanel accountPanel;
	private List listSavedFoods;
	private JButton loginBtn;
	private JPanel foodPanel;
	private JTextField searchBar;
	private boolean loggedIn = false;

	//TEST VARIABLES
	FoodItem a = new Appetizer(1, "A", 0, 12, "www.zuckit.com", "5min", "Bekfast");
	FoodItem b = new Entree(2, "B", 1, 10, "www.example.com", "8min", "Lunch");
	FoodItem c = new Entree(3, "C", 2, 2400, "www.badprogramming.com", "1hr", "Dinner");
	Beverage b1 = new Beverage(007, "water", 1, 0, "", "", "All", 0);
	Appetizer a1 = new Appetizer(006, "app", 2, 100, "asdf.com", "2min", "All");
	Dessert d1 = new Dessert(8, "cake", 1, 50, "cake", "30min", "All");
	Entree e1 = new Entree(010, "entree", 3, 100, "jkl.com", "4min", "All");

	FoodItem[] foods = new FoodItem[] {a,b,c,b1,a1,d1,e1};
	

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

		loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		loginBtn.setBackground(Color.WHITE);
		loginBtn.setBounds(546, 48, 72, 20);
		frame.getContentPane().add(loginBtn);

		accountBtn = new JButton("Account");
		accountBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayAccount();	
			}
		});
		accountBtn.setBounds(6, 97, 96, 29);
		frame.getContentPane().add(accountBtn);

		btnEntrees = new JButton("Entrees");
		btnEntrees.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayEntrees();	
			}
		});
		btnEntrees.setBounds(114, 97, 117, 29);
		frame.getContentPane().add(btnEntrees);

		btnAppetizers = new JButton("Appetizers");
		btnAppetizers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayAppetizers();	
			}
		});
		btnAppetizers.setBounds(243, 97, 117, 29);
		frame.getContentPane().add(btnAppetizers);

		btnBeverages = new JButton("Beverages");
		btnBeverages.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayBeverages();	
			}
		});
		btnBeverages.setBounds(372, 97, 117, 29);
		frame.getContentPane().add(btnBeverages);

		btnDesserts = new JButton("Desserts");
		btnDesserts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayDesserts();	
			}
		});
		btnDesserts.setBounds(501, 97, 117, 29);
		frame.getContentPane().add(btnDesserts);

		accountPanel = new JPanel();
		accountPanel.setBounds(16, 138, 175, 230);
		frame.getContentPane().add(accountPanel);
		accountPanel.setLayout(null);
		accountPanel.setVisible(false);

		listSavedFoods = new List();
		accountPanel.add(listSavedFoods);
		listSavedFoods.setBounds(79, 24, 96, 206);

		JLabel lblSavedItems = new JLabel("Saved Items");
		lblSavedItems.setBounds(89, 2, 86, 16);
		accountPanel.add(lblSavedItems);

		JLabel lblAccount = new JLabel("UsrName");
		lblAccount.setBounds(6, 2, 77, 16);
		accountPanel.add(lblAccount);

		JButton btnNewButton = new JButton("Change Password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 6));
		btnNewButton.setBounds(0, 24, 80, 29);
		accountPanel.add(btnNewButton);

		foodPanel = new JPanel();
		foodPanel.setBounds(203, 138, 429, 230);
		frame.getContentPane().add(foodPanel);
		foodPanel.setLayout(null);

		listFoodItems = new List();
		listFoodItems.setBounds(10, 10, 409, 220);
		foodPanel.add(listFoodItems);

		searchBar = new JTextField();
		searchBar.setBounds(114, 44, 130, 26);
		frame.getContentPane().add(searchBar);
		searchBar.setColumns(10);
		searchBar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				search();
				
			}
		});
		frame.setVisible(true);
	}

	protected void displayDesserts() {
		if(!(foodPanel.isVisible()) ) {
			foodPanel.setVisible(true);
		}
		listFoodItems.removeAll();
		for(int i = 0; i < foods.length; i++) {
			if(foods[i] instanceof Dessert) {
				listFoodItems.add(foods[i].toJSON());
			}
		}
	}

	protected void displayBeverages() {
		if(!(foodPanel.isVisible()) ) {
			foodPanel.setVisible(true);
		}
		listFoodItems.removeAll();
		for(int i = 0; i < foods.length; i++) {
			if(foods[i] instanceof Beverage) {
				listFoodItems.add(foods[i].toJSON());
			}
		}
	}

	protected void displayAppetizers() {
		if(!(foodPanel.isVisible()) ) {
			foodPanel.setVisible(true);
		}
		listFoodItems.removeAll();
		for(int i = 0; i < foods.length; i++) {
			if(foods[i] instanceof Appetizer) {
				listFoodItems.add(foods[i].toJSON());
			}
		}
	}

	protected void displayEntrees() {
		if(!(foodPanel.isVisible()) ){
			foodPanel.setVisible(true);
		}
		listFoodItems.removeAll();
		for(int i = 0; i < foods.length; i++) {
			if(foods[i] instanceof Entree) {
				listFoodItems.add(foods[i].toJSON());
			}
		}
	}

	private void displayAccount() {
		if(!loggedIn) {
			
		}
		else {
			if(accountPanel.isVisible()) {
				accountPanel.setVisible(false);
			}
			else {
				accountPanel.setVisible(true);
			}
			listSavedFoods.removeAll();
			listSavedFoods.add(a.toJSON());
			listSavedFoods.add(b.toJSON());
			listSavedFoods.add(c.toJSON());
		}
		

	}
	
	protected void login() {
		//open new window
		JFrame loginframe = new JFrame();
		loginframe.setBackground(Color.WHITE);
		loginframe.setBounds(100, 100, 650, 400);
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginframe.getContentPane().setLayout(null);
		loginframe.setAlwaysOnTop(true);
		
		JTextField usernameField = new JTextField();
		usernameField.setBounds(175, 120, 260, 26);
		usernameField.setColumns(10);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(175, 160, 260, 26);
		
		JButton loginBtn2 = new JButton("Login");
		loginBtn2.setBounds(305, 200, 50, 26);
		loginBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkCredentials(usernameField.getText(), passwordField.getPassword())) {
					loginBtn.setText("Logout");
					loginframe.dispose();
				}
				
			}
		});
		
		loginframe.getContentPane().add(usernameField);
		loginframe.getContentPane().add(passwordField);
		loginframe.getContentPane().add(loginBtn2);
		loginframe.setVisible(true);
		
		
		loginBtn.setText("Logout");
		
		
	}

	protected boolean checkCredentials(String username, char[] pw) {
		
		System.out.println("Checking username and password");
		return (username != null && pw != null);
	}

	private void testPopulate() {
		for(int i = 0; i < foods.length; i++) {
			if(foods[i] != null) {
				listFoodItems.add(foods[i].toJSON());
			}
		}
	}

	protected void search() {
		System.out.println(searchBar.getText());
	}
}


