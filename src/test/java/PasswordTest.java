import static org.junit.Assert.*;
import org.junit.Test;

public class PasswordTest {

	@Test
	public void testVerifyPass() {
		Password testPass1 = new Password("password123");
		Password testPass2 = new Password("12345");
		
		assertEquals("The password is accepted", testPass1.verifyPass());
		assertEquals("The password is not accepted\nThe password must be at least 8 characters in length\nThe password must contain at least 1 letter",
				testPass2.verifyPass());
		
	}

}
