<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>Hello World!</h2>
<p>Now this one has precedency</p>
<h2>
    <%--<%= request.getAttribute("myVar") %>--%>
    <c:out value="${myVar}"></c:out>
</h2>
<c:set var="iaka" value="Adrian"></c:set>
<c:out value="${iaka}"></c:out>
<c:forEach items="${myList}" var="item">
    Item = ${item}<br>
</c:forEach>


</body>
</html>
