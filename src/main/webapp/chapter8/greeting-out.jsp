<%-- 以降の文をutf-8で書かれたhtmlとして解釈する --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%-- header.htmlを読み込む --%>
<%@include file="../header.html"%>

<%-- スクリプトレットを使って日本語を使えるようにする --%>
<% request.setCharacterEncoding("UTF-8"); %>
<%-- 式を使ってname="user"の値を取得して表示 --%>
<p>こんにちは、<%=request.getParameter("user") %>さん！</p>

<%-- footer.htmlを読み込む --%>
<%@include file="../footer.html"%>
