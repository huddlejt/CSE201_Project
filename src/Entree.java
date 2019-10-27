
public class Entree extends FoodItem {

	//constructors
	public Entree() {
		super();
	}
	//constructor for form in GUI
	public Entree(String name, int rank, int calories, String recipe, String prepTime, String meal) {
		super(-1, name, rank, calories, recipe, prepTime, meal);
	}

	//=================== Methods
	@Override
	public String toJSON() {
		String json = "Entree" + "\t" + getId() + "\t" + getName() + "\t" + getRank() + "\t" + getCalories() +
				"\t" + getRecipe() + "\t" + getPrepTime() + "\t" + getMeal() + "\n}\n";
		
		return json;
	}
}
