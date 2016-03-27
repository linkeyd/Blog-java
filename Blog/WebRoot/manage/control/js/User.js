/**
 * Created by linwei on 2015/6/10.
 */


/*
 *获取用户信息
 */
var GetUser={
    callback:function(data) {
        $(".GetUser").html('<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;'+data.username);
    },
    init:function(){
        sumbit_ajax.get_ajax("../../GetLogin",GetUser.callback);
    }
};





/**
 *  用户登出
 */


var OutUser={
    callback:function(data){
     if(data)
     {
         window.location.href="../login.html";
     }
     else{
         $(window).dag("登出失败请重新操作");
     }
    },
    init:function(){
        $(".OutLogin").click(function(){
            sumbit_ajax.get_ajax("../../OutLogin",OutUser.callback)
        });
    }
}


/**
 * 执行调用
 */
GetUser.init();
OutUser.init();