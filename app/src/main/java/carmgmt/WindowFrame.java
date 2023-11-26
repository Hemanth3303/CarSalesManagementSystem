package carmgmt;

import javax.swing.*;
import java.awt.*;

public class WindowFrame extends JFrame {
	public WindowFrame(int width, int height) {
		setSize(width, height);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
	}
}