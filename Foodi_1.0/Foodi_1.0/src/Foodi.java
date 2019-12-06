//import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.List;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JComboBox;

public class Foodi {

	private JFrame frame = new JFrame();

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

	private JComboBox<String> foodTypeBox;


	@SuppressWarnings("unused")
	private User currentUser = null;

	private boolean loggedIn = false;
	private dbManager dbm = new dbManager();

	//TEST VARIABLES
	FoodItem a = new Appetizer(1, "A", 0, 12, "www.zuckit.com", "5min", "Bekfast");
	FoodItem b = new Entree(2, "B", 1, 10, "www.example.com", "8min", "Lunch");
	FoodItem c = new Entree(3, "C", 2, 2400, "www.badprogramming.com", "1hr", "Dinner");
	//	Beverage b1 = new Beverage(007, "water", 1, 0, "", "", "All", 0);
	//	Appetizer a1 = new Appetizer(006, "app", 2, 100, "asdf.com", "2min", "All");
	//	Dessert d1 = new Dessert(8, "cake", 1, 50, "cake", "30min", "All");
	//	Entree e1 = new Entree(010, "entree", 3, 100, "jkl.com", "4min", "All");

	FoodItem[] foods = new FoodItem[dbm.foods.size()];// {a,b,c,b1,a1,d1,e1};

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

