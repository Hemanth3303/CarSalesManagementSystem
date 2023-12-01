package carmgmt.login;

import carmgmt.backend.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffLoginPanel extends LoginPanel {
	public StaffLoginPanel(int width, int height) {
		super(width, height);
		
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO: implement this
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				
				ConnectionManager.validateLogin(username, password, UserType.Staff);
				
				if(ConnectionManager.getCurrentLoginId() <= -1) {
					loginFailWarning.setVisible(true);
				} else {
					loginFailWarning.setVisible(false);
					detachFromParentFrame();
					System.out.println("Connect as staff with id: " + ConnectionManager.getCurrentLoginId());
				}
			}
		});
	}
}