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
//		doGet(request, response);
		HttpSession session = request.getSession();
		Cookie [] cookies = request.getCookies();
		
		for (int i = 0; i < cookies.length; i++) {
	 		Cookie c = cookies[i];
	 		if (c.getName().equals("role")) {
	 			//IF ROLE IS CUSTOMER
	 			if (c.getValue().equals("cust")) {
	 				try {
	 				//update customer profile
	 				String custNum = request.getParameter("custNum");
					String custName = request.getParameter("custName");
					String custFirstName = request.getParameter("custFirstName");
					String custLastName = request.getParameter("custLastName");
					String custPhone = request.getParameter("custPhone");
					String custCreditLimit = request.getParameter("custCreditLimit");
					String custAddr1 = request.getParameter("custAddr1");
					String custAddr2 = request.getParameter("custAddr2");
					String custPostal = request.getParameter("custPostal");
					String custCity = request.getParameter("custCity");
					String custState = request.getParameter("custState");
					String custCountry = request.getParameter("custCountry");
					
					String[] custString = { custNum, custName, custFirstName, custLastName, custPhone, custCreditLimit,
							custAddr1, custAddr2, custPostal, custCity, custState, custCountry};

					customerBean.updateCustomerFromProfile(custString);
					
					//set new values
					CustomerEntity customerEntity = customerBean.getCustomerByCustNum(custNum);
	 				session.setAttribute("CUSTOMER_ENTITY", customerEntity);
	 				} catch (Exception e) {
	 					
	 				}
	 				RequestDispatcher req = request.getRequestDispatcher("profile.jsp");
					req.forward(request, response);
	 			}
	 			//IF ROLE IS EMPLOYEE
	 			else if (c.getValue().equals("emp")) {
	 			try {
					//update employee profile
					String empNum = request.getParameter("empNum");
					String empFirstName = request.getParameter("empFirstName");
					String empLastName = request.getParameter("empLastName");
					String empEmail = request.getParameter("empEmail");
					
					String[] empString = {empNum, empFirstName, empLastName, empEmail};
					
					employeeBean.updateEmployeeFromProfile(empString);
					
					//set new values
					EmployeeEntity employeeEntity = employeeBean.getEmployeeByEmpNum(empNum);
	 				session.setAttribute("EMPLOYEE_ENTITY", employeeEntity);
	 				
	 			}catch (Exception e) {
	 				
	 			}

 				RequestDispatcher req = request.getRequestDispatcher("profile.jsp");
				req.forward(request, response);
	 			}
	 		}
		}
	}
}
