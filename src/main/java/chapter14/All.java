/* 目標
 * 	DB接続方法を理解する
 * DBの接続
 * 	書式
 * 		InitialContext ic=new InitialContext();
		DataSource ds=(DataSource)ic.lookup("java:/comp/env/接続設定名");
		Connection con=ds.getConnection();
	例
		InitialContext ic=new InitialContext();
		DataSource ds=(DataSource)ic.lookup("java:/comp/env/jdbc/book");
		Connection con=ds.getConnection();
		jdbc/bookという名前で定義されたDBに接続
 * SQLの実行
 * 	書式
 * 		PreparedStatement st=con.prepareStatement("SQL文");
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

@WebServlet(urlPatterns={"/chapter14/all"}) // urlにchapter14/allを設定
public class All extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); // レスポンスに必要な機能を取得
		Page.header(out); // tool/Page.javaのheaderメソッドを実行
		// 正常な場合の処理
		try { 
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/book");
			Connection con=ds.getConnection(); // DBに接続

			PreparedStatement st=con.prepareStatement(
			"select * from product"); // sqlの準備
			ResultSet rs=st.executeQuery(); // sqlの実行結果を取得
			
			/* rsの中身はこんな感じ
			 * ----------------------
			 * | i d | name | price |
			 * ----------------------
			 * |  1  |まぐろ|  100  |
			 * ----------------------
			 * |  2  | えび |  100  |
			 * ----------------------
			 * |  3  | イカ |  150  |
			 * ----------------------
			*/

			// sqlの実行結果を順に取得して表示
			while (rs.next()) {  // rsの次の要素が存在する限り処理を繰り返す
				out.println(rs.getInt("id")); // id列の値をint型で取得して表示
				out.println("：");
				out.println(rs.getString("name")); // name列の値をstring型で取得して表示
				out.println("：");
				out.println(rs.getInt("price")); // priceの値をint型で取得して表示
				out.println("<br>");
			}

			st.close();
			con.close(); // DBの切断
			
		// 例外発生時の処理
		} catch (Exception e) {
			e.printStackTrace(out); // 例外の内容を表示
		}
		Page.footer(out); // tool/Page.javaのheaderメソッドを実行
	}
}

