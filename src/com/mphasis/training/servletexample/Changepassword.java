package com.mphasis.training.servletexample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.cart.bo.CartAUserBo;
import com.mphasis.cart.bo.CartAUserBoImp;

/**
 * Servlet implementation class Changepassword
 */
@WebServlet("/Change")
public class Changepassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */CartAUserBo  cartAUserBo;
    public Changepassword() {
        super();
        cartAUserBo =new CartAUserBoImp() ;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	String gmail=request.getParameter("gmailid");
		String newpass=request.getParameter("passwod");
		String news=request.getParameter("passwod1");
		try {
			if(newpass.equals(news))
					{
				     int i= cartAUserBo.changePassword(news,gmail);
				     if(i>0)
				     {
				      RequestDispatcher rd=request.getRequestDispatcher("menu.html");
						 rd.include(request,  response);
				     }
					}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("Changepassword.html");
				 rd.include(request,  response);
			}
			
			
			
			
		}catch(Exception e)
		{
			 e.printStackTrace();
			 RequestDispatcher rd=request.getRequestDispatcher("Changepassword.html");
			 rd.include(request,  response);
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
