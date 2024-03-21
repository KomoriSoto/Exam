package chapter15;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import bean.Product;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter15/search"}) // urlに/chapter15/searchを指定
public class Search extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		// ページにアクセスがあった時の処理
		PrintWriter out=response.getWriter(); // レスポンスに必要な機能を取得
		Page.header(out); // tool/Page.javaのheaderメソッドを実行
		
		// 正常に動作したときの処理
		try {
			String keyword=request.getParameter("keyword"); // name=keywordの値を取得

			ProductDAO dao=new ProductDAO(); // ProductDAOをインスタンス化(ProductDAOのメソッドを使えるようにする
			List<Product> list=dao.search(keyword); // ProductDAOのsearchメソッドを実行

			for (Product p : list) { // 取得した値を順に取り出す
				out.println(p.getId()); // idを取り出す
				out.println("：");
				out.println(p.getName()); // nameを取り出す
				out.println("：");
				out.println(p.getPrice()); // priceを取り出す
				out.println("<br>");
			}
		// 例外発生時の処理
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}

