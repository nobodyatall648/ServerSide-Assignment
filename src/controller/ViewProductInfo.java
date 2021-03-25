package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
		
		PrintWriter out = response.getWriter();
		
		String pageReq = request.getParameter("page");
				
        //List<ProductEntity> productList = productBean.getAllProduct();
		//List<ProductlineEntity> productLineList = productlineBean.getAllProductLine();
		
		//pagination part
		int prodQty = productBean.getProductQuantity();
		int prodShowInPage = 15;
		int pagesNumber = prodQty / prodShowInPage;
		
		if(prodQty % prodShowInPage != 0) {
			pagesNumber++;
		}
		
		int viewPage = 0;
		
		List<ProductEntity> productList = new ArrayList<ProductEntity>();
		if(pageReq == null) {
			//default page 1
			viewPage = 1;
			productList = productBean.getProductByPageNum(viewPage);
		}else {
			viewPage = Integer.parseInt(pageReq);
			productList = productBean.getProductByPageNum(viewPage);
		}
		
		//testing
		out.println("[rows]: " + productList.size());
		for(int i=0; i < productList.size(); i++) {
			out.println(productList.get(i).getProductcode());
			out.println(productList.get(i).getProductname());
			out.println();
		}
		
		request.setAttribute("VIEW_PAGE", viewPage);
		request.setAttribute("PRODUCT_LIST", productList);
		request.setAttribute("MAX_PAGE_NUM", pagesNumber);
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
