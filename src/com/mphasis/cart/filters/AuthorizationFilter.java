package com.mphasis.cart.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.net.httpserver.HttpServer;

/**
 * Servlet Filter implementation class AuthorizationFilter
 */
@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthorizationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out=response.getWriter();
		HttpServletRequest srequest=(HttpServletRequest)request;
		HttpServletResponse sresponse=(HttpServletResponse)response;
		String url=srequest.getRequestURI();
		HttpSession session=srequest.getSession(false);
		if(session==null && !(url.endsWith("index.html")
				||
				(url.endsWith("User.html"))||
						(url.endsWith("Signup.html"))||
								(url.endsWith("Addproduct.html")) || (url.endsWith("login.html")) || (url.endsWith("Login")) ))
						{
					out.print("not authorised");
					srequest.getRequestDispatcher("login.html").include(srequest, sresponse);
					
						}
		
		
		else{
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
