package carmgmt;

import javax.swing.*;

// Customer Panel
public class CPanel extends JPanel {
	protected JFrame parentFrame = null;
	
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
