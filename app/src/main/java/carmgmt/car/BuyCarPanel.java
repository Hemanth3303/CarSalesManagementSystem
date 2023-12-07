package carmgmt.car;

import carmgmt.Application;
import carmgmt.CPanel;
import carmgmt.backend.Server;

import javax.swing.*;
import java.awt.*;

public class BuyCarPanel extends CPanel {
	private int carId;
	private JLabel questionLabel;
	private JButton buyBtn;
	private JButton goBackBtn;
	
	public BuyCarPanel(int width, int height, int carId) {
		super(width, height);
		
		this.carId = carId;
		
		gbc.insets = new Insets(5, 5, 5, 5); // Setting insets for spacing
		
		CarProps props = Server.getCarProps(this.carId);
		
		questionLabel = new JLabel();
		buyBtn = new JButton("Yes, Buy!!!");
		goBackBtn = new JButton("No, Go Back");
		
		String question = "Are you sure you want to buy a " + props.model + "(" + props.year + " model) for " + props.cost + "?";
		
		questionLabel.setForeground(Color.WHITE);
		questionLabel.setText(question);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(questionLabel, gbc);
		
		gbc.gridy = 1;
		gbc.gridx = 1;
		add(goBackBtn, gbc);
		gbc.gridx = 2;
		add(buyBtn, gbc);
		
		goBackBtn.addActionListener(e -> {
			new ViewCarsPanel(Application.WinWidth, Application.WinHeight).attachTo(parentFrame);
			detachFromParentFrame();
		});
		
		buyBtn.addActionListener(e -> {
			Server.buyCar(this.carId, props.cost);
			new ViewCarsPanel(Application.WinWidth, Application.WinHeight).attachTo(parentFrame);
			detachFromParentFrame();
		});
	}
}
