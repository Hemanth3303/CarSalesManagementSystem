package carmgmt.login;

import javax.swing.*;
import java.awt.*;

public class UserLoginPanel extends JPanel {
	public UserLoginPanel(int width, int height) {
		setSize(width, height);
		setBackground(new Color(30, 30, 30, 255));
	}
	
	public void attachTo(JFrame frame) {
		frame.add(this);
		setVisible(true);
	}
	
	public void dettachFrom(JFrame frame) {
		setVisible(false);
		frame.remove(this);
	}
}
