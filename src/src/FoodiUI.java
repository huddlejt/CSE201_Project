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
import java.awt.Canvas;
import java.awt.Label;
import javax.swing.JComboBox;

public class FoodiUI {

	private JFrame frame;
	
	private JButton accountBtn;
	private JButton btnEntrees;
	private JButton btnAppetizers;
	private JButton btnBeverages;
	private JButton btnDesserts;
	private JButton btnAllfoods;
	private JButton loginBtn;
	private JButton sortMeal;
	private JButton sortPop;
	private JButton saveItem;
	private JButton btnCreateRecipe;
	
	private List listFoodItems;
	private List listSavedFoods;
	private List featuredList;
	
	private JTextField searchBar;
	private JTextField itemNameBox;
	
	private JPanel foodPanel;
	private JPanel homePanel;
	
	private JLabel lblAccount = new JLabel();
	
	private JComboBox foodTypeBox;
	
	
	private User currentUser = null;
	
	private boolean loggedIn = false;
	private dbManager dbm = new dbManager();

	//TEST VARIABLES
	FoodItem a = new Appetizer(1, "A", 0, 12, "www.zuckit.com", "5min", "Bekfast");
	FoodItem b = new Entree(2, "B", 1, 10, "www.example.com", "8min", "Lunch");
	FoodItem c = new Entree(3, "C", 2, 2400, "www.badprogramming.com", "1hr", "Dinner");
	Beverage b1 = new Beverage(007, "water", 1, 0, "", "", "All", 0);
	Appetizer a1 = new Appetizer(006, "app", 2, 100, "asdf.com", "2min", "All");
	Dessert d1 = new Dessert(8, "cake", 1, 50, "cake", "30min", "All");
	Entree e1 = new Entree(010, "entree", 3, 100, "jkl.com", "4min", "All");

	FoodItem[] foods = new FoodItem[] {a,b,c,b1,a1,d1,e1};
	
//	User u = new User("Abc","123",1);
//	User u1 = new User("123","abc",2);
//	User u2 = new User("bcd","321",3);
//	User u3 = new User("def","555",4);
//	User u4 = new User("Aaa","aaa",5);
//	User u5 = new User("Acdc","111",6);
//	User u6 = new User("c3po","r2d2",7);
//	User[] users = new User[] {u,u1,u2,u3,u4,u5,u6};
	


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
		accountBtn.setBounds(546, 7, 80, 29);
		frame.getContentPane().add(accountBtn);

