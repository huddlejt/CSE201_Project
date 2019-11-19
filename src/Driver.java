import java.io.File;
import java.io.PrintWriter;

public class Driver {

	public static void main(String[] args) {
		PrintWriter fout = null;
		FoodItem nullItem = new FoodItem();
		FoodItem popItem = new FoodItem(001,"bread",1, 11, "just bread", "45min","BLD");
		Appetizer a = new Appetizer();
		Beverage b = new Beverage("b", 1, 0, "www.zuckit.com", "5min", "Lunch", 69);
		//Test dbManager
		dbManager food_dbM = new dbManager();
		food_dbM.update(0);
		
		

	}
}
