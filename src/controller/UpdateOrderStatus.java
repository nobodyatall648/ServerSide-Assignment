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

import domain.OrderEntity;
import sessionbean.OrderSessionBeanLocal;

/**
 * Servlet implementation class UpdateCustomerStatus
 */
@WebServlet("/UpdateOrderStatus")
public class UpdateOrderStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	OrderSessionBeanLocal orderBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateOrderStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String orderNum = request.getParameter("ordernum");
		String orderStatus = request.getParameter("status");

		// update status
		try {
			OrderEntity order = orderBean.getOrderByOrderNumber(orderNum);
			order.setStatus(orderStatus);

			boolean result = orderBean.updateOrder(order);

			if (result) {
				RequestDispatcher req = request.getRequestDispatcher("updateOrderStatusSuccess.jsp");
				req.forward(request, response);
			} else {
				out.println("[ERROR]: Something wrong in the update order status");
			}

		} catch (Exception e) {
			out.println("[ERROR]: " + e);
		}

	}

}
