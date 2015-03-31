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
		String sql = "insert into userinfo (username,name,address,password,email) values(?,?,?,?,?)";	//modify

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
		String sql = "select * from userinfo where username = ?";	//modify
		ResultSet rs = null;
		try {
			con = dbcon.initDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserInfo u = new UserInfo();
				u.setUserId(rs.getInt("userid"));
				u.setUserName(rs.getString("username"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setAddress(rs.getString("address"));
				l.add(u);

			}
			
		}catch (SQLException e) {
			System.out.println("Erro!");
			e.printStackTrace();
		} 
		return l;
	}

	

	public int checkExists(String username) {
		DataBaseConnector dbcon = new DataBaseConnector();
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from userinfo where username =?";
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
			System.out.println("Erro!");
			e.printStackTrace();
		} 
		try {
			dbcon.closeDB(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

}