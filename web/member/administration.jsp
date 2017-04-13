<%--
  Created by IntelliJ IDEA.
  User: zhangchuanqiang
  Date: 2017/4/12
  Time: 上午11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理中心</title>
    <link rel="stylesheet" type="text/css" href="../assets/css/administration.css"/>
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="../assets/js/administration.js"></script>

</head>
<body>
<div id="center" class="center">
    <table border="1">
        <tr>
            <th rowspan="3">上传账号</th>
            <td>会员<select name="type" id="type"/>
                <option value="aqi" selected>爱奇艺会员</option>
                <option value="tudou">土豆会员</option>
                <option value="xunlei" >迅雷会员</option>
                <option value="leshi">乐视会员</option>
                <option value="mangguo">芒果会员</option>
                <option value="shouhu">搜狐会员</option>
                <option value="kugou">酷狗会员</option>
            </td>
        </tr>

        <tr>
            <td>
                <textarea rows="10" cols="40" id="account" class="textarea">

                </textarea>
            </td>
        </tr>
        <tr>
            <td>
                <%--<button id="save" class="save">上传</button>--%>
                <a class="save"  name="btn-get-code" onclick = "SaveAccount()">上传</a>
            </td>
        </tr>
    </table>
</div>


</body>
</html>
