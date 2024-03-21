/* 目標
 * 	EL式の使い方を理解する
 * EL式とは
 * 	jspでデータの取得処理を簡潔にする記法
 * 書式
 * 	${式}
 * 例
 * 	<p> ${ product.id } </p>
 * 	productのidの値を取得する
*/

package chapter21;

import java.io.IOException;

import bean.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter21/el"}) // urlにchapter21/elを指定
public class EL extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		Product p=new Product(); // Productクラスをコピーする
		
		/* pのイメージ図(こんな感じの箱ができている状態です)
		 *  --------------------
		 * | i d | name | price |
		 *  --------------------
		 * |     |      |       |
		 *  --------------------
		*/  
		
		p.setId(1); // ProductクラスのIDに1を設定
		p.setName("まぐろ"); // Productクラスのnameにまぐろを設定
		p.setPrice(100); // Productクラスのpriceに100を設定

		/* pのイメージ図(箱の中に値を入れている状態です)
		 *  --------------------
		 * | i d | name | price |
		 *  --------------------
		 * |  1  |まぐろ|  100  |
		 *  --------------------
		*/  
		
		request.setAttribute("product", p); // pの値をproductという名前で使えるようにする

		request.getRequestDispatcher("el.jsp") // el.jspにページ遷移
			.forward(request, response);
	}
}

