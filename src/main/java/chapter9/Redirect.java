/*	目標
 * 		リダイレクトを使って外部のwebページにアクセスする方法を理解する
 *  リダイレクト
 *	 	説明
 * 			ほかのwebページに遷移する
 * 		書式
 * 			response.sendRedirect("URL");
 * 			指定したURLに遷移する
*/

package chapter9;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter9/redirect"}) // urlにchapter9/redirectを指定
public class Redirect extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		response.sendRedirect("http://tomcat.apache.org/"); // http://tomcat.apache.org/に遷移 
	}
}



