<%-- 以降の文をutf-8で書かれたhtmlとして解釈する --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%-- header.htmlを読み込む --%>
<%@include file="../header.html"%>

<p>お名前を入力してください。</p>
<%-- 確定ボタンが押されたらgreeting-out.jspを表示 --%>
<form action="greeting-out.jsp" method="post">
	<input type="text" name="user"> <input type="submit" value="確定">
</form>
<%-- footer.htmlを読み込む --%>
<%@include file="../footer.html"%>
