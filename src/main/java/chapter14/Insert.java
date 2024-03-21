package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter14/insert"}) // urlにchapter14/insertを指定
public class Insert extends HttpServlet {

	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out); // tool/Page.javaのheaderメソッドを実行
		// 正常な場合の処理
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/book");
			Connection con=ds.getConnection(); // DBに接続
			
			String name=request.getParameter("name"); // name="name"の値を取得
			int price=Integer.parseInt(request.getParameter("price")); // name="price"の値を取得
			
			PreparedStatement st=con.prepareStatement(
				"insert into product values(null, ?, ?)");
			st.setString(1, name);
			st.setInt(2, price);
			int line=st.executeUpdate(); // sqlの実行。処理した行数を取得
			
			if (line>0) {
				out.println("追加に成功しました。");
			}
			
			st.close();
			con.close(); // DBを閉じる
		// 例外発生時の処理
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out); // tool/Page.javaのfooterメソッドを実行
	}
}

