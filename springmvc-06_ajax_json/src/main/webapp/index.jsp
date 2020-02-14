<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--导入JQuery，需要导入--%>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.3.1.js"></script>

    <script type="text/javascript">

        function a1() {

            //所有参数
            //url:带载入页面的URL地址，Json
            //data:待发送key/value 参数
            //success:载入成功时回调函数
            //data 请求返回的数据
            //status：请求返回的状态
            //ajax默认是get请求
            $.ajax({
                url:"${pageContext.request.contextPath}/ajax/a1",
                data:{'name':$("#txtName").val()},
                success:function (data,status) {
                    console.log(data);
                    console.log(status);
                }
            });
        }

    </script>

</head>
<body>

用户名：<input type="text" id="txtName" onblur="a1()" />

</body>
</html>