import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

class foodItemTest {

	//============================= Constructor Tester

	@Test
	public void testFoodItem() { 
		int id = 2;		//line number in text File
		String name = "Pasta";
		int rank = 3;
		int calories = 1000;
		String recipe = "URL.com";
		String prepTime = "40mins";
		String meal = "meal";
		
		FoodItem foodItem_forNull = new FoodItem(); 
		FoodItem foodItem_forNull2 = new FoodItem(); 
		FoodItem foodItem1 = new FoodItem(id, name, rank, calories, recipe, prepTime, meal);
		FoodItem foodItem2 = new FoodItem(id, name, rank, calories, recipe, prepTime, meal);
		
		assertEquals(foodItem1, foodItem2);
		assertEquals(foodItem_forNull, foodItem_forNull2);
		
	}

	//============================= Getters and Setter Tests

	@Test 
	public void testSetGetId() {
		int id = 200; 
		FoodItem foodItem1 = new FoodItem(); 
		foodItem1.setId(id);

		assertTrue(foodItem1.getId() == id); 

	}

	@Test 
	public void testSetGetName() {
		String name = "Pasta";
		FoodItem foodItem1 = new FoodItem(); 
		foodItem1.setName(name);

		assertTrue(name.equals(foodItem1.getName())); 
	}

	@Test 
	public void testSetGetRank() {
		int rank = 2; 
		FoodItem foodItem1 = new FoodItem(); 
		foodItem1.setRank(rank);

		assertTrue(foodItem1.getRank() == rank); 
	}

	@Test 
	public void testSetGetCalories() {
		int calories = 1000; 
		FoodItem foodItem1 = new FoodItem(); 
		foodItem1.setCalories(calories);

		assertTrue(foodItem1.getCalories() == calories); 

	}

	@Test 
	public void testSetGetRecipe() {
		String recipe = "URL.com";
		FoodItem foodItem1 = new FoodItem(); 
		foodItem1.setRecipe(recipe);

		assertTrue(recipe.equals(foodItem1.getRecipe())); 
	}

	@Test 
	public void testSetGetPrepTime() {
		String prepTime = "40mins";
		FoodItem foodItem1 = new FoodItem(); 
		foodItem1.setPrepTime(prepTime);

		assertTrue(prepTime.equals(foodItem1.getPrepTime())); 
	}

	@Test 
	public void testSetGetMeal() {
		String meal = "meal";
		FoodItem foodItem1 = new FoodItem(); 
		foodItem1.setMeal(meal);

		assertTrue(meal.equals(foodItem1.getMeal())); 
	}
	
	//============================= Methods Tests

	@Test
	public void testToJson() { 
		System.out.println("Testing the toJson Method...");
		int id = 200;
		String name = "Pasta";
		int rank = 2;
		int calories = 1000;
		String recipe = "URL.com";
		String prepTime = "45mins";
		String meal = "mealString";

		FoodItem foodItem1 = new FoodItem();
		foodItem1.setId(id);
		foodItem1.setName(name);
		foodItem1.setRank(rank);
		foodItem1.setCalories(calories);
		foodItem1.setRecipe(recipe);
		foodItem1.setPrepTime(prepTime);
		foodItem1.setMeal(meal);

		String input = "FoodItem" + "\t" + foodItem1.getId() + "\t" 
		+ foodItem1.getName() + "\t" + foodItem1.getRank() 
		+ "\t" + foodItem1.getCalories() + "\t" + foodItem1.getRecipe() 
		+ "\t" + foodItem1.getPrepTime() + "\t" + foodItem1.getMeal() + "\n}\n";

		assertTrue(input.equals(foodItem1.toJSON()));
	}

	@Test
	public void testHashCode() { 
		System.out.println("Testing the hasshCode Method...");
		final int prime = 31;		
		int expectedResult = 1;	
		int foodId = 6000;

		FoodItem foodItem1 = new FoodItem();
		foodItem1.setId(foodId);

		expectedResult = prime * expectedResult + (int) (foodItem1.getId() ^ (foodItem1.getId() >>> 32));

		assertTrue(foodItem1.hashCode() == expectedResult);
	}

	@Test
	public void testEquals() {
		FoodItem foodItem1 = new FoodItem();
		FoodItem foodItem2 = new FoodItem();

		assertTrue(foodItem1.equals(foodItem2));

	}
	
	//============================= 

}
