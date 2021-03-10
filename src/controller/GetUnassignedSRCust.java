package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CustomerEntity;
import sessionbean.CustomerSessionBeanLocal;

/**
 * Servlet implementation class GetUnassignedSRCust
 */
@WebServlet("/GetUnassignedSRCust")
public class GetUnassignedSRCust extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	CustomerSessionBeanLocal customerBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUnassignedSRCust() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String empno = "1611"; //demo
		
		List<CustomerEntity> custListNoSR = customerBean.getCustomerByUnassignedSR();
		List<CustomerEntity> custHandling = customerBean.getCustomerBySR(empno);
		
		request.setAttribute("CUST_LIST_NOSR", custListNoSR);
		request.setAttribute("CUST_LIST_HANDLING", custHandling);
		request.setAttribute("SALESREP", empno);
		RequestDispatcher req = request.getRequestDispatcher("custHandling.jsp");
		
		req.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
