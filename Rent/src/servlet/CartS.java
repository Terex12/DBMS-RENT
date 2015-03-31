package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import bean.ProductInfo;
import bean.CartInfo;

public class CartS extends HttpServlet {
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		switch(Integer.parseInt(request.getParameter("flag"))) {
		case 0:
			add(request, response);
			break;
		case 1:
			changeNum(request, response);
			break;
		case 2:
			clearCart(request, response);
			break;
		case 3:
			removeCart(request, response);
			break;
		}
	}

	public void add(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("proid"));
		try {
			int exitNum = 0;

			LinkedList<CartInfo> cart = (LinkedList<CartInfo>) request.getSession().getAttribute("Shoppingcart");

			for (int i = 0; i < cart.size(); i++) {
				if (cart.get(i).getId() == id) {
					exitNum = cart.get(i).getQuantity();
					cart.remove(cart.get(i));
				}
			}
			
			CartInfo sc = new CartInfo();
			ProductDao pd = new ProductDao();
			ProductInfo pro = pd.findById(id);

			sc.setProductName(pro.getProName());
			sc.setQuantity(exitNum + 1);
			sc.setPrice(pro.getPrice());
			sc.setId(pro.getProId());
			
			cart.add(sc);
			
			RequestDispatcher rd = request.getRequestDispatcher("/addsuccess.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public void changeNum(HttpServletRequest request, HttpServletResponse response) {
		LinkedList<CartInfo> cart = (LinkedList<CartInfo>) request.getSession().getAttribute("Shoppingcart");
		try {
			String[] number = request.getParameterValues("num");
			LinkedList<CartInfo> listSc = new LinkedList<CartInfo>();
			for (int i = 0; i < cart.size(); i++) {
				cart.get(i).setQuantity(Integer.parseInt(number[i]));
				listSc.add(cart.get(i));
			}
			request.getSession().setAttribute("Shoppingcart", listSc);
			RequestDispatcher rd = request.getRequestDispatcher("shoppingcart.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void clearCart(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.getSession().setAttribute("Shoppingcart", new LinkedList<CartInfo>());
			RequestDispatcher rd = request.getRequestDispatcher("clearcart.jsp?keyword=" + request.getAttribute("keyword"));
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeCart(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		LinkedList<CartInfo> cart = (LinkedList<CartInfo>) request.getSession().getAttribute("Shoppingcart");
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getId() == id) {
				cart.remove(cart.get(i));
			}
		}
		request.getSession().setAttribute("Shoppingcart", cart);
		RequestDispatcher rd = request.getRequestDispatcher("shoppingcart.jsp");
		try {
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