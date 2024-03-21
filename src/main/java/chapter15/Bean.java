/* 目標
 * 	Beanの使い方を理解する
 * Beanとは
 * 	関連する情報をまとめる枠組み
 * 	意味のある情報の設定方法と取得方法をまとめておく
 * 		バグの影響を小さくできる
*/

package chapter15;

import java.io.IOException;
import java.io.PrintWriter;

import bean.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter15/bean"}) // urlに/chapter15/beanを設定
public class Bean extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		// ページにアクセスがった時の処理
		PrintWriter out=response.getWriter(); // レスポンスに必要な機能を取得
		Page.header(out); // tool/Page.javaのheaderメソッドを実行

		Product p=new Product(); // オブジェクトの作成（Productのコピーを作成）
		
		/* pのイメージ図(こんな感じの箱ができている状態です)
		 *  --------------------
		 * | i d | name | price |
		 *  --------------------
		 * |     |      |       |
		 *  --------------------
		*/  

		p.setId(1); // idに1を設定
		p.setName("まぐろ"); // nameにまぐろを設定
		p.setPrice(100); // priceに100を設定
		
		/* pのイメージ図(箱の中に値を入れている状態です)
		 *  --------------------
		 * | i d | name | price |
		 *  --------------------
		 * |  1  |まぐろ|  100  |
		 *  --------------------
		*/  

		out.println(p.getId()); // idを取得して表示
		out.println("：");
		out.println(p.getName()); // nameを取得して表示
		out.println("：");
		out.println(p.getPrice()); // priceを取得して表示

		Page.footer(out); // tool/Page.javaのfooterメソッドを実行
	}
}


