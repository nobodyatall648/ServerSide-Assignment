package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ProductlineEntity;
import domain.ProductEntity;
import sessionbean.ProductSessionBeanLocal;
import utilities.ProductValidation;
import sessionbean.ProductLineSessionBeanLocal;


@WebServlet(name="/ProductController")
public class ProductController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ProductSessionBeanLocal productbean;
	
	public ProductController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ProductDetail.html");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String pcode = request.getParameter("productcode");
		String pname = request.getParameter("productname");
		String pscale = request.getParameter("productscale");
		String pvendor = request.getParameter("productvendor");
		String pdescription = request.getParameter("productdescription");
		String quantity = request.getParameter("quantityinstock");
		
		List<ProductEntity> p = (List<ProductEntity>) new ProductEntity();
		p = productbean.findProductByName(pname);
		
		PrintWriter out = response.getWriter();
		
		String[] s= {pcode, pname, pscale, pvendor, pdescription, quantity};
		
			if(ProductValidation.ProductValidation(request).equals("UPDATE")) {
				productbean.updateProduct(s);
			}else if(ProductValidation.ProductValidation(request).equals("DELETE")) {
				productbean.deleteProduct(pcode);
			}
			else {
				productbean.addProduct(s);
			}
			ProductValidation.naviJS(out);
			}
	}

