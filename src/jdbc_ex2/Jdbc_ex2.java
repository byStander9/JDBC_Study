package jdbc_ex2;

//step1 import 
import java.sql.*;

public class Jdbc_ex2 {
	public static void main(String args[]) {
		
		Connection con = null;
		Statement stmt = null;
		
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
			//step4-1 createStatement
			stmt = con.createStatement();
			int result = stmt.executeUpdate("insert into user Values ('apple1', 'orange', 'melon', 100);");	
			if(result == 1) {
				System.out.println("Insert success");
			}
			else {
				System.out.println("Insert fail");
			}
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