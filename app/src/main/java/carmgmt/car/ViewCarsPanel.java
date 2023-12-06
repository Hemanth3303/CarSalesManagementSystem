package carmgmt.car;

import carmgmt.Application;
import carmgmt.backend.Server;
import carmgmt.backend.UserType;
import carmgmt.login.StaffLoginPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCarsPanel extends JPanel {
	private JTable carTable;
	private JLabel heading;
	private JFrame parentFrame = null;
	private GridBagConstraints gbc;
	private JButton addCarBtn;
	private JButton deleteCarBtn;
	private JButton logoutBtn;
	private String[][] cars;
	private String[] tableHeadings;
	
	public ViewCarsPanel(int width, int height) {
		setBounds(0, 0, width, height);
		setBackground(new Color(50, 50, 50, 255));
		
		setLayout(new GridBagLayout());
		
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10); // Setting insets for spacing
		
		tableHeadings = new String[]{"ID", "Model", "Year", "Availability", "Description"};
		cars = new String[][]{
				{"1", "Maruti Suzuki 800", "2000", "available", "Very good car"},
				{"2", "Toyota Galnza", "2020", "sold", "Bad good car"},
		};
		
		heading = new JLabel("Cars");
		carTable = new JTable(cars, tableHeadings);
		addCarBtn = new JButton("Add Car");
		deleteCarBtn = new JButton("Delete Car");
		logoutBtn = new JButton("Logout");
		
		heading.setForeground(Color.WHITE);
		
		// Add Heading
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(heading, gbc);
		
		// Add table header
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(carTable.getTableHeader(), gbc);
		
		// Add table
		gbc.gridx = 0;
		gbc.gridy = 2;
		carTable.setEnabled(false);
		add(carTable, gbc);
		
		// Add logout btn
		gbc.gridx = 3;
		gbc.gridy = 3;
		add(logoutBtn, gbc);
		
		if(Server.getCurrentUserType() == UserType.Staff) {
			// Add addCar btn
			gbc.gridx = 3;
			gbc.gridy = 1;
			add(addCarBtn, gbc);
			
			// Add deleteCar btn
			gbc.gridx = 3;
			gbc.gridy = 2;
			add(deleteCarBtn, gbc);
		}
		
		logoutBtn.addActionListener(e -> {
			Server.disconnect();
			new StaffLoginPanel(Application.WinWidth, Application.WinHeight).attachTo(parentFrame);
			detachFromParentFrame();
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
