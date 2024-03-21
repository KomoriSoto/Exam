<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%-- jstlを使うためのおまじない --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
switch文
<c:choose>
	<c:when test="条件式１">条件式１がtrueの時の処理</c:when>
	<c:when test="条件式２">条件式２がtrueの時の処理</c:when>
	<c:otherwise>それ以外の時の処理</c:otherwise>
</c:choose>
 --%>


<%-- iの値を101~200まで1ずつ増やしながら繰り返し処理 --%>
<c:forEach var="i" begin="101" end="200">
	<c:choose>
		<%-- iを10で割った時のあまりが1の時の処理 --%>
		<c:when test="${i%10==1}">(${i},</c:when>
		<%-- iを10で割った時のあまりが0の時の処理 --%>
		<c:when test="${i%10==0}">${i})<br></c:when>
		<%-- それ以外の時の処理 --%>
		<c:otherwise>${i},</c:otherwise>
	</c:choose>
</c:forEach>

<%@include file="../footer.html" %>
