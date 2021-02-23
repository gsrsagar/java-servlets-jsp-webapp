package com.mphasis.training.cart.testcases;

import java.util.Scanner;

public class TestCodeDemo {
	
	public  static String RemoveFirstTwoOccurenceOfA(String s)
	{    
		 if(s.length()<=2)
		 { 
	          return s.replaceAll("A"," ");
		 }
		
		
	 String first2chars=s.substring(0,2);
			 String remaining=s.substring(2);
			 return first2chars.replaceAll("A","")+remaining;
		
	         
	}
	public static boolean arefirst2andlast2charsaresame(String s)
	{ 
		if(s.length()<=1)
			return false;
		if(s.length()==2)
			return true;
		String first2chars=s.substring(0,2);
		String last2chars=s.substring(s.length(),2);
		return first2chars.equals(last2chars);
		
	}
	
	
	//sample.charAt(sample.length() -1);
	
	
	
	
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s="aasagar";
		int op=sc.nextInt();
		switch(op)
		{
		
		case 1:  System.out.println("Remove the first sequence occurences of A | a");
		         String b=TestCodeDemo.RemoveFirstTwoOccurenceOfA(s);
			   System.out.println(b);
			
			  break;
			  
		case 2: System.out.println("arefirst2andlast2charsaresame");
		        boolean i=TestCodeDemo.arefirst2andlast2charsaresame(s);
		        System.out.println(i);
			
			break;
		
		
			default:System.out.println("invalid");
		}
		
		
		
	}
	

}
