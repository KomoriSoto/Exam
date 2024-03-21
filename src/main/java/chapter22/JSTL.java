/* 目標
 * 	JSTLの記法を理解する
 * JSTLとは
 * 	jspでfor文やif文が使えるようになる便利機能(タグライブラリの一種)
 * for文の書式
 * <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 * 	<c:forEach var="変数" items="${配列}">
		処理
	</c:forEach>
	配列の値を一つずつ変数に代入して処理を行う
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:forEach var="p" items="${list}">
		${p.id}：${p.name}：${p.price}<br>
	</c:forEach>
	配列listの内容を一つずつ変数pに代入してid, name, priceを表示
*/

package chapter22;

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

@WebServlet(urlPatterns={"/chapter22/jstl"}) // urlに/chapter22/jstlを指定
public class JSTL extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); // レスポンスに必要な機能を取得
		try {
			ProductDAO dao=new ProductDAO(); // ProductDAOのコピーを作成
			List<Product> list=dao.search(""); // ProductDAOのsearchメソッドを実行(全商品データを取得)
			
			/* listの中身は以下の通り(実際は全商品のデータが格納されている)
			 *   ------------------------------------------------- 
			 *  |           0            |            1           |
			 *   -------------------------------------------------|
			 *  |  --------------------  |  --------------------  |
			 *  | | i d | name | price | | | i d | name | price | |
			 *  |  --------------------  |  --------------------  |
			 *  | |  1  |まぐろ|  100  | | |  2  |ハマチ|  100  | |
			 *  |  --------------------  |  --------------------  |
			 *   -------------------------------------------------
			 */   

			request.setAttribute("list", list); // 商品データをlistという名前で保存

			request.getRequestDispatcher("jstl.jsp") // jstl.jspに遷移
				.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}
}

