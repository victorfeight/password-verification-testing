/**
 * Password.java
 * 
 * Title: Simple Password Verification Tool, v.1.0 Files: Password.java
 * PasswordDriver.java README Author: Victor Feight Email: vrfeight@gmail.com
 *
 * Requirements (iteration 1): The password must be at least 8 characters in
 * length The password must contain at least 1 letter The password must contain
 * at least 1 number
 * 
 * Requirements (iteration 2):  informs the user why the password is invalid.
 *
 */

public class Password {

	public static String version = "1.2";

	private String pass;
	public Password(String pass) {
		this.pass = pass;
	}
	
	
	public String verifyPass() {
		int numberCounter = 0;
		int letterCounter = 0;
		for (char c : pass.toCharArray()) {
			if (Character.isDigit(c)) {
				numberCounter++;
			} else if (Character.isLetter(c)) {
				letterCounter++;
			}
		}

		String verifyString = "";
		if (pass.length() >= 8 && numberCounter >= 1 && letterCounter >= 1) {
			verifyString = "The password is accepted";
		} else {
			verifyString = "The password is not accepted";

			if (pass.length() < 8) {
				verifyString += "\nThe password must be at least 8 characters in length";
			}
			if (numberCounter < 1) {
				verifyString += "\nThe password must contain at least 1 number";
			}

			if (letterCounter < 1) {
				verifyString += "\nThe password must contain at least 1 letter";
			}

		}
		return verifyString;
	}

}
