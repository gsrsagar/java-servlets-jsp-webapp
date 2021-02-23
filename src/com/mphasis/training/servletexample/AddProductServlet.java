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
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao productDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
    	productDao=new ProductdaoImp1();
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
        System.out.println("Servlte Called");
    String pid=request.getParameter("pid");
       
        
        System.out.println("Servlet Called"+ pid);
       
        	if(pid.isEmpty()) {
        		 String pname=request.getParameter("pname");
        	        String cost=request.getParameter("cost");
        	        String quantity1=request.getParameter("quantity");
               Product p=new Product();
              // p.setPid(Integer.parseInt(pid));
               p.setPname(pname);
               p.setCost(Long.parseLong(cost));
               p.setQuantity(Integer.parseInt(quantity1));
               System.out.println("servlet enterd");
               //out.println("Successfully added product"); 
             productDao.addProduct(p);
             List<Product> products=productDao.getAll();
     		HttpSession session1=request.getSession();
     		session1.setAttribute("products",products);
            	   RequestDispatcher rd=request.getRequestDispatcher("products.jsp");  
   			rd.include(request, response);
   		
        	}else {
        		int pi=Integer.parseInt(pid);
        		 String pname=request.getParameter("pname");
        	        String cost=request.getParameter("cost");
        	        String quantity1=request.getParameter("quantity");
        		
                
                System.out.println("servlet enterd edit ");
                 int i=productDao.updateProduct(pi, pname,   Long.parseLong(cost), Integer.parseInt(quantity1));
                                List<Product> products=productDao.getAll();
                        		HttpSession session1=request.getSession();
                        		session1.setAttribute("products",products);
                                  out.println("Successfully added product"); 

                      
               	   
               	   RequestDispatcher rd=request.getRequestDispatcher("products.jsp");  
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
