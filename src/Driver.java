import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		PrintWriter fout = null;
		FoodItem nullItem = new FoodItem();
		FoodItem popItem = new FoodItem(001,"bread",1, 11, "just bread", "45min","BLD");
		Appetizer a = new Appetizer();
		Beverage b = new Beverage(0, "b", 1, 0, "www.zuckit.com", "5min", "Lunch", 69);
		//Test dbManager
		dbManager food_dbM = new dbManager();
		
		try { food_dbM.open(new File("testFoodDB.txt")); }
		catch (Exception e){ e.printStackTrace(); }
			
		food_dbM.addItem(nullItem);
		food_dbM.addItem(b);
		food_dbM.addItem(a);
		food_dbM.addItem(popItem);
		food_dbM.close();
		
		
		//Testing FoodItem and Appetizer Classes
		try {  fout = new PrintWriter("itemDB.txt");  }
		catch (Exception e) { System.out.println(e.getMessage());  }
		
		fout.println(nullItem.toJSON());
		fout.println(popItem.toJSON());
		fout.println(a.toJSON());
		
		fout.close();
		
		
//		ArrayList<Long> temp = new ArrayList<>();
//		
//		temp.add(10L);
//		temp.add(20L);
//		
//		
//		User user1 = new User();
//		user1.setLibrary(temp);
//		
//		user1.setUserId(200);
//		user1.setUsername("userboy");
//		user1.setPassword("abgfajsgrpau");
//		
//		System.out.println(user1.toJSON());
		
		
		
		
		
		
		
		
		
	}
}
