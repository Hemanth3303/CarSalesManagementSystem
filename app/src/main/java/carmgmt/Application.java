package carmgmt;

import carmgmt.backend.Server;
import carmgmt.car.ManageCarsPanel;

public class Application {
	WindowFrame windowFrame;
	public static final int WinWidth = 640, WinHeight = 480;
	
	public Application() {
		Server.init("jdbc:mysql://localhost:3306/carmgmtdb", "root", "admin");
		
		windowFrame = new WindowFrame(WinWidth, WinHeight);
		HomePanel homePanel = new HomePanel(WinWidth, WinHeight);
		
		homePanel.attachTo(windowFrame);
		
		//TODO: remove this
		homePanel.detachFromParentFrame();
		new ManageCarsPanel(WinWidth, WinHeight).attachTo(windowFrame);
	}
}
