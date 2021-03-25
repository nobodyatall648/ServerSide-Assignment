package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.core.NullAttributeException;

import domain.EmployeeEntity;
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
		
		PrintWriter out = response.getWriter();
		OfficeEntity o=new OfficeEntity();
		
		
			if(offbean.findOffice(Integer.parseInt(ocode))==null) {
				out.println("<SCRIPT type=\"text/javascript\">");
				out.println("alert(\"Office cannot be found please type a valid office\")");
				out.println("window.location.href="+"\"indexAdmin.jsp\"");
				out.println("</SCRIPT>");
			}
			else {
				o=offbean.findOffice(Integer.parseInt(ocode));
		
		
		//for adding employees
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmployeenumber(Integer.parseInt(eid));
		emp.setFirstname(fname);
		emp.setLastname(lname);
		emp.setEmail(email);
		emp.setExtension("x100");
		emp.setJobtitle(job);
		emp.setOffice(o);;
		emp.setReportsto(report);
		
		String[] s= {eid,fname,lname,email,job,ocode,report};
		
			if(ValidateEmployee.ValidateEmployee(request).equals("UPDATE")) {
				empbean.updateEmployee(s);
			}else if(ValidateEmployee.ValidateEmployee(request).equals("DELETE")) {
				empbean.deleteEmployee(eid);
			}
			else {
				empbean.addEmployee(emp);
			}
			ValidateEmployee.navigateJS(out);
			}
	}

}
