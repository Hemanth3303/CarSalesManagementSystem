package carmgmt;

import javax.swing.*;

public class WindowFrame extends JFrame {
	public WindowFrame(int width, int height) {
		setBounds(0, 0, width, height);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Car Sales Management System");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
	}
}