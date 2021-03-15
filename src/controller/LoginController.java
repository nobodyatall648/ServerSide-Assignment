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

import domain.CustomerEntity;
import domain.EmployeeEntity;
import domain.UserRoleEntity;
import domain.UserRoleEntityPK;
import sessionbean.CustomerSessionBeanLocal;
import sessionbean.EmployeeSessionBeanLocal;
import sessionbean.UserRoleSessionBeanLocal;
import sessionbean.UserSessionBeanLocal;

/**
 * Servlet implementation class Usercontroller
 */
@WebServlet(name = "/Login", urlPatterns = { "/LoginController" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private UserRoleSessionBeanLocal userRoleBean;

	@EJB
	private UserSessionBeanLocal userBean;
	
	@EJB
	private CustomerSessionBeanLocal custBean;
	
	@EJB 
	private EmployeeSessionBeanLocal empBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String user = request.getParameter("name");
		String pass = request.getParameter("pass");

		try {
			boolean credCheck = userBean.accountMatching(user, pass);

			// check credential matching, if true
			if (credCheck) {
				// retrieve user role
				UserRoleEntity userRole = userRoleBean.findRole(user);

				// set cookie for authorization checking & retrieving user profile information
				Cookie uidCookie = new Cookie("uid", userRole.getId().getUsername());
				uidCookie.setMaxAge(60 * 60); // 1hr cookie age
				response.addCookie(uidCookie);

				Cookie roleCookie = new Cookie("role", userRole.getId().getRole());
				roleCookie.setMaxAge(60 * 60); // 1hr cookie age
				response.addCookie(roleCookie);											

				if (userRole.getId().getRole().equals("cust")) {
					CustomerEntity custInfo = custBean.getCustomerByCustNum(userRole.getId().getUsername());
					Cookie usernameCookie = new Cookie("username", custInfo.getCustomername());
					usernameCookie.setMaxAge(60 * 60); // 1hr cookie age
					response.addCookie(usernameCookie);
										
					response.sendRedirect("index.jsp");
				} else if (userRole.getId().getRole().equals("emp")) {
					EmployeeEntity empInfo = empBean.getEmployeeByEmpNum(userRole.getId().getUsername());
					Cookie usernameCookie = new Cookie("username", empInfo.getFirstname());
					usernameCookie.setMaxAge(60 * 60); // 1hr cookie age
					response.addCookie(usernameCookie);
					
					response.sendRedirect("indexEmp.jsp");
				} else if (userRole.getId().getRole().equals("admin")) {					
					Cookie usernameCookie = new Cookie("username", "Administration");
					usernameCookie.setMaxAge(60 * 60); // 1hr cookie age
					response.addCookie(usernameCookie);
					
					response.sendRedirect("indexAdmin.jsp");
				}

			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Invalid Credential');");
				out.println("location='login.jsp';");
				out.println("</script>");
			}

		} catch (Exception e) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Something went wrong');");
			out.println("location='login.jsp';");
			out.println("</script>");
		}
	}
}
