package com.mphasis.training.servletexample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mphasis.cart.bo.CartAUserBo;
import com.mphasis.cart.bo.CartAUserBoImp;
import com.mphasis.training.amazonjdbcprograms.CartAUser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     CartAUserBo  cartAUserBo;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        cartAUserBo= new CartAUserBoImp(); 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");  //http:1.1
		response.setHeader("pragma","no-cache");  // 1.0
		response.setHeader("Expires", "0"); 		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("username");
		String pass=request.getParameter("passwod");
		
		CartAUser user=cartAUserBo.login(name, pass);
		try {
			 if(user.getEmail().equals(name) && user.getPassword().equals(pass))
              { 
				 
				if(user.getRole().equalsIgnoreCase("admin"))
				{ out.print("welcome"+" "+"Admin"+" "+name+"<br/>");
				 RequestDispatcher rd=request.getRequestDispatcher("menu.html");
				 rd.include(request, response);
            
				 HttpSession session=request.getSession();
				 session.setAttribute("sname",name);
				 
              
              }
				else
				{ out.print("welcome"+" "+"User"+" "+name+"<br/>");
					RequestDispatcher rd=request.getRequestDispatcher("Usermenu.html");
					 rd.include(request, response);
	            
					 HttpSession session=request.getSession();
					 session.setAttribute("sname",name);
				}
		}}catch(Exception e)
		
		{   e.printStackTrace();
			out.print("invalid credentials");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