		try {
			new Foodi();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FoodiUI window = new FoodiUI();
//					
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the application.
	 */
	public Foodi() {
		initialize();
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
				sort(0);

			}
		});
		foodPanel.add(sortName);

		JButton sortCal = new JButton("Calories");
		sortCal.setBounds(222, -1, 117, 29);
		sortCal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//implement sort

				sort(1);

			}
		});
		foodPanel.add(sortCal);

		sortMeal = new JButton("Meal");
		sortMeal.setBounds(336, -1, 117, 29);
		sortMeal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//implement sort

				sort(2);
			}
		});
		foodPanel.add(sortMeal);

		sortPop = new JButton("Popularity");
		sortPop.setBounds(454, -1, 117, 29);
		sortPop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//implement sort
				sort(3);
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
				else {
					String str = listFoodItems.getSelectedItem();
					String[] parts = str.split("\t");
					currentUser.saveToLibrary(Integer.parseInt(parts[0]));
					
					dbm.foods.get(Integer.parseInt(parts[0])).setRank(dbm.foods.get(Integer.parseInt(parts[0])).getRank() + 1);
					dbm.update(0);
					//update references
					dbm.users.put(currentUser.getUsername(), currentUser);
					dbm.update(1);
					System.out.println("ADDED");
				}

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
		searchBar.setBounds(277, 44, 246, 26);
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
		
		JButton btnFAQ = new JButton("FAQ");
		btnFAQ.setBounds(0, 7, 58, 29);
		frame.getContentPane().add(btnFAQ);
		
		JLabel lblsearch = new JLabel("Search");
		lblsearch.setBounds(235, 49, 41, 16);
		frame.getContentPane().add(lblsearch);
		btnFAQ.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame createframe = new JFrame();
				createframe.setBackground(Color.WHITE);
				createframe.setBounds(frame.getX(), frame.getY(), 650, 400);
				createframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				createframe.getContentPane().setLayout(null);
				createframe.setAlwaysOnTop(true);
				JScrollPane faqs = new JScrollPane(new JTextArea("FAQ’s\n" + 
						"\n" + 
						"How do I create an account?\n" + 
						"\tYou will need to click on the “Create Account” button.\n\tThis will then display the create account window. From there you will\n\tneed to create a username and password. The passwords will need to match in order for your\n\taccount to be correctly created within our system.\n" + 
						"Once I have created an account and I close the window how do I log in?\n" + 
						"\tYou will need to come back and click the “login” button.\n\tThis will open the login window that then will require you to input\n\tyour correct username and password.\n" + 
						"Why can’t I see the homepage?\n" + 
						"\tYou need to login for this to display. Please refer back\n\tto #1 and #2.  \n" + 
						"How do I display a recipe?\n" + 
						"\tYou will want to select the type of food you are looking\n\tby clicking on one of the buttons in the top screen. From there you can\n\tclick on the specific item you are looking for. This will open up a detailed view of the selected item.\n" + 
						"How do I save one of the recipes for later?\n" + 
						"\tOnce you open the detailed view of the item you can click\n\tadd to your library and it will save this recipe within your account\n" + 
						""));
				faqs.setBounds(50, 50, 500, 300);
				JButton exit = new JButton("Exit");
				exit.setBounds(20, 20, 50, 30);
				exit.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						createframe.dispose();
						
					}
				});
				createframe.getContentPane().add(faqs);
				createframe.getContentPane().add(exit);
				createframe.setVisible(true);
				
			}
		});

		searchBar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				search(searchBar.getText());

			}
		});
		foodPanel.setVisible(false);
		displayHome();
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
	}

	protected void createForm() {
		JFrame createframe = new JFrame();
		createframe.setBackground(Color.WHITE);
		createframe.setBounds(frame.getX(), frame.getY(), 650, 400);
		createframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createframe.getContentPane().setLayout(null);
		createframe.setAlwaysOnTop(true);

		JLabel typeLbl = new JLabel("Food Type:");
		typeLbl.setBounds(70, 0, 120, 20);
		
		foodTypeBox = new JComboBox<String>();
		foodTypeBox.setBounds(70, 30, 190, 27);

		foodTypeBox.addItem("Appetizer");
		foodTypeBox.addItem("Beverage");
		foodTypeBox.addItem("Dessert");
		foodTypeBox.addItem("Entree");

		createframe.getContentPane().add(foodTypeBox);
		
		JLabel nameLbl = new JLabel("Food Name:");
		nameLbl.setBounds(70, 60, 120, 20);
		
		itemNameBox = new JTextField();
		itemNameBox.setBounds(70, 84, 181, 26);
		createframe.getContentPane().add(itemNameBox);
		itemNameBox.setColumns(10);

		JLabel calLbl = new JLabel("Calories:");
		calLbl.setBounds(70, 115, 60, 20);
		
		JTextField caloriesBox = new JTextField();
		caloriesBox.setBounds(70, 135, 181, 26);
		createframe.getContentPane().add(caloriesBox);
		caloriesBox.setColumns(10);
		
		JLabel urlLbl = new JLabel("Website:");
		urlLbl.setBounds(70, 160, 60, 20);
		
		JTextField recipeUrlBox = new JTextField();
		recipeUrlBox.setBounds(70, 180, 181, 26);
		createframe.getContentPane().add(recipeUrlBox);
		recipeUrlBox.setColumns(10);
		
		JLabel prepLbl = new JLabel("Preparation Time:");
		prepLbl.setBounds(70, 200, 160, 20);

		JTextField preptimeBox = new JTextField();
		preptimeBox.setBounds(70, 224, 181, 26);
		createframe.getContentPane().add(preptimeBox);
		preptimeBox.setColumns(10);

		JLabel mealLbl = new JLabel("Meal:");
		mealLbl.setBounds(70, 254, 60, 20);
		
		JComboBox<String> mealBox = new JComboBox<String>();
		mealBox.setBounds(70, 274, 190, 27);
		mealBox.addItem("Breakfast");
		mealBox.addItem("Lunch");
		mealBox.addItem("Dinner");
		mealBox.addItem("Any");
		createframe.getContentPane().add(mealBox);

		JButton btnSubmit = new JButton("Create Recipe");
		btnSubmit.setBounds(70, 304, 117, 29);
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String name = itemNameBox.getText();
				int calories = Integer.parseInt(caloriesBox.getText());
				String recipe = recipeUrlBox.getText();
				String prepTime = preptimeBox.getText();
				String meal = (String) mealBox.getSelectedItem();
				String foodType = (String) foodTypeBox.getSelectedItem();


				createFoodItem(foodType, name, calories, recipe, prepTime, meal);
				createframe.dispose();

			}
		});

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(70, 334, 117, 29);
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				createframe.dispose();

			}
		});

		createframe.getContentPane().add(btnCancel);
		createframe.getContentPane().add(btnSubmit);
		createframe.getContentPane().add(mealLbl);
		createframe.getContentPane().add(prepLbl);
		createframe.getContentPane().add(urlLbl);
		createframe.getContentPane().add(calLbl);
		createframe.getContentPane().add(nameLbl);
		createframe.getContentPane().add(typeLbl);

		createframe.setVisible(true);

		//JPanel accountPanel = new JPanel();
		//accountPanel.setBounds(16, 6, 628, 362);
		//createframe.getContentPane().add(accountPanel);
		//accountPanel.setLayout(null);
		//accountPanel.setVisible(false);
	}

	protected void createFoodItem(String type, String name, int calories, String recipe, String prepTime, String meal) {
		
		int id = -1; // << change this

		switch(type) {
		case "Appetizer":
			dbm.addItem(new Appetizer(id ,name, 0, calories, recipe, prepTime, meal));
			break;
		case "Beverage":

			// alcohol content currently set to zero for all foods

			dbm.addItem(new Beverage(id ,name, 0, calories, recipe, prepTime, meal, 0));
			break;


		case "Dessert":
			dbm.addItem(new Dessert(id ,name, 0, calories, recipe, prepTime, meal));
			break;

		case "Entree":
			dbm.addItem(new Entree(id ,name, 0, calories, recipe, prepTime, meal));
			break;
		}

		dbm.update(0);


		// figure out how we determine IDs
		// figure out how to account beverages and alcohol
		//



	}

	protected void displayHome() {
		featuredList.removeAll();
		homePanel.setVisible(true);
		foodPanel.setVisible(false);
		//ensure random value is never null
		int key = (int) (Math.random() * dbm.idCount);
		while (dbm.foods.get(key) == null)
			key = (int) (Math.random() * dbm.idCount);

		featuredList.add(dbm.foods.get(key).display());

	}

	protected void displayAllFoods() {
		if(!(foodPanel.isVisible()) ) {
			foodPanel.setVisible(true);
		}
		listFoodItems.removeAll();
		for(int i = 0; i < dbm.idCount; i++) {
			if(dbm.foods.get(i) != null) {
				listFoodItems.add(dbm.foods.get(i).display());
			}
		}

	}

	protected void displayDesserts() {
		if(!(foodPanel.isVisible()) ) {
			foodPanel.setVisible(true);
		}
		listFoodItems.removeAll();
		for(int i = 0; i < dbm.idCount; i++) {
			FoodItem f = dbm.foods.get(i);
			if(f != null) {
				if(f instanceof Dessert)
					listFoodItems.add(dbm.foods.get(i).display());
			}
		}
	}

	protected void displayBeverages() {
		if(!(foodPanel.isVisible()) ) {
			foodPanel.setVisible(true);
		}
		listFoodItems.removeAll();
		for(int i = 0; i < dbm.idCount; i++) {
			FoodItem f = dbm.foods.get(i);
			if(f != null) {
				if(f instanceof Beverage)
					listFoodItems.add(dbm.foods.get(i).display());
			}
		}
	}

	protected void displayAppetizers() {
		if(!(foodPanel.isVisible()) ) {
			foodPanel.setVisible(true);
		}
		listFoodItems.removeAll();

		for(int i = 0; i < dbm.idCount; i++) {
			FoodItem f = dbm.foods.get(i);
			if(f != null) {
				if(f instanceof Appetizer)
					listFoodItems.add(dbm.foods.get(i).display());
			}
		}
	}

	protected void displayEntrees() {
		if(!(foodPanel.isVisible()) ){
			foodPanel.setVisible(true);
		}
		listFoodItems.removeAll();

		for(int i = 0; i < dbm.idCount; i++) {
			FoodItem f = dbm.foods.get(i);
			if(f != null) {
				if(f instanceof Entree)
					listFoodItems.add(dbm.foods.get(i).display());
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
			accountframe.setBounds(frame.getX(), frame.getY(), 650, 400);
			accountframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			accountframe.getContentPane().setLayout(null);
			accountframe.setAlwaysOnTop(true);

			JPanel accountPanel = new JPanel();
			accountPanel.setBounds(16, 6, 628, 362);
			accountframe.getContentPane().add(accountPanel);
			accountPanel.setLayout(null);
			accountPanel.setVisible(false);

			listSavedFoods = new List();	
			listSavedFoods.setBounds(129, 146, 489, 206);
			//populate List
			ArrayList<Integer> items = new ArrayList<>(currentUser.getLibrary());

			for(int i = 0; i < items.size(); i++) {
				System.out.println(items.get(i));
				int index = items.get(i);
				if(index != -1)
					listSavedFoods.add(dbm.foods.get(index).display());
			}
			accountPanel.add(listSavedFoods);

			JLabel lblSavedItems = new JLabel("Saved Items");
			lblSavedItems.setBounds(195, 102, 86, 16);
			accountPanel.add(lblSavedItems);

			lblAccount.setBounds(9, 6, 77, 16);
			accountPanel.add(lblAccount);

			JButton btnNewButton = new JButton("Change Password");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					newPassword(accountframe);
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

			accountframe.getContentPane().add(accountPanel);
			accountframe.setVisible(true);

		}




	}
	
	protected void newPassword(JFrame loginframe) {
		JFrame createframe = new JFrame();
		createframe.setBackground(Color.WHITE);
		createframe.setBounds(frame.getX(), frame.getY(), 650, 400);
		createframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		createframe.getContentPane().setLayout(null);
		createframe.setAlwaysOnTop(true);
		
		JLabel oldLbl = new JLabel("Old Password");
		oldLbl.setBounds(165, 100, 100, 25);

		JPasswordField oldPasswordField = new JPasswordField();
		oldPasswordField.setBounds(165, 125, 260, 25);
		oldPasswordField.setColumns(10);

		JLabel newLbl = new JLabel("New Password");
		newLbl.setBounds(165, 150, 100, 25);
		
		JTextField passwordField = new JTextField();
		passwordField.setBounds(165, 175, 260, 25);

		JLabel confirmLbl = new JLabel("Confirm Password");
		confirmLbl.setBounds(165, 200, 150, 25);
		
		JTextField passwordField1 = new JTextField();
		passwordField1.setBounds(165, 225, 260, 25);


		JButton loginBtn2 = new JButton("Cancel");
		loginBtn2.setBounds(305, 295, 75, 26);
		loginBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				createframe.dispose();

			}
		});
		JButton createAccountBtn = new JButton("Confirm");
		createAccountBtn.setBounds(305, 265, 75, 26);
		createAccountBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!passwordField.getText().equals(passwordField1.getText())) {
					displayWarning("New passwords do not match!");
					return;
				}
				if(checkCredentials(currentUser.getUsername(), oldPasswordField.getPassword())) {
					currentUser.setPassword(passwordField.getText());
					//update references
					dbm.addItem(currentUser);
					dbm.update(1);
					//close frame
					createframe.dispose();
					//close initial login
					loginframe.dispose();
				}
				else {
					displayWarning("Incorrect password!");
				}

			}
		});

		createframe.getContentPane().add(oldLbl);
		createframe.getContentPane().add(newLbl);
		createframe.getContentPane().add(confirmLbl);
		createframe.getContentPane().add(oldPasswordField);
		createframe.getContentPane().add(passwordField);
		createframe.getContentPane().add(passwordField1);
		createframe.getContentPane().add(loginBtn2);
		createframe.getContentPane().add(createAccountBtn);
		createframe.setVisible(true);
	}

	private void displayWarning(String string) {
		JFrame warningframe = new JFrame();
		warningframe.setBackground(Color.WHITE);
		warningframe.setBounds(frame.getX() + 200, frame.getY() + 100, 200, 200);
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
			currentUser = null;

			return;
		}
		//open new window
		JFrame loginframe = new JFrame();
		loginframe.setBackground(Color.WHITE);
		loginframe.setBounds(frame.getX(), frame.getY(), 650, 400);
		loginframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		loginframe.getContentPane().setLayout(null);
		loginframe.setAlwaysOnTop(true);

		JLabel username = new JLabel("Username");
		username.setBounds(175, 90, 260, 26);
		
		JTextField usernameField = new JTextField();
		usernameField.setBounds(175, 115, 260, 26);
		usernameField.setColumns(10);

		JLabel pswd = new JLabel("Password");
		pswd.setBounds(175, 150, 260, 26);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(175, 175, 260, 26);

		JButton loginBtn2 = new JButton("Login");
		loginBtn2.setBounds(245, 210, 120, 26);
		loginBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkCredentials(usernameField.getText(), passwordField.getPassword())) {
					loggedIn = true;
					loginBtn.setText("Logout");
					lblAccount.setText(usernameField.getText());
					currentUser = dbm.users.get(usernameField.getText());
					loginframe.dispose();
				}
				else {
					displayWarning("Invalid credentials!");
				}

			}
		});
		JButton createAccountBtn = new JButton("Create an Account");
		createAccountBtn.setBounds(230, 240, 150, 26);
		createAccountBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				newAccount(loginframe);

			}
		});
		
		JButton exit = new JButton("Cancel");
		exit.setBounds(245, 275, 120, 26);
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loginframe.dispose();

			}
		});

		loginframe.getContentPane().add(exit);
		loginframe.getContentPane().add(username);
		loginframe.getContentPane().add(pswd);
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
		createframe.setBounds(frame.getX(), frame.getY(), 650, 400);
		createframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		createframe.getContentPane().setLayout(null);
		createframe.setAlwaysOnTop(true);
		
		JLabel username = new JLabel("Username");
		username.setBounds(175, 90, 260, 26);
		
		JTextField usernameField = new JTextField();
		usernameField.setBounds(175, 115, 260, 26);
		usernameField.setColumns(10);

		JLabel newLbl = new JLabel("Password");
		newLbl.setBounds(175, 135, 100, 25);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(175, 150, 260, 26);
		
		JLabel confirmLbl = new JLabel("Confirm Password");
		confirmLbl.setBounds(175, 175, 150, 25);

		JPasswordField passwordField1 = new JPasswordField();
		passwordField1.setBounds(175, 190, 260, 26);

		JButton loginBtn2 = new JButton("Cancel");
		loginBtn2.setBounds(245, 260, 120, 26);
		loginBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				createframe.dispose();

			}
		});
		JButton createAccountBtn = new JButton("Create Account");
		createAccountBtn.setBounds(230, 230, 150, 26);
		createAccountBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(dbm.users.get(usernameField.getText()) == null) {
					String password = new String(passwordField.getPassword());
					dbm.users.put(usernameField.getText(), new User(usernameField.getText(), password));
					dbm.update(1);
				}
				System.out.println(checkCredentials(usernameField.getText(), passwordField.getPassword()));
				System.out.println("added to users");
				//close frame
				createframe.dispose();
				//close initial login
				loginframe.dispose();

			}
		});
		
		createframe.getContentPane().add(newLbl);
		createframe.getContentPane().add(confirmLbl);
		createframe.getContentPane().add(username);
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

	protected void search(String input) {
		if(!(foodPanel.isVisible()) ) {
			foodPanel.setVisible(true);
		}
		listFoodItems.removeAll();
		for(int i = 0; i < dbm.idCount; i++) {
			if(dbm.foods.get(i) != null && dbm.foods.get(i).getName().toLowerCase().contains(input.toLowerCase())) {
				listFoodItems.add(dbm.foods.get(i).display());
			}
		}
	}

	protected void sort(int type) {

		if(!(foodPanel.isVisible()) ) {
			foodPanel.setVisible(true);
		}


		String[] foodlist = listFoodItems.getItems();
		String temp;

		
		switch (type) {
		case 0:
			// Name
			for (int i = 0; i < foodlist.length; i++) {
				for (int j = i + 1; j < foodlist.length; j++) {
					if (foodlist[i].split("\t\t")[1].compareTo(foodlist[j].split("\t\t")[1]) > 0) {
						temp = foodlist[i];
						foodlist[i] = foodlist[j];
						foodlist[j] = temp;
					}
				}
			}
			break;
		case 1:
			// Calories
			for (int i = 0; i < foodlist.length; i++) {
				for (int j = i + 1; j < foodlist.length; j++) {
					int itemA = Integer.parseInt(foodlist[i].split("\t\t")[2].replace("Calories: ", ""));
					int itemB = Integer.parseInt(foodlist[j].split("\t\t")[2].replace("Calories: ", ""));
					if (itemA > itemB) {
						temp = foodlist[i];
						foodlist[i] = foodlist[j];
						foodlist[j] = temp;
					}
				}
			}
			break;
		case 2:
			// Meal
			for (int i = 0; i < foodlist.length; i++) {
				for (int j = i + 1; j < foodlist.length; j++) {
					if (foodlist[i].split("\t\t")[3].compareTo(foodlist[j].split("\t\t")[3]) > 0) {
						temp = foodlist[i];
						foodlist[i] = foodlist[j];
						foodlist[j] = temp;
					}
				}
			}
			break;
		case 3:
			// Popularity
			for (int i = 0; i < foodlist.length; i++) {
				for (int j = i + 1; j < foodlist.length; j++) {
					if (dbm.foods.get(Integer.parseInt(foodlist[i].split("\t\t")[0])).getRank() < dbm.foods.get(Integer.parseInt(foodlist[j].split("\t\t")[0])).getRank()) {
						temp = foodlist[i];
						foodlist[i] = foodlist[j];
						foodlist[j] = temp;
					}
				}
			}
			break;
		}

		listFoodItems.removeAll();

		for (int i = 0; i < foodlist.length; i++) {
			listFoodItems.add(foodlist[i]);
		}
	}

}


