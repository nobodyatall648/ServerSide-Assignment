package controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.OrderEntity;
import domain.PaymentEntity;
import sessionbean.PaymentSessionBeanLocal;

/**
 * Servlet implementation class GetCustomerPaymentByEmployee
 */
@WebServlet("/GetCustomerPaymentByEmployee")
public class GetCustomerPaymentByEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private PaymentSessionBeanLocal paymentBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCustomerPaymentByEmployee() {
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
		String customerNumber = request.getParameter("customernumber");	
		
		List<PaymentEntity> paymentList = paymentBean.getCustomerPaymentInfo(customerNumber);
		
		request.setAttribute("PAYMENT_LIST_BYEMP", paymentList);
		
		RequestDispatcher req = request.getRequestDispatcher("employeeViewCustomerPayment.jsp");
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
