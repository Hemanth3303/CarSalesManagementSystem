package carmgmt.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("FieldCanBeLocal")
public class UserLoginPanel extends JPanel {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel usernameLabel, passwordLabel, heading;
	private JButton showPasswordBtn;
	private JButton loginBtn;
	
	public UserLoginPanel(int width, int height) {
		setBounds(0, 0, width, height);
		setBackground(new Color(50, 50, 50, 255));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5); // Setting insets for spacing
		
		heading = new JLabel("User Login");
		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		showPasswordBtn = new JButton("Show");
		loginBtn = new JButton("Login");
		
		usernameLabel.setForeground(Color.WHITE);
		passwordLabel.setForeground(Color.WHITE);
		heading.setForeground(Color.WHITE);
		
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
		showPasswordBtn.setPreferredSize(new Dimension(40, 25)); // Adjust the size as needed
		showPasswordBtn.setBorder(new EmptyBorder(0, 0, 0, 0)); // Remove button border
		add(showPasswordBtn, gbc);
		
		// Adding Login Button
		gbc.gridx = 1;
		gbc.gridy = 4;
		add(loginBtn, gbc);
		
		showPasswordBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (passwordField.getEchoChar() == 0) {
					passwordField.setEchoChar('\u2022'); // Hide password
					showPasswordBtn.setText("Show");
				} else {
					passwordField.setEchoChar((char) 0); // Show password
					showPasswordBtn.setText("Hide");
				}
			}
		});
		
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO: implement this
				System.out.println("call login validation function(to be implemented)");
			}
		});
	}
	
	public void attachTo(JFrame frame) {
		frame.add(this);
		setVisible(true);
	}
	
	public void detachFrom(JFrame frame) {
		setVisible(false);
		frame.remove(this);
	}
}