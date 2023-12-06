package carmgmt.login;

import carmgmt.backend.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffLoginPanel extends LoginPanel {
	public StaffLoginPanel(int width, int height) {
		super(width, height);
		
		heading.setText("Staff Login");
		
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				
				Server.validateLogin(username, password, UserType.Staff);
				
				if(Server.getCurrentLoginId() <= 0) {
					loginFailWarning.setVisible(true);
				} else {
					loginFailWarning.setVisible(false);
					detachFromParentFrame();
					System.out.println("Connect as staff with id: " + Server.getCurrentLoginId());
				}
			}
		});
	}
}