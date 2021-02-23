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

import com.mphasis.cart.dao.ProductDao;
import com.mphasis.cart.dao.ProductdaoImp1;
import com.mphasis.training.amazonjdbcprograms.Product;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/addproducts")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 ProductDao productDao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
		productDao =new ProductdaoImp1();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");  //http:1.1
		response.setHeader("pragma","no-cache");  // 1.0
		response.setHeader("Expires", "0");  
		response.setContentType("text/html");
       //   PrintWriter out=response.getWriter();
		
		   String pid1=request.getParameter("pid");
		   
		 /*  if(pid1.isEmpty())
		   {
			  // HttpSession session1=request.getSession(false);
			   // session1.invalidate();
			    response.sendRedirect("addproducts.jsp");
		   }
		   else
		   {*/
			   int pid=Integer.parseInt(pid1);
			   Product p=productDao.getById(pid);
			  // HttpSession session1=request.getSession();
			   request.setAttribute("p",p);
			   System.out.println(p);
			  request.getRequestDispatcher("addproduct.jsp").forward(request,response);
		  // }
		
	}
		
		
		
		
		
		/*	response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String pid=(request.getParameter("pid"));
        String pname=request.getParameter("pname");
        String cost=(request.getParameter("cost"));
        String quantity1=(request.getParameter("quantity"));
        
        
        try {
               Product p=new Product();
               p.setPid(Integer.parseInt(pid));
               p.setPname(pname);
               p.setCost(Long.parseLong(cost));
               p.setQuantity(Integer.parseInt(quantity1));
               
               out.println("Successfully added product"); 
               int i=productDao.addProduct(p);
               if(i>0) {
               RequestDispatcher rd=request.getRequestDispatcher("products.jsp");
               
               
   			rd.include(request, response);}
               response.sendRedirect("menu.html");
        }catch(Exception e) {
               out.println("already product existing with id");
               response.sendRedirect("Addproduct.html");
        }*/

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
