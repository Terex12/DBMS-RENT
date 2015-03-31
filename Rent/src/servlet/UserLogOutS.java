package servlet;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedList;


public class UserLogOutS extends HttpServlet {

	public void init() throws ServletException {
		super.init();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getSession().removeAttribute("userinfo");
			request.getSession().removeAttribute("Shoppingcart");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
	}

	//same as post method
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void destroy() {
		super.destroy();
	}

}