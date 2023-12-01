package carmgmt;

import carmgmt.backend.*;
import carmgmt.login.CustomerLoginPanel;
import carmgmt.login.StaffLoginPanel;
import org.checkerframework.checker.units.qual.A;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("FieldCanBeLocal")
public class HomePanel extends JPanel {
	private JButton customerLoginBtn;
	private JButton customerRegistrationBtn;
	private JButton staffLoginBtn;
	private JLabel heading;
	private JFrame parentFrame;
	
	public HomePanel(int width, int height) {
		setBounds(0, 0, width, height);
		setBackground(new Color(50, 50, 50, 255));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
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
		
		customerLoginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CustomerLoginPanel(Application.WinWidth, Application.WinHeight).attachTo(parentFrame);
				detachFromParentFrame();
			}
		});
		
		customerRegistrationBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
				//new CustomerRegistrationPanel(Application.WinWidth, Application.WinHeight).attachTo(parentFrame);
				detachFromParentFrame();
			}
		});
		
		staffLoginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new StaffLoginPanel(Application.WinWidth, Application.WinHeight).attachTo(parentFrame);
				detachFromParentFrame();
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