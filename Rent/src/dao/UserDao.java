package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import bean.UserInfo;
import util.DataBaseConnector;

public class UserDao{
	
	//register insert
	public boolean insertUser(UserInfo user) throws Exception {
		DataBaseConnector dbcon = new DataBaseConnector();
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into CUSTOMERS (USERNAME,FIRSTNAME,ADDRESS1,PASSWORD,EMAIL) values(?,?,?,?,?)";	//modify(name)

		try {
			con = dbcon.initDB();
			pstmt = con.prepareStatement(sql);
		
			//if sql change,here need to change
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getAddress());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getEmail());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			//System.out.println("Insert Erro!");
			e.printStackTrace();
			return false;
		} 
		dbcon.closeDB(con);
		return true;
	}

	public LinkedList<UserInfo> findByUsername(String username) throws Exception {
		LinkedList<UserInfo> l = new LinkedList<UserInfo>();
		DataBaseConnector dbcon = new DataBaseConnector();
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from CUSTOMERS where USERNAME = ?";	//modify
		ResultSet rs = null;
		try {
			con = dbcon.initDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserInfo u = new UserInfo();
				u.setUserId(rs.getInt("CUSTOMERID"));
				u.setUserName(rs.getString("USERNAME"));	
				u.setName(rs.getString("FIRSTNAME"));	//name
				u.setPassword(rs.getString("PASSWORD"));
				u.setEmail(rs.getString("EMAIL"));
				u.setAddress(rs.getString("ADDRESS1"));
				l.add(u);

			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} 
		return l;
	}


	public int checkExists(String username) {
		DataBaseConnector dbcon = new DataBaseConnector();
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from CUSTOMERS where USERNAME =?";
		ResultSet rs = null;
		int flag = 0;
		try {
			con = dbcon.initDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				flag = 1;	//Exist
			} else
				flag = 0;	//non
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		try {
			dbcon.closeDB(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

}