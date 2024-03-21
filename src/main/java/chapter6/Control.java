package chapter6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter6/control"}) // urlにchapter6/controlを指定
public class Control extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); // レスポンスをhtmlで解釈
		PrintWriter out=response.getWriter(); // レスポンスに必要な機能を取得

		Page.header(out); // tool/Page.javaのheaderメソッドを実行

		request.setCharacterEncoding("UTF-8"); // リクエストをutf-8でエンコーディング
		List<String> names=Collections.list(request.getParameterNames()); // パラメータ覧の取得
		for (String name : names) { // パラメータの内容を順に表示
			String[] values=request.getParameterValues(name);
			for (String value : values) { // valuesの名前と値を順に表示
				out.println("<p>"+name+"="+value+"</p>");
			}
		}
		Page.footer(out); // tool/Page.javaのheaderメソッドを実行
	}
}

/* for文２回も使う理由ある？
 *	[ name1: value1,
 *	  name2: value2,
 *	  name3: [value3, value4]
 *  ]
 *  の書式で値が返ってくる
*/