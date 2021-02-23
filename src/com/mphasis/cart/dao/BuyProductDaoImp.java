package com.mphasis.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mphasis.training.amazonjdbcprograms.BuyProduct;
import com.mphasis.training.cart.util.DbUtil;

public class BuyProductDaoImp implements BuyProductDao {
 Connection con;
 public BuyProductDaoImp()
 {
	 con=DbUtil.getConnection();
 }
 
	@Override
	public List<BuyProduct> getAllBuyProducts() {
		List<BuyProduct> buyproducts=new ArrayList<>();
		try {  System.out.println("touched dao");
			    String sql="select * from buyproduct";
			    PreparedStatement pst=con.prepareStatement(sql);
			    ResultSet rs= pst.executeQuery();
			    while(rs.next())
			    {  
			      BuyProduct b=new BuyProduct();
			      b.setEmail(rs.getString(1));
			      b.setPname(rs.getString(2));
			      b.setCost(rs.getInt(3));
			      buyproducts.add(b);
			    }      
		 }
			    catch(Exception e)
		{
			e.printStackTrace();
		}
          return buyproducts;
	}

	

	@Override
	public int addBuyProduct(String email,String pname,long cost) {
      
		int i=0;
      try {
    	  
    	  String sql="insert into buyproduct values(?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,email);
		pst.setString(2, pname);
		pst.setLong(3, cost);
		i =pst.executeUpdate();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
		

		return i;
	}

}
