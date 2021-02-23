package com.mphasis.cart.bo;

import com.mphasis.cart.exceptions.BussinessException;
import com.mphasis.training.amazonjdbcprograms.*;

public interface CartAUserBo {
	
	public void register(CartAUser user)throws BussinessException ;
	public int changePassword(String oldpass, String newpass)throws BussinessException ;
	public CartAUser login(String email,String pass);

}
