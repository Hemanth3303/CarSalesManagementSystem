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

public class ViewCarsPanel extends CPanel {
	private JTable carTable;
	private JLabel heading;
	private JButton logoutBtn;
	private String[][] cars;
	private String[] tableHeadings;
	
	public ViewCarsPanel(int width, int height) {
		super(width, height);
		
		gbc.insets = new Insets(5, 5, 5, 5); // Setting insets for spacing
		
		tableHeadings = new String[]{"ID", "Model", "Year", "Availability", "Price", "Action"};
		cars = Server.getCarsToUser();
		
		heading = new JLabel("View Cars");
		DefaultTableModel model = new DefaultTableModel(cars, tableHeadings);
		carTable = new JTable(model);
		logoutBtn = new JButton("Logout");
		
		heading.setForeground(Color.WHITE);
		
		Action buy = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int modelRow = Integer.valueOf(e.getActionCommand());
				String strId = (String) table.getModel().getValueAt(0, 0);
				if(strId != null) {
					int id = Integer.parseInt(strId);
					new BuyCarPanel(Application.WinWidth, Application.WinHeight, id).attachTo(parentFrame);
					detachFromParentFrame();
				}
			}
		};
		
		new ButtonColumn(carTable, buy, 5);
		
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
}
