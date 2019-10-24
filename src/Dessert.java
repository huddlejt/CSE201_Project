
public class Dessert extends FoodItem {

	//constructors
	public Dessert() {
		super();
	}

	public Dessert( String name, int rank, int calories, String recipe, String prepTime, String meal) {
		super(-1, name, rank, calories, recipe, prepTime, meal);
	}

	//=================== Methods
	@Override
	public String toJSON() {
		String json = "Dessert" + " { ";
		json += "\n\t\"id\" : \"" + getId() + "\",";
		json += "\n\t\"name\" : \"" + getName() + "\",";
		json += "\n\t\"rank\" : \"" + getRank() + "\",";
		json += "\n\t\"calories\" : \"" + getCalories() + "\",";
		json += "\n\t\"recipe\" : \"" + getRecipe() + "\",";
		json += "\n\t\"prepTime\" : \"" + getPrepTime() + "\",";
		json += "\n\t\"meal\" : \"" + getMeal() + "\",";
		json += "\n}";
		return json;
	}
}
