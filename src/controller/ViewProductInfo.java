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

import domain.ProductEntity;
import domain.ProductlineEntity;
import sessionbean.ProductSessionBeanLocal;
import sessionbean.ProductLineSessionBeanLocal;


@WebServlet("/ViewProductInfo")
public class ViewProductInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	ProductSessionBeanLocal productBean;
	
	@EJB
	ProductLineSessionBeanLocal productlineBean;
	/**
     * @see HttpServlet#HttpServlet()
     */
	public ViewProductInfo() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        List<ProductEntity> productList = productBean.getAllProduct();
		List<ProductlineEntity> productLineList = productlineBean.getAllProductLine();
		
		request.setAttribute("PRODUCT_LIST", productList);
		//request.setAttribute("PRODUCTLINE_LIST", productLineList);
		RequestDispatcher req = request.getRequestDispatcher("ViewProductInfo.jsp");
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
