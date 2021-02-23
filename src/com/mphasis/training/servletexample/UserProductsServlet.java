package com.mphasis.training.servletexample;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class UserProductsServlet
 */
   
@WebServlet("/UserProducts")
public class UserProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao productDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProductsServlet() {
    	productDao=new ProductdaoImp1();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		List<Product> productss=productDao.getAll();
		HttpSession session1=request.getSession();
		session1.setAttribute("products1",productss);
		response.sendRedirect("UserProducts.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
