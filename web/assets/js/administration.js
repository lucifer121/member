/**
 * Created by zhangchuanqiang on 2017/4/12.
 */

var id=null;
var Request = new Object();
$(document).ready(function(){

    // Request = GetRequest();
    // id=Request["id"];
    // if(id==null){
    //     id=3;
    // }
    // init(id);

});
function SaveAccount() {
   var type= document.getElementById("type").value;

   var account=document.getElementById("account").value;
    alert("type=="+type+"\n"+"account=="+account);

    $.ajax({
        type: 'POST',
        url: "http://localhost:8080/member/saveServlet",
        data: {
            type:type,
            account:account
        },
        success: function () {
            alert("tijiaochenggong")
        },
        error:function(e){
            alert(e);
        }

    });


}