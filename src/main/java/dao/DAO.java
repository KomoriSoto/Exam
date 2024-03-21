/* 目標
 * 	DAOの使い方を理解する
 * DAOとは
 * 	データベースに関する処理をまとめたもの
 * 	データベースに関する共通の処理をまとめることができる
*/

package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	static DataSource ds;

	// データベースの接続に必要な処理をgetConnectionというメソッドにまとめておく
	public Connection getConnection() throws Exception {
		if (ds==null) {
			InitialContext ic=new InitialContext();
			ds=(DataSource)ic.lookup("java:/comp/env/jdbc/book");
		}
		return ds.getConnection();
	}
}
