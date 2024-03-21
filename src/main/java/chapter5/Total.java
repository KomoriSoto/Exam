// 目標：int型でデータを受け取る
package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter5/total"}) // URLにchapter5/totalを指定
public class Total extends HttpServlet { 

	public void doPost ( // 情報を受け取って処理を行う
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); // htmlを返す
		PrintWriter out=response.getWriter(); // レスポンスに必要な機能を取得

		// 正常な場合の処理を記述
		try { 
			request.setCharacterEncoding("UTF-8"); // htmlの内容をutf-8で受け取る
			int price=Integer.parseInt(request.getParameter("price")); // name="price"の値をint型で取得
			int count=Integer.parseInt(request.getParameter("count")); // name="count"の値をint型で取得

			Page.header(out); // tool/Page.javaのheaderメソッドを実行
			out.println(price+"円×");
			out.println(count+"個＝");
			out.println(price*count+"円"); // 単価 * 個数の表示
			Page.footer(out); // tool/Page.javaのheaderメソッドを実行
		// 例外発生時の処理
		} catch (NumberFormatException e) {
			out.println("数値を入力してください。"); // エラー分の表示
		}
	}
}

/* 例外処理
 * 	説明
 * 		正常に処理が行われた場合と例外が発生した場合の処理を分ける
 * 	書式
 * 		try { 
 * 			正常な場合の処理
 * 		} catch (エラーの種類 e) {
 * 			例外発生時の処理
 * 		}
*/

/* 数値の取得
 * 	書式
 * 		int 変数 = Integer.parseInt(request.getParameter("name属性"));
 * 	例
 * 		int price=Integer.parseInt(request.getParameter("price"));
 * 		name=priceの値をint型で取得
*/
