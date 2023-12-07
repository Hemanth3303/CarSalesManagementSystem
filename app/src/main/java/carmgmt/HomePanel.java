package carmgmt;

import carmgmt.login.CustomerLoginPanel;
import carmgmt.login.CustomerRegistrationPanel;
import carmgmt.login.StaffLoginPanel;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("FieldCanBeLocal")
public class HomePanel extends CPanel {
	private final JButton customerLoginBtn;
	private final JButton customerRegistrationBtn;
	private final JButton staffLoginBtn;
	private final JLabel heading;
	
	public HomePanel(int width, int height) {
		super(width, height);
		gbc.insets = new Insets(5, 5, 5, 5); // Setting insets for spacing
		
		heading = new JLabel("Car Sales Management System");
		customerLoginBtn = new JButton("Customer Login");
		customerRegistrationBtn = new JButton("Customer Registration");
		staffLoginBtn = new JButton("Staff Login");
		
		heading.setForeground(Color.WHITE);
		customerLoginBtn.setForeground(Color.BLACK);
		customerRegistrationBtn.setForeground(Color.BLACK);
		staffLoginBtn.setForeground(Color.BLACK);
		
		// Add Heading
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(heading, gbc);
		
		// Adding Customer Registration Btn
		gbc.gridx = 0;
		gbc.gridy = 2;
		customerRegistrationBtn.setPreferredSize(new Dimension(180, 30));
		add(customerRegistrationBtn, gbc);
		
		// Adding Customer Login Btn
		gbc.gridx = 1;
		gbc.gridy = 2;
		customerLoginBtn.setPreferredSize(new Dimension(150, 30));
		add(customerLoginBtn, gbc);
		
		// Adding Staff Login
		gbc.gridx = 2;
		gbc.gridy = 2;
		staffLoginBtn.setPreferredSize(new Dimension(150, 30));
		add(staffLoginBtn, gbc);
		
		customerLoginBtn.addActionListener(e -> {
			new CustomerLoginPanel(Application.WinWidth, Application.WinHeight).attachTo(parentFrame);
			detachFromParentFrame();
		});
		
		customerRegistrationBtn.addActionListener(e -> {
			new CustomerRegistrationPanel(Application.WinWidth, Application.WinHeight).attachTo(parentFrame);
			detachFromParentFrame();
		});
		
		staffLoginBtn.addActionListener(e -> {
			new StaffLoginPanel(Application.WinWidth, Application.WinHeight).attachTo(parentFrame);
			detachFromParentFrame();
		});
	}
}