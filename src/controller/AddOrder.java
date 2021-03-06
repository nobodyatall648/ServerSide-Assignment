package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Cart;
import domain.OrderEntity;
import domain.OrderdetailEntity;
import domain.OrderdetailEntityPK;
import domain.ProductEntity;
import sessionbean.OrderDetailSessionBean;
import sessionbean.OrderDetailSessionBeanLocal;
import sessionbean.OrderSessionBeanLocal;
import sessionbean.ProductSessionBeanLocal;

/**
 * Servlet implementation class AddOrder
 */
@WebServlet("/AddOrder")
public class AddOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private OrderSessionBeanLocal orderBean;
	private OrderDetailSessionBeanLocal orderDetailBean;
	private ProductSessionBeanLocal productBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddOrder() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String comment = request.getParameter("comments");
		
		HttpSession session = request.getSession();

		try {
			List<Cart> cartList = (List<Cart>) session.getAttribute("CART");

			// add Order
			String orderDate = null;

			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				orderDate = dateFormat.format(new Date());
			} catch (Exception e) {
				out.println("Something wrong somewhere: " + e);
			}

			// get new order number
			int orderNum = orderBean.newOrderNumber();

			OrderEntity orderEntity = new OrderEntity();
			orderEntity.setOrdernumber(orderNum);
			orderEntity.setOrderdate(orderDate);
			orderEntity.setRequireddate(cartList.get(0).getRequiredDate());
			orderEntity.setStatus("In Process");
			orderEntity.setComments(comment);
			orderEntity.setCustomernumber(cartList.get(0).getCustomerNumber());

			// add orderDetails
			
			
			// deduct qty

			// reset cart session
		} catch (Exception e) {

		}

	}

}
