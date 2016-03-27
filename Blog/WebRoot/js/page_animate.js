// JavaScript Document

var animate_html="";
	animate_html+='<div class="loading">';
	animate_html+='<div class="loading_img"><img src="img/loading.gif"></div>';
	animate_html+='</div>';
$("body").prepend(animate_html);
	
var height=$(".loading").height()/2-100;
	$(".loading_img").css({
		"margin-top":height+"px"
		})
$(document).ready(function(e) {

	setTimeout(fade,700);//调用回调特效方法
    

    function fade(){
    $(".loading").fadeOut("slow",function(){
		$(this).remove();
	});
	}
	
});
