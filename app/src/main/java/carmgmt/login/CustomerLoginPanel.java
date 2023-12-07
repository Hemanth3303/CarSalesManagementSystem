package carmgmt.login;

import carmgmt.Application;
import carmgmt.backend.*;
import carmgmt.car.ViewCarsPanel;

public class CustomerLoginPanel extends LoginPanel {
	public CustomerLoginPanel(int width, int height) {
		super(width, height);
		
		heading.setText("Customer Login");
		
		loginBtn.addActionListener(e -> {
			//TODO: implement this
			String username = usernameField.getText();
			String password = new String(passwordField.getPassword());
			
			Server.validateLogin(username, password, UserType.Customer);
			
			if(Server.getCurrentLoginId() <= 0) {
				loginFailWarning.setVisible(true);
			} else {
				loginFailWarning.setVisible(false);
				new ViewCarsPanel(Application.WinWidth, Application.WinHeight).attachTo(parentFrame);
				detachFromParentFrame();
				System.out.println("Connect as customer with id: " + Server.getCurrentLoginId());
			}
		});
	}
}