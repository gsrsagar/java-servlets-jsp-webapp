package com.mphasis.training.amazonjdbcprograms;

import java.io.Serializable;

public class Product implements Serializable{
	
	 private int pid;
	 private String pname;
	 private long cost;
	 private int quantity;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", cost=" + cost + ", quantity=" + quantity + "]";
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}
