/* 目標
 * 	セッションに情報を追加する方法を理解する
 * セッションとは
 * 	ユーザごとに固有のデータを管理する仕組み
 * 	一度webページを離れてもデータを保存することができる
 * 書式
 * 	HttpSession session=request.getSession(); // セッションの開始
 * 	(型名)session.getAttribute("列名"); // セッションの値を取得
 * 	session.setAttribute("列名", 値); // セッションに値を追加
*/	

package chapter17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import bean.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Page;

@WebServlet(urlPatterns={"/chapter17/cart-add"}) // urlに/chapter17/cat-addを指定
public class CartAdd extends HttpServlet {

	@SuppressWarnings("unchecked") // 警告を無視する
	public void doPost (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); // レスポンスに必要な機能を取得
		Page.header(out); // tool/Page.javaのheaderメソッドを実行

		String name=request.getParameter("name"); // name="name"の値を取得
		int price=Integer.parseInt(request.getParameter("price")); // name="price"の値をint型で取得

		HttpSession session=request.getSession(); // セッションの開始

		List<Product> cart=(List<Product>)session.getAttribute("cart"); // セッション内の列名cartの値を取得
		
		
		
		if (cart==null) {
			cart=new ArrayList<Product>(); // cartがnullであれば空のリストを新しく作る
			
			/* 変数cartのイメージ図(空の配列を作成しています)
			 * 	 ------------------------
			 *  |           0            |
			 *   ------------------------
			 *  |  --------------------  |
			 *  | | i d | name | price | |
			 *  |  --------------------  |
			 *  | |     |      |       | |
			 *  |  --------------------  |
			 *   ------------------------
			*/  
		}

		Product p=new Product(); // Productクラスをインスタンス化
		p.setName(name); // name列に変数nameの値を設定
		p.setPrice(price); // price列に変数priceの値を設定
		cart.add(p); // 配列cartにpを追加
		
		/* 変数cartのイメージ図(配列にデータを追加します)
		 * 	 ------------------------
		 *  |           0            |
		 *   ------------------------
		 *  |  --------------------  |
		 *  | | i d | name | price | |
		 *  |  --------------------  |
		 *  | |  1  |まぐろ|  100  | |
		 *  |  --------------------  |
		 *   ------------------------
		 *   
		 *   ２件目のデータがカートに入れられたとき
		 *   -------------------------------------------------
		 *  |           0            |           1            |
		 *   -------------------------------------------------
		 *  |  --------------------  |  --------------------  |
		 *  | | i d | name | price | | | i d | name | price | |
		 *  |  --------------------  |  --------------------  |
		 *  | |  1  |まぐろ|  100  | | |  2  |はまち|  100  | |
		 *  |  --------------------  |  --------------------  |
		 *   ------------------------------------------------
		*/  

		session.setAttribute("cart", cart); // セッションのcart列にcartを登録
		
		/* セッションcartのイメージ図
		 *  ----------------------------
		 * |           cart             |
		 * |----------------------------|
		 * |  ------------------------  |
		 * | |           0            | |
		 * |  ------------------------  |
		 * | |  --------------------  | |
		 * | | | i d | name | price | | |
		 * | |  --------------------  | |
		 * | | |  1  |まぐろ|  100  | | |
		 * | |  --------------------  | |
		 * |  ------------------------  |
		 *  ----------------------------
		 *  
		 * ２件目のデータがカートに入れられたとき
		 * 
		 *  -----------------------------------------------------
		 * |                         cart                        |             
		 * |-----------------------------------------------------
		 * |  -------------------------------------------------  |
		 * | |           0            |           1            | |
		 * |  -------------------------------------------------  |
		 * | |  --------------------  |  --------------------  | |
		 * | | | i d | name | price | | | i d | name | price | | |
		 * | |  --------------------  |  --------------------  | |
		 * | | |  1  |まぐろ|  100  | | |  2  |はまち|  100  | | |
		 * | |  --------------------  |  --------------------  | |
		 * |  ------------------------------------------------   |
		 *  -----------------------------------------------------
		*/  

		out.println("カートに商品を追加しました。");
		Page.footer(out);
	}
}

