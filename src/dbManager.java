import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class dbManager {
	private HashMap<Integer, FoodItem> foods;
	private HashMap<Integer, User> users;
	private Scanner read;
	private PrintWriter pw;
	private final String FOODS = "FoodItems.txt";
	private final String USERS = "Users.txt";


	public dbManager() {
		read = null;
		pw = null;
		foods = new HashMap<>();
		users = new HashMap<>();
		//populate foods and users
		fetch(0);
		fetch(1);
	}
	/*
	 * @param File
	 * @param String readWrite <<Accepts "r", "rw">>
	 */
	public void fetch(int db) {	
		//check that raf is null, then open file
		if(read == null) {
			if(db == 0) {
				try {
					read = new Scanner(new File(FOODS));
				} catch (Exception e) {
					e.printStackTrace();
				}
				//populate hashmap foods
				int line = 0;
				while(read.hasNextLine()) {
					String[] split = read.nextLine().split("\t");
					foods.put(line, new FoodItem(line, split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), split[4], split[5], split[6]));
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
			
			try {
				read.close();
			} catch (Exception e) {
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
				pw.println(foods.get(key).toJSON());
			}
			break;
		case 1:
			try {
				pw = new PrintWriter(new File(USERS));
			} catch (Exception e) {
				e.printStackTrace();
			}
			for(int key : users.keySet()) {
				pw.println(users.get(key).toJSON());
			}
			break;
		}
		
		try {
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
