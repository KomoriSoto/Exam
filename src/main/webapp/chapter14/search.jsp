<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<p>検索キーワードを入力してください。</p>
<%-- 検索ボタンが押されたらSerch.javaを実行 --%>
<form action="search" method="post">
	<input type="text" name="keyword"> <input type="submit"
		value="検索">
</form>

<%@include file="../footer.html"%>
