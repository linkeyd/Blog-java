/**
 * Created by � on 2015/5/16.
 */




var sumbit_ajax={
    post_ajax:function(url,data_list,callback){
        $.ajax({
            url:url,
            dataType:"json",
            type:"post",
            data:data_list,
            success:callback,
            timeout:(10000),
            error:function(){
               $(window).dag("通信错误");
            }
        })
    },
    get_ajax:function(url,callback){
        $.ajax({
            url:url,
            dataType:"json",
            type:"get",
            success:callback,
            timeout:(10000),
            error:function(){
                $(window).dag("通信错误");
            }
        })
    }
}
