package com.mphasis.cart.listner;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
@WebListener
public class MyListener implements HttpSessionListener {
  private int sessionCount=0;
  
  public void sessionCreated(HttpSessionEvent se)
  {
	  synchronized(this)
	  {
		  sessionCount++;
	  }
	  System.out.println("Id os session"+se.getSession());
	  System.out.println("count of logged"+sessionCount);
  }
   
    
    public MyListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
   

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
