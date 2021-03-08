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

import domain.OrderdetailEntity;
import sessionbean.OrderDetailSessionBeanLocal;

/**
 * Servlet implementation class GetOrderDetails
 */
@WebServlet("/GetOrderDetailsByEmployee")
public class GetOrderDetailsByEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB
	OrderDetailSessionBeanLocal orderDetailBean;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrderDetailsByEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderNum = request.getParameter("ordernumber");
		
		List<OrderdetailEntity> orderDetailList = orderDetailBean.getOrderDetalByOrderNumber(orderNum);
		
		request.setAttribute("ORDER_DETAIL_LISTBYEMP", orderDetailList);
		RequestDispatcher req = request.getRequestDispatcher("employeeViewCustomerOrder.jsp");
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
