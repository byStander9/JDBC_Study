package jdbc_ex1;

//step1 import 
import java.sql.*;

public class Jdbc_ex1 {
	public static void main(String args[]) {
		
		Connection con = null;
		
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
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_db?useSSL=false", "root", "rlsRms5244");
			System.out.println("connection success");
		}
		catch(SQLException e) {
			System.out.println("connection fail");
		}
		//step4 connection close
		finally {
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
