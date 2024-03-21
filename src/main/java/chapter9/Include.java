/* 目標
 * 	includeメソッドを使ったファイルの読み込み方を理解する
 * includeメソッド
 * 	書式
 * 		request.getRequestDispatcher("ファイル名").include(request, response);
 * 		指定したファイルを実行する
 * 	例
 * 		request.getRequestDispatcher("include1.jsp").include(request, response);
 * 		include1.jspを実行する
 */

package chapter9;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter9/include"}) // urlにchapter9/includeを指定
public class Include extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); // レスポンスをhtmlとして解釈
		PrintWriter out=response.getWriter(); // レスポンスに必要な機能を取得

		Page.header(out); // tool/Page.javaのheaderメソッドを実行
		request.getRequestDispatcher("include1.jsp") 
		.include(request, response);
		request.getRequestDispatcher("include2.jsp")
		.include(request, response); // include2.jspを実行（処理は戻ってくる）
		Page.footer(out); // tool/Page.javaのheaderメソッドを実行
	}
}


