package test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	public static Connection getConnection() {
		Connection cnn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:51060;databaseName=QLYTHUEDIA;encrypt=true;trustServerCertificate=true;";
			String username = "dunglh";
			String pw = "123456";
			cnn = DriverManager.getConnection(url, username, pw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnn;
	}
	
	public static void closeConnection(Connection cnn) {
		if (cnn != null) {
			try {
				cnn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
