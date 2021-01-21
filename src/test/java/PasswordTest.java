import static org.junit.Assert.*;
import org.junit.Test;

public class PasswordTest {

	@Test
	public void testVerifyPass() {
		Password testPass = new Password();
		assertEquals("The password is accepted", testPass.verifyPass("password123"));
		assertEquals("The password is not accepted", testPass.verifyPass("12345"));
	}

}
