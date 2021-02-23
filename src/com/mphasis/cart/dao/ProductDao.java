package com.mphasis.cart.dao;
import com.mphasis.training.amazonjdbcprograms.*;
import java.util.List;


public interface ProductDao {
	        
	public int addProduct(Product p);
	
	public int deleteProduct(int pid);
	public Product getById(int pid);
	public List<Product> getProductByName(String pname);
	public List<Product> getAll();
	public int updateProduct(int pid, String pname, long cost, int qty);
	
         
}
