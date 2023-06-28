package jdbc_ex3;

//step1 import 
import java.sql.*;

public class Jdbc_ex3 {
	public static void main(String args[]) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		//SQL sequence
		String sql = "Insert into user values(?, ?, ?, ?);";
		
		//step2 driver load
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("JDBC Driver load success");
		}
		catch(ClassNotFoundException e) {
			System.out.println("JDBC Driver load fail");
		}
		
		//step3 connection
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db?useSSL=false", "root", "rlsRms5244");
			System.out.println("connection success");
			
			//step4-2 prepared statement
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "apple2");
			pstmt.setString(2, "orange");
			pstmt.setString(3, "melon");
			pstmt.setInt(4, 40000);
			
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println("connection fail");
		}
		//step4 connection close
		finally {
			try {
				if(pstmt != null) {
					pstmt.close();
					System.out.println("pstmt close success");
				}
			}
			catch(SQLException e) {
				System.out.println("pstmt close fail");
			}
			try {
				if(con != null) {
					con.close();
					System.out.println("DB connection close success");
				}
			}
			catch(SQLException e) {
				System.out.println("DB connection close exception!!");
			}
		}
	}
}
