/** 菜单最小化 */
function navToggle(){
    $("#navbar-minimalize").trigger("click");
}
function SmoothlyMenu() {
    if($("body").hasClass("mini-navbar")){
        if($("body").hasClass("fixed-sidebar") ){
            $("#side-menu").hide();
            setTimeout(function () {
                $("#side-menu").fadeIn(500);
            }, 300);
        }else{
            $("#side-menu").removeAttr("style");
        }
    }else{
        $("#side-menu").hide();
        setTimeout(function () {
            $("#side-menu").fadeIn(500);
        }, 100);
    }
}
$(document).ready(function(){
    function resize() {
        var e = $("body > #wrapper").height() - 61;
        $(".sidebard-panel").css("min-height", e + "px");
    }
    $("#side-menu").metisMenu();
    //右侧顶部导航
    $(".right-sidebar-toggle").click(function () {
        $("#right-sidebar").toggleClass("sidebar-open");
    });
    $("#navbar-minimalize").click(function () {
        $("body").toggleClass("mini-navbar");
        SmoothlyMenu();
    });
    /** 菜单点击 */
    $("#side-menu>li").click(function () {
        if($("body").hasClass("mini-navbar")) navToggle();
    });
    $(".nav-close").click(navToggle);
});

$(window).bind("load resize", function () {
    if($(this).width() < 769){
        $("body").addClass("mini-navbar");
        $(".navbar-static-side").fadeIn();
    }
});