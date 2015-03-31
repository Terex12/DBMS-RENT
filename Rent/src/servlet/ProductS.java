package servlet;

import javax.servlet.*;
import javax.servlet.http.*;

import util.PageList;

import java.io.*;
import java.sql.ResultSet;

import dao.ProductDao;

public class ProductS extends HttpServlet {

	ProductDao pd = new ProductDao();
	
	public void init() throws ServletException {
		super.init();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		switch (Integer.parseInt(request.getParameter("flag"))) {
			case 0:
				findAll(request, response);
				break;
			case 1:
				findSingle(request, response);
				break;
			}
		}

		public void findAll(HttpServletRequest request, HttpServletResponse response) {
			
			try {
				Integer curPage = 0;
				Integer rowPerPage = 10;
				if (request.getParameter("start") == null) {
					curPage=1;
				} else {
					curPage=Integer.parseInt(request.getParameter("start"));
				}
				PageList pl = new PageList("product",curPage,rowPerPage);		//if table name change!!
				
				String keyword = request.getParameter("keyword");

				request.setAttribute("page", pl);
				request.setAttribute("findAllGoods", pd.getAllProductByPage(pl.getCurrentCount(),pl.getRowsPerPage(),keyword));
				
				RequestDispatcher rd = request.getRequestDispatcher("/homepage.jsp?keyword=" + keyword);
				rd.forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void findSingle(HttpServletRequest request, HttpServletResponse response) {
			Integer id = Integer.parseInt(request.getParameter("proid"));
			try {
				request.setAttribute("product", pd.findById(id));
				RequestDispatcher rd = request.getRequestDispatcher("/product.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
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