package utilities;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

public class ValidateEmployee {
	public static String ValidateEmployee(HttpServletRequest request) {
		if (request.getParameter("UPDATE") != null && request.getParameter("UPDATE").equals("UPDATE")) {
			return "UPDATE";
		} else if (request.getParameter("DELETE") != null && request.getParameter("DELETE").equals("DELETE")) {
			return "DELETE";
		}
		return "ADD";
	}
	public static void navigateJS(PrintWriter out) {
		out.println("<SCRIPT type=\"text/javascript\">");
		out.println("alert(\"Record has been updated and url will be redirected\")");
		out.println("</SCRIPT>");
		out.println("<td> <button type='submit' value='OK' onclick =\"window.location.href='indexAdmin.jsp'\">BACK</button> </td>");
		
	}

}
