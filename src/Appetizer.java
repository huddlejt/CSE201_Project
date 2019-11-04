
public class Appetizer extends FoodItem {

	//constructors
	public Appetizer() {
		super();
	}
	//constructor for form in GUI
	public Appetizer(String name, int rank, int calories, String recipe, String prepTime, String meal) {
		super(name, rank, calories, recipe, prepTime, meal);
	}
	//constructor for form in GUI
		public Appetizer(int id, String name, int rank, int calories, String recipe, String prepTime, String meal) {
			super(id, name, rank, calories, recipe, prepTime, meal);
		}

	//=================== Methods
	@Override
	public String toJSON() {
		String json = "Appetizer" + "\t" + getId() + "\t" + getName() + "\t" + getRank() + "\t" + getCalories() +
				"\t" + getRecipe() + "\t" + getPrepTime() + "\t" + getMeal() + "\n}\n";
		
		return json;
	}
}
