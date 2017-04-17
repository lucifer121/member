<%--
  Created by IntelliJ IDEA.
  User: zhangchuanqiang
  Date: 2017/4/7
  Time: 下午2:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取失败</title>
    <link rel="stylesheet" type="text/css" href="../assets/css/index.css"/>
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <%--<script src="../assets/js/administration.js"></script>--%>
</head>
<body>
<div class="center">
    <h1 >领取失败</h1><br>
    您的领取码是:<%= request.getParameter("CDkey")%><br>
    <br>
<a href="index.jsp">返回领取页面</a>
</div>
</body>
</html>
