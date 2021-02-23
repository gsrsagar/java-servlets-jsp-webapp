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

import com.mphasis.cart.dao.BuyProductDao;
import com.mphasis.cart.dao.BuyProductDaoImp;
import com.mphasis.cart.dao.ProductDao;
import com.mphasis.cart.dao.ProductdaoImp1;
import com.mphasis.training.amazonjdbcprograms.Product;

/**
 * Servlet implementation class BuyProducts
 */
@WebServlet("/buyproducts")
public class BuyProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */ProductDao productDao ;
	
	BuyProductDao  buyProductDao;
    public BuyProducts() {
    	 buyProductDao =new BuyProductDaoImp(); 
    	 productDao=new ProductdaoImp1(); 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		String emaill=session.getAttribute("sname").toString();
		String p1=request.getParameter("pid");
		int pid=Integer.parseInt(p1);
		Product p=new Product();
		p=productDao.getById(pid);
		String pnamee=p.getPname();
		long costt=p.getCost();

		
		int i=buyProductDao.addBuyProduct(emaill,pnamee,costt);
		if(i>0)
		{
			out.print("successfully updated the purchaser details");
			RequestDispatcher rs=request.getRequestDispatcher("Usermenu.html");
			rs.include(request, response);
		}
		else
		{
		 out.print("Purchasing failed");
		 RequestDispatcher rs=request.getRequestDispatcher("UserProducts.jsp");
			rs.include(request, response);
		}			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
