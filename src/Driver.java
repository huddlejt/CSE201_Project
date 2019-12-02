
public class Driver {

	public static void main(String[] args) {
		FoodItem nullItem = new Dessert();
		FoodItem popItem = new Appetizer(1,"bread",1, 11, "just bread", "45min","BLD");
		Appetizer a0 = new Appetizer(2,"Food",1, 11, "just food", "45min","BLD");
		Beverage b0 = new Beverage(3, "b", 1, 0, "www.zuckit.com", "5min", "Lunch", 69);
		FoodItem a = new Appetizer(4, "A", 0, 12, "www.zuckit.com", "5min", "Bekfast");
		FoodItem b = new Entree(5, "B", 1, 10, "www.example.com", "8min", "Lunch");
		FoodItem c = new Entree(6, "C", 2, 2400, "www.badprogramming.com", "1hr", "Dinner");
		Beverage b1 = new Beverage(7, "water", 1, 0, "", "", "All", 0);
		Appetizer a1 = new Appetizer(8, "app", 2, 100, "asdf.com", "2min", "All");
		Dessert d1 = new Dessert(9, "cake", 1, 50, "cake", "30min", "All");
		Entree e1 = new Entree(10, "entree", 3, 100, "jkl.com", "4min", "All");
		
		FoodItem[] foods = new FoodItem[] {nullItem, popItem, a0, b0, a,b,c,b1,a1,d1,e1};
		
		User u = new User("Abc","123");
		User u1 = new User("123","abc");
		User u2 = new User("bcd","321");
		User u3 = new User("def","555");
		User u4 = new User("Aaa","aaa");
		User u5 = new User("Acdc","111");
		User u6 = new User("c3po","r2d2");
		
		User[] users = new User[] {u,u1,u2,u3,u4,u5,u6};
		//Test dbManager
		dbManager dbM = new dbManager();
		
		
//		for(int i = 0; i < users.length; i++) {
//			dbM.addItem(users[i]);
//		}
		
//		for(int i = 0; i < foods.length; i++) {
//			dbM.addItem(foods[i]);
//		}
		
		System.out.println(foods[0]);
		System.out.println(users[0]);
		System.out.println(dbM.containsUser("Abc"));
		
		dbM.update(0);
		dbM.update(1);



	}
}
