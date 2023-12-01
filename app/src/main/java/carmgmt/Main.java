package carmgmt;

import javax.swing.*;

/*
 * Database Name: carmgmtdb
 * Tables: customer, staff, cars, sales
 */

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(Application::new);
	}
}