import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class dbManager {

	private HashMap<Integer, FoodItem> foods;
	private HashMap<Integer, User> users;
	private Scanner read;
	private final String FOODS = "FoodItems.txt";
	private final String USERS = "Users.txt";
	private PrintWriter pw;


	public dbManager() {


		pw = null;
		read = null;
		foods = new HashMap<>();
		users = new HashMap<>();
		//populate foods and users
		fetch(0);
		fetch(1);

	}

	public void fetch(int db) {
		if(read == null) {
			if(db == 0) {
				try {
					read = new Scanner(new File(FOODS));
				} catch (Exception e) {
					e.printStackTrace();
				}
				//populate hashmap foods

				//read empty line
				if(read.hasNextLine())
					read.nextLine();


				while(read.hasNextLine()) {
					String[] split = read.nextLine().split("\t");
					System.out.println(split.length);
					if(split[0].equals("Appetizer"))
						foods.put(Integer.parseInt(split[1]), new Appetizer(Integer.parseInt(split[1]), split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]), split[5], split[6], split[7]));
					else if(split[0].equals("Beverage"))
						foods.put(Integer.parseInt(split[1]), new Beverage(Integer.parseInt(split[1]), split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]), split[5], split[6], split[7], Integer.parseInt(split[8])));
					else if(split[0].equals("Dessert"))
						foods.put(Integer.parseInt(split[1]), new Dessert(Integer.parseInt(split[1]), split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]), split[5], split[6], split[7]));
					else if(split[0].equals("Entree"))
						foods.put(Integer.parseInt(split[1]), new Appetizer(Integer.parseInt(split[1]), split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]), split[5], split[6], split[7]));
					else {
						System.out.println("None matched");
					}
				}

			}
			else if(db == 1) {
				try {
					read = new Scanner(new File(USERS));
				} catch (Exception e) {
					e.printStackTrace();
				}
				//populate hashmap users
				int line = 0;
				while(read.hasNextLine()) {
					String[] split = read.nextLine().split("\t");
					users.put(line, new User(split[1], split[2], line));


					////////////////////////////
				}
			}

			try {
				read.close();
			}

			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(int type) {

		switch(type) {

		case 0:
			try {
				pw = new PrintWriter(new File(FOODS));
			} catch (Exception e) {
				e.printStackTrace();
			}
			for(int key : foods.keySet()) {
				pw.print(foods.get(key).toFileFormat());
			}
			break;
		case 1:
			try {
				pw = new PrintWriter(new File(USERS));
			} catch (Exception e) {
				e.printStackTrace();
			}
			for(int key : users.keySet()) {
				pw.print(users.get(key).toJSON());
			}
			break;
		}

		try {
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//OVERLOADED
	public boolean addItem(FoodItem f) {
		if (foods.containsKey(f.getId())) {
			return false;
		}
		foods.put(f.getId(), f);
		return true;
	}

	//OVERLOADED
	public boolean addItem(User u) {
		if (users.containsKey(u.getId())) {
			return false;
		}
		users.put(u.getId(), u);
		return true;
	}



}