<%-- 
JSPのエラー処理
	書式
		<%@page errorPage="ファイル名" %>
		エラーが起きた際に指定したファイル名が実行される
	例
		<%@page errorPage="total-error.jsp" %>
		エラーが起きた際にtotal-error.jspが実行される
--%>

<%-- 以降の文をutf-8で書かれたhtmlとして解釈する --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%-- header.htmlを読み込む --%>
<%@include file="../header.html"%>

<%-- エラーが発生したらtotal-error.jspを表示 --%>
<%@page errorPage="total-error.jsp" %>

<%-- スクリプトレットを使って入力された内容を受け取る --%>
<%
request.setCharacterEncoding("UTF-8");
int price=Integer.parseInt(request.getParameter("price")); // name="price"の値を取得
int count=Integer.parseInt(request.getParameter("count")); // name="count"の値を取得
int delivery=Integer.parseInt(request.getParameter("delivery")); // name="delivery"の値を取得
%>

<%-- 式を使って入力された値を基に合計金額を計算 --%>
<%=price %>円×<%=count %>個＋送料<%=delivery %>円＝
<%=price*count+delivery %>円

<%-- footer.htmlを読み込む --%>
<%@include file="../footer.html"%>

