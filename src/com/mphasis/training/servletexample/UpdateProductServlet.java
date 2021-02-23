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

import com.mphasis.cart.dao.ProductDao;
import com.mphasis.cart.dao.ProductdaoImp1;
import com.mphasis.training.amazonjdbcprograms.Product;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProductDao productDao;
    
    public UpdateProductServlet() {
       
        productDao=new ProductdaoImp1();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
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
               int p1=Integer.parseInt(pid);
                Long c=Long.parseLong(cost);
                int q=Integer.parseInt(quantity1);
                
               //out.println("Successfully updated product"); 
               int i=productDao.updateProduct(p1, pname,c, q);
               if(i>0) {
              
            	   List<Product> products=productDao.getAll();
           		HttpSession session1=request.getSession();
           		session1.setAttribute("products",products);
           		response.sendRedirect("products.jsp");
            	   RequestDispatcher rd=request.getRequestDispatcher("products.jsp");
               
      rd.include(request, response);}
              
        }catch(Exception e) {
               out.println("already product existing with id");
               response.sendRedirect("Addproduct.html");
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
