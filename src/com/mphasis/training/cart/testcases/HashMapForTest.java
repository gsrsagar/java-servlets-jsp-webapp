package com.mphasis.training.cart.testcases;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HashMapForTest {
	static Map<Integer, String> Employeepairs=new HashMap<>();
	static int eid; 
	static String email;
	static Scanner sc=new Scanner(System.in);
 
	public  void getAllPairs() 
	{    Employeepairs.entrySet().forEach(entry->{
	     System.out.println(entry.getKey() + " " + entry.getValue());});  
		
	}
	
	public void addEmpPairs()
	{
		 eid=sc.nextInt();		 
		  email=sc.next();
		  if(HashMapForTest.isValid(email))
		  {
			  Employeepairs.put(eid,email);
		  }
			System.out.println("successfully added");
		  
	}
	
	
	public static boolean isValid(String email) 
	{ 
	    String emailRegex = "^([a-zA-Z0-9]+)@gmail.com"; 
	                          
	    Pattern pat = Pattern.compile(emailRegex); 
	    if (email == null) 
	        return false; 
	    return pat.matcher(email).matches(); 
	} 
	public void getEmpById()
	{
		String val=Employeepairs.get(sc.nextInt());
	     System.out.println("The Value mapped to Key  is:"+ val);
	}
	
	
	
	public static void main(String args[])
	{
		Scanner sc1=new Scanner(System.in);
		
		HashMapForTest  h=new HashMapForTest();
		int id=2368365;
		String email= "sagar@gmail.com";
		Employeepairs.put(2368365,"sagar@gmail.com");
	   do {
		    System.out.println("Enter the choice  \n  1.get employess by id  \n  2. Add emp pairs  \n 3. print all emp pairs");
			  int choose=sc.nextInt();
		switch(choose){
		   
		case 1: System.out.println("get  employees by id");
		        h.getEmpById();    
		       break;       
		 
		
		case 2: System.out.println("Add employee pairs");   
		          h.addEmpPairs();
		        break;
		case 3: System.out.println("Print all the emp pairs from employee");
		         h.getAllPairs();      
		           break;
		
		default:System.exit(0);
		
		 }
		
		  }while(true);
		 
		}
	}
         


