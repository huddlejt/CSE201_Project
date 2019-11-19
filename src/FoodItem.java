
public class FoodItem {
	//=================== Variables
	private int id;		//line number in text File
	private String name;
	private int rank;
	private int calories;
	private String recipe; //url
	private String prepTime;
	private String meal;	//breakfast, lunch, dinner
	
	//=================== Constructors
	//set ID to -1 so we can catch errors
	public FoodItem () {
		this(-1, null, 0, 0, null, null, null);
	}
	//Constructor for the Form.  ID will be determined by dbManager class
	public FoodItem (String name, int rank, int calories, String recipe, String prepTime, String meal) {
		this(-1, name, rank, calories, recipe, prepTime, meal);
	}
	//workhorse constructor
	public FoodItem (int id, String name, int rank, int calories, String recipe, String prepTime, String meal) {
		setId(id);
		setName(name);
		setRank(rank);
		setCalories(calories);
		setRecipe(recipe);
		setPrepTime(prepTime);
		setMeal(meal);
	}
	//=================== Methods
	/*  This method returns a JSON structure of the object FoodItem
	 *  @return String
	 */
	public String toJSON() {
		String json = "FoodItem" + "\t" + getId() + "\t" + getName() + "\t" + getRank() + "\t" + getCalories() +
				"\t" + getRecipe() + "\t" + getPrepTime() + "\t" + getMeal() + "\n}\n";
		
		return json;

	}
	//=================== Getter/Setter
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getRank() {
		return rank;
	}
	public int getCalories() {
		return calories;
	}
	public String getRecipe() {
		return recipe;
	}
	public String getPrepTime() {
		return prepTime;
	}
	public String getMeal() {
		return meal;
	}
	public void setId(int id2) {
		this.id = id2;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	
	
	
}
