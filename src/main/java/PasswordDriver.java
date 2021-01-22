/* 
 *  PasswordDriver.java
 *  Program description: Read in a password string,
 *  If the password is valid, inform the user that their password is accepted via a graphical message.
 *  If password is not valid, inform the user via a simple graphical message.
 *
 *  Iteration 3: Add button to allow the user to select between Admin and Normal user
 *
 */

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordDriver  {

	private static JFrame passwordFrame = new JFrame("Password Input Dialog");
	
	public JFrame buildGUI() {
		// Set up JFrame for password entries
		passwordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	    
		// JFrame for User button selection, add buttons to JFrame	
		JFrame buttonFrame = new JFrame("Admin / User Choice");
		buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonFrame.setLocationRelativeTo(null);
		JButton adminButton = new JButton("Admin");
		JButton normalButton = new JButton("Normal");
		
		// Add buttons to JPanel, and JPanel to JFrame
		JPanel panel = new JPanel();
		panel.add(adminButton);
		panel.add(normalButton);
		buttonFrame.getContentPane().add(panel);		
		buttonFrame.setSize(200, 100);
		buttonFrame.setVisible(true);
		
        // Run verifyAdminPass() on 'Admin' button press
		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guiUserSelect(0); // run verifyAdminPass() function
			}
		});
		
		// Run verifyPass() on 'Normal' button press
		normalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guiUserSelect(1);  // run verifyPass() function
			}
		});
		
		return buttonFrame;
	}
	
	public static void main(String[] args) {
		PasswordDriver newGUI = new PasswordDriver();
		newGUI.buildGUI();
	}
	
	/*
	 * guiUserSelect():  helper method to choose appropriate password checking function for JFrame
	 * 	Options:	
	 * 		guiUserSelect(0); run verifyAdminPass()
	 * 		guiUserSelect(1); run verifyPass() function
	 */
	private static void guiUserSelect(int selection) {
		// Prefix window title with (admin) or (user) depending on selection
		String password = JOptionPane.showInputDialog(passwordFrame, "Please enter a password to verify:  ", 
				((selection == 0) ? "(admin) " : "(user) ") +
				"Password Verification Tool v" + Password.version, JOptionPane.WARNING_MESSAGE);
		Password newPass = new Password(password);
		
		// Pressing cancel causes program to exit gracefully
		if(!(password == null)) {
			
			if (selection == 0) {
				JOptionPane.showMessageDialog(passwordFrame, newPass.verifyAdminPass());
			} else {
				JOptionPane.showMessageDialog(passwordFrame, newPass.verifyPass());
			}
			
		} else {
			System.out.println("Exiting.");
			System.exit(0);
		}
	}
}
