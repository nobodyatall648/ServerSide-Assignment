package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
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
import domain.PaymentEntity;
import domain.PaymentEntityPK;


import sessionbean.OrderDetailSessionBeanLocal;
import sessionbean.OrderSessionBeanLocal;
import sessionbean.PaymentSessionBeanLocal;
import sessionbean.ProductSessionBeanLocal;

/**
 * Servlet implementation class PaymentCheckout
 */
@WebServlet("/PaymentCheckout")
public class PaymentCheckout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PaymentSessionBeanLocal paymentBean;
	
	@EJB
	private OrderSessionBeanLocal orderBean;
	
	@EJB
	private OrderDetailSessionBeanLocal orderDetailBean;
	
	@EJB
	private ProductSessionBeanLocal productBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentCheckout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		HttpSession session = request.getSession();

		try {

			// retrieve information from paymentCheckout.jsp on payment details
			String totalPrice = request.getParameter("totalPrice");
			String paymentDate = request.getParameter("paymentDate");
			String checkNumber = request.getParameter("checkNumber");
			String customerNumber = request.getParameter("customernumber");

			// format date object into string
			DateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy");
			DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = inputFormat.parse(paymentDate);
			String paymentDateFormat = outputFormat.format(date);

			// get orderEntity and orderDetailEntity from AddOrder module
			OrderEntity orderEntity = (OrderEntity) session.getAttribute("ORDER_ENTITY");
			List<OrderdetailEntity> orderDetailEntity = (List<OrderdetailEntity>) session.getAttribute("ORDERDETAIL_ENTITY");
			List<Cart> cartList = (List<Cart>) session.getAttribute("CART");

			// add order and order details to database
			orderBean.addOrder(orderEntity);

			for (int i = 0; i < orderDetailEntity.size(); i++) {
				OrderdetailEntityPK orderDetailPK = new OrderdetailEntityPK();

				orderDetailPK.setOrdernumber(orderEntity.getOrdernumber());
				orderDetailPK.setProductcode(cartList.get(i).getProductCode());
				orderDetailEntity.get(i).setId(orderDetailPK);
				
				orderDetailBean.addOrderDetail(orderDetailEntity.get(i));	
				
				
				//deduct quantity of product from ProductEntity		
				productBean.setQuantityByProductCode(cartList.get(i).getProductCode(), (productBean.getQuantityByProductCode(cartList.get(i).getProductCode()))-(orderDetailEntity.get(i).getQuantityordered()));

			}
			

			// add payment details to database
			PaymentEntity paymentEntity = new PaymentEntity();

			paymentEntity.setAmount(new BigDecimal(totalPrice));
			paymentEntity.setPaymentdate(paymentDateFormat);
			
			PaymentEntityPK paymentEntityPKVal = new PaymentEntityPK();

			paymentEntityPKVal.setChecknumber(checkNumber);
			paymentEntityPKVal.setCustomernumber(Integer.parseInt(customerNumber));

			paymentEntity.setId(paymentEntityPKVal);

			paymentBean.addCustomerPayment(paymentEntity);
			
			//send to payment receipt
			session.setAttribute("PAYMENT_ENTITY", paymentEntity);

		} catch (Exception e) {
			e.printStackTrace();
		}

		//reset cart & placed order session attribute
		session.removeAttribute("CART");
		session.removeAttribute("PLACED_ORDER");

		//send attribute to show success payment
		request.setAttribute("CHECKOUT_SUCCESS","success");
		
		//pass the objects to payment receipt
		RequestDispatcher req = request.getRequestDispatcher("paymentReceipt.jsp");
		req.forward(request, response);
	}

}
