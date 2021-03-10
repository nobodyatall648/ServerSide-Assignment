package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.EmployeeEntity;
import sessionbean.CustomerSessionBeanLocal;
import sessionbean.EmployeeSessionBeanLocal;

/**
 * Servlet implementation class AcceptCustomerAssign
 */
@WebServlet("/AcceptCustomerAssign")
public class AcceptCustomerAssign extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	CustomerSessionBeanLocal customerBean;
	EmployeeSessionBeanLocal employeeBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public AcceptCustomerAssign() {
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
		String salesRep = request.getParameter("salesRep");
		String custNum = request.getParameter("custnum");

		PrintWriter out = response.getWriter();
		
		try {			
			boolean updateRsl = customerBean.assignSalesRep(custNum, salesRep);
			
			if(updateRsl == true) {
				RequestDispatcher req = request.getRequestDispatcher("assignSalesRepSuccess.jsp");
				req.forward(request, response);
			}else {
				out.println("[ERROR]: Something went wrong in update");
			}
		} catch (Exception e) {
			out.println("[ERROR]: " + e);
		}
	}

}
