import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		FoodItem nullItem = new FoodItem();
		FoodItem popItem = new FoodItem(001,"bread",1, 11, "just bread", "45min","BLD");
		Appetizer a = new Appetizer();
		Beverage b = new Beverage(0, "b", 1, 0, "www.zuckit.com", "5min", "Lunch", 69);
		User u = new User("A","b",1);
		//Test dbManager
		dbManager dbM = new dbManager();
		dbM.update(0);
		dbM.update(1);
		dbM.addItem(a);
		dbM.addItem(u);
		dbM.update(0);
		dbM.update(1);



	}
}
