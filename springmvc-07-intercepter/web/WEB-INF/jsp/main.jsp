<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/1/25
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>主页</h1>
<span>${userInfo}</span>
<p>
    <a href="${pageContext.request.contextPath}/user/logout">注销</a>
</p>

</body>
</html>
