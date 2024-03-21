/* ゲッタ
 * 	説明
 * 		Beanにおいてデータの取得に使用するメソッド
 * 	書式
 * 		public int getフィールド名() {
			return フィールド名;
		}
 * 	例
 * 		public int getId() {
			return id;
		}
 * 		idの値を取得する
 * 
 * セッタ
 * 	説明
 * 		Beanにおいてデータの設定に使用するメソッド
 * 	書式
 * 		public void setフィールド名(型 引数) {
			this.フィールド名 = 引数;
		}		
 * 	例
 * 		public void setId(int id) {
			this.id = id; // beanで定義された変数idに別のプログラムから受け取ったidの値を代入
		}
 * 		idの値を設定する
*/


package bean;

public class Product implements java.io.Serializable {

	// Beanで使用する変数（フィールド名）を宣言
	private int id;
	private String name;
	private int price;

	// データを取得するメソッドを定義
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}

	// データを設定するメソッドを定義
	public void setId(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPrice(int price) {
		this.price=price;
	}
}

