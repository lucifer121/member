/**
 * Created by zhangchuanqiang on 2017/4/11.
 */
var id=null;
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