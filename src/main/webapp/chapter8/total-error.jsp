<%-- 
例外内容の表示
	書式
		<%@page isErrorPage="true" %>
		<%=exception %>
		例外を表示する
--%>

<%-- 以降の文をutf-8で書かれたhtmlとして解釈する --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%-- header.htmlを読み込む --%>
<%@include file="../header.html"%>

<%-- 例外内容表示の準備 --%>
<%@page isErrorPage="true" %>

<p>数値を入力してください。</p>

<%-- エラーの内容を表示 --%>
<p><%=exception %></p>

<%-- footer.htmlを読み込む --%>
<%@include file="../footer.html"%>

