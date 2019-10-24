
public class Entree extends FoodItem {

	//constructors
	public Entree() {
		super();
	}

	public Entree(int id, String name, int rank, int calories, String recipe, String prepTime, String meal) {
		super(id, name, rank, calories, recipe, prepTime, meal);
	}

	//=================== Methods
	@Override
	public String toJSON() {
		String json = "Entree" + " { ";
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
