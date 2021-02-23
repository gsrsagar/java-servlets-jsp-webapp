package com.mphasis.cart.dao;

import java.util.List;

import com.mphasis.training.amazonjdbcprograms.BuyProduct;

public interface BuyProductDao {
	public 	List<BuyProduct> getAllBuyProducts();
	//public int addBuyProduct(String email,String pname, int cost);
	//public int addBuyProduct(String email, String pname);
	public int addBuyProduct(String email, String pname, long cost);

}
