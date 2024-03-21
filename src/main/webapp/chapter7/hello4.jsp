<%-- 
目標
	式の使い方を理解する
式の値を出力
	書式
		<%= Javaの式 %>
	例
		<%=new java.util.Date()%>
		現時刻を表示する
--%>

<%-- 以降の文をutf-8で書かれたhtmlとして解釈する --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%-- header.htmlを読み込む --%>
<%@include file="../header.html"%>

<p>Hello!</p>
<p>こんにちは！</p>

<%-- javaのプログラムを実行して現時刻を表示 --%>
<p><%=new java.util.Date()%></p>
<%-- footer.htmlを読み込む --%>
<%@include file="../footer.html"%>


