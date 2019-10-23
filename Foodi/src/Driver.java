import java.io.PrintWriter;

public class Driver {

	public static void main(String[] args) {
		PrintWriter fout = null;
		FoodItem nullItem = new FoodItem();
		FoodItem popItem = new FoodItem(001,"bread",1, 11, "just bread", "45min","BLD");
		
		try {  fout = new PrintWriter("itemDB.txt");  }
		catch (Exception e) { System.out.println(e.getMessage());  }
		
		fout.println(nullItem.toJSON());
		fout.println(popItem.toJSON());
		
		fout.close();
	}
}
