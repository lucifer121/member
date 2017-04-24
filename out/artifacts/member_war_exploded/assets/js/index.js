/**
 * Created by zhangchuanqiang on 2017/4/11.
 */
var id=null;
var code;
var Request = new Object();
$(document).ready(function(){

    Request = GetRequest();
    id=Request["id"];
    if(id==null){
        id=3;
    }
    init(id);

});
function init(id){
    var receiveHint=null;
    switch (id/1){
        case 3:
            receiveHint="请输入爱奇艺vip领取码：";
            break;
        case 4:
            receiveHint="请输入优酷土豆vip领取码：";
            break;
        case 5:
            receiveHint="请输入迅雷vip领取码：";
            break;
        case 6:
            receiveHint="请输入乐视vip领取码：";
            break;
        case 7:
            receiveHint="请输入芒果vip领取码：";
            break;
        case 8:
            receiveHint="请输入搜狐vip领取码：";
            break;
        case 9:
            receiveHint="请输入酷狗音乐vip领取码：";
            break;
    }
    document.getElementById("p1").innerHTML=receiveHint;
    var li_index=id-1;
    $('ul#navigationBar li:eq('+li_index+')').attr("class","li_spe");

    code = "";
    var codeLength = 4;//验证码的长度
    var checkCode = document.getElementById("code");
    var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
        'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');//随机数
    for (var i = 0; i < codeLength; i++) {//循环操作
        var index = Math.floor(Math.random() * 36);//取得随机数的索引（0~35）
        code += random[index];//根据索引取得随机数加到code上
    }
    checkCode.value = code;//把code值赋给验证码

    //document.getElementById("li2").setAttribute("class","li_spe");
}
function GetRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
            theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}
function createCode() {
    code = "";
    var codeLength = 4;//验证码的长度
    var checkCode = document.getElementById("code");
    var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
        'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');//随机数
    for (var i = 0; i < codeLength; i++) {//循环操作
        var index = Math.floor(Math.random() * 36);//取得随机数的索引（0~35）
        code += random[index];//根据索引取得随机数加到code上
    }
    checkCode.value = code;//把code值赋给验证码
}
//校验验证码
function validate() {
    var inputCode = document.getElementById("input").value.toUpperCase(); //取得输入的验证码并转化为大写
    var CDkey=document.getElementById("CDkey").value;
    if (CDkey.length<=0){
        alert("请输入您的领取码!");
        document.forms.accountFrom.CDkey.focus();
    }
    else if (inputCode.length <= 0) { //若输入的验证码长度为0
        alert("请输入验证码！"); //则弹出请输入验证码
    }
    else if (inputCode != code) { //若输入的验证码与产生的验证码不一致时
        alert("验证码输入错误!"); //则弹出验证码输入错误
        createCode();//刷新验证码
        document.getElementById("input").value = "";//清空文本框
    }
    else { //输入正确时
        //alert("^-^sss"); //弹出^-^
        if (id!=null&&id>=3) {
            // var form1 = document.getElementById("accountFrom");
            // form1.action = "http://localhost:8080/member/receiveServlet?id="+(id-2);                //设置提交路径
            // form1.submit();
            var type=id-2;
            $.ajax({
                type: 'POST',
                // url: "http://1av7022880.iask.in:38613/member/receiveServlet",
                url:"http://localhost:8080/member/receiveServlet",
                data: {
                    id: type,
                    CDkey: CDkey
                },
                success: function (data) {
                    var json = eval("(" + data + ")");
                    var result = json.result;
                    if (result == 'success') {
                        $("#receive").css('display','block');
                        $("#get-account").text("您获取的账号是："+json.account);
                    }else{
                        $("#receive").css('display','none');
                        alert("领取失败，领取码不正确，详情请加入qq群询问管理");
                    }
                },
                error: function (e) {
                    alert("领取失败，请稍后重试");
                }

            });



        }
    }
}