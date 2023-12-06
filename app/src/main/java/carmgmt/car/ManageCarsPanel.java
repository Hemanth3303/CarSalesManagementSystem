package carmgmt.car;

import carmgmt.Application;
import carmgmt.thirdparty.ButtonColumn;
import carmgmt.backend.Server;
import carmgmt.backend.UserType;
import carmgmt.login.StaffLoginPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ManageCarsPanel extends JPanel {
	private JTable carTable;
	private JLabel heading;
	private JFrame parentFrame = null;
	private GridBagConstraints gbc;
	private JButton addCarBtn;
	private JButton logoutBtn;
	private String[][] cars;
	private String[] tableHeadings;
	
	public ManageCarsPanel(int width, int height) {
		setBounds(0, 0, width, height);
		setBackground(new Color(50, 50, 50, 255));
		
		setLayout(new GridBagLayout());
		
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5); // Setting insets for spacing
		
		tableHeadings = new String[]{"ID", "Model", "Year", "Availability", "Description", "Action"};
		cars = new String[][]{
				{"1", "Maruti Suzuki 800", "2000", "available", "Very good car", "Delete"},
				{"2", "Toyota Galnza", "2020", "sold", "Bad good car", "Delete"},
		};
		
		heading = new JLabel("Manage Cars");
		DefaultTableModel model = new DefaultTableModel(cars, tableHeadings);
		carTable = new JTable(model);
		addCarBtn = new JButton("Add Car");
		logoutBtn = new JButton("Logout");
		
		heading.setForeground(Color.WHITE);
		
		Action delete = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int modelRow = Integer.valueOf(e.getActionCommand());
				((DefaultTableModel) table.getModel()).removeRow(modelRow);
			}
		};
		
		ButtonColumn buttonColumn = new ButtonColumn(carTable, delete, 5);
		buttonColumn.setMnemonic(KeyEvent.VK_D);
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
		carTable.setDefaultEditor(Object.class, null);
		add(carTable, gbc);
		
		// Add addCar btn
		gbc.gridx = 3;
		gbc.gridy = 1;
		add(addCarBtn, gbc);
		
		// Add logout btn
		gbc.gridx = 3;
		gbc.gridy = 2;
		add(logoutBtn, gbc);
		
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
