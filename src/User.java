import java.util.ArrayList;

public class User {
	private String username;
	private String password;
	private long userId;
	
	
	
	
	private ArrayList<Long> library = new ArrayList<>();
	
	// =================== Getters/Setters =======================================
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
	
	public void setLibrary(ArrayList<Long> library) {
		this.library = library;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
	// ==================== user library mgmt =================================
	
	
	public boolean createItem(FoodItem newFood) {
		
		
		
		return true;
	}
	
	public boolean saveToLibrary(long id) {
		if (library.contains(id)) {
			return false;
		}
		
		library.add(id);
		return true;
	}
	
	
	// returns false if food id does not exist in library
	public boolean removeFromLibrary(long id) {
		if (library.contains(id)) {
			library.remove(id);
			return true;
		}
		else {
			return false;
		}
	}
	
	// Temporary way of storing an ArrayList of your library items so that 
	// you can simply parse to display all your items
	// Return type will eventually become ArrayList<FoodItem> instead of 
	// ArrayList<String> to have easy access to all the items in your personal
	// library
	public ArrayList<String> fetchLibrary(ArrayList<Long> library){
		
		ArrayList<String> result = new ArrayList<>();
//		for(int i = 0; i < library.size(); i++) {
//			result.add(readItem(library.get(i)));
//		}
		return result;
	}
	
	
	
	
	
	// converts the user's library to a comma separated list
	@Override
	public String toString() {
		String result = "";
		for(int i = 0; i < library.size(); i++) {
			if(i == library.size() - 1) {
				result += library.get(i);
			}
			else {
				result += library.get(i) + ",";
			}
		}
		return result;
	}
	
	public String toJSON() {
		
		String json = "User" + "\t" + getUserId() + "\t" + getUsername() + "\t" +
		getPassword() + "\t" + toString() + "\n}\n";
		
		return json;
		
	}
	// =================== equals =============================================		


 	@Override		
	public int hashCode() {		
		final int prime = 31;		
		int result = 1;		
		result = prime * result + (int) (userId ^ (userId >>> 32));		
		return result;		
	}		

 	@Override		
	public boolean equals(Object obj) {		
		if (this == obj)		
			return true;		
		if (obj == null)		
			return false;		
		if (getClass() != obj.getClass())		
			return false;		
		User other = (User) obj;		
		if (userId != other.userId)		
			return false;		
		if (username == null) {		
			if (other.username != null)		
				return false;		
		} else if (!username.equals(other.username))		
			return false;		
		return true;		
	}
}
