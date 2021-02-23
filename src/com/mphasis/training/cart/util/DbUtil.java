package com.mphasis.training.cart.util;

import java.sql.*;
public class DbUtil {
	 private static Connection conn;
	 public static Connection getConnection()
	 {
	 
	 try {
		  Class.forName("oracle.jdbc.OracleDriver");
		  conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","java166sqlsagar","sagar");
		 	  
	 }catch(Exception e)
	 {
		  e.printStackTrace();
	 }
	return conn;
	

}
}
