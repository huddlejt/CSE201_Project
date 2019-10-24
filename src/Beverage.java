
public class Beverage extends FoodItem {
	
	private int alcoholContent; //store as percent

	
	//=================== Constructors
	public Beverage() {
		super(); //call FoodItem()
		setAlcoholContent(0);
	}
	public Beverage(String name, int rank, int calories, String recipe, String prepTime, String meal, int alcoholContent) {
		super(-1, name, rank, calories, recipe, prepTime, meal); //call parameterized FoodItem constructor
		setAlcoholContent(alcoholContent);
	}
	
	//=================== Methods
	@Override
	public String toJSON() {
		String json = "Beverage" + " { ";
		json += "\n\t\"id\" : \"" + getId() + "\",";
		json += "\n\t\"name\" : \"" + getName() + "\",";
		json += "\n\t\"rank\" : \"" + getRank() + "\",";
		json += "\n\t\"calories\" : \"" + getCalories() + "\",";
		json += "\n\t\"recipe\" : \"" + getRecipe() + "\",";
		json += "\n\t\"prepTime\" : \"" + getPrepTime() + "\",";
		json += "\n\t\"meal\" : \"" + getMeal() + "\",";
		json += "\n\t\"alcoholContent\" : \"" + getAlcoholContent() + "\",";
		json += "\n}\n";
		return json;
	}
	
	//=================== Getters/Setters
	public int getAlcoholContent() {
		return alcoholContent;
	}
	public void setAlcoholContent(int alcoholContent) {
		this.alcoholContent = alcoholContent;
	}
}