package carmgmt.car;

import carmgmt.Application;
import carmgmt.CPanel;
import carmgmt.thirdparty.ButtonColumn;
import carmgmt.backend.Server;
import carmgmt.login.StaffLoginPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ManageCarsPanel extends CPanel {
	private JTable carTable;
	private JLabel heading;
	private JButton addCarBtn;
	private JButton logoutBtn;
	private String[][] cars;
	private String[] tableHeadings;
	
	public ManageCarsPanel(int width, int height) {
		super(width, height);
		gbc.insets = new Insets(5, 5, 5, 5); // Setting insets for spacing
		
		tableHeadings = new String[]{"ID", "Model", "Year", "Availability", "Price", "Action"};
		cars = Server.getCarsToStaff();
		
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
				String strId = (String) table.getModel().getValueAt(0, 0);
				if(strId != null) {
					int id = Integer.parseInt(strId);
					Server.deleteCar(id);
					((DefaultTableModel) table.getModel()).removeRow(modelRow);
				}
			}
		};
		
		new ButtonColumn(carTable, delete, 5);
		
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
		
		addCarBtn.addActionListener(e -> {
			new AddCarPanel(Application.WinWidth, Application.WinHeight).attachTo(parentFrame);
			detachFromParentFrame();
		});
	}
}
