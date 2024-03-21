<%-- 
目標
	JSPの基本について理解する
ディレクティブ
	説明
		JSPの設定を行う機能
	書式
		<%@ディレクティブ名 属性名="値"%>
	例
		<%@page contentType="text/html; charset=UTF-8"%>
		以降の文をutf-8で書かれたhtmlとして解釈する
--%>

<%-- コンテントタイプと文字コードの設定 --%>
<%@page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet/JSP Samples</title>
</head>
<body>

	<%-- メッセージの出力--%>
	<p>Hello!</p>
	<p>こんにちは！</p>

</body>
</html>

