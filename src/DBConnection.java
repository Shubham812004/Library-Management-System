import java.sql.*;
public class DBConnection {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/librarydb";
		String user = "root";
		String password = "shubham0801";
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void closeConnection(Connection connect, Statement statement) throws SQLException {
		connect.close();
		statement.close();
	}
}
