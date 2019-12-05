import java.util.ArrayList;

public class User {
	private String username;
	private String password;
	private ArrayList<Integer> library = new ArrayList<>();
	
	public User (String username, String password) {
		setUsername(username);
		setPassword(password);
	}
	
	public User() {
		this("","");
	}

	public User(String string, String string2, String string3) {
		this(string, string2);
		setLibrary(string3.split(","));
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
	
	public ArrayList<Integer> getLibrary() {
		return library;	
	}
	
	public void setLibrary(ArrayList<Integer> library) {
		this.library = library;
	}
	
	private void setLibrary(String[] split) {
		for(String s : split) {
			try {
				library.add(Integer.parseInt(s));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// =================== equals =============================================
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	// ==================== user library mgmt =================================
	
	public boolean saveToLibrary(int id) {
		if (library.contains(id)) {
			return false;
		}
		
		library.add(id);
		return true;
	}
	
	
	// returns false if food id does not exist in library
	public boolean removeFromLibrary(int id) {
		if (library.contains(id)) {
			library.remove(id);
			return true;
		}
		else {
			return false;
		}
	}

	public String exportLibrary() {
		String result = "";
		if(library.size() == 0)
			return "-1";
		for(int i = 0; i < library.size(); i++) {
			if(i == library.size() - 1) {
				result += library.get(i);
			}
			else {
			if(library.get(i) != null)
				result +=  library.get(i) + ",";
			}
		}
		return result;
	}
	// converts the user's library to a comma separated list
	@Override
	public String toString() {
		return toJSON();
	}
	
	public boolean containsItem(int id) {
		return library.contains(id);
	}
	
	public String toJSON() {
		String json = "\nUser\t" + getUsername() + "\t" + getPassword() + "\t" + exportLibrary();
		return json;
	}
}
