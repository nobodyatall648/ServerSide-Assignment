package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ProductEntity;
import sessionbean.ProductSessionBeanLocal;

/**
 * Servlet implementation class GetProductInfo
 */
@WebServlet("/GetProductInfo")
public class GetProductInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	ProductSessionBeanLocal productBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProductInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String productCode = request.getParameter("productCode");
		
		try {
			ProductEntity productInfo = productBean.getProductByProductCode(productCode);
			
			request.setAttribute("PRODUCT_INFO", productInfo);
			RequestDispatcher req = request.getRequestDispatcher("addOrder.jsp");
			req.forward(request, response);
		} catch (EJBException e) {
			out.println("[error]: " + e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
