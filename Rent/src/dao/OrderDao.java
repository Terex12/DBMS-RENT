package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Random;

import bean.OrderInfo;
import util.DataBaseConnector;

public class OrderDao{
	
	//register insert
	public boolean insertOrder(OrderInfo oi) throws Exception {
		DataBaseConnector dbcon = new DataBaseConnector();
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into ORDERS (orderid,username,userid,proname,quantity,price) values(?,?,?,?,?,?)";	//modify

		try {
			con = dbcon.initDB();
			pstmt = con.prepareStatement(sql);
			Random random = new Random();
			//if sql change,here need to change
			pstmt.setInt(1, random.nextInt());
			pstmt.setString(2, oi.getUsename());
			pstmt.setInt(3, oi.getUseid());
			pstmt.setString(4, oi.getProname());
			pstmt.setInt(5, oi.getQuantity());
			pstmt.setFloat(6, oi.getSum());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
		dbcon.closeDB(con);
		return true;
	}
	
	public LinkedList<Integer> queryOrderid(String uname) throws Exception {
		DataBaseConnector dbcon = new DataBaseConnector();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LinkedList<Integer> oidlist = new LinkedList<Integer>();
		String sql = "select distinct orderid from orderinfo where username=?";	//modify

		try {
			con = dbcon.initDB();
			pstmt = con.prepareStatement(sql);
		
			//if sql change,here need to change
			pstmt.setString(1, uname);
			rs = pstmt.executeQuery();
		
			while (rs.next()) {
				oidlist.add(rs.getInt("orderid"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		dbcon.closeDB(con);
		return oidlist;
	}
	
	public LinkedList<OrderInfo> queryOrder(int oid) throws Exception{
		DataBaseConnector dbcon = new DataBaseConnector();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LinkedList<OrderInfo> orderlist = new LinkedList<OrderInfo>();
		String sql = "select * from orderinfo where orderid=?";	//modify

		try {
			con = dbcon.initDB();
			pstmt = con.prepareStatement(sql);
		
			//if sql change,here need to change
			pstmt.setInt(1, oid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderInfo oinfo = new OrderInfo();
				oinfo.setProname(rs.getString("proname"));
				oinfo.setPrice(rs.getFloat("price"));
				oinfo.setQuantity(rs.getInt("quantity"));
				orderlist.add(oinfo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		dbcon.closeDB(con);
		return orderlist;
	}
	
}