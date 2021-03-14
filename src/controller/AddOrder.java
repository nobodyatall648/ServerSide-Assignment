package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.RequestDispatcher;
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
	
	@EJB
	private OrderDetailSessionBeanLocal orderDetailBean;
	
	@EJB
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
		
		//demo customer number
		String customerNumber = request.getParameter("customernumber");
		
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
			//demo customer number
			orderEntity.setCustomernumber(Integer.parseInt(customerNumber));
			
			orderEntity.setOrdernumber(orderNum);
			orderEntity.setOrderdate(orderDate);
			orderEntity.setRequireddate(cartList.get(0).getRequiredDate());
			orderEntity.setStatus("In Process");
			orderEntity.setComments(comment);
			orderEntity.setCustomernumber(cartList.get(0).getCustomerNumber());
			
			//orderBean.addOrder(orderEntity);
			
			session.setAttribute("ORDER_ENTITY", orderEntity);

			// add orderDetails
			List<OrderdetailEntity> orderDetailEntityList = new ArrayList<OrderdetailEntity>();
			
			
//			System.out.println("[debug cart size]: " + cartList.size());
//			System.out.println("[debug cart ]: " + cartList.get(0).getProductCode());
			
			for(int i=0; i < cartList.size(); i++) {
				OrderdetailEntity orderDetailEntity = new OrderdetailEntity();
				ProductEntity productInfo = new ProductEntity();
				
				try {
					productInfo = productBean.getProductByProductCode(cartList.get(i).getProductCode());
					
					orderDetailEntity.setQuantityordered(cartList.get(i).getQty());
					orderDetailEntity.setPriceeach(productInfo.getMsrp());
					orderDetailEntity.setOrderlinenumber(i+1);
					
					orderDetailEntityList.add(orderDetailEntity);
					
					//orderDetailBean.addOrderDetail(orderDetailEntity);
					
					
				}catch(Exception e) {
					System.out.println(e);
				}							
			}
			
			session.setAttribute("ORDERDETAIL_ENTITY", orderDetailEntityList);			
			
//			// reset cart session attribute
//			session.setAttribute("CART", "");
			
			
			//pass the orderEntity + orderDetailEntity object to payment module
			RequestDispatcher req = request.getRequestDispatcher("paymentCheckout.jsp");
			req.forward(request, response);
			
			
		} catch (Exception e) {

		}
		
	}
}
