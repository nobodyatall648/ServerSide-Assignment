package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import domain.UserEntity;
import sessionbean.EmployeeSessionBeanLocal;

/**
 * Servlet Filter implementation class adminFilter
 */
@WebFilter(filterName="/adminFilter",urlPatterns= {"/LoginController"})
public class LoginFilter implements Filter {
	@EJB
	private EmployeeSessionBeanLocal usr;

    /**
     * Default constructor. 
     */
    public LoginFilter() {
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
		// TODO Auto-generated method stub
		// place your code here
		  PrintWriter out=response.getWriter();  
		  
          String name=request.getParameter("name");
		    String password=request.getParameter("pass");
		    
		    		UserEntity u=usr.findUser(name);
		    		if(u!=null && password.equals(u.getPassword())){
		    			chain.doFilter(request, response);
		    		}
		    		else {
		    			 out.println("alert(\\\"Username or Password is invalid!!\\\")");  
		    			    RequestDispatcher rd=request.getRequestDispatcher("login.html");  
		    			    rd.forward(request, response);
		    		}
		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
