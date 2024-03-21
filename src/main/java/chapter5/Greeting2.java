// 目標：POSTによるページ間の値の受け渡しを理解する
package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter5/greeting2"})
public class Greeting2 extends HttpServlet {

	public void doPost ( // post通信を行う際はdoPostメソッドを使う
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter(); // レスポンスの出力に必要な機能を準備

		request.setCharacterEncoding("UTF-8"); // 受け取った内容をutf-8にエンコーディング
		String user=request.getParameter("user"); // name="user"の値を取得

		Page.header(out); // Page.javaのheaderメソッドを実行
		out.println("<p>こんにちは、"+user+"さん！</p>"); // ユーザ名を表示
		Page.footer(out); // Page.javaのheaderメソッドを実行
	}
}
