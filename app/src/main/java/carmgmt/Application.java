package carmgmt;

import carmgmt.login.CustomerLoginPanel;

public class Application {
	WindowFrame windowFrame;
	
	public Application() {
		windowFrame = new WindowFrame(640, 480);
		CustomerLoginPanel customerLoginPanel = new CustomerLoginPanel(640, 480);
		
		customerLoginPanel.attachTo(windowFrame);
	}
}
