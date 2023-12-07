package carmgmt;

import javax.swing.*;
import java.awt.*;

// Customer Panel
public class CPanel extends JPanel {
	protected JFrame parentFrame = null;
	protected GridBagConstraints gbc;
	
	public CPanel(int width, int height) {
		setBounds(0, 0, width, height);
		setBackground(new Color(50, 50, 50, 255));
		
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
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
