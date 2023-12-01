package carmgmt;

import carmgmt.backend.ConnectionManager;

public class Application {
	WindowFrame windowFrame;
	public static final int WinWidth = 640, WinHeight = 480;
	
	public Application() {
		ConnectionManager.init("jdbc:mysql://localhost:3306/carmgmtdb", "root", "admin");
		
		windowFrame = new WindowFrame(WinWidth, WinHeight);
		HomePanel homePanel = new HomePanel(WinWidth, WinHeight);
		
		homePanel.attachTo(windowFrame);
	}
}
