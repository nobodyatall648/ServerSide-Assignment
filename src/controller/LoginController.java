package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.EmployeeEntity;
import domain.UserRoleEntity;
import domain.UserRoleEntityPK;
import sessionbean.EmployeeSessionBeanLocal;

/**
 * Servlet implementation class Usercontroller
 */
@WebServlet(name="/Login",urlPatterns= {"/LoginController"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private EmployeeSessionBeanLocal emp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		String usrname=request.getParameter("name");
		String pass=request.getParameter("pass");
		
		List<UserRoleEntity> u=emp.findRole(usrname);
		if(u.get(0).getId().getRole().equals("user")==true) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("userhomepage");//DIRECT USER HOMEPAGE
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("AdminHomepage.html");
			dispatcher.forward(request, response);
		}
		
	
		
		}

}
