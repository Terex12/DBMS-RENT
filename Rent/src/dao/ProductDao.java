package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import util.DataBaseConnector;
import bean.ProductInfo;

public class ProductDao{
	private DataBaseConnector dbcon = new DataBaseConnector();
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	//get all products
	public LinkedList<ProductInfo> getAllProduct(){  
		String sql = "select * from product group by cateid order by proname";	//modify
        LinkedList<ProductInfo> list = new LinkedList<ProductInfo>();  
        
        try {  
        	con = dbcon.initDB();
			pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();  
            
            while(rs.next()){  
            	ProductInfo product = new ProductInfo();
            	//will modify
            	product.setProId(rs.getInt("proid"));
            	product.setCateId(rs.getInt("cateid"));
            	product.setPrice(rs.getFloat("price"));
            	product.setProName(rs.getString("proname"));
            	product.setStock(rs.getInt("stock"));
            	product.setRate(rs.getInt("rate"));
            	product.setPic(rs.getString("picpath"));
            	list.add(product);

            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        try {
			dbcon.closeDB(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return list;  
    }   
    
	
	//get specific page products
    public LinkedList<ProductInfo> getAllProductByPage(int  start, int rowPerPage, String keyword){  
    	  LinkedList<ProductInfo> list = new LinkedList<ProductInfo>();  
    	  String sql =  "select * from (select * from product where proname like \'%" + keyword + "%\')" + "where rownum>=" + (start*rowPerPage) + "and rownum<=" + ((start*rowPerPage)+rowPerPage);

           try {  
        	   	con = dbcon.initDB();
   				pstmt = con.prepareStatement(sql);
   				rs = pstmt.executeQuery();  
   				while(rs.next()){  
   					ProductInfo product = new ProductInfo();
   					//will modify
   					product.setProId(rs.getInt("proid"));
   	            	product.setCateId(rs.getInt("cateid"));
   	            	product.setPrice(rs.getFloat("price"));
   	            	product.setProName(rs.getString("proname"));
   	            	product.setStock(rs.getInt("stock"));
   	            	product.setRate(rs.getInt("rate"));
   	            	product.setPic(rs.getString("pic"));
              		list.add(product);
              }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
           
        try {
			dbcon.closeDB(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return list;  
    } 
    
    
    public LinkedList<ProductInfo> getAllProductByPage1(int  start, int rowPerPage, int temp){  
  	  LinkedList<ProductInfo> list = new LinkedList<ProductInfo>();  
  	  String sql =  "select * from (select * from product where cateid=" + temp+ ")" + "where rownum>=" + (start*rowPerPage) + "and rownum<=" + ((start*rowPerPage)+rowPerPage);
         try {  
      	   		con = dbcon.initDB();
 				pstmt = con.prepareStatement(sql);
 				rs = pstmt.executeQuery();  
 				while(rs.next()){  
 					ProductInfo product = new ProductInfo();
 					//will modify
 					product.setProId(rs.getInt("proid"));
 	            	product.setCateId(rs.getInt("cateid"));
 	            	product.setPrice(rs.getFloat("price"));
 	            	product.setProName(rs.getString("proname"));
 	            	product.setStock(rs.getInt("stock"));
 	            	product.setRate(rs.getInt("rate"));
 	            	product.setPic(rs.getString("pic"));
            		list.add(product);
            }  
      } catch (SQLException e) {  
          e.printStackTrace();  
      }  
      try {
			dbcon.closeDB(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
      return list;  
  } 
    
   public int findCateId(String cate){
	   //change 
	   String sql = "select * from cate where catename=?";
	   int id = 0;
       try {  
    		con = dbcon.initDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cate);
			rs = pstmt.executeQuery(); 
			while (rs.next()) {
				id = rs.getInt("cateid");
			}
			
    } catch (SQLException e) {  
        e.printStackTrace();  
    }  
       
    try {
		dbcon.closeDB(con);
	} catch (Exception e) {
		e.printStackTrace();
	}
    return id;  
   }
    
   
   
   
   public boolean changeStock(String proname, int quantity) throws Exception{
	   	DataBaseConnector dbcon = new DataBaseConnector();
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update product set stock=? where proname=?";	//modify
		
		int requantity = findQuantity(proname) - quantity;
		
		System.out.println("PDAO.change" + proname + "q---" + findQuantity(proname));
		System.out.println("PDAO.change~~~" + quantity);
		try {
			con = dbcon.initDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, requantity);
			pstmt.setString(2, proname);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
		try {
			dbcon.closeDB(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
   }
    
   
    //search
    public ProductInfo findById(int proid) throws Exception {
		ProductInfo product = new ProductInfo();
	  	con = dbcon.initDB();
		String sql = "select * from product where proid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, proid);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			product.setProId(rs.getInt("proid"));
        	product.setCateId(rs.getInt("cateid"));
        	product.setPrice(rs.getFloat("price"));
        	product.setProName(rs.getString("proname"));
        	product.setStock(rs.getInt("stock"));
        	product.setRate(rs.getInt("rate"));
        	product.setPic(rs.getString("pic"));
		}
		
		dbcon.closeDB(con);
		
		return product;
	}

  //search
    public ProductInfo findByName(String proname) throws Exception {
    	ProductInfo product = new ProductInfo();
		String sql = "select * from product where proname=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, proname);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			product.setProId(rs.getInt("proid"));
        	product.setCateId(rs.getInt("cateid"));
        	product.setPrice(rs.getFloat("price"));
        	product.setProName(rs.getString("proname"));
        	product.setStock(rs.getInt("stock"));
        	product.setRate(rs.getInt("rate"));
        	product.setPic(rs.getString("pic"));
		}
		
		dbcon.closeDB(con);
		
		return product;
	}

    public int findQuantity(String proname) throws Exception {
    	
		String sql = "select * from product where proname=?";
		int stock = 0;
		con = dbcon.initDB();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, proname);
		rs = pstmt.executeQuery(); 
		while (rs.next()) {
			stock= rs.getInt("stock");
		}
		dbcon.closeDB(con);
		return stock;
		
	}

    
    
	
}