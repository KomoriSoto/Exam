/* 目標
 * 	プレースホルダを使ったSQLの実行方法を理解する
 * プレースホルダ
 * 	説明
 * 		SQL文を仮で作成してから変数の値を追加することでSQLインジェクションの対策を行う
 * 	書式
 * 		PreparedStatement st=con.prepareStatement("SQL文");
		st.setString(1, "%"+変数+"%"); 
		ResultSet rs=st.executeQuery(); 
 */

package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter14/search"}) // urlにchapter14/searchを指定
public class Search extends HttpServlet {
	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); // レスポンスに必要な機能を取得
		Page.header(out); // tool/Page.javaのheaderメソッドを実行
		// 正常な場合の処理
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/book");
			Connection con=ds.getConnection(); // DBの接続

			String keyword=request.getParameter("keyword"); // name="kyeword"の値を取得

			PreparedStatement st=con.prepareStatement(
				"select * from product where name like ?"); // sql文の準備
			st.setString(1, "%"+keyword+"%"); // 1番目の?にkeywordの値を代入してsql文の作成
			ResultSet rs=st.executeQuery(); // sqlの実行

			while (rs.next()) { // sqlの実行結果を順に表示
				out.println(rs.getInt("id")); // id列の値をint型で表示
				out.println("：");
				out.println(rs.getString("name")); // name列の値をstring型で表示
				out.println("：");
				out.println(rs.getInt("price")); // price列の値をint型で表示
				out.println("<br>");
			}

			st.close();
			con.close();
		// 例外発生時の処理
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}


