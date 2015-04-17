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
		String sql = "select * from PRODUCTS as p, INVENTORY as i where p.PROD_ID = i.PROD_ID group by CATEGORY order by TITLE";	//modify
        LinkedList<ProductInfo> list = new LinkedList<ProductInfo>();  
        
        try {  
        	con = dbcon.initDB();
			pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();  
            
            while(rs.next()){  
            	ProductInfo product = new ProductInfo();
            	//will modify
            	product.setProId(rs.getInt("PROD_ID"));
            	product.setCateId(rs.getInt("CATEGORY"));
            	product.setPrice(rs.getFloat("PRICE"));
            	product.setProName(rs.getString("TITLE"));
            	product.setStock(rs.getInt("QUAN_IN_STOCK"));
            	product.setRate(rs.getInt("RATE"));
            	product.setPic(rs.getString("PIC"));
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
    public LinkedList<ProductInfo> getAllProductByPage(int start, int rowPerPage, String keyword){  
    	  LinkedList<ProductInfo> list = new LinkedList<ProductInfo>(); 
    	  
    	  String sql = "select * from (select * from (select p.*, rownum r from PRODUCTS p where p.TITLE like \'%"+ keyword + "%\')" + "where r>=" + start + "and r<=" + (start+rowPerPage) + ") pr, INVENTORY i where pr.PROD_ID = i.PROD_ID";
    	  
    	  
    	  //String sql =  "select * from (select *, rownum r from PRODUCTS p, INVENTORY i where p.PROD_ID = i.PROD_ID and p.TITLE like \'%" + keyword + "%\')" + "where r>=" + (start*rowPerPage) + "and r<=" + ((start*rowPerPage)+rowPerPage);
    	  
    	  System.out.println("ProductDao60--"+ sql);
    	  
    	  
           try {  
        	   	con = dbcon.initDB();
   				pstmt = con.prepareStatement(sql);
   				rs = pstmt.executeQuery();  
   				while(rs.next()){  
   					ProductInfo product = new ProductInfo();
   					//will modify
   					product.setProId(rs.getInt("PROD_ID"));
   	            	product.setCateId(rs.getInt("CATEGORY"));
   	            	product.setPrice(rs.getFloat("PRICE"));
   	            	product.setProName(rs.getString("TITLE"));
   	            	product.setStock(rs.getInt("QUAN_IN_STOCK"));
   	            	product.setRate(rs.getInt("RATE"));
   	            	product.setPic(rs.getString("PIC"));
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
    
    
    public LinkedList<ProductInfo> getAllProductByPage1(int  start, int rowPerPage, int temp){  
  	  LinkedList<ProductInfo> list = new LinkedList<ProductInfo>();  
	  String sql = "select * from (select * from (select p.*, rownum r from PRODUCTS p where p.CATEGORY="+ temp + ")" + "where r>=" + start + "and r<=" + (start+rowPerPage) + ") pr, INVENTORY i where pr.PROD_ID = i.PROD_ID";
	  System.out.println("ProductDao99--"+ sql);   
	  try {  
      	   		con = dbcon.initDB();
 				pstmt = con.prepareStatement(sql);
 				rs = pstmt.executeQuery();  
 				while(rs.next()){  
 					ProductInfo product = new ProductInfo();
 					//will modify
 					product.setProId(rs.getInt("PROD_ID"));
   	            	product.setCateId(rs.getInt("CATEGORY"));
   	            	product.setPrice(rs.getFloat("PRICE"));
   	            	product.setProName(rs.getString("TITLE"));
   	            	product.setStock(rs.getInt("QUAN_IN_STOCK"));
   	            	product.setRate(rs.getInt("RATE"));
   	            	product.setPic(rs.getString("PIC"));
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
    
    
    
    
    public LinkedList<ProductInfo> getAllProductByPage2(int start, int rowPerPage, String keyword){  
  	  LinkedList<ProductInfo> list = new LinkedList<ProductInfo>(); 
  	  keyword = String.valueOf(keyword.charAt(keyword.length()-1));
  	  String sql = "select * from (select * from (select p.*, rownum r from PRODUCTS p where p.Rate >="+ keyword + ")" + "where r>=" + start + "and r<=" + (start+rowPerPage) + ") pr, INVENTORY i where pr.PROD_ID = i.PROD_ID";
  	  
  	  System.out.println("ProductDao134--"+ sql);
  	  
  	  
         try {  
      	   	con = dbcon.initDB();
 				pstmt = con.prepareStatement(sql);
 				rs = pstmt.executeQuery();  
 				while(rs.next()){  
 					ProductInfo product = new ProductInfo();
 					//will modify
 					product.setProId(rs.getInt("PROD_ID"));
 	            	product.setCateId(rs.getInt("CATEGORY"));
 	            	product.setPrice(rs.getFloat("PRICE"));
 	            	product.setProName(rs.getString("TITLE"));
 	            	product.setStock(rs.getInt("QUAN_IN_STOCK"));
 	            	product.setRate(rs.getInt("RATE"));
 	            	product.setPic(rs.getString("PIC"));
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
	   String sql = "select * from CATEGORIES where CATEGORYNAME=?";
	   int id = 0;
       try {  
    		con = dbcon.initDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cate);
			rs = pstmt.executeQuery(); 
			while (rs.next()) {
				id = rs.getInt("CATEGORY");
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
    
   
   public boolean changeStock(String proname, int proid, int quantity) throws Exception{
	   	DataBaseConnector dbcon = new DataBaseConnector();
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update INVENTORY set QUAN_IN_STOCK=? where PROD_ID=(select i.PROD_ID from PRODUCTS p, INVENTORY i where p.PROD_ID = i.PROD_ID and p.TITLE=?)";	//modify
		
		int requantity = findQuantity(proid) - quantity;
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
			e.printStackTrace();
		}
		return true;
   }
    
   
    //search
    public ProductInfo findById(int proid) throws Exception {
		ProductInfo product = new ProductInfo();
	  	con = dbcon.initDB();
		String sql = "select * from PRODUCTS p, INVENTORY i where p.PROD_ID = i.PROD_ID and p.PROD_ID=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, proid);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			product.setProId(rs.getInt("PROD_ID"));
           	product.setCateId(rs.getInt("CATEGORY"));
           	product.setPrice(rs.getFloat("PRICE"));
           	product.setProName(rs.getString("TITLE"));
           	product.setStock(rs.getInt("QUAN_IN_STOCK"));
           	product.setRate(rs.getInt("RATE"));
           	product.setPic(rs.getString("PIC"));
		}
		
		dbcon.closeDB(con);
		return product;
	}

  //search
    public ProductInfo findByName(String proname) throws Exception {
    	ProductInfo product = new ProductInfo();
		String sql = "select * from PRODUCTS where TITLE=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, proname);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			product.setProId(rs.getInt("PROD_ID"));
           	product.setCateId(rs.getInt("CATEGORY"));
           	product.setPrice(rs.getFloat("PRICE"));
           	product.setProName(rs.getString("TITLE"));
           	product.setStock(rs.getInt("QUAN_IN_STOCK"));
           	product.setRate(rs.getInt("RATE"));
           	product.setPic(rs.getString("PIC"));
		}
		
		dbcon.closeDB(con);
		return product;
	}

    public int findQuantity(int proid) throws Exception {
		String sql = "select * from INVENTORY where PROD_ID=?";
		int stock = 0;
		con = dbcon.initDB();
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, proid);
		rs = pstmt.executeQuery(); 
		while (rs.next()) {
			stock= rs.getInt("QUAN_IN_STOCK");
		}
		dbcon.closeDB(con);
		return stock;	
	}
}