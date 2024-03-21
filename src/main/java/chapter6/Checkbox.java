package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter6/checkbox"}) // urlにchapter6/checkboxを指定
public class Checkbox extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); // レスポンスをhtmlとして解釈
		PrintWriter out=response.getWriter(); // レスポンスに必要な機能を取得

		request.setCharacterEncoding("UTF-8"); // リクエストをutf-8でエンコーディング
		String[] genre=request.getParameterValues("genre"); // name="genre"の値を取得

		Page.header(out); // tool/Page.javaのheaderメソッドを実行
		if (genre!=null) { // チェックされているときの処理
			for (String item : genre) { // 配列genreの中身を順に取り出す
				out.println("「" + item + "」"); // 取り出した内容を表示（"文字列" + item + "文字列"の書式）
			}
			out.println("に関するお買い得情報をお送りします。");
		} else {
			out.println("お買い得情報はお送りしません。");
		}
		Page.footer(out); // tool/Page.javaのfooterメソッドを実行
	}
}
