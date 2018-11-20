package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "root";
	private static Connection conn = null;

	/*
	 * ����ģʽ������һ��Connection����
	 */
	public static Connection getConnection() throws Exception {
		try {
			Class.forName(Driver);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		if (conn == null) {
			conn = DriverManager.getConnection(url, USER, PASS);
		}
		return conn;
	}
}
