package servlet;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedList;

import dao.ProductDao;
import dao.UserDao;
import bean.CartInfo;
import bean.UserInfo;

public class StarS extends HttpServlet {

	public void init() throws ServletException {
		super.init();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword = (String) request.getParameter("star");
		RequestDispatcher rd;
		request.getSession().setAttribute("keyword", keyword);
		rd = request.getRequestDispatcher("ProductS?flag=0&&keyword=" + keyword);
		rd.forward(request, response);
	}

	//same as post method
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void destroy() {
		super.destroy();
	}

}