<%--
  Created by IntelliJ IDEA.
  User: zhangchuanqiang
  Date: 2017/4/7
  Time: 下午2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>领取成功</title>
</head>
<body>
领取成功<br>
您的领取码是:<%= request.getParameter("CDkey")%><br>
您获取的账号是:<%= request.getAttribute("account")%><br>
<a href="index.jsp">返回领取页面</a>

</body>
</html>
