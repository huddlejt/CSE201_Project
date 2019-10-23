import java.util.ArrayList;

public abstract class User {
	private String username;
	private String password;
	private int userId;
	
	private ArrayList<Integer> savedItems = new ArrayList<>();
	
	//=============== Getters/Setters
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean saveItem(int id) {
		savedItems.add(id);
		return true;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	//
	public boolean createItem(FoodItem newFood) {
		newFood.setId(dbManager.getID());
		
		return true;
	}
}
