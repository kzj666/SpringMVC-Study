<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.3.1.js"></script>

    <script type="text/javascript">

        function A() {
            $.post({
                url:"${pageContext.request.contextPath}/ajax/a3",
                data:{'name':$("#name").val()},
                success: function (data) {
                    if(data.toString()=="ok"){
                        $('#userInfo').css("color","green");
                    }else{
                        $('#userInfo').css("color","red");
                    }
                    $("#userInfo").html(data);
                }
            });
        }

        function B() {
            $.post("${pageContext.request.contextPath}/ajax/a3",{'pwd':$("#pwd").val()},function (data) {
                if(data.toString()=="ok"){
                    $('#pwdInfo').css("color","green");
                }else{
                    $('#pwdInfo').css("color","red");
                }
                $("#pwdInfo").html(data);
            })
        }
    </script>
    
</head>
<body>

<p>
    用户名：
    <input type="text" id="name" onblur="A()" />
    <span id="userInfo"></span>
</p>

<p>
    密码：
    <input type="password" id="pwd" onblur="B()" />
    <span id="pwdInfo"></span>
</p>

</body>
</html>
