package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.EmployeeEntity;
import domain.UserRoleEntity;
import domain.UserRoleEntityPK;
import sessionbean.EmployeeSessionBeanLocal;
import sessionbean.UserRoleSessionBeanLocal;
import sessionbean.UserSessionBeanLocal;

/**
 * Servlet implementation class Usercontroller
 */
@WebServlet(name="/Login",urlPatterns= {"/LoginController"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private UserRoleSessionBeanLocal userRoleBean;
	
	@EJB
	private UserSessionBeanLocal userBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
         
		String user=request.getParameter("name");
		String pass=request.getParameter("pass");
	    
		boolean credCheck = userBean.accountMatching(user, pass);
		
		if(credCheck) {
			out.println("still under development");
		}else {
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Invalid Credential');");  
			out.println("location='login.jsp';");
			out.println("</script>"); 	
		}
	}

}
