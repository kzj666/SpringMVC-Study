<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/1/25
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="upload">
  </form>

  <br>
  <h2><a href="${pageContext.request.contextPath}/download">下载图片</a></h2>
  </body>
</html>
