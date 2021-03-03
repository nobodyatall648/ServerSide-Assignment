package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sessionbean.EmployeeSessionBeanLocal;

/**
 * Servlet implementation class Usercontroller
 */
@WebServlet(name="/User",urlPatterns= {"/Usercontroller"})
public class Usercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private EmployeeSessionBeanLocal emp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usercontroller() {
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
		String usrname=request.getParameter("usrname");
		String pass=request.getParameter("usrpsw");
		System.out.println(usrname);
		System.out.println(pass);
		
		
		
		
		
		}

}
