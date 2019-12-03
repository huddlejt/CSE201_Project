import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

class userTest {
	//============================= Getters and setters test
	@Test
	public void testSetGetUsername() {
		System.out.println("Testing the setter and getter for username...");
		String input = "desaidn";
		User userTest1 = new User();
		userTest1.setUsername(input);

		assertTrue(input.equals(userTest1.getUsername()));  
	}

	@Test
	public void testSetGetPassword() {
		System.out.println("Testing the setter and getter for passsword...");
		String input = "xyz12";
		User userTest1 = new User();
		userTest1.setPassword(input);

		assertTrue(input.equals(userTest1.getPassword()));
	}


//	@Test
//	public void testSetGetUserId() {
//		System.out.println("Testing the setter and getter for userID...");
//		int input = 6000;
//		User userTest1 = new User();
//		userTest1.setId(input);
//
//		assertTrue(userTest1.getId() == input);
//	}
//	//============================= Method tester
//
//	@Test
//	public void testToJson() { // also tests toString method
//		System.out.println("Testing the toJson Method...");
//		int id = 200;
//		String username = "desaidn";
//		String password = "123";
//
//		User userTest1 = new User();
//		userTest1.setId(id);
//		userTest1.setUsername(username);
//		userTest1.setPassword(password);
//
//		String input = "User" + "\t" + userTest1.getId() + "\t" + userTest1.getUsername() + "\t" +
//				userTest1.getPassword() + "\t" + userTest1.toString() + "\n}\n";
//
//		assertTrue(input.equals(userTest1.toJSON()));
//	}
//
//	@Test
//	public void testHashCode() { 
//		System.out.println("Testing the hasshCode Method...");
//		final int prime = 31;		
//		int expectedResult = 1;	
//		int userId = 6000;
//
//		User userTest1 = new User();
//		userTest1.setId(userId);
//
//		expectedResult = prime * expectedResult + (int) (userTest1.getId() ^ (userTest1.getId() >>> 32));
//
//		assertTrue(userTest1.hashCode() == expectedResult);
//	}

	@Test
	public void testEquals() {
		User userTest1 = new User(); 
		User userTest2 = new User(); 

		assertTrue(userTest1.equals(userTest2));

	}
	
	
	
	//	@Test
	//	public void testsetLibrary() {  
	//		
	//		
	//	}
	
	//	@Test
	//	public void testCreateItem() {
	//		
	//	}
		
	//	@Test 
	//	public void testSaveToLibrary() { 
	//		
	//	}
	//	
	//	@Test
	//	public void testRemoveFromLibrary() {
	//		
	//		
	//	}

	//	@Test
	//	public void testFetchLibrary() {
	//		
	//		
	//	}


}
