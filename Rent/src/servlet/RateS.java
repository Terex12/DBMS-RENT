package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderInfo;



public class RateS extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int proid = Integer.parseInt(request.getParameter("proid"));
		LinkedList<OrderInfo> order = (LinkedList<OrderInfo>) request.getSession().getAttribute("order");
		
		
		for (OrderInfo oi : order){
			if (oi.getProid() == proid){
				request.setAttribute("singleProduct", oi);
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("productrate.jsp");
		rd.forward(request, response);
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void destroy() {
		super.destroy();
	}
}