		btnEntrees = new JButton("Entrees");
		btnEntrees.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayEntrees();	
			}
		});
		btnEntrees.setBounds(237, 97, 99, 29);
		frame.getContentPane().add(btnEntrees);

		btnAppetizers = new JButton("Appetizers");
		btnAppetizers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayAppetizers();	
			}
		});
		btnAppetizers.setBounds(335, 97, 99, 29);
		frame.getContentPane().add(btnAppetizers);

		btnBeverages = new JButton("Beverages");
		btnBeverages.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayBeverages();	
			}
		});
		btnBeverages.setBounds(435, 97, 99, 29);
		frame.getContentPane().add(btnBeverages);

		btnDesserts = new JButton("Desserts");
		btnDesserts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayDesserts();	
			}
		});
		btnDesserts.setBounds(533, 97, 99, 29);
		frame.getContentPane().add(btnDesserts);

		btnAllfoods = new JButton("All Foods");
		btnAllfoods.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayAllFoods();
			}
		});
		btnAllfoods.setBounds(137, 97, 99, 29);
		frame.getContentPane().add(btnAllfoods);
		
		JButton homeBtn = new JButton("Home");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayHome();
			}
		});
		homeBtn.setBounds(10, 97, 80, 29);
		frame.getContentPane().add(homeBtn);

		foodPanel = new JPanel();
		foodPanel.setBounds(16, 138, 616, 230);
		frame.getContentPane().add(foodPanel);
		foodPanel.setLayout(null);

		listFoodItems = new List();
		listFoodItems.setBounds(108, 34, 498, 196);
		foodPanel.add(listFoodItems);
		
		JButton sortName = new JButton("Name");
		sortName.setBounds(107, -1, 117, 29);
		sortName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//implement sort
				
			}
		});
		foodPanel.add(sortName);
		
		JButton sortCal = new JButton("Calories");
		sortCal.setBounds(222, -1, 117, 29);
		sortCal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//implement sort
				
			}
		});
		foodPanel.add(sortCal);
		
		sortMeal = new JButton("Meal");
		sortMeal.setBounds(336, -1, 117, 29);
		sortMeal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//implement sort
				
			}
		});
		foodPanel.add(sortMeal);
		
		sortPop = new JButton("Popularity");
		sortPop.setBounds(454, -1, 117, 29);
		sortPop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//implement sort
				
			}
		});
		foodPanel.add(sortPop);
		
		saveItem = new JButton("Save");
		saveItem.setBounds(6, 195, 99, 29);
		saveItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!loggedIn) {
					displayWarning("You are not logged in!");
				}
				//add item to user's db
				
			}
		});
		foodPanel.add(saveItem);
		
		homePanel = new JPanel();
		homePanel.setBounds(16, 138, 616, 230);
		frame.getContentPane().add(homePanel);
		homePanel.setLayout(null);
		
		JLabel lblFOD = new JLabel("Featured items:");
		lblFOD.setBounds(20, 20, 122, 16);
		homePanel.add(lblFOD);
		
		featuredList = new List();
		featuredList.setBounds(20, 40, 596, 220);
		homePanel.add(featuredList);

		searchBar = new JTextField();
		searchBar.setBounds(243, 44, 246, 26);
		frame.getContentPane().add(searchBar);
		searchBar.setColumns(10);
		
		btnCreateRecipe = new JButton("Create Recipe");
		btnCreateRecipe.setBounds(0, 44, 117, 29);
		btnCreateRecipe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!loggedIn) {
					displayWarning("You are not logged in!");
				}
				else
					createForm();
				
			}
		});
		frame.getContentPane().add(btnCreateRecipe);
		
		searchBar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				search();

			}
		});
		foodPanel.setVisible(false);
		displayHome();
		frame.setVisible(true);
	}

	protected void createForm() {
		JFrame createframe = new JFrame();
		createframe.setBackground(Color.WHITE);
		createframe.setBounds(100, 100, 650, 400);
		createframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createframe.getContentPane().setLayout(null);
		createframe.setAlwaysOnTop(true);
		
		foodTypeBox = new JComboBox();
		foodTypeBox.setBounds(70, 21, 190, 27);
		createframe.getContentPane().add(foodTypeBox);
		
		itemNameBox = new JTextField();
		itemNameBox.setBounds(70, 74, 181, 26);
		createframe.getContentPane().add(itemNameBox);
		itemNameBox.setColumns(10);
		
		JTextField recipeUrlBox = new JTextField();
		recipeUrlBox.setBounds(70, 114, 181, 26);
		createframe.getContentPane().add(recipeUrlBox);
		recipeUrlBox.setColumns(10);
		
		JTextField preptimeBox = new JTextField();
		preptimeBox.setBounds(70, 154, 181, 26);
		createframe.getContentPane().add(preptimeBox);
		preptimeBox.setColumns(10);
		
		JComboBox mealBox = new JComboBox();
		mealBox.setBounds(70, 194, 190, 27);
		createframe.getContentPane().add(mealBox);
		
		JButton btnSubmit = new JButton("Create Recipe");
		btnSubmit.setBounds(70, 234, 117, 29);
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				createFoodItem();
				
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(70, 274, 117, 29);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				createframe.dispose();
				
			}
		});
		
		createframe.getContentPane().add(btnCancel);
		createframe.getContentPane().add(btnSubmit);
		
		createframe.setVisible(true);

