<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%-- jstlを使うためのおまじない --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 
if文
	書式
		<c:if test="条件式}">
			条件式がtrueの時の処理
		</c:if>
--%>

抽選結果：
<%-- Math.random()の値が0.5未満ならタグ内の処理を行う --%>
<c:if test="${Math.random()<0.5}">
	あたり！
</c:if>

<%@include file="../footer.html" %>
