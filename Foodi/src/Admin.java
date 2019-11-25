
public class Admin extends User {
	
	
	public Admin(String username, String password, int userId) {
		super(username, password, userId);
		
	}
	
	@Override
	public String toJSON() {

		String json = "Admin" + "\t" + getId() + "\t" + getUsername() + "\t" +
		getPassword() + "\t" + toString() + "\n";
		
		return json;
		
	}
	
	
}
