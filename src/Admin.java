
public class Admin extends User {
	
	public Admin(String username, String password, long userId) {
		super(username, password, userId);
		
	}

	@Override
	public String toJSON() {

		String json = "Admin" + "\t" + getUserId() + "\t" + getUsername() + "\t" +
		getPassword() + "\t" + toString() + "\n}\n";
		
		return json;
		
	}
	
	
}
