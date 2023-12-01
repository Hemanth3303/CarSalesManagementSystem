package carmgmt;

public class Application {
	WindowFrame windowFrame;
	public static final int WinWidth = 640, WinHeight = 480;
	
	public Application() {
		windowFrame = new WindowFrame(WinWidth, WinHeight);
		HomePanel homePanel = new HomePanel(WinWidth, WinHeight);
		
		homePanel.attachTo(windowFrame);
	}
}
