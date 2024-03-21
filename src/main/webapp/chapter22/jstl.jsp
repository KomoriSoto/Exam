<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%-- jstlを使うためのおまじない --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- listの値を一つずつ読み込み変数pに代入 --%>
<c:forEach var="p" items="${list}">
	<%-- 変数pのid, name, priceをそれぞれ表示する --%>
	${p.id}：${p.name}：${p.price}<br>
</c:forEach>

<%@include file="../footer.html" %>
