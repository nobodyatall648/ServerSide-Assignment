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

import domain.OrderEntity;
import sessionbean.OrderDetailSessionBeanLocal;
import sessionbean.OrderSessionBeanLocal;

/**
 * Servlet implementation class GetCustomerOrder
 */
@WebServlet("/GetCustomerOrder")
public class GetCustomerOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB
	OrderSessionBeanLocal orderBean;
	OrderDetailSessionBeanLocal orderDetailBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCustomerOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();		
		
		String customerNumber = "114"; //demo
		
		List<OrderEntity> orderList = orderBean.getOrderByCustNum(customerNumber);
		
		request.setAttribute("ORDER_LIST", orderList);
		RequestDispatcher req = request.getRequestDispatcher("viewOrder.jsp");
		req.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
