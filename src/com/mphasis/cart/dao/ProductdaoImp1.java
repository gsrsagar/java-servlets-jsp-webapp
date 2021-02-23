package com.mphasis.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mphasis.training.amazonjdbcprograms.Product;
import com.mphasis.training.cart.util.DbUtil;

public class ProductdaoImp1 implements ProductDao {
	 Connection con;
	 
	 
	 
	public ProductdaoImp1() {
		con=DbUtil.getConnection();
		
	}

	@Override
	public int addProduct(Product p) {
		 int i;
		 try { String sql="insert into product values(prodseq.nextval,?,?,?)";
		       PreparedStatement pst=con.prepareStatement(sql);
		       pst.setString(1, p.getPname());
		       pst.setLong(2, p.getCost());
		       pst.setInt(3, p.getQuantity());
		       i=pst.executeUpdate();
		       }catch(SQLException e) {
		    	   e.printStackTrace();
		       }
		 return 0;
	}

	@Override
	public int updateProduct(int pid,String pname, long cost, int qty) {
		 int i=0;
		try{
		 String sql="update product set cost=?, quantity=? ,pname=?where pid=? ";	
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(4, pid);
			pst.setLong(1, cost);
			pst.setInt(2, qty);
			pst.setString(3, pname);
			i=pst.executeUpdate();
		} 
		catch(Exception e)
		{
			 e.printStackTrace();
		}
		 return i;
	}

	@Override
	public int deleteProduct(int pid) {
		int i=0;
		try {
			 String sql="delete from product where pid=? ";
			 PreparedStatement pst =con.prepareStatement(sql);
			 pst.setInt(1,pid);
			 pst.executeUpdate();
			 i++;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Product getById(int pid) {
		 Product p =new Product();
		 try { String sql="select * from Product where pid=? ";
		  PreparedStatement pst=con.prepareStatement(sql);
		  pst.setInt(1, pid);
		  ResultSet rs=pst.executeQuery();
		  if(rs.next())
		  {
			  p.setPid(rs.getInt(1));
			  p.setPname(rs.getString(2));
			  p.setCost(rs.getLong(3));
			  p.setQuantity(rs.getInt(4));
			  
		  } }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
			 
		
		return p;
	}

	@Override
	public List<Product> getProductByName(String pname) {
		  List<Product> pn = new ArrayList<>();
		  
			 try { 
				 String sql="select * from Product where pname=? ";
			      PreparedStatement pst=con.prepareStatement(sql);
			      pst.setString(1, pname);
			     ResultSet rs=pst.executeQuery();
			  while(rs.next())
			  {
				  Product p1 =new Product();
				  p1.setPid(rs.getInt(1));
				  p1.setPname(rs.getString(2));
				  p1.setCost(rs.getLong(3));
				  p1.setQuantity(rs.getInt(4));
				  pn.add(p1);
			  } }catch(Exception e)
			  {
				  e.printStackTrace();
			  }
				 
			
			return pn;
			
		 }
	


	@Override
	public List<Product> getAll() {
		List<Product> products=new ArrayList<>();
		
		 try{ Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery("select * from product");
		 while(rs.next()) {
			 Product p=new Product();
			 p.setPid(rs.getInt(1));
			 p.setPname(rs.getString(2));
			 p.setCost(rs.getLong(3));
			 p.setQuantity(rs.getInt(4));
			 products.add(p);
			 
		 }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
			 return products;
			 
			 
	}

	

}
