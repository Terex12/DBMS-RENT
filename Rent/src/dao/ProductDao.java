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
    
    /*
    //number of product
    public int count(){  
        int count=0;  
        String sql="select count(*) from emp";  
        try {
        	con = dbcon.initDB();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();  
            while(rs.next()){  
                count = rs.getInt(1);  
            }  
        }catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return count;  
    } 
    
    
    //calculate total pages
    public int getTotalPage(int pageSize){  
        int totalPage = count();  
        return (totalPage%pageSize==0)?(totalPage/pageSize):(totalPage/pageSize+1);  
    }  
    */
    
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

    
    
    
	
}