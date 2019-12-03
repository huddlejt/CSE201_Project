
public class Admin extends User {
	
	
	public Admin(String username, String password) {
		super(username, password);
		
	}
	
	@Override
	public String toJSON() {

		String json = "Admin\t" + getUsername() + "\t" +
		getPassword() + "\t" + toString() + "\n";
		
		return json;
		
	}
	
	
}
