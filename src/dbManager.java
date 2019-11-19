import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class dbManager {

	private HashMap<Integer, FoodItem> foods;
	private HashMap<Integer, User> users;
	private Scanner read;
	private final String FOODS = "FoodItems.txt";
	private final String USERS = "Users.txt";

	
	public dbManager() {

		read = null;
		foods = new HashMap<>();
		users = new HashMap<>();
		//populate foods and users
		fetch(0, read);
		fetch(1, read);

	}
	
	public void fetch(int db, Scanner read) {
		
		if(read == null) {
			if(db == 0) {
				try {
					read = new Scanner(new File(FOODS));
				} catch (Exception e) {
					e.printStackTrace();
				}
				//populate hashmap foods
				
				
				
				while(read.hasNextLine()) {
					String[] split = read.nextLine().split("\t");
					foods.put(Integer.parseInt(split[2]), new FoodItem(Integer.parseInt(split[2]), split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), split[4], split[5], split[6]));
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
				}
			}
		}
	}
	
	public void update(int type, PrintWriter pw) {
		
		switch(type) {
			
			case 0:
				
				Iterator foodIterator = foods.entrySet().iterator();
				while (foodIterator.hasNext()) {
					Map.Entry mapElement = (Map.Entry)foodIterator.next();
					pw.println(((FoodItem)mapElement.getValue()).toJSON());
			
			}
				
			case 1:
				
				Iterator userIterator = users.entrySet().iterator();
				while (userIterator.hasNext()) {
					Map.Entry mapElement = (Map.Entry)userIterator.next();
					pw.println(((User)mapElement.getValue()).toJSON());
			
			}
				
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
		if (foods.containsKey(u.getId())) {
			return false;
		}
		foods.put(u.getId(), u);
		return true;
	}
																																									


}