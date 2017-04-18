/**
 * Created by zhangchuanqiang on 2017/4/12.
 */

var id = null;
var that = window;
$(document).ready(function () {


});
function SaveAccount() {
    var type = document.getElementById("type").value;
    var account = document.getElementById("account").value;

    // var reg = /[a-zA-Z]+(?=\d+)|\d+(?=[a-zA-Z]+)/g;
    var reg=/[0-9a-z]/i;
    //验证是否含有字符
    if (reg.test(account)==true) {
        $.ajax({
            type: 'POST',
            url: "http://localhost:8080/member/saveServlet",
            data: {
                type: type,
                account: account
            },
            success: function (data) {
                var json = eval("(" + data + ")");
                // var result= data.hasOwnProperty("message")?data.message:null;
                var result = json.result;
                if (result == 'success') {
                    document.getElementById("account").value = "";
                    alert("上传成功");
                }
            },
            error: function (e) {
                alert("上传失败，请稍后重试");
            }

        });
        alert("有账号")

    } else {
        alert("请输入账号后再上传！")
    }
}
function getCDkey() {
    var type = document.getElementById("type-search").value;
    if (type == "" || type == undefined) {
        alert("请选择您需要获取的领取码会员类型！")
    }
    else {
        $.ajax({
            type: 'POST',
            url: "http://localhost:8080/member/searchCDkeyServlet",
            data: {
                type: type,
            },
            success: function (data) {
                var json = eval("(" + data + ")");
                var keys = "";
                var number = json.length;
                for (var i = 0; i < number / 1; i++) {
                    if (i == 0) {
                        keys = json[i];
                    } else {
                        keys = keys + "\n" + json[i];
                    }
                }
                // var result= data.hasOwnProperty("message")?data.message:null;
                // var result = json.result;
                // if (result == 'success') {
                alert("查询成功");
                document.getElementById("CDkey").value = keys;
                // }

            },
            error: function (e) {
                alert("查询失败，请稍后重试");
            }

        });

    }
}
