<%-- 以降の文をutf-8で書かれたhtmlとして解釈する --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%-- header.htmlを読み込む --%>
<%@include file="../header.html"%>

<%-- 計算ボタンが押されたらtotal2-out.jspを実行 --%>
<form action="total2-out.jsp" method="post">
<input type="text" name="price">
円×
<input type="text" name="count">
個＋送料
<input type="text" name="delivery">
円＝
<input type="submit" value="計算">
</form>

<%-- footer.htmlを読み込む --%>
<%@include file="../footer.html"%>
