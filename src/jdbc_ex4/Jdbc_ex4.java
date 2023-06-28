package jdbc_ex4;

//step1 import 
import java.sql.*;

public class Jdbc_ex4 {
	public static void main(String args[]) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into book values(?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_db?useSSL=false", "root", "rlsRms5244");
			System.out.println("connection success");
			
			pstmt = con.prepareStatement(sql);
			for(int i = 1; i < 5; i++) {
				pstmt.setString(1, "a" + i);
				pstmt.setString(2, "b" + i);
				pstmt.setString(3, "c" + i);
				pstmt.setInt(4, i*10);
				pstmt.executeUpdate();
			}
			
		}
		catch(SQLException e) {
			System.out.println("exception occured");
		}
		finally {
			try {
				if(pstmt != null) {
					pstmt.close();
					System.out.println("pstmt close success");
				}
			}
			catch(SQLException e){
				System.out.println("pstmt close fail");
			}
			
			try {
				if(con != null) {
					con.close();
					System.out.println("connection close success");
				}
			}
			catch(SQLException e) {
				System.out.println("connection close fail!!");
			}
		}
		
	}
}
