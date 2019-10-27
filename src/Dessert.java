
public class Dessert extends FoodItem {

	//constructors
	public Dessert() {
		super();
	}

	public Dessert(int id, String name, int rank, int calories, String recipe, String prepTime, String meal) {
		super(id, name, rank, calories, recipe, prepTime, meal);
	}

	//=================== Methods
	@Override
	public String toJSON() {
		String json = "Dessert" + "\t" + getId() + "\t" + getName() + "\t" + getRank() + "\t" + getCalories() +
				"\t" + getRecipe() + "\t" + getPrepTime() + "\t" + getMeal() + "\n}\n";
		
		return json;
	}
}
