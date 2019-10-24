
public class Admin extends User {
	
	@Override
	public String toJSON() {
		String json = "Admin" + " { ";
		json += 	"\n\t\"username\" : \"" 	+ getUsername() + "\",";
		json += 	"\n\t\"password\" : \"" 	+ getPassword() + "\",";
		json += 	"\n\t\"id\" : \"" 			+ getUserId() 	+ "\",";
		json += 	"\n\t\"library\" : \"" 		+ toString() 	+ "\",";
		json += 	"\n}";
		return json;
	}
	
	
}
