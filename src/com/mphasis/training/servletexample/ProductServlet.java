package com.mphasis.training.servletexample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mphasis.cart.bo.CartAUserBo;
import com.mphasis.cart.bo.CartAUserBoImp;
import com.mphasis.cart.dao.ProductDao;
import com.mphasis.cart.dao.ProductdaoImp1;
import com.mphasis.training.amazonjdbcprograms.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/Product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProductDao productDao;
     /* @see HttpServlet#HttpServlet()
     */
	
    public ProductServlet() {
        super();
        productDao= new ProductdaoImp1();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products=productDao.getAll();
		HttpSession session1=request.getSession();
		session1.setAttribute("products",products);
		response.sendRedirect("products.jsp");
	   	
		
	}/*response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");  //http:1.1
		response.setHeader("pragma","no-cache");  // 1.0
		response.setHeader("Expires", "0"); 
			
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try{
			HttpSession session=request.getSession(false);
		String s=session.getAttribute("sname").toString();
		out.print("Product page"+" "+s);
		out.print("Session"+session.getLastAccessedTime());
		out.print("Session"+session.getCreationTime());
		
		RequestDispatcher rs=request.getRequestDispatcher("menu.html");
		rs.include(request, response);
		List<Product> products=productDao.getAll();
		out.print("<table border='1'>");
		out.print("<tr><th>Product ID</th><th>Product Name</th><th>Cost</th><th>Quantity</th><th>Buy</th></tr>"); 
		for(Product p:products)
		{
			out.print("<tr>");
			out.print("<td>"+p.getPid()+"</td>");
			out.print("<td>"+p.getPname()+"</td>");
			out.print("<td>"+p.getCost()+"</td>");
			out.print("<td>"+p.getQuantity()+"</td>");
			out.print("<td><a>Buy</a></td>");
			out.print("</tr>");
			
			
		}
		
	}catch(NullPointerException e)
		{
		  out.print("LoginFirst");
		  RequestDispatcher rs=request.getRequestDispatcher("login.html");
		  rs.include(request,response);
		}
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
