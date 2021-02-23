package com.mphasis.cart.dao;

import com.mphasis.training.amazonjdbcprograms.*;
public interface CartAUserDao {
	public void register(CartAUser c);
	public CartAUser login(String email, String pass);
	public int changePassword(String oldpass, String newpass);
	
	
	  

}
