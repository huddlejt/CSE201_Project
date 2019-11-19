import java.util.ArrayList;

public class User {
	private String username;
	private String password;
	private int id;
	private ArrayList<Long> library = new ArrayList<>();
	
	
	
	
	public User (String username, String password, int userId) {
		setUsername(username);
		setPassword(password);
		setId(userId);
	}
	
	public User() {
		this("","",-1);
	}

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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	// =================== equals =============================================
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		if (id != other.id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	// ==================== user library mgmt =================================
	
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
		
		String json = "User" + "\t" + getId() + "\t" + getUsername() + "\t" +
		getPassword() + "\t" + toString() + "\n";
		
		return json;
		
	}
}
