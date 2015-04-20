package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PageList {

	private int currentPage = 0;
	private int rowsPerPage = 0;
	private int currentCount = 0;
	private int maxPage = 0;
	private int maxRowCount = 0;

	private DataBaseConnector dbcon = new DataBaseConnector();
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	

	public PageList(String tableName, int currentPage, int rowsPerPage,String keyword) {
		con = dbcon.initDB();		
		this.currentPage = currentPage;
		this.rowsPerPage = rowsPerPage;
		setCurrentCount();
		
		System.out.println("PageList28-- keyword" + keyword);
		int temp = 0;
		try{
			temp = Integer.valueOf(keyword);
		}catch(Exception e){
			temp = Integer.MIN_VALUE;
		}
		if (temp == Integer.MIN_VALUE){
			if (!keyword.substring(0, 4).equals("star")){
				setMaxRowCount(tableName,keyword);
			}
			else{
				setMaxRowCount1(tableName,keyword);
			}
		}
		else{
			setMaxRowCount2(tableName,keyword);
		}
		

		setMaxPage();
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount() {
		this.currentCount = (currentPage - 1) * rowsPerPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage() {
		if (maxRowCount % rowsPerPage == 0 && maxRowCount!=0) {
			maxPage = maxRowCount / rowsPerPage;
		} else {
			maxPage = maxRowCount / rowsPerPage + 1;
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(Integer rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public int getMaxRowCount() {
		return maxRowCount;
	}

	public void setMaxRowCount(String tableName, String keyword) {
		String findAllSql = "select count(*) as count from " + tableName +" where TITLE like \'%"+ keyword + "%\'";
		
		System.out.println("PageList93--" + findAllSql);
		
		try {
			pstmt = con.prepareStatement(findAllSql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				maxRowCount = rs.getInt("count");
				System.out.println("PageList100--" + maxRowCount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			dbcon.closeDB(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setMaxRowCount1(String tableName, String keyword) {
		keyword = String.valueOf(keyword.charAt(keyword.length()-1));
		String findAllSql = "select count(*) as count from " + tableName +" where Rate>="+ keyword;
		
		System.out.println("PageList117--" + findAllSql);
		
		try {
			pstmt = con.prepareStatement(findAllSql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				maxRowCount = rs.getInt("count");
				System.out.println("PageList124--" + maxRowCount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			dbcon.closeDB(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setMaxRowCount2(String tableName, String keyword) {
		String findAllSql = "select count(*) as count from " + tableName +" where CATEGORY="+ keyword;
		
		System.out.println("PageList140--" + findAllSql);
		
		try {
			pstmt = con.prepareStatement(findAllSql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				maxRowCount = rs.getInt("count");
				System.out.println("PageList147--" + maxRowCount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			dbcon.closeDB(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}