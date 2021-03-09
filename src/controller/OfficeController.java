package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.OfficeEntity;
import sessionbean.EmployeeSessionBeanLocal;
import sessionbean.OfficeSessionBeanLocal;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OfficeEntity o=offbean.findOffice(2);
		System.out.println(o.getOfficecode());
		System.out.println(o.getPhone());
	}

}
