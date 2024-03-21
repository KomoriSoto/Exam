<%--
目標
	JSPを使った値の受け渡し方法を理解する
JSPのリクエスト処理
	説明
		JSPから別のJSPに値を受け渡す
	書式
		<form action="ファイル名" method="post">
		ファイル名で指定したJSPに値を送信して画面遷移
	例
		<form action="total-out.jsp" method="post">
		total-out.jspにpostで値を送信
--%>

<%-- 以降の文をutf-8で書かれたhtmlとして解釈する --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%-- header.htmlを読み込む --%>
<%@include file="../header.html"%>

<%-- 計算ボタンが押されたらtotal-out.jspを表示 --%>
<form action="total-out.jsp" method="post">
<input type="text" name="price">
円×
<input type="text" name="count">
個＝
<input type="submit" value="計算">
</form>

<%-- footer.htmlを読み込む --%>
<%@include file="../footer.html"%>
