// 目標：サーブレットで日本語を出力できるようにする

package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter4/hello2"}) // URLに/chapter4/hello2を指定
public class Hello2 extends HttpServlet {

	public void doGet ( 
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException { 
//		ページにアクセスしたときに行われる処理
		response.setContentType("text/plain; charset=UTF-8"); // 日本語の使用設定
		PrintWriter out=response.getWriter(); // レスポンスに必要な機能を取得
		out.println("Hello!"); // Helloと表示
		out.println("こんにちは！"); // こんにちはと表示できるようになる
		out.println(new java.util.Date());
	}
}

/* urlPatternについて
 * 	同じURLが複数あるとエラーになるのでコピペをする際は気を付けましょう
 * 	Tomcatは起動に失敗しましたというエラーが出ます
*/

/* setContentTypeメソッド
 * 	説明
 * 		レスポンスの文字エンコーディングとMIMEタイプを指定
 * 	書式
 * 		response.setContentType("MIMEタイプ; charset=文字コード");
 * 	例
 * 		response.setContentType("text/plain; charset=UTF-8");
 * 		レスポンスをutf-8のテキストで表示する
 * 		response.setContentType("text/html; charset=UTF-8");
 * 		レスポンスをutf-8のテキストで表示する
 */
