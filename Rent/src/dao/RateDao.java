package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DataBaseConnector;
import bean.OrderInfo;

public class RateDao{
	public boolean insertRate(OrderInfo oi, int rate){
		DataBaseConnector dbcon = new DataBaseConnector();
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into ";	//modify

		try {
			con = dbcon.initDB();
			pstmt = con.prepareStatement(sql);
		
			//if sql change,here need to change
			pstmt.setString(1, );
			pstmt.setString(2, );
			pstmt.setString(3, );
			pstmt.setString(4, );
			pstmt.setString(5, );
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
		dbcon.closeDB(con);
		return true;
	}
}