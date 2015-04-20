package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.Random;

import bean.OrderInfo;
import util.DataBaseConnector;


public class OrderDao{
	
	//insert order line
	public boolean insertOrderLine(int orderid, OrderInfo oi) throws Exception {
		DataBaseConnector dbcon = new DataBaseConnector();
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dbcon.initDB();
			pstmt = con.prepareStatement("{call INSERT_ORDERLINE(?,?,?)}");
			pstmt.setInt(1, orderid);	//username
			pstmt.setInt(2, oi.getProid());
			pstmt.setInt(3, oi.getQuantity());
		
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
		dbcon.closeDB(con);
		return true;
	}
	
	
	//insert order
	public int insertOrder(String username) throws Exception {
		DataBaseConnector dbcon = new DataBaseConnector();
		Connection con = null;
		int orderid = 0;
		try {
			con = dbcon.initDB();
			//inser order
			CallableStatement cstmt = con.prepareCall("{call INSERT_ORDER(?,?)}");
			cstmt.setString(1, username);
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.execute();	
		    orderid = cstmt.getInt(2);
		    
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		dbcon.closeDB(con);
		return orderid;
	}
	
	
	public boolean updateOrder(int orderid, float sum) throws Exception {
		DataBaseConnector dbcon = new DataBaseConnector();
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update ORDERS set NETAMOUNT = ? where ORDERID = ?";

		try {
			con = dbcon.initDB();
			//inser order
			pstmt = con.prepareStatement(sql);
			Random random = new Random();
			//if sql change,here need to change
			pstmt.setInt(1, orderid);	//username
			pstmt.setFloat(2, sum);
	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
		dbcon.closeDB(con);
		return true;
	}
	
	
	
	
	
	
	public LinkedList<Integer> queryOrderid(int userid) throws Exception {
		DataBaseConnector dbcon = new DataBaseConnector();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LinkedList<Integer> oidlist = new LinkedList<Integer>();
		String sql = "select * from ORDERS where CUSTOMERID=?";	//modify

		System.out.println("OrderDao102--" + sql);
		
		try {
			con = dbcon.initDB();
			pstmt = con.prepareStatement(sql);
		
			//if sql change,here need to change
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
		
			while (rs.next()) {
				oidlist.add(rs.getInt("ORDERID"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		dbcon.closeDB(con);
		return oidlist;
	}
	
	
	
	
	
	
	
	//------------------------------------------------------------------------
	public LinkedList<OrderInfo> queryOrder(int oid) throws Exception{
		DataBaseConnector dbcon = new DataBaseConnector();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LinkedList<OrderInfo> orderlist = new LinkedList<OrderInfo>();
		String sql = "select * from ORDERLINES o, PRODUCTS p where ORDERID=? and o.PROD_ID = p.PROD_ID";	//modify
		
		System.out.println("OrderDao131--" + sql);

		try {
			con = dbcon.initDB();
			pstmt = con.prepareStatement(sql);
		
			pstmt.setInt(1, oid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderInfo oinfo = new OrderInfo();
				oinfo.setProid(rs.getInt("PROD_ID"));
				oinfo.setPrice(rs.getFloat("PRICE"));
				oinfo.setProname(rs.getString("TITLE"));
				oinfo.setQuantity(rs.getInt("QUANTITY"));
				
				orderlist.add(oinfo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		dbcon.closeDB(con);
		return orderlist;
	}
	
}