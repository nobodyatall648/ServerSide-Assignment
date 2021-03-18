package utilities;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

public class ProductValidation {
	public static String ProductValidation(HttpServletRequest request) {
		if(request.getParameter("UPDATE") != null && request.getParameter("UPDATE").equals("UPDATE")) {
			return "UPDATE";
		}else if (request.getParameter("DELETE") != null && request.getParameter("DELETE").equals("DELETE")) {
			return "DELETE";
		}
		return "ADD";
	}
	
	public static void 
}
