package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	public static Connection getConnection() {
		Connection conn = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String user = "c##green";
		String password = "green1234";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB연결 완료");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB연결 실패");
		}

		return conn;
	}

	public static void close(Connection c, PreparedStatement p, ResultSet r) {
		try {
			if (r != null)
				r.close();
			if (p != null)
				p.close();
			if (c != null)
				c.close();
		} catch (Exception e) {

		}
	}

	public static void close(Connection c, PreparedStatement p) {
		try {
			if (p != null)
				p.close();
			if (c != null)
				c.close();
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {
		getConnection();

	}

}
