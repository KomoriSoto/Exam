package chapter17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import bean.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Page;

@WebServlet(urlPatterns={"/chapter17/cart-get"}) // urlに/chapter17/cart-getを指定
public class CartGet extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); // レスポンスに必要な機能を取得
		Page.header(out); // tool/Page.javaのheaderメソッドを実行

		HttpSession session=request.getSession(); // セッションを開始

		List<Product> cart=(List<Product>)session.getAttribute("cart"); // セッションのcartの値を取得

		for (Product p : cart) { // cartの値を順に表示
			out.println("<p>");
			out.println(p.getName());
			out.println("：");
			out.println(p.getPrice());
			out.println("</p>");
		}

		Page.footer(out);
	}
}

