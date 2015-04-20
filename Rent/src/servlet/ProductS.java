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
				Integer rowPerPage = 100;
				if (request.getParameter("start") == null) {
					curPage=1;
				} else {
					curPage=Integer.parseInt(request.getParameter("start"));
				}		
				
				String keyword = (String) request.getSession().getAttribute("keyword");
			
				System.out.println("ProductS44-- " + keyword);
				
				int temp = 0;
				try{
					temp = Integer.valueOf(keyword);
				}catch(Exception e){
					temp = Integer.MIN_VALUE;
				}
				if (temp == Integer.MIN_VALUE){
					if (!keyword.substring(0, 4).equals("star")){	//search bar
						PageList pl = new PageList("PRODUCTS",curPage,rowPerPage,keyword);		//if table name change!!
						request.setAttribute("page", pl);
						System.out.println("ProductS60-- current page=" + pl.getCurrentCount() + "row per page" +pl.getRowsPerPage());
						request.setAttribute("findAllGoods", pd.getAllProductByPage(pl.getCurrentCount(),pl.getRowsPerPage(),keyword));
					}
					else{	//search rate star
						PageList pl = new PageList("PRODUCTS",curPage,rowPerPage,keyword);		//if table name change!!
						request.setAttribute("page", pl);
						System.out.println("ProductS65-- current page=" + pl.getCurrentCount() + "row per page" +pl.getRowsPerPage());
						request.setAttribute("findAllGoods", pd.getAllProductByPage2(pl.getCurrentCount(),pl.getRowsPerPage(),keyword));
					}
				}
				else{	//category
					PageList pl = new PageList("PRODUCTS",curPage,rowPerPage,String.valueOf(temp));		//if table name change!!
					request.setAttribute("page", pl);
					request.setAttribute("findAllGoods", pd.getAllProductByPage1(pl.getCurrentCount(),pl.getRowsPerPage(),temp));
				}
				
				RequestDispatcher rd = request.getRequestDispatcher("/mainpage.jsp?keyword=" + keyword);
				rd.forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void findSingle(HttpServletRequest request, HttpServletResponse response) {
			Integer id = Integer.parseInt(request.getParameter("proid"));
			try {
				request.setAttribute("product", pd.findById(id));
				RequestDispatcher rd = request.getRequestDispatcher("/item.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void destroy() {
		super.destroy();
	}

}