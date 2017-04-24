
//导航
$(function(){
    $('.navbar-toggle').click(function() {
        $('.menu_slide').animate({"right":0},500);
        $(".gray_bg").show();
    });
    $(".menu_slide .right").click(function(){
        $('.menu_slide').animate({"right":"-260px"},500);
        $(".gray_bg").hide();
    })
    $(".gray_bg").click(function(){
        $('.menu_slide').animate({"right":"-260px"},500);
        $(".gray_bg").hide();
    })
})