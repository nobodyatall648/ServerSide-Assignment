package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.PaymentEntity;
import domain.PaymentEntityPK;
import sessionbean.PaymentSessionBeanLocal;


/**
 * Servlet implementation class GetCustomerPayment
 */
@WebServlet("/GetCustomerPayment")
public class GetCustomerPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private PaymentSessionBeanLocal paymentBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCustomerPayment() {
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

		String customerNumber = "";
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie c = cookies[i];
			if (c.getName().equals("uid")) {
				customerNumber = c.getValue();
			}
		}
	
		
		List<PaymentEntity> paymentList = paymentBean.getCustomerPaymentInfo(customerNumber);


		session.setAttribute("PAYMENT_LIST", paymentList);
		
		RequestDispatcher req = request.getRequestDispatcher("viewPayment.jsp");
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
