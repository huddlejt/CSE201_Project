
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
	public String toFileFormat() {
		String json = "\nEntree" + "\t" + getId() + "\t" + getName() + "\t" + getRank() + "\t" + getCalories() +
				"\t" + getRecipe() + "\t" + getPrepTime() + "\t" + getMeal();
		
		return json;
	}
}
