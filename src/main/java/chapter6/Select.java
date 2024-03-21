package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter6/select"}) // URLにchapter6/selectを指定
public class Select extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); // レスポンスをhtmlで出力
		PrintWriter out=response.getWriter(); // レスポンスに必要な機能を取得

		request.setCharacterEncoding("UTF-8"); // リクエストをutf-8でエンコーディング
		String count=request.getParameter("count"); // name=countの値を取得
		String payment=request.getParameter("payment"); // name=paymentの値を取得
		String review=request.getParameter("review"); // name=reviewの値を取得
		String mail=request.getParameter("mail"); // name=mailの値を取得

		Page.header(out); // tool/Page.javaのheaderメソッドを実行
		out.println("<p>"+count+"個の商品をカートに入れました。</p>"); // セレクトボックス=>valueの値を取得
		out.println("<p>お支払い方法を"+payment+"に設定しました。</p>"); // ラジオボタン=>valueの値を取得
		out.println("<p>ご感想ありがとうございます。</p>"); // テキストエリア=>入力された内容を取得
		out.println("<p>「"+review+"」</p>"); // チェックボックス（１つ）=>チェックされている(true)されていない(false)
		if (mail!=null) { // チェックされてる時の処理
			out.println("<p>メールをお送りします。</p>");
		} else { // チェックされていないときの処理
			out.println("<p>メールはお送りしません。</p>");
		}
		Page.footer(out); // tool/Page.javaのheaderメソッドを実行
	}
}

