package chapter15;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter15/nobean"})
public class NoBean extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);

		int id=1;
		String name="まぐろ";
		int price=100;

		out.println(id);
		out.println("：");
		out.println(name);
		out.println("：");
		out.println(price);

		Page.footer(out);
	}
}

/* Beanとは
 * 	説明	
 * 		関連する情報をまとめる枠組み
 * 		必要なデータをクラスにまとめておく
 * 	メリット
 * 		データの意図しない書き換えを防ぐことができる（カプセル化）
 * 		処理の抜け漏れをなくすことができる
*/
