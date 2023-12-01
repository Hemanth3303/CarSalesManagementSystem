package carmgmt.login;

import carmgmt.backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("FieldCanBeLocal")
public class CustomerLoginPanel extends JPanel {
	private JFrame parentFrame = null;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel usernameLabel, passwordLabel, heading, loginFailWarning;
	private JButton showPasswordBtn;
	private JButton loginBtn;
	
	public CustomerLoginPanel(int width, int height) {
		setBounds(0, 0, width, height);
		setBackground(new Color(50, 50, 50, 255));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5); // Setting insets for spacing
		
		heading = new JLabel("User Login");
		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		loginFailWarning = new JLabel("username or password incorrect");
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		showPasswordBtn = new JButton("Show");
		loginBtn = new JButton("Login");
		
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
		showPasswordBtn.setPreferredSize(new Dimension(40, 25)); // Adjust the size as needed
		showPasswordBtn.setBorder(new EmptyBorder(0, 0, 0, 0)); // Remove button border
		add(showPasswordBtn, gbc);
		
		// Adding Login Button
		gbc.gridx = 1;
		gbc.gridy = 4;
		add(loginBtn, gbc);
		
		// Adding LoginFailWarning
		gbc.gridx = 1;
		gbc.gridy = 5;
		add(loginFailWarning, gbc);
		loginFailWarning.setVisible(false);
		
		showPasswordBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(passwordField.getEchoChar() == 0) {
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
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				
				ConnectionManager.validateLogin(username, password, UserType.Customer);
				
				if(ConnectionManager.getCurrentLoginId() == -1) {
					loginFailWarning.setVisible(true);
				} else {
					loginFailWarning.setVisible(false);
					detachFromParentFrame();
					System.out.println("Connect as customer with id: " + ConnectionManager.getCurrentLoginId());
				}
			}
		});
	}
	
	public void attachTo(JFrame frame) {
		parentFrame = frame;
		parentFrame.add(this);
		setVisible(true);
	}
	
	public void detachFromParentFrame() {
		setVisible(false);
		parentFrame.remove(this);
		parentFrame = null;
	}
}