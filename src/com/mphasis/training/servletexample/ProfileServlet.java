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

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/Profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");  //http:1.1
		response.setHeader("pragma","no-cache");  // 1.0
		response.setHeader("Expires", "0");   // proxies
		
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
		HttpSession session=request.getSession(false);
		String s=session.getAttribute("sname").toString();
		out.print("<b>profile page</b>"+" "+s);
		RequestDispatcher rs=request.getRequestDispatcher("menu.html");
		rs.include(request, response);
		
	}catch(NullPointerException e)
		{
		  out.print("LoginFirst");
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
