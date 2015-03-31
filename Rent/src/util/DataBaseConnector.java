package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector{
	//initialize database
	public Connection initDB(){
		String dbdriver = "oracle.jdbc.driver.OracleDriver";
		String dburl = "jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl";
		String dbusername = "xux";
		String dbpassword = "Axu11235813";
		Connection con = null;
		
		try {
			Class.forName(dbdriver);
			con = DriverManager.getConnection(dburl, dbusername, dbpassword);
		} catch (ClassNotFoundException e) {
			System.out.println("No Calss Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection Fails");
			e.printStackTrace();
		}
		return con;
	}
	
	//close database
	public void closeDB(Connection con) throws Exception{
		if (con != null && !con.isClosed()){
			con.close();
		}
	}
}