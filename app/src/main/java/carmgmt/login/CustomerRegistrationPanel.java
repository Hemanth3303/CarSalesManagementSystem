package carmgmt.login;

import carmgmt.Application;
import carmgmt.HomePanel;
import carmgmt.backend.Server;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CustomerRegistrationPanel extends JPanel {
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel fnameLabel;
	private JLabel lnameLabel;
	private JLabel emailLabel;
	private JLabel phoneLabel;
	private JLabel addressLabel;
	private JFrame parentFrame = null;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField fnameField;
	private JTextField lnameField;
	private JTextField emailField;
	private JTextField phoneField;
	private JTextField addressField;
	private JLabel heading;
	private JLabel registerFailWarning;
	private JLabel registerSuccess;
	private JButton showPasswordBtn;
	private JButton registerBtn, backBtn;
	private GridBagConstraints gbc;
	
	public CustomerRegistrationPanel(int width, int height) {
		setBounds(0, 0, width, height);
		setBackground(new Color(50, 50, 50, 255));
		
		setLayout(new GridBagLayout());
		
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5); // Setting insets for spacing
		
		heading = new JLabel("Customer Registration");
		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		fnameLabel = new JLabel("First Name:");
		lnameLabel = new JLabel("Last Name:");
		emailLabel = new JLabel("Email:");
		phoneLabel = new JLabel("Phone:");
		addressLabel = new JLabel("Address:");
		registerFailWarning = new JLabel("Register Failed");
		registerSuccess = new JLabel("Register Succes");
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		fnameField = new JTextField();
		lnameField = new JTextField();
		emailField = new JTextField();
		phoneField = new JTextField();
		addressField = new JTextField();
		showPasswordBtn = new JButton("Show");
		registerBtn = new JButton("Register");
		backBtn = new JButton("Go Back");
		
		usernameLabel.setForeground(Color.WHITE);
		passwordLabel.setForeground(Color.WHITE);
		fnameLabel.setForeground(Color.WHITE);
		lnameLabel.setForeground(Color.WHITE);
		emailLabel.setForeground(Color.WHITE);
		phoneLabel.setForeground(Color.WHITE);
		addressLabel.setForeground(Color.WHITE);
		heading.setForeground(Color.WHITE);
		registerFailWarning.setForeground(Color.RED);
		registerSuccess.setForeground(Color.GREEN);
		
		// Add Heading
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(heading, gbc);
		
		// Adding Username Label
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(usernameLabel, gbc);
		
		// Adding Username Field
		gbc.gridx = 1;
		gbc.gridy = 1;
		usernameField.setPreferredSize(new Dimension(150, 25));
		add(usernameField, gbc);
		
		// Adding Password Label
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(passwordLabel, gbc);
		
		// Adding Password Field
		gbc.gridx = 1;
		gbc.gridy = 2;
		passwordField.setPreferredSize(new Dimension(150, 25));
		add(passwordField, gbc);
		
		// Adding Show Password Button
		gbc.gridx = 2;
		gbc.gridy = 2;
		showPasswordBtn.setPreferredSize(new Dimension(40, 25));
		showPasswordBtn.setBorder(new EmptyBorder(0, 0, 0, 0)); // Remove button border
		add(showPasswordBtn, gbc);
		
		// Adding Fname Label
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(fnameLabel, gbc);
		
		// Adding Fname Field
		gbc.gridx = 1;
		gbc.gridy = 3;
		fnameField.setPreferredSize(new Dimension(150, 25));
		add(fnameField, gbc);
		
		// Adding Lname Label
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(lnameLabel, gbc);
		
		// Adding Lname Field
		gbc.gridx = 1;
		gbc.gridy = 4;
		lnameField.setPreferredSize(new Dimension(150, 25));
		add(lnameField, gbc);
		
		// Adding Email Label
		gbc.gridx = 0;
		gbc.gridy = 5;
		add(emailLabel, gbc);
		
		// Adding Email Field
		gbc.gridx = 1;
		gbc.gridy = 5;
		emailField.setPreferredSize(new Dimension(150, 25));
		add(emailField, gbc);
		
		// Adding Phone Label
		gbc.gridx = 0;
		gbc.gridy = 6;
		add(phoneLabel, gbc);
		
		// Adding Phone Field
		gbc.gridx = 1;
		gbc.gridy = 6;
		phoneField.setPreferredSize(new Dimension(150, 25));
		add(phoneField, gbc);
		
		// Adding Address Label
		gbc.gridx = 0;
		gbc.gridy = 7;
		add(addressLabel, gbc);
		
		// Adding Address Field
		gbc.gridx = 1;
		gbc.gridy = 7;
		addressField.setPreferredSize(new Dimension(150, 25));
		add(addressField, gbc);
		
		// Adding Register Button
		gbc.gridx = 1;
		gbc.gridy = 8;
		add(registerBtn, gbc);
		
		// Adding Go Back Btn
		gbc.gridx = 0;
		gbc.gridy = 8;
		add(backBtn, gbc);
		
		// Adding Register Fail Warning
		gbc.gridx = 1;
		gbc.gridy = 9;
		add(registerFailWarning, gbc);
		registerFailWarning.setVisible(false);
		
		// Adding Register Success
		gbc.gridx = 1;
		gbc.gridy = 9;
		add(registerSuccess, gbc);
		registerSuccess.setVisible(false);
		
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
		
		registerBtn.addActionListener(e -> {
			registerSuccess.setVisible(false);
			registerFailWarning.setVisible(false);
			
			String username = usernameField.getText();
			String password = new String(passwordField.getPassword());
			String fname = fnameField.getText();
			String lname = lnameField.getText();
			String email = emailField.getText();
			String phone = phoneField.getText();
			String address = addressField.getText();
			
			if(username.isEmpty() || password.isEmpty() || fname.isEmpty() || lname.isEmpty()
					|| email.isEmpty() || phone.isEmpty() || address.isEmpty()) {
				registerFailWarning.setText("Empty fields not allowed");
				registerFailWarning.setVisible(true);
				return;
			}
			
			if(Server.userNameExists(username)) {
				registerFailWarning.setText("Username already exists");
				registerFailWarning.setVisible(true);
			} else {
				Server.registerCustomer(username, password, fname, lname, email, phone, address);
				registerSuccess.setVisible(true);
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