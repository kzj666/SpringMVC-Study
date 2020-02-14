<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.3.1.js"></script>

    <script type="text/javascript">

        $(function () {
            $("#btn").click(function () {
                $.post("${pageContext.request.contextPath}/ajax/a2",function (data) {
                    console.log(data);
                    var html="";
                    for(var i=0; i<data.length; i++){
                        html += "<tr>"+
                        "<td>" + data[i].name + "</td>"+
                        "<td>" + data[i].age + "</td>"+
                        "<td>" + data[i].sex + "</td>"+
                        "</tr>";
                    }
                    $("#content").html(html);
                })
            })
        })

    </script>
</head>
<body>

    <input type="button" id="btn" value="获取数据" />
    <table width="80%" align="center">
        <thead>
            <tr>
                <td>姓名</td>
                <td>年龄</td>
                <td>性别</td>
            </tr>
        </thead>
        <tbody id="content">

        </tbody>
    </table>

</body>
</html>