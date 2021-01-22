import static org.junit.Assert.*;
import org.junit.Test;

public class PasswordTest {

    //	The password must be at least 8 characters in length
    //	The password must contain at least 1 letter
    //	The password must contain at least 1 number
	@Test
	public void testVerifyPass() {
		
		Password testPass1 = new Password("password123");
		assertEquals("The password is accepted", testPass1.verifyPass());
		
		Password testPass2 = new Password("12345");
		assertEquals("The password is not accepted\nThe password must be at least 8 characters in length\nThe password must contain at least 1 letter",
				testPass2.verifyPass());
	}
	
	// Passwords for Admin users must be at least 13 characters in length
    // Passwords for Admin users must contain a special character ('!', '@', '#', '$', '%', '^', '&', or '*')
	@Test public void testVerifyAdminPass() {
		
		
		Password adminPass1 = new Password("password1234!");
		assertEquals("The password is accepted", adminPass1.verifyAdminPass());
		
		Password adminPass2 = new Password("password123");
		assertEquals("The password is not accepted\nPasswords for Admin users must be at least 13 characters in length\nPasswords for Admin users must contain a special character ('!', '@', '#', '$', '%', '^', '&', or '*')", adminPass2.verifyAdminPass());
		
		
	}

}