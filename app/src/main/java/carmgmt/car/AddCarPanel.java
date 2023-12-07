package carmgmt.car;

import carmgmt.Application;
import carmgmt.CPanel;
import carmgmt.backend.Server;

import javax.swing.*;
import java.awt.*;

public class AddCarPanel extends CPanel {
	private GridBagConstraints gbc;
	private JLabel modelLabel;
	private JLabel yearLabel;
	private JLabel costLabel;
	private JTextField modelField;
	private JTextField yearField;
	private JTextField costField;
	private JLabel heading;
	private JLabel addCarSuccessLabel;
	private JButton addCarBtn, backBtn;
	
	public AddCarPanel(int width, int height) {
		setBounds(0, 0, width, height);
		setBackground(new Color(50, 50, 50, 255));
		
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5); // Setting insets for spacing
		
		heading = new JLabel("Add Car");
		modelLabel = new JLabel("Model:");
		yearLabel = new JLabel("Year:");
		costLabel = new JLabel("Cost: ");
		addCarSuccessLabel = new JLabel("Successfully Added Car");
		modelField = new JTextField();
		yearField = new JTextField();
		costField = new JTextField();
		addCarBtn = new JButton("Add Car");
		backBtn = new JButton("Go Back");
		
		modelLabel.setForeground(Color.WHITE);
		yearLabel.setForeground(Color.WHITE);
		costLabel.setForeground(Color.WHITE);
		heading.setForeground(Color.WHITE);
		addCarSuccessLabel.setForeground(Color.GREEN);
		
		// Add Heading
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(heading, gbc);
		
		// Add Model
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(modelLabel, gbc);
		gbc.gridx = 1;
		modelField.setPreferredSize(new Dimension(150, 25));
		add(modelField, gbc);
		
		// Add year
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(yearLabel, gbc);
		gbc.gridx = 1;
		yearField.setPreferredSize(new Dimension(150, 25));
		add(yearField, gbc);
		
		// Add desc
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(costLabel, gbc);
		gbc.gridx = 1;
		costField.setPreferredSize(new Dimension(150, 25));
		add(costField, gbc);
		
		// Add AddBtn
		gbc.gridx = 1;
		gbc.gridy = 4;
		add(addCarBtn, gbc);
		
		// Add BackBtn
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(backBtn, gbc);
		
		// Add success label
		gbc.gridx = 1;
		gbc.gridy = 5;
		add(addCarSuccessLabel, gbc);
		addCarSuccessLabel.setVisible(false);
		
		addCarBtn.addActionListener(e -> {
			addCarSuccessLabel.setVisible(false);
			
			String model = modelField.getText();
			String year = yearField.getText();
			String cost = costField.getText();
			
			Server.addCar(model, year, cost);
			addCarSuccessLabel.setVisible(true);
		});
		
		backBtn.addActionListener(e -> {
			new ViewCarsPanel(Application.WinWidth, Application.WinHeight).attachTo(parentFrame);
			detachFromParentFrame();
		});
	}
}
