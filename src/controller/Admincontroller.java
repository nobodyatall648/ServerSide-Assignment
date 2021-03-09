package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.OfficeEntity;
import sessionbean.EmployeeSessionBeanLocal;
import sessionbean.OfficeSessionBeanLocal;
import utilities.ValidateEmployee;

/**
 * Servlet implementation class Admincontroller
 */
@WebServlet(name="/admincontroller",urlPatterns= {"/admincontroller"})
public class Admincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private EmployeeSessionBeanLocal empbean;
	@EJB
	private OfficeSessionBeanLocal offbean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admincontroller() {
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
		
		String eid=request.getParameter("id");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String job=request.getParameter("job");
		String ocode=request.getParameter("officecode");
		String report=request.getParameter("report");
		
		OfficeEntity o=new OfficeEntity();
		o=offbean.findOffice(Integer.parseInt(ocode));
		
		PrintWriter out = response.getWriter();
		
		String[] s= {eid,fname,lname,email,job,ocode,report};
		
			if(ValidateEmployee.ValidateEmployee(request).equals("UPDATE")) {
				empbean.updateEmployee(s);
			}else if(ValidateEmployee.ValidateEmployee(request).equals("DELETE")) {
				empbean.deleteEmployee(eid);
			}
			else {
				empbean.addEmployee(s,o);
			}
			ValidateEmployee.navigateJS(out);
	}

}
