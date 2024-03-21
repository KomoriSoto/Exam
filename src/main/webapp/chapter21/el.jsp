<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%-- productのid, name, priceをそれぞれ表示する --%>
<p>${product.id}：${product.name}：${product.price}</p>

<%@include file="../footer.html" %>
