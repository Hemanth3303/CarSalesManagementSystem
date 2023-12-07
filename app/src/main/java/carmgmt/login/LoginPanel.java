package carmgmt.login;

import carmgmt.Application;
import carmgmt.CPanel;
import carmgmt.HomePanel;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("FieldCanBeLocal")
public abstract class LoginPanel extends CPanel {
	protected JTextField usernameField;
	protected JPasswordField passwordField;
	protected JLabel usernameLabel, passwordLabel, heading, loginFailWarning;
	protected JButton showPasswordBtn;
	protected JButton loginBtn, backBtn;
	protected GridBagConstraints gbc;
	
	public LoginPanel(int width, int height) {
		setBounds(0, 0, width, height);
		setBackground(new Color(50, 50, 50, 255));
		
		setLayout(new GridBagLayout());
		
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5); // Setting insets for spacing
		
		heading = new JLabel("Login");
		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		loginFailWarning = new JLabel("username or password incorrect");
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		showPasswordBtn = new JButton("Show");
		loginBtn = new JButton("Login");
		backBtn = new JButton("Go Back");
		
		usernameLabel.setForeground(Color.WHITE);
		passwordLabel.setForeground(Color.WHITE);
		heading.setForeground(Color.WHITE);
		loginFailWarning.setForeground(Color.RED);
		
		// Add Heading
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(heading, gbc);
		
		// Adding Username Label
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(usernameLabel, gbc);
		
		// Adding Username Field
		gbc.gridx = 1;
		gbc.gridy = 2;
		usernameField.setPreferredSize(new Dimension(150, 25));
		add(usernameField, gbc);
		
		// Adding Password Label
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(passwordLabel, gbc);
		
		// Adding Password Field
		gbc.gridx = 1;
		gbc.gridy = 3;
		passwordField.setPreferredSize(new Dimension(150, 25));
		add(passwordField, gbc);
		
		// Adding Show Password Button
		gbc.gridx = 2;
		gbc.gridy = 3;
		showPasswordBtn.setPreferredSize(new Dimension(40, 25));
		showPasswordBtn.setBorder(new EmptyBorder(0, 0, 0, 0)); // Remove button border
		add(showPasswordBtn, gbc);
		
		// Adding Login Button
		gbc.gridx = 1;
		gbc.gridy = 4;
		add(loginBtn, gbc);
		
		// Adding Go Back Btn
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(backBtn, gbc);
		
		// Adding LoginFailWarning
		gbc.gridx = 1;
		gbc.gridy = 5;
		add(loginFailWarning, gbc);
		loginFailWarning.setVisible(false);
		
		showPasswordBtn.addActionListener(e -> {
			if(passwordField.getEchoChar() == 0) {
				passwordField.setEchoChar('\u2022'); // Hide password with this character •
				showPasswordBtn.setText("Show");
			} else {
				passwordField.setEchoChar((char) 0); // Show password
				showPasswordBtn.setText("Hide");
			}
		});
		
		backBtn.addActionListener(e -> {
			new HomePanel(Application.WinWidth, Application.WinHeight).attachTo(parentFrame);
			detachFromParentFrame();
		});
	}
}