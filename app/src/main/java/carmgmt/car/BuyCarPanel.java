package carmgmt.car;

import carmgmt.CPanel;

import java.awt.*;

public class BuyCarPanel extends CPanel {
	private int carId;
	
	public BuyCarPanel(int width, int height, int carId) {
		super(width, height);
		
		this.carId = carId;
		
		gbc.insets = new Insets(5, 5, 5, 5); // Setting insets for spacing
	}
}
