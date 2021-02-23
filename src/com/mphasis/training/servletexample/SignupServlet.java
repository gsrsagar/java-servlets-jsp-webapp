package com.mphasis.training.servletexample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.cart.bo.CartAUserBo;
import com.mphasis.cart.bo.CartAUserBoImp;
import com.mphasis.cart.exceptions.BussinessException;
import com.mphasis.training.amazonjdbcprograms.CartAUser;
import com.sun.jmx.snmp.Enumerated;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/Signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	CartAUserBo  cartAUserBo;
    public SignupServlet() {
        super();
          cartAUserBo =new CartAUserBoImp() ;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		/* PrintWriter out=response.getWriter();
		 Enumeration<String> en=request.getParameterNames();
		 while(en.hasMoreElements())
		 {
			 Object ob=en.nextElement();
			 String st=(String)ob;
			 String[] value=request.getParameterValues(st.toString());
					 if(value.length==1)
					 {
						 out.print("name is"+st+"value is"+value[0]+"<br/>");	 
					 }
					 else if(value.length>1)
					 {
						 out.print("<ol>");
						 for(String st1:value)
						 {
							out.print("<li>"+st1+"</li>");
						 } out.print("</ol>");
					 }
					 else
					 {
						 
					 }
		 }*/
		PrintWriter out=response.getWriter();
		CartAUser c=new CartAUser();
		int userid=Integer.parseInt(request.getParameter("userid"));
		String uname= request.getParameter("username");
		String email=request.getParameter("email");
		String pass=request.getParameter("psw");
		long credit=Long.parseLong(request.getParameter("credit"));
		String role=request.getParameter("role");
		String gender=request.getParameter("gender");
	   
		c.setUserid(userid);
		c.setUsername(uname); 
		c.setEmail(email);
		c.setPassword(pass);
		c.setCredit(credit);
		c.setGender(gender);
		c.setRole(role);
			try {
				cartAUserBo.register(c);
				out.print("Registration success");
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
		    	rd.include(request,  response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				RequestDispatcher rd=request.getRequestDispatcher("Signup.html");
		    	rd.include(request,  response);
				
			}
			
		
		
           
	
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
