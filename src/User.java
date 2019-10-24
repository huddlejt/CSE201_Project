import java.util.ArrayList;

public class User {
	private String username;
	private String password;
	private long userId;
	
	private ArrayList<Integer> userLibrary = new ArrayList<>();
	
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
		userLibrary.add(id);
		return true;
	}
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public boolean createItem(FoodItem newFood) {
		
		
		return true;
	}
	
	@Override
	public String toString() {
		String result = "";
		for(int i = 0; i < userLibrary.size(); i++) {
			if(i == userLibrary.size() - 1) {
				result += userLibrary.get(i);
			}
			else {
				result += userLibrary.get(i) + ",";
			}
		}
		return result;
	}
	
	
	public boolean removeFromLibrary(int id) {
		return true;
	}
	
	
	
	public String toJSON() {
		String json = "User" + " { ";
		json += 	"\n\t\"id\" : \"" 			+ getUserId() 	+ "\",";
		json += 	"\n\t\"username\" : \"" 	+ getUsername() + "\",";
		json += 	"\n\t\"password\" : \"" 	+ getPassword() + "\",";
		json += 	"\n\t\"library\" : \"" 		+ toString() 	+ "\",";
		json += 	"\n}";
		return json;
	}
}
