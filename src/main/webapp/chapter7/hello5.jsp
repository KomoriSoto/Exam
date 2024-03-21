<%--
目標
	クラスのインポートについて理解する
クラスのインポート
	書式
		<%@page import="クラス名"%>
	例
		<%@page import="java.util.Date"%>
		java.util.Dateクラスをインポートする(現時刻の表示等を行えるようにする)
 --%>

<%-- 以降の文をutf-8で書かれたhtmlとして解釈する --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%-- header.htmlを読み込む --%>
<%@include file="../header.html"%>

<%-- java.util.Dateをインポート(Dateを使える状態にする) --%>
<%@page import="java.util.Date"%>

<p>Hello!</p>
<p>こんにちは！</p>

<%-- javaのプログラムを実行して現時刻を表示 --%>
<p><%=new Date()%></p>
<%-- footer.htmlを読み込む --%>
<%@include file="../footer.html"%>
