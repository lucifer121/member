/**
 * Created by zhangchuanqiang on 2017/4/12.
 */

var id = null;
var that = window;
$(document).ready(function () {


});
/**
 * 一号一码  上传
 * @constructor
 */
function SaveAccount() {
    var type = document.getElementById("type").value;
    var account = document.getElementById("account").value;
    var reg=/[0-9a-z]/i;
    //验证是否含有字符
    if (reg.test(account)==true) {
        $.ajax({
            type: 'POST',
            url: "http://1av7022880.iask.in:38613/member/saveServlet",
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
    } else {
        alert("请输入账号后再上传！")
    }
}
/**
 * 一号一码  获取账号
 */
function getCDkey() {
    var type = document.getElementById("type-search").value;
    if (type == "" || type == undefined) {
        alert("请选择您需要获取的领取码会员类型！")
    }
    else {
        $.ajax({
            type: 'POST',
            url: "http://1av7022880.iask.in:38613/member/searchCDkeyServlet",
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
/**
 * 上传一码多号表
 * @constructor
 */
function SaveAccountMore() {
    var type = document.getElementById("more-type").value;
    var account = document.getElementById("more-account").value;
    var reg=/[0-9a-z]/i;
    //验证是否含有字符
    if (reg.test(account)==true) {
        $.ajax({
            type: 'POST',
            url: "http://1av7022880.iask.in:38613/member/saveMoreServlet",
            data: {
                type: type,
                account: account
            },
            success: function (data) {
                var json = eval("(" + data + ")");
                // var result= data.hasOwnProperty("message")?data.message:null;
                var result = json.result;
                if (result == 'success') {
                    document.getElementById("more-account").value = "";
                    alert("上传成功");
                }
            },
            error: function (e) {
                alert("上传失败，请稍后重试");
            }

        });
    } else {
        alert("请输入账号后再上传！")
    }

}
/**
 * 修改领取码
 * @constructor
 */
function UpdateKeyMore() {
    var type = document.getElementById("update-type").value;
    var key = document.getElementById("update-key").value;
    var reg=/[0-9a-z]/i;
    //验证是否含有字符
    if (reg.test(key)==true) {
        $.ajax({
            type: 'POST',
            url: "http://1av7022880.iask.in:38613/member/updateCdKeyServlet",
            data: {
                type: type,
                key: key
            },
            success: function (data) {
                var json = eval("(" + data + ")");
                // var result= data.hasOwnProperty("message")?data.message:null;
                var result = json.result;
                if (result == 'success') {
                    document.getElementById("update-key").value = "";
                    alert("更新领取码成功");
                }
            },
            error: function (e) {
                alert("更新失败，请稍后重试");
            }

        });
    } else {
        alert("请输入领取码后再更新！")
    }
}
