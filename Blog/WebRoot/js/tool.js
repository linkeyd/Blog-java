// JavaScript Document


//后台数据0 1 判断 男女框 sex(number)
function sex(number){
	if(number=="0")
	{
		return "男";
	}
	else{
		return "女";
		}
	}
	
//这是一个提示框的封装  font的值必须输入 msg("");
function msg(font,background_color,font_color){
	$("body").append("<div class='msg' style='background-color:rgb(253, 253, 253);'></div>");
	$(".msg").append("<p class='font'>"+font+"</p>");
		if(background_color!=null)
	{
		$(".msg").css({
			"background-color":background_color,
			});
	}
	if(font_color!=null)
	{
		$(".font").css({
			"color":font_color,
			})
	}
	$(".msg").css({
		"position":"fixed",
		"top":"30%",
		"left":"40%",
		"width":"auto",
		"border":"solid 1px #CCCCCC",
		"z-index":"1000",
		"border-radius":"5px",
		"margin":"0px",
		"min-height":"40px",
		"cursor":"pointer",
		"display":"block",
		});
	$(".font").css({
		"margin":"auto 1.05em",
		"line-height":"2.5em",
		"font-family":"微软雅黑",
		});
	setTimeout(function(){
		$(".msg").remove();
		},1000);
	$(".msg").click(function(){
		$(".msg").remove();
		})			
	
	}
	
	//这个是一个获取地址中参数的包装
	
function GetRequest() {
	var url = location.search; //获取url中"?"符后的字串
	var theRequest = new Object();
	if (url.indexOf("?") != -1) {
		var str = url.substr(1);
		strs = str.split("&");
		
		for ( var i = 0; i < strs.length; i++) {
			theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
		}
	}
	return theRequest;
}


/**
 * 
 	var Request=new GetRequest();
	if(Request['字符串']=="true")
	{
		alert("处理成功");
	}
	else if("false"==Request['字符串']){
	
	alert("处理失败");
	}
 */
var scrolls={
	  Cdisplay:function(Class_name,pixel){
		  if($(window).scrollTop()>pixel)
			{
    		$("."+Class_name+"").css({
			"display":"block"
			})
			}


		 $(window).scroll(function(){
			if($(window).width()<768)
			{
				 $(".headerd").css({"display":"none"});
				}
			else{
			if($(window).scrollTop()>pixel)
			{
 			   $("."+Class_name+"").fadeIn(300);
			}
			else{
		    	$("."+Class_name+"").fadeOut(100);
			}
			 }
			})
			
		  },
      Cslide:function(Active_class,Cpassive_class){
		 
		$("."+Active_class+"").click(function() {  

        $("body,html").animate({    
            scrollTop:($("."+Cpassive_class+"").offset().top-50)+"px"    
        }, 700);  
		});
		}
	  };
	  
	  
	  
(function($){
	$.fn.to_fadeIn=function(options){
		var ops=$.extend(options);
		$(this).addClass("dist");
		$(this).find("*").css({
			"display":"none"
			})
			
		$(window).scroll(function(){
			if($(".dist").offset().top<=$(window).scrollTop()+$(window).height()/1.5)
			{	
				$(".dist").find("*").fadeIn(1000);
				$(".dist").removeClass("dis")
				}
			})
		}
	})(jQuery);
	
	






