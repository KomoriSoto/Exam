// 目標：GETによるページ間の値の受け渡しを理解する
package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter5/greeting"}) // URLにchapter5/greetingを指定
public class Greeting extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
//		ページにアクセスがあったときに行われる処理
		response.setContentType("text/html; charset=UTF-8"); // htmlとして解釈
		PrintWriter out=response.getWriter(); // レスポンスに必要な機能を取得

		request.setCharacterEncoding("UTF-8"); // 受け取った値をutf-8でエンコーディング
		String user=request.getParameter("user"); // name="user"の値を取得

		Page.header(out); // Page.javaのheaderメソッドを実行
		out.println("<p>こんにちは、"+user+"さん！</p>"); // 名前の表示
		Page.footer(out); // Page.javaのheaderメソッドを実行
	}
}

/* responseとrequest
 * 	説明
 * 		response：サーバ→クライアントに送られる値
 * 		request	：クライアント→サーバに送られる値
 * 		このプログラムではクライアントが入力した値を受け取るのでrequestも使用しています
*/

/* getParameterメソッド
 * 	説明
 * 		html内の情報を取得
 * 	書式
 * 		String 変数 = request.getParameter("name属性");
 * 	例
 * 		String user=request.getParameter("user");
 * 		変数userにname="user"の値を代入
*/

/* GET通信とPOST通信
 * 	GET通信	：情報を取得する際に使用（URL、商品検索）。情報がURLに記載される。
 * 	POST通信：情報を送信する際に使用（認証情報、フォームの入力）
*/