//		JPanel accountPanel = new JPanel();
//		accountPanel.setBounds(16, 6, 628, 362);
//		createframe.getContentPane().add(accountPanel);
//		accountPanel.setLayout(null);
//		accountPanel.setVisible(false);
	}

	protected void createFoodItem() {
		// TODO Auto-generated method stub
		
	}

	protected void displayHome() {
		featuredList.removeAll();
		homePanel.setVisible(true);
		foodPanel.setVisible(false);
		featuredList.add(foods[0].toString());
		
	}

	protected void displayAllFoods() {
		if(!(foodPanel.isVisible()) ) {
			foodPanel.setVisible(true);
		}
		listFoodItems.removeAll();
		for(int i = 0; i < foods.length; i++) {
			if(foods[i] != null) {
				listFoodItems.add(foods[i].toFileFormat());
			}
		}

	}

	protected void displayDesserts() {
		if(!(foodPanel.isVisible()) ) {
			foodPanel.setVisible(true);
		}
		listFoodItems.removeAll();
		for(int i = 0; i < foods.length; i++) {
			if(foods[i] instanceof Dessert) {
				listFoodItems.add(foods[i].toFileFormat());
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
				listFoodItems.add(foods[i].toFileFormat());
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
				listFoodItems.add(foods[i].toFileFormat());
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
				listFoodItems.add(foods[i].toFileFormat());
			}
		}
	}

	private void displayAccount() {
		if(!loggedIn) {
			displayWarning("You are not logged in!");
		}
		else {
			JFrame accountframe = new JFrame();
			accountframe.setBackground(Color.WHITE);
			accountframe.setBounds(100, 100, 650, 400);
			accountframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			accountframe.getContentPane().setLayout(null);
			accountframe.setAlwaysOnTop(true);

			JPanel accountPanel = new JPanel();
			accountPanel.setBounds(16, 6, 628, 362);
			accountframe.getContentPane().add(accountPanel);
			accountPanel.setLayout(null);
			accountPanel.setVisible(false);

			listSavedFoods = new List();
			accountPanel.add(listSavedFoods);
			listSavedFoods.setBounds(129, 146, 489, 206);

			JLabel lblSavedItems = new JLabel("Saved Items");
			lblSavedItems.setBounds(195, 102, 86, 16);
			accountPanel.add(lblSavedItems);

			lblAccount.setBounds(9, 6, 77, 16);
			accountPanel.add(lblAccount);

			JButton btnNewButton = new JButton("Change Password");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("password change requested");
				}
			});
			btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			btnNewButton.setBounds(6, 127, 122, 26);
			accountPanel.add(btnNewButton);

			JButton exitBtn = new JButton("Exit");
			exitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					accountframe.dispose();
				}
			});
			exitBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			exitBtn.setBounds(524, 76, 80, 26);
			accountPanel.add(exitBtn);


			if(accountPanel.isVisible()) {
				accountPanel.setVisible(false);
			}
			else {
				accountPanel.setVisible(true);
			}
			listSavedFoods.removeAll();
			listSavedFoods.add(a.toFileFormat());
			listSavedFoods.add(b.toFileFormat());
			listSavedFoods.add(c.toFileFormat());
			accountframe.getContentPane().add(accountPanel);
			accountframe.setVisible(true);

		}




	}

	private void displayWarning(String string) {
		JFrame warningframe = new JFrame();
		warningframe.setBackground(Color.WHITE);
		warningframe.setBounds(300, 200, 200, 200);
		warningframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		warningframe.getContentPane().setLayout(null);
		warningframe.setAlwaysOnTop(true);
		JLabel message = new JLabel(string);
		message.setBounds(30, 60, 150, 26);
		JButton okaybtn = new JButton("Ok");
		okaybtn.setBounds(75, 90, 60, 26);
		okaybtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				warningframe.dispose();

			}
		});
		warningframe.getContentPane().add(okaybtn);
		warningframe.getContentPane().add(message);

		warningframe.setVisible(true);

	}

	protected void login() {
		if(loggedIn) {
			loggedIn = false;
			loginBtn.setText("Login");
			
			return;
		}
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
					loggedIn = true;
					loginBtn.setText("Logout");
					lblAccount.setText(usernameField.getText());
					loginframe.dispose();
				}

			}
		});
		JButton createAccountBtn = new JButton("Create an Account");
		createAccountBtn.setBounds(305, 240, 50, 26);
		createAccountBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				newAccount(loginframe);

			}
		});

		loginframe.getContentPane().add(usernameField);
		loginframe.getContentPane().add(passwordField);
		loginframe.getContentPane().add(loginBtn2);
		loginframe.getContentPane().add(createAccountBtn);
		loginframe.setVisible(true);


		//loginBtn.setText("Logout");


	}
	protected void newAccount(JFrame loginframe) {
		JFrame createframe = new JFrame();
		createframe.setBackground(Color.WHITE);
		createframe.setBounds(100, 100, 650, 400);
		createframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createframe.getContentPane().setLayout(null);
		createframe.setAlwaysOnTop(true);

		JTextField usernameField = new JTextField();
		usernameField.setBounds(175, 120, 260, 26);
		usernameField.setColumns(10);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(175, 160, 260, 26);
		
		JPasswordField passwordField1 = new JPasswordField();
		passwordField1.setBounds(175, 190, 260, 26);

		JButton loginBtn2 = new JButton("Cancel");
		loginBtn2.setBounds(305, 290, 50, 26);
		loginBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				createframe.dispose();

			}
		});
		JButton createAccountBtn = new JButton("Create Account");
		createAccountBtn.setBounds(305, 230, 50, 26);
		createAccountBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println(checkCredentials(usernameField.getText(), passwordField.getPassword()));
				System.out.println("add to users");
				//close frame
				createframe.dispose();
				//close initial login
				loginframe.dispose();

			}
		});

		createframe.getContentPane().add(usernameField);
		createframe.getContentPane().add(passwordField);
		createframe.getContentPane().add(passwordField1);
		createframe.getContentPane().add(loginBtn2);
		createframe.getContentPane().add(createAccountBtn);
		createframe.setVisible(true);
	}

	//checks user db to see if account is valid
	protected boolean checkCredentials(String username, char[] pw) {

		System.out.println("Checking username and password");
//		return (username != null && pw != null);
		
		if (!(dbm.containsUser(username))) {
			System.out.println("User does not exist");
			return false;
		}
		
		String password = new String(pw);
		
		if (!(dbm.retrievePassword(username)).equals(password)) {
			System.out.println("Incorrect password");
			return false;
		}
		
		currentUser = dbm.retrieveUser(username);
		
		return true;
		
		
	}
	
	///pre populates allFoods
	private void testPopulate() {
		
//		for(int i = 0; i < foods.length; i++) {
//			if(foods[i] != null) {
//				listFoodItems.add(foods[i].toFileFormat());
//			}
//		}
	}

	protected void search() {
		System.out.println(searchBar.getText());
	}
}


