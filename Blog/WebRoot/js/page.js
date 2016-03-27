// JavaScript Document
var count_total=4;//每页显示多少条
var frist=0;//第一条标记
var last=count_total;//最后一条标记

function page_(total,Class_Name)
{
	//第一次使用函数
	$("."+Class_Name+"").eq(count_total-1).nextAll().css({"display":"none"});
	$(".prev_page").click(function(){
		if(frist>0){
			frist=frist-count_total;
			last=last-count_total;

			$("."+Class_Name+"").eq(last-1).nextAll().css({"display":"none"});
			for(var i=frist;i<last;i++)
			{
				$("."+Class_Name+"").eq(i).css({"display":"block"});
			}

			}
		else{
			alert("这已经是第一页了.");
			}
		});
	$(".next_page").click(function(){
		if(last<total)
		{
			frist=frist+count_total;
			last=last+count_total;
			$("."+Class_Name+"").eq(frist).prevAll().css({"display":"none"});
			for(var i=frist;i<last;i++)
			{
				$("."+Class_Name+"").eq(i).css({"display":"block"});
			}

		}
		else{
			alert("这已经是最后一页了.");
			}
		
		});
}
