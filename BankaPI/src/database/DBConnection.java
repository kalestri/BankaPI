package database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class DBConnection {

	private static Connection conn;
	private static final String LOCK_TIMEOUT_INTERVAL = "5000";
	
	public static Connection getConnection(){
		if(conn == null)
			try{
				open();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		return conn;
	}
	
	
	public static void open() throws ClassNotFoundException, SQLException{
		
		if(conn != null)
			return;
		ResourceBundle bundle = PropertyResourceBundle.getBundle("DBConnection");   //fajl je dbconnection
		String driver = bundle.getString("driver");   //ovo je parametar, ovo driver
		String url = bundle.getString("url");
		String username = bundle.getString("username");
		String password = bundle.getString("password");
		Class.forName(driver);			//ovde se registruje drajver
		conn = DriverManager.getConnection(url, username, password);
		conn.setAutoCommit(false);
		setLockTimeout();
	}
	
	
	public static void setLockTimeout() throws SQLException{
		
		Statement statement = conn.createStatement();
		String cmd = "SET LOCK_TIMEOUT" + LOCK_TIMEOUT_INTERVAL;
		statement.execute(cmd);
	}
	
	public static void close(){
		try{
			if(conn!=null)
				conn.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
