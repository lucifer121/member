<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1,  user-scalable=no">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta>
    <meta name="renderer" content="webkit">
    <title>抢红包_抢会员_一人一号不掉线_优酷_迅雷_芒果_乐视_搜狐_爱奇艺会员共享</title>
    <meta name="keywords" content="抢红包，抢会员，优酷，迅雷，芒果，乐视，搜狐，爱奇艺会员共享，VIP信息"/>
    <meta name="description"
          content="VIP信息是一个专注优质信息分享的网站,同时收集并提供红包信息,爱奇艺会员共享,优酷会员账号共享,迅雷会员账号分享,乐视会员账号共享,搜狐会员账号共享,芒果tv会员账号共享等好人岛服务。"/>
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="assets/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="assets/css/index.css"/>
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/main.js"></script>
    <script src="assets/js/index.js"></script>
</head>
<body>
<!-- 头部 开始 -->
<div class="head container clearfix">
    <div class="logo fl"><a href="javascript:void(0);"></a>
        <div class="navbar-header fr">
            <button type="button" class="navbar-toggle click_btn" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
    </div>
    <div class="share fr">
        <div class="bshare-custom share1">
            <a title="更多平台" class="bshare-more bshare-more-icon more-style-addthis"></a>
            <a title="分享到QQ空间" class="bshare-qzone"></a>
            <a title="分享到新浪微博" class="bshare-sinaminiblog"></a>
            <a title="分享到腾讯微博" class="bshare-qqmb"></a>
            <a title="分享到人人网" class="bshare-renren"></a>
            <a title="分享到网易微博" class="bshare-weixin"></a>
        </div>
        <script type="text/javascript" charset="utf-8"
                src="http://static.bshare.cn/b/buttonLite.js#style=-1&amp;uuid=&amp;pophcol=2&amp;lang=zh"></script>
        <script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/bshareC0.js"></script>
        <div class="share2">如果你有闲置的会员账号或者优质的资源，可以发送到*******.com 这样可以帮助更多人 谢谢~</div>
    </div>
</div>
<!-- 头部 结束 -->

<!-- 导航 开始 -->
<ul class="index_nav container clearfix" id="navigationBar">
    <li><a href="index.jsp?id=1">抢红包</a></li>
    <li><a href='http://www.sdbinfu.com/' target='_blank'>抢优惠券</a></li>
    <li id="li2"><a href="index.jsp?id=3">爱奇艺会员</a></li>
    <li><a href="index.jsp?id=4">优酷土豆会员</a></li>
    <li><a href="index.jsp?id=5">迅雷会员</a></li>
    <li><a href="index.jsp?id=6">乐视会员</a></li>
    <li><a href="index.jsp?id=7">芒果会员</a></li>
    <li><a href="index.jsp?id=8">搜狐会员</a></li>
    <li><a href="index.jsp?id=9">酷狗音乐会员</a></li>
</ul>
<!-- 导航 结束 -->

<!-- 内容 开始 -->
<div class="sort1 container">
    <div class="sort1_box">
        <form method="post" id="accountFrom">
            <div class="p1" id="p1">请输入爱奇艺vip领取码：</div>
            <div class="p2"><input placeholder="领取码" name="CDkey" id="CDkey"/></div>
            <div class="p3 clearfix">
                <div class="in"><input class="cdKey" type="text" id="input" placeholder="验证码"/></div>
                <input class="code" type="button" id="code" onclick="createCode()"/>
            </div>
            <a class="lq" name="btn-get-code" onclick="validate()">领取</a>
        </form>
    </div>
    <div class="receive" id="receive">
        <div class="hint-div"><h4 class="hint">恭喜！领取成功！</h4></div>
        <div class="hint-div"><h4 class="hint" id="get-account"></h4></div>
    </div>


</div>
<div class="cont_top cont_list_top container sport_new tu">
    <p>请在以上搜索框内输入群主最新发布的领取码, 并且输入图片中的验证码，然后点击"领取"</p>
    <p><span>如果你没有最新的领取码，请<a href="https://jq.qq.com/?_wv=1027&amp;k=46io78E" target="_blank">点此加入我们的官方QQ群******</a>领取码在群公告</span>
    </p>
    <p>本网站全天候24小时为大家免费提供爱奇艺VIP会员！本网站不对外开放,如需使用请先加群！</p>
    <%--<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>--%>
    <!-- 2 -->
    <%--<ins class="adsbygoogle"--%>
    <%--style="display:inline-block;width:336px;height:280px"--%>
    <%--data-ad-client="ca-pub-9595674526397594"--%>
    <%--data-ad-slot="8520553868"></ins>--%>
    <!--<script>-->
    <!--(adsbygoogle = window.adsbygoogle || []).push({});-->
    <!--</script>-->
</div>

</body>
</html>
