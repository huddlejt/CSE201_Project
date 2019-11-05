
public class Beverage extends FoodItem {
	
	private int alcoholContent; //store as percent

	
	//=================== Constructors
	public Beverage() {
		super(); //call FoodItem()
		setAlcoholContent(0);
	}
	public Beverage(String name, int rank, int calories, String recipe, String prepTime, String meal, int alcoholContent) {
		super(name, rank, calories, recipe, prepTime, meal); //call parameterized FoodItem constructor
		setAlcoholContent(alcoholContent);
	}
	public Beverage(int id, String name, int rank, int calories, String recipe, String prepTime, String meal, int alcoholContent) {
		super(id, name, rank, calories, recipe, prepTime, meal); //call parameterized FoodItem constructor
		setAlcoholContent(alcoholContent);
	}
	
	//=================== Methods
	@Override
	public String toJSON() {
		
		String json = "Beverage" + "\t" + getId() + "\t" + getName() + "\t" + getRank() + "\t" + getCalories() +
				"\t" + getRecipe() + "\t" + getPrepTime() + "\t" + getMeal() + "\t" + getAlcoholContent() + "\n}\n";
		
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
