<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>区域信息</center>
<table>
    <tr>
        <td>区域</td>
        <td>名称</td>
    </tr>
    <c:forEach items="${list}" var="d">
        <tr>
            <td>${d.id}</td>
            <td>${d.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
