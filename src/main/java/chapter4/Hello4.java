// 目標：サーブレットで共通の処理をまとめられるようにする
package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page; // tool/Page.javaを読み込む

@WebServlet(urlPatterns={"/chapter4/hello4"})
public class Hello4 extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();

		Page.header(out); // tool/Page.javaのheaderの内容を出力

		out.println("<p>Hello!</p>");
		out.println("<p>こんにちは！</p>");
		out.println("<p>"+new java.util.Date()+"</p>");

		Page.footer(out); // tool/Page.javaのfooterの内容を出力
	}
}

/* 外部ファイルの読み込み
 * 	書式
 * 		import ファイルのパス
 * 	例
 * 		import tool.Page
 * 		tool/Page.javaの内容を読み込む
*/
