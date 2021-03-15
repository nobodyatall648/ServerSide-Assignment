package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.CustomerEntity;
import domain.EmployeeEntity;
import sessionbean.CustomerSessionBeanLocal;
import sessionbean.EmployeeSessionBeanLocal;
import sessionbean.PaymentSessionBeanLocal;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet("/ProfileController")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private CustomerSessionBeanLocal customerBean;
	
	@EJB
	private EmployeeSessionBeanLocal employeeBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		Cookie [] cookies = request.getCookies();
		String customerNumber = "";
		String empNumber = "";
		
		//get customer role
		for (int i = 0; i < cookies.length; i++) {
	 		Cookie c = cookies[i];
	 		if (c.getName().equals("role")) {
	 			if (c.getValue().equals("cust")) {
	 				//get customer id
	 				for (int j = 0; j < cookies.length; j++) {
	 					Cookie c2 = cookies[j];
	 					if (c2.getName().equals("uid")) {
	 						customerNumber = c2.getValue();
	 					}
	 				}
	 				
	 				CustomerEntity customerEntity = customerBean.getCustomerByCustNum(customerNumber);
	 				
	 				session.setAttribute("CUSTOMER_ENTITY", customerEntity);
	 				
	 				RequestDispatcher req = request.getRequestDispatcher("profile.jsp");
	 				req.forward(request, response);
	 			}
	 			else if (c.getValue().equals("emp")) {
	 				//get customer id
	 				for (int j = 0; j < cookies.length; j++) {
	 					Cookie c2 = cookies[j];
	 					if (c2.getName().equals("uid")) {
	 						empNumber = c2.getValue();
	 					}
	 				}
	 				
	 				EmployeeEntity employeeEntity = employeeBean.getEmployeeByEmpNum(empNumber);
	 				
	 				session.setAttribute("EMPLOYEE_ENTITY", employeeEntity);
	 				
	 				
	 				RequestDispatcher req = request.getRequestDispatcher("profile.jsp");
	 				req.forward(request, response);
	 			}
	 			else {
	 				response.sendRedirect(request.getContextPath() + "/Logout");
	 			}
	 		}
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
