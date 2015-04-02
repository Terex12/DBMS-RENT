package servlet;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.UserDao;

import java.io.*;

import bean.UserInfo;

public class UserRegisterS extends HttpServlet {

	public void init() throws ServletException {
		super.init();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errMsg = "";
		RequestDispatcher rd;
		String username = request.getParameter("username");
		String name = request.getParameter("realname");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		UserInfo user = new UserInfo();
		user.setUserName(username);
		user.setName(name);
		user.setAddress(address);
		user.setPassword(password);
		user.setEmail(email);
		
		UserDao userdao = new UserDao();
		
		try {
			int result = userdao.checkExists(username);

			if(result == 0){
				if (userdao.insertUser(user)) {
					response.sendRedirect("login.jsp");
				} else {
					errMsg = "Register Fails";
				}
			}
			else{
				//response.sendRedirect("register.jsp");
				errMsg = "Exist this user";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (errMsg != null && !errMsg.equals("")){
			rd = request.getRequestDispatcher("/register.jsp");
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