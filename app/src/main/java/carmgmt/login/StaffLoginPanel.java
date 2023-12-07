package carmgmt.login;

import carmgmt.Application;
import carmgmt.backend.*;
import carmgmt.car.ManageCarsPanel;

public class StaffLoginPanel extends LoginPanel {
	public StaffLoginPanel(int width, int height) {
		super(width, height);
		
		heading.setText("Staff Login");
		
		loginBtn.addActionListener(e -> {
			String username = usernameField.getText();
			String password = new String(passwordField.getPassword());
			
			Server.validateLogin(username, password, UserType.Staff);
			
			if(Server.getCurrentLoginId() <= 0) {
				loginFailWarning.setVisible(true);
			} else {
				loginFailWarning.setVisible(false);
				new ManageCarsPanel(Application.WinWidth, Application.WinHeight).attachTo(parentFrame);
				detachFromParentFrame();
				System.out.println("Connect as staff with id: " + Server.getCurrentLoginId());
			}
		});
	}
}