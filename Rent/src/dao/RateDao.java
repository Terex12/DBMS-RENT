package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DataBaseConnector;
import bean.OrderInfo;

public class RateDao{
	public boolean insertRate(OrderInfo oi, int rate) throws Exception{
		DataBaseConnector dbcon = new DataBaseConnector();
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dbcon.initDB();
			pstmt = con.prepareStatement("{call update_rate(?,?)}");
		
			//if sql change,here need to change
			pstmt.setInt(1, oi.getProid());
			pstmt.setInt(2, rate);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
		dbcon.closeDB(con);
		return true;
	}
}