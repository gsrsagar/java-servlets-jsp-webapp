package com.mphasis.cart.dao;

import java.sql.*;

import com.mphasis.training.amazonjdbcprograms.CartAUser;
import com.mphasis.training.cart.util.DbUtil;

public class CartAUserImp1  implements CartAUserDao{

	Connection con;
	public CartAUserImp1() 
	{
		con=DbUtil.getConnection();
	}
	


	@Override
	public void register(CartAUser c) {
		try {
			 String sql="insert into cartauser values(?,?,?,?,sysdate,?,?,?)";
			PreparedStatement pst= con.prepareStatement(sql);
			pst.setInt(1,c.getUserid());
			pst.setString(2, c.getUsername());
			pst.setString(3, c.getEmail());
			pst.setString(4, c.getPassword() );
			pst.setLong(5,c.getCredit());
			pst.setString(6,c.getGender());
			pst.setString(7, c.getRole());
			pst.executeUpdate();
			  
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
		}
		
	}

	@Override
	public CartAUser login(String email, String pass) {
		CartAUser c = new CartAUser();
		try {
		String sql = "select * from cartauser where email = ? and password = ?";
		PreparedStatement pst= con.prepareStatement(sql);
		 pst.setString(1,email);
		 pst.setString(2, pass);
		 ResultSet rs=pst.executeQuery();
		 if(rs.next())
		 {
			 c.setUserid(rs.getInt(1));
			 c.setUsername(rs.getString(2)); 
				c.setEmail(rs.getString(3));
				c.setPassword(rs.getString(4));
				c.setDor(rs.getString(5));
				c.setCredit(rs.getLong(6));
				c.setGender(rs.getString(7));
				c.setRole(rs.getString(8));
		 }
		}catch(Exception e)
		{
			
		}
		return c;			
	}

	@Override
	public int changePassword(String pass, String email) 
	{  
		 int i=0;
		try {
		String sql = "update cartauser set password = ? where email = ?";
		PreparedStatement pst= con.prepareStatement(sql);
		 pst.setString(1,pass);
		 pst.setString(2, email);
		 i=pst.executeUpdate();
		 
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
		
		
		
	}
	


}
