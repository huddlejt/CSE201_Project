import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class dbManager {
	private HashMap<Integer, FoodItem> foods;
	private HashMap<Integer, User> users;
	private long filePointer;
	private Scanner read;
	private final String FOODS = "FoodItems.txt";
	private final String USERS = "Users.txt";


	public dbManager() {
		filePointer = 1;
		read = null;
		foods = new HashMap<>();
		users = new HashMap<>();
		//populate foods and users
		fetch(0, read);
		fetch(1, read);
	}
	/*
	 * @param File
	 * @param String readWrite <<Accepts "r", "rw">>
	 */
	public void fetch(int db, Scanner read) {	
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
		}

	}
	public void update(int type, PrintWriter pw) {

		switch(type) {

		case 0:

			Iterator foodIterator = foods.entrySet().iterator();
			while (foodIterator.hasNext()) {
				Map.Entry mapElement = (Map.Entry)foodIterator.next();
				pw.println((mapElement.getValue()).toJSON());

			}

		case 1:

			Iterator userIterator = users.entrySet().iterator();
			while (userIterator.hasNext()) {
				Map.Entry mapElement = (Map.Entry)userIterator.next();
				pw.println((mapElement.getValue()).toJSON());

			}

		}
	}
	public String readItem(long id) {
		String item = "";
		String line = "";
		//go to item
		try {
			raf.seek(id);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while(!line.equals("}")) {
				line = raf.readLine();
				item += line;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}

	//OVERLOADED
	public boolean addItem(FoodItem fi) {
		//set FoodItem's id to lineNum
		fi.setId(filePointer);
		//check that raf was initialized
		if(raf == null) {
			return false;
		}
		if(filePointer == 1) {
			try {
				raf.writeBytes(fi.toJSON());
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			updateFilePointer();
			return true;
		}
		else {
			//skip necessary lines
			try {
				raf.seek(filePointer);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//write to next available line
			try {
				raf.writeBytes(fi.toJSON());
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			updateFilePointer();
			return true;

		}
	}
	//OVERLOADED
	public boolean addItem(User u) {
		u.setUserId(filePointer);

		if(raf == null) {
			return false;
		}
		if(filePointer == 1) {
			try {
				raf.writeBytes(u.toJSON());
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			updateFilePointer();
			return true;
		}
		else {
			//skip necessary lines
			for(int i = 1; i < filePointer; i++) {
				try{
					raf.readLine();
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			}
			//write to next available line
			try {
				raf.writeBytes(u.toJSON());
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			updateFilePointer();
			return true;

		}
	}


	//OVERLOADED
	private void updateFilePointer() {
		try {
			filePointer = raf.getFilePointer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	//Used to set a User or FoodItem ID
	public long getID() {
		return filePointer;
	}

}
