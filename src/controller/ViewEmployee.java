package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.EmployeeEntity;
import sessionbean.EmployeeSessionBeanLocal;

/**
 * Servlet implementation class ViewEmployee
 */
@WebServlet(name="/employee",urlPatterns= {"/ViewEmployee"})
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private EmployeeSessionBeanLocal emp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEmployee() {
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
		String employeenum=request.getParameter("employeenum");
		if(employeenum!=null) {
		EmployeeEntity e=emp.getEmployeeByEmpNum(employeenum,request);
		request.setAttribute("EmployeeResult", e);
		RequestDispatcher req=request.getRequestDispatcher("ViewEmployee.jsp");
		req.forward(request, response);
		}else response.sendRedirect("ViewEmployeedetail.html");
	}

}
