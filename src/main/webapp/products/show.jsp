<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>One Product</title>
</head>
<body>

<c:if test="${error != null}">
    <h3 style="color:red">${error}</h3>
</c:if>

<c:if test="${error == null}">
    <h1>One Product</h1>
    <div>
        <h3>${product.name}</h3>
        <p>${product.price}</p>
    </div>
</c:if>



</body>
</html>