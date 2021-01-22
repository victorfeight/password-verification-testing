
/** 
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
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGUI {

	public static final String title = "Password Verification Tool v" + Password.version;

	/*
	 * Swing Components: JFrame for Password Input, JButton components, JFrame for
	 * User button selection, JPanel
	 */
	private JFrame passwordFrame = new JFrame("Password Input Dialog");
	private JButton adminButton = new JButton("Admin");
	private JButton normalButton = new JButton("Normal");
	private JFrame buttonFrame = new JFrame(title);
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Select between Admin password verify and Normal user verifier");
		
	public void buildFrame() {
		// Close JFrame on [x], Set up JFrame location
		passwordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonFrame.setLocationRelativeTo(null);

		// Add JLabel to JPanel
		panel.add(label);

		// Add buttons to JPanel
		panel.add(adminButton);
		panel.add(normalButton);

		// Add JPanel to buttonFrame
		buttonFrame.getContentPane().add(panel);
		buttonFrame.setSize(400, 100);
		buttonFrame.setVisible(true);
		
		// Add Event listener to buttons
		ButtonListener bl = new ButtonListener();
		adminButton.addActionListener(bl);
		normalButton.addActionListener(bl);
	}

	
	/*
	 *  guiUserSelect(): helper method to choose appropriate 
	 *  password checking function for JFrame Options: 
	 *    guiUserSelect(0); run verifyAdminPass()
	 *    guiUserSelect(1); run verifyPass() function
	 */
	 void guiUserSelect(int selection) {
		// Prefix window title with (admin) or (user) depending on selection
		String password = JOptionPane.showInputDialog(passwordFrame, "Please enter a password to verify:  ",
				((selection == 0) ? "(admin) " : "(user) ") + "Password Verification Tool v" + Password.version,
				JOptionPane.WARNING_MESSAGE);
		Password newPass = new Password(password);
		
		// Pressing cancel causes program to exit gracefully
		if (!(password == null)) {

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

	/*
	 * Event listener has two possible inputs
	 * guiUserSelect(0): admin button pressed, run verifyAdminPass() function run
	 * guiUserSelect(1): normal button pressed, run verifyPass() function
	 */
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == adminButton) {
				guiUserSelect(0);
			} else if (e.getSource() == normalButton) {
				guiUserSelect(1); 
			}
		}

	}
}