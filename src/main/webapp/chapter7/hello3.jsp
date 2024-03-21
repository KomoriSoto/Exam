<%--
目標
	スクリプトレットについて理解する 
スクリプトレット
	説明
		htmlファイル内でjavaのプログラムを実行する
	書式
		<% Java プログラム %>
	例
		<% out.println(new java.util.Date()); %>
		現時刻を表示(outはデフォルトで使える機能)
--%>

<%-- 以降の文をutf-8で書かれたhtmlとして解釈する --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%-- header.htmlを読み込む --%>
<%@include file="../header.html" %>

<p>Hello!</p>
<p>こんにちは！</p>

<%-- javaのプログラムを実行して現時刻を表示 --%>
<p><% out.println(new java.util.Date()); %></p>
<%-- footer.htmlを読み込む --%>
<%@include file="../footer.html" %>


