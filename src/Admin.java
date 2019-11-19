
public class Admin extends User {
	
	@Override
	public String toJSON() {

		String json = "Admin" + "\t" + getUserId() + "\t" + getUsername() + "\t" +
		getPassword() + "\t" + toString() + "\n}\n";
		
		return json;
		
	}
	
	
}
