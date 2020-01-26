package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConfig {
	public Connection getConnection() {
		Connection con = null;
		try {
			ResourceBundle resource = ResourceBundle.getBundle("application");
			Class.forName(resource.getString("class"));
			con = DriverManager.getConnection(resource.getString("url"), resource.getString("username"), resource.getString("password"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
