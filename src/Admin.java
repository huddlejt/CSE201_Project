
public class Admin extends User {
	
	
	public Admin(String username, String password) {
		super(username, password);
		
	}
	
	@Override
	public String toJSON() {

		String json = "\nAdmin\t" + getUsername() + "\t" +
		getPassword() + "\t" + toString();
		
		return json;
		
	}
	
	
}
