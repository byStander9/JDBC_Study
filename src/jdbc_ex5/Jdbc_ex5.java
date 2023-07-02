import java.sql.*;
public class Jdbc_ex5 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet=null;
		String driverName = "com.mysql.cj.jdbc.Driver";
		String DBName = "jdbc_db";
		String dbURL = "jdbc:mysql://localhost:3306/" + DBName;
		String sslStr="?useSSL=false";
		String sql = "SELECT id FROM user where id like ?";
		String UserId="_"+"pp"+"%";
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(dbURL+sslStr, "root", "rlsRms5244");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, UserId);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) 
			{
				System.out.println(resultSet.getString("id"));
			}
		}
		
		catch (ClassNotFoundException e) {
			System.out.println("JDBC driver load fail !!");
		} catch (SQLException e) {
			System.out.println("DB SQLException fail !!");
			e.printStackTrace();
		}
		finally
		{
			if (resultSet != null) {
				try{
					resultSet.close(); 
				} 
				catch(SQLException ex) {
					System.out.println("DB resultSet close exception !!");
				}
			}
			if (pstmt != null) {
				try{
					pstmt.close(); 
				} 
				catch(SQLException ex) {
					System.out.println("DB pstmt close exception !!");
				}
			}
			if (con != null) {
				try {
					con.close(); 
				}
				catch(SQLException ex) {
					System.out.println("DB connection close exception !!");
				}
			}
		}
	}
}
