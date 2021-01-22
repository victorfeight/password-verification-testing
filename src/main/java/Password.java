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
 * Requirements (iteration 3):  processing special character requirement for verifyAdminPass()
 * Requirements (iteration 4): Admin users must now include at least 3 special characters,
 * 				Passwords for regular users must now be at least 10 characters in length
 */

import java.util.regex.Pattern;

public class Password {

	public static final String version = "1.4";

	private String pass;
	public Password(String pass) {
		this.pass = pass;
	}
	
	public String verifyAdminPass() {
		
		// Iteration 4) Updated regex pattern to match 3 or more occurrences of special characters
		Pattern regex = Pattern.compile("[!@#$%^&*]{3,}");
		String verifyString = "";
		if(regex.matcher(pass).find() && pass.length() >= 13) {
			verifyString = "The password is accepted";
		} else {
			verifyString = "The password is not accepted";
			if(pass.length() < 13) {
				verifyString += "\nPasswords for Admin users must be at least 13 characters in length";
			}
			
			if(!(regex.matcher(pass).find())) {
				verifyString += "\nPasswords for Admin users must contain at least 3 special characters ('!', '@', '#', '$', '%', '^', '&', or '*')";
			}	
		}
		
		return verifyString;
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

		// iteration 4) updated to 10 minimum character length
		String verifyString = "";
		if (pass.length() >= 10 && numberCounter >= 1 && letterCounter >= 1) {
			verifyString = "The password is accepted";
		} else {
			verifyString = "The password is not accepted";

			if (pass.length() < 10) {
				verifyString += "\nThe password must be at least 10 characters in length";
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