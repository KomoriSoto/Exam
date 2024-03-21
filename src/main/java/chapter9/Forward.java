/* 目標
 * 	forwardを使ったページ遷移について理解する
 * forwardメソッドを使ったページ遷移
 * 	説明
 * 		サーブレットからjspへページ遷移を行う
 * 	書式
 * 		request.getRequestDispatcher("ファイル名").forward(request, response);
 * 		指定したファイル名に遷移する（処理をほかのファイルに任せる）
 * 	例
 * 		request.getRequestDispatcher("forward.jsp").forward(request, response);
 * 		forward.jspに遷移
 */

package chapter9;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter9/forward"}) // urlにchapter9/forwardを指定
public class Forward extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		request.getRequestDispatcher("forward.jsp") 
			.forward(request, response); // forward.jspに遷移
	}
}

