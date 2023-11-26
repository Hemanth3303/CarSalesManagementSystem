package carmgmt;

import carmgmt.login.UserLoginPanel;

public class Application {
	WindowFrame windowFrame;
	
	public Application() {
		windowFrame = new WindowFrame(640, 480);
		UserLoginPanel userLoginPanel = new UserLoginPanel(640, 480);
		
		userLoginPanel.attachTo(windowFrame);
	}
}
