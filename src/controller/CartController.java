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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// remove from cart
		HttpSession session = request.getSession();
		String productCode = request.getParameter("productCode");

		try {
			List<Cart> cartList = (List<Cart>) session.getAttribute("CART");

			int loc = -9999;

			// finding the correct index with productCode
			for (int i = 0; i < cartList.size(); i++) {
				if (cartList.get(i).getProductCode().equals(productCode)) {
					loc = i;
					break;
				}
			}

			if (loc != -9999) {
				cartList.remove(loc);
				session.setAttribute("CART", cartList);
			}

		} catch (Exception e) {

		}

		RequestDispatcher req = request.getRequestDispatcher("addOrder.jsp");
		req.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// add to cart
		PrintWriter out = response.getWriter();

		String productCode = request.getParameter("productCode");
		String custNum = request.getParameter("customernumber");
		String requiredDate = request.getParameter("requiredDate");
		String comments = request.getParameter("comments");
		String qty = request.getParameter("qty");

		HttpSession session = request.getSession();

		// init
		Cart cart = new Cart();

		cart.setProductCode(productCode);
		cart.setCustomerNumber(Integer.parseInt(custNum));
		cart.setRequiredDate(requiredDate);
		cart.setComments(comments);
		cart.setQty(Integer.parseInt(qty));
		
		boolean jsAlert = false;
		// catching null when 1st time adding to cart
		try {
			List<Cart> cartList = (List<Cart>) session.getAttribute("CART");
			
			// check redundancy
			boolean redundant = false;

			for (int i = 0; i < cartList.size(); i++) {
				if (cartList.get(i).getProductCode().equals(productCode)) {
					redundant = true;
					break;
				}
			}			

			if (redundant == false) {
				cartList.add(cart);
				session.setAttribute("CART", cartList);
			} else {
				jsAlert = true;
			}
		} catch (Exception e) {
			List<Cart> cartList = new ArrayList<Cart>();
			cartList.add(cart);
			session.setAttribute("CART", cartList);
		}

		if (jsAlert == true) {
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('redundant product code found in the cart.');");  
			out.println("location='addOrder.jsp';");
			out.println("</script>"); 	
		} else {
			RequestDispatcher req = request.getRequestDispatcher("addOrder.jsp");
			req.forward(request, response);
		}
	}

}
