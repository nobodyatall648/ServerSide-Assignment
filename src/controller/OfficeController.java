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
import domain.OfficeEntity;
import sessionbean.EmployeeSessionBeanLocal;
import sessionbean.OfficeSessionBeanLocal;
import utilities.ValidateEmployee;

/**
 * Servlet implementation class OfficeController
 */
@WebServlet("/OfficeController")
public class OfficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private OfficeSessionBeanLocal offbean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfficeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String officecode=request.getParameter("ocode");
		
		try {
			OfficeEntity o = offbean.findOffice(Integer.parseInt(officecode));
			request.setAttribute("OfficeResult", o);
			RequestDispatcher req = request.getRequestDispatcher("ViewOffice.jsp");
			req.forward(request, response);
		}catch (Exception e) { 
			response.sendRedirect(request.getContextPath() + "/ManageOffice.jsp?fail=0");
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String num=request.getParameter("ocode");
		String city=request.getParameter("city");
		String phone=request.getParameter("phone");
		String add1=request.getParameter("add1");
		String add2=request.getParameter("add2");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String pcode=request.getParameter("pcode");
		String territory=request.getParameter("territory");
		
		PrintWriter out = response.getWriter();
		
		String[] s= {num,city,phone,add1,add2,state,country,pcode,territory};
		
		if(ValidateEmployee.ValidateEmployee(request).equals("UPDATE")) {
			offbean.updateOffice(s);
		}else if(ValidateEmployee.ValidateEmployee(request).equals("DELETE")) {
			offbean.deleteOffice(s);
		}
		else {
			int i=1;
			while(offbean.findOffice(i)!=null) {
				i++;
			}
			String replacenum=Integer.toString(i);
			String[] o= {replacenum,city,phone,add1,add2,state,country,pcode,territory};
			offbean.addOffice(o);
		}
		ValidateEmployee.navigateJS(out);
	}

}
