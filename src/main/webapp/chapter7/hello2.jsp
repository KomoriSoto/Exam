<%-- 
目標
	ディレクティブについて理解を深める	
includeディレクティブ
	説明
		JSPでほかのファイルを読み込む
	書式
		<%@include file="ファイルのパス" %>
	例
		<%@include file="../header.html" %>
		一つ上の階層にあるheader.htmlを読み込む
--%>

<%-- 以降の文をutf-8で書かれたhtmlとして解釈する --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%-- header.htmlを読み込む --%>
<%@include file="../header.html" %>

<p>Hello!</p>
<p>こんにちは！</p>

<%-- footer.htmlを読み込む --%>
<%@include file="../footer.html" %>

