package mySql_Test;
import java.sql.*;

public class mySql_my {
	
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String USER="root";
	private static final String PASS="root";
	private static final String DBurl="jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con;
		PreparedStatement pstmt;
		try {
			//加载驱动
			Class.forName(Driver);
			//连接数据库
			/*
			 * 1.getConnection(String url) url=jdbc:mysql://localhost/test?user="...."&password="...";
			 * 2.getConnection(String url,Properties prop);
			 * 		Properties prop=new Properties;
			 * 		prop.put("user","...");
			 * 		prop.put("password","...");
			 * !!!!3.getConnection(String url,String user,String password);
			 */
			con=DriverManager.getConnection(DBurl, USER, PASS);
			System.out.println("Connecting Success");
			
			/*
			 * 静态的SQL语句
			 * String sql_1="select * from StuTest";
			 * Statement stmt=con.createStatement();
			 * ****使用Statement对象
			 * 1.Boolean stmt.execute(sql); 只返回sql是否成功执行
			 * 2.int stmt.executeUpdate(sql); 返回有多少行收到影响
			 * 3.ResultSet stmt.executeQuery(sql); 返回结果
			 * 
			 * 可传参的sql语句，？表示占位符，sql使用前不赋值，抛出SQLException，
			 * *******select * from StuTest where Sno=? and Sname=?
			 * PreparedStatement pstmt=con.PrepareStatement(sql);	可重复使用
			 * pstmt.setXXX(int index,XXX ); 	index从1开始计数
			 * 		例如：pstmt.setString(1,str);
			 * statement的三种执行方式
			 * 
			 * 存储过程的调用process(SQL Server)
			 * CallableStatement
			 * 
			*/
			
			String sql="select * from StuTest where Sno=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, 001);
			ResultSet rs=pstmt.executeQuery();
			/*
			 *rs.next()表示将指针（游标）移到下一行 
			 */
			while(rs.next()) {
				int sno=rs.getInt("Sno");
				String sname=rs.getString("Sname");
				String sdept=rs.getString("Sdept");
				System.out.println("学号："+sno+"\t姓名："+sname+"\t专业："+sdept);
			}
			con.close();
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		}
		/*
		 * 批量处理 	
		 * 		Batch
		 * addBatch(sql);
		 * executeBatch();
		 */
		
	}

}
