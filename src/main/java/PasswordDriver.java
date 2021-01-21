/** 
 *  PasswordDriver.java
 *  Program description: Read in a password string,
 *  If the password is valid, inform the user that their password is accepted via a graphical message.
 *  If password is not valid, inform the user via a simple graphical message.
 *
 */

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class PasswordDriver {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Password Input Dialog");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String password = JOptionPane.showInputDialog(frame, "Please enter a password to verify:  ", "Simple Password Verification Tool v" + Password.version, JOptionPane.WARNING_MESSAGE);
		Password newPass = new Password();
			
		// Pressing cancel causes program to exit gracefully
		if(!(password == null)) {
			JOptionPane.showMessageDialog(frame, newPass.verifyPass(password));
		} else {
			System.out.println("Exiting.");
			System.exit(0);
		}	
	}
}