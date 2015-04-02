package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import bean.OrderInfo;
import util.DataBaseConnector;

public class OrderDao{
	
	//register insert
	public boolean insertOrder(OrderInfo oi) throws Exception {
		DataBaseConnector dbcon = new DataBaseConnector();
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into order (username,userid,proname,quantity,price) values(?,?,?,?,?)";	//modify

		try {
			con = dbcon.initDB();
			pstmt = con.prepareStatement(sql);
		
			//if sql change,here need to change
			pstmt.setString(1, oi.getUsename());
			pstmt.setInt(2, oi.getUseid());
			pstmt.setString(3, oi.getProname());
			pstmt.setInt(4, oi.getQuantity());
			pstmt.setFloat(5, oi.getPrice());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			//System.out.println("Insert Erro!");
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
		String sql = "select distinct oid from order where uname=?";	//modify

		try {
			con = dbcon.initDB();
			pstmt = con.prepareStatement(sql);
		
			//if sql change,here need to change
			pstmt.setString(1, uname);
			pstmt.executeUpdate();
			
			while (rs.next()) {
				oidlist.add(rs.getInt("oid"));
			}
			
		} catch (SQLException e) {
			//System.out.println("Insert Erro!");
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
		String sql = "select * from order where oid=?";	//modify

		try {
			con = dbcon.initDB();
			pstmt = con.prepareStatement(sql);
		
			//if sql change,here need to change
			pstmt.setInt(1, oid);
			pstmt.executeUpdate();
			
			while (rs.next()) {
				OrderInfo oinfo = new OrderInfo();
				oinfo.setProname(rs.getString("proname"));
				oinfo.setPrice(rs.getFloat("price"));
				oinfo.setQuantity(rs.getInt("quantity"));
				orderlist.add(oinfo);
			}
			
		} catch (SQLException e) {
			//System.out.println("Insert Erro!");
			e.printStackTrace();
		} 
		dbcon.closeDB(con);
		return orderlist;
	}
	
}