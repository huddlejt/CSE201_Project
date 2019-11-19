
public class FoodItem {
	//=================== Variables
	private long id;		//line number in text File
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
	public FoodItem (long id, String name, int rank, int calories, String recipe, String prepTime, String meal) {
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * auto generated hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * auto generated equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FoodItem))
			return false;
		FoodItem other = (FoodItem) obj;
		if (calories != other.calories)
			return false;
		if (id != other.id)
			return false;
		if (meal == null) {
			if (other.meal != null)
				return false;
		} else if (!meal.equals(other.meal))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (prepTime == null) {
			if (other.prepTime != null)
				return false;
		} else if (!prepTime.equals(other.prepTime))
			return false;
		if (rank != other.rank)
			return false;
		if (recipe == null) {
			if (other.recipe != null)
				return false;
		} else if (!recipe.equals(other.recipe))
			return false;
		return true;
	}
	//=================== Getter/Setter
	public long getId() {
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
	public void setId(long id) {
		this.id = id;
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
