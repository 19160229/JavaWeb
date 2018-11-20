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
			//��������
			Class.forName(Driver);
			//�������ݿ�
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
			 * ��̬��SQL���
			 * String sql_1="select * from StuTest";
			 * Statement stmt=con.createStatement();
			 * ****ʹ��Statement����
			 * 1.Boolean stmt.execute(sql); ֻ����sql�Ƿ�ɹ�ִ��
			 * 2.int stmt.executeUpdate(sql); �����ж������յ�Ӱ��
			 * 3.ResultSet stmt.executeQuery(sql); ���ؽ��
			 * 
			 * �ɴ��ε�sql��䣬����ʾռλ����sqlʹ��ǰ����ֵ���׳�SQLException��
			 * *******select * from StuTest where Sno=? and Sname=?
			 * PreparedStatement pstmt=con.PrepareStatement(sql);	���ظ�ʹ��
			 * pstmt.setXXX(int index,XXX ); 	index��1��ʼ����
			 * 		���磺pstmt.setString(1,str);
			 * statement������ִ�з�ʽ
			 * 
			 * �洢���̵ĵ���process(SQL Server)
			 * CallableStatement
			 * 
			*/
			
			String sql="select * from StuTest where Sno=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, 001);
			ResultSet rs=pstmt.executeQuery();
			/*
			 *rs.next()��ʾ��ָ�루�α꣩�Ƶ���һ�� 
			 */
			while(rs.next()) {
				int sno=rs.getInt("Sno");
				String sname=rs.getString("Sname");
				String sdept=rs.getString("Sdept");
				System.out.println("ѧ�ţ�"+sno+"\t������"+sname+"\tרҵ��"+sdept);
			}
			con.close();
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		}
		/*
		 * �������� 	
		 * 		Batch
		 * addBatch(sql);
		 * executeBatch();
		 */
		
	}

}
