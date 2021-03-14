package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.CustomerEntity;
import domain.OrderEntity;
import sessionbean.CustomerSessionBeanLocal;
import sessionbean.OrderSessionBeanLocal;

/**
 * Servlet implementation class GetEmpHandleCustStatus
 */
@WebServlet("/GetCustOrdersForUpdateStatus")
public class GetCustOrdersForUpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	CustomerSessionBeanLocal customerBean;
	
	@EJB
	OrderSessionBeanLocal orderBean;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCustOrdersForUpdateStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String empno = ""; 
		String customerNumber = "";
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie c = cookies[i];
			if (c.getName().equals("uid")) {
				empno = c.getValue();
			}
		}
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String filtering = request.getParameter("filter");
		String custNum = request.getParameter("custnum");
		
		try {

			CustomerEntity custEntity = customerBean.getCustomerByCustNum(custNum);

		//check customer sales representative matching
		if(custEntity.getEmployee().getEmployeenumber() == Integer.parseInt(empno)) {
			List<OrderEntity> orderList = orderBean.getOrderByCustNum(custNum);
			
			//filter option show all or filter shipped status order
			if(filtering.equals("all")) {
				session.setAttribute("ORDERLIST", orderList);
				session.setAttribute("CUSTLIST", custEntity);
				RequestDispatcher req = request.getRequestDispatcher("UpdateCustOrderStatus.jsp");
				
				req.forward(request, response);
			}else if(filtering.equals("filter_ship")) {
				List<OrderEntity> filterShippedOrderList = new ArrayList<OrderEntity>();
				
				for(int i=0; i < orderList.size(); i++) {
					if(!orderList.get(i).getStatus().equals("Shipped")) {
						filterShippedOrderList.add(orderList.get(i));
					}
				}				
				
				session.setAttribute("CUSTLIST", custEntity);				
				session.setAttribute("ORDERLIST", filterShippedOrderList);
				RequestDispatcher req = request.getRequestDispatcher("UpdateCustOrderStatus.jsp");
				
				req.forward(request, response);
			}
		}else {
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('You are not the sales representative of the customer.');");  
			out.println("location='UpdateCustOrderStatus.jsp';");
			out.println("</script>"); 	
		}
		
		
		}catch(Exception e) {
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Something wrong happen here.');");  
			out.println("location='UpdateCustOrderStatus.jsp';");
			out.println("</script>"); 	
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
