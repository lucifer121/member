/**
 * Created by snake on 17-1-22.
 */

$(function () {
    $("form img").on('click', function () {
        $img = $(this);
        $.getJSON("/change-check-pic", function (data) {
            var pic_url = data.csdata.link;
            $img.attr("src", pic_url);
        });
    });
});