package carmgmt;

import carmgmt.core.SQLManager;
import carmgmt.gui.WindowFrame;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application {
	public static void main(String[] args) {
		SQLManager sqlManager=new SQLManager();
		sqlManager.executeSQL("Show tables;");
		
		SwingUtilities.invokeLater(()->new WindowFrame(640, 480));
	}
}