package com.mphasis.training.cart.testcases;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringHelperTest {
	TestCodeDemo  testCodeDemo;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testCodeDemo=new TestCodeDemo() ;
	}

	@After
	public void tearDown() throws Exception {
		testCodeDemo=null;
	}

	@Test
	public void testRemoveFirstTwoOccurenceOfA() {
		assertEquals("BC",testCodeDemo.RemoveFirstTwoOccurenceOfA("AABC"));
		
	}
	

	
	@Test
	public void testArefirst2andlast2charsaresame() {
		assertEquals(false,testCodeDemo.arefirst2andlast2charsaresame("ADBAB"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testArray()
	{
		int [] numbers=null;
		Arrays.sort(numbers);
	}
	
	@Test
	public void testArray1()
	{
		int [] numbers= {34,2,12,56,78};
		Arrays.sort(numbers);
		int [] expected= {2,12,34,56,78};
		assertArrayEquals(expected,numbers);
	}
	
	@Test(timeout=149)
	public void testTiming()
	{
		  for(int i=0;i<100000;i++)
		  {
			  int [] numbers= {i,i-1,i+1};
			  Arrays.sort(numbers);
		  }
	}

}
