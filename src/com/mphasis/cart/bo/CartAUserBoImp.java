package com.mphasis.cart.bo;

import com.mphasis.cart.dao.CartAUserDao;
import com.mphasis.cart.dao.CartAUserImp1;
import com.mphasis.cart.exceptions.BussinessException;
import com.mphasis.training.amazonjdbcprograms.CartAUser;

public class CartAUserBoImp implements CartAUserBo {

	 CartAUserDao cartAUserDao;
	 
	 public CartAUserBoImp()
	 {
		 cartAUserDao=new CartAUserImp1();
	 }
	
	
	
	@Override
	public void register(CartAUser user) throws BussinessException{
		
        if(user.getGender().matches("[mMfF]{1}")) 
        {
        	cartAUserDao.register(user);
        	System.out.println("touched bo");
        }
        else
        {
        	throw new BussinessException("entered invalid gender");
        }
	}

	@Override
	public int changePassword(String oldpass, String email)throws BussinessException {
	   
	   
	    	return cartAUserDao.changePassword(oldpass,email);
	    
	   
	    
		
	}



	@Override
	public CartAUser login(String email, String pass) {
		
		return cartAUserDao.login(email, pass);
	}

}
