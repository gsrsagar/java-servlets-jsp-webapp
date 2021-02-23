package com.mphasis.training.amazonjdbcprograms;

public class BuyProduct {
	private String email;
	private String pname;
	private long cost;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	@Override
	public String toString() {
		return "BuyProduct [email=" + email + ", pname=" + pname + ", cost=" + cost + "]";
	}
	

}
