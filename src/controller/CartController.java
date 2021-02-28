package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Cart;
import domain.ProductEntity;

import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
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
		//add to cart
		PrintWriter out = response.getWriter();
		
		String productCode = request.getParameter("productCode");
		String custNum = request.getParameter("customernumber");
		String requiredDate = request.getParameter("requiredDate");
		String comments = request.getParameter("comments");
		String qty = request.getParameter("qty");
		
		HttpSession session = request.getSession();
		
		//init
		Cart cart = new Cart();		
		boolean firstTimeCart = false;
		
		cart.setProductCode(productCode);
		cart.setCustomerNumber(Integer.parseInt(custNum));
		cart.setRequiredDate(requiredDate);		
		cart.setComments(comments);
		cart.setQty(Integer.parseInt(qty));
		
		//catching null when 1st time adding to cart
		try {
			List<Cart> cartList = (List<Cart>) session.getAttribute("CART");				
			cartList.add(cart);
			session.setAttribute("CART", cartList);
		}catch(Exception e) {
			List<Cart> cartList = new ArrayList<Cart>();	
			cartList.add(cart);
			session.setAttribute("CART", cartList);
		}
		
		
		RequestDispatcher req = request.getRequestDispatcher("addOrder.jsp");
		req.forward(request, response);
		
	}

}
