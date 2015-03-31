package servlet;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedList;

import dao.UserDao;
import bean.CartInfo;
import bean.UserInfo;

public class UserLoginS extends HttpServlet {

	public void init() throws ServletException {
		super.init();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String errMsg = "";
		RequestDispatcher rd;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDao userdao = new UserDao();
		try {
			LinkedList<UserInfo> lu = userdao.findByUsername(username);
			if (lu.size() > 0 && lu.get(0).getPassword().equals(password)){
				request.getSession().setAttribute("userinfo", lu.get(0));
				LinkedList<CartInfo> cart = new LinkedList<CartInfo>();
				request.getSession().setAttribute("Shoppingcart", cart);
				rd = request.getRequestDispatcher("/searchwelcom.jsp");
				//rd = request.getRequestDispatcher("ProductS?flag=0");
				rd.forward(request, response);
			}
			else{
				errMsg = "No this User";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (errMsg != null && !errMsg.equals("")){
			rd = request.getRequestDispatcher("/login.jsp");
			request.setAttribute("err", errMsg);
			rd.forward(request, response);
		}
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