/**
 * Created by sherry on 2015/5/16.
 */


var post_login={
    Username:"",
    Password:"",
    list:function(){
        return {username:post_login.Username,password:post_login.Password};
    },
    callback:function(data){
        if(data)
        	{
        	window.location.href="control/index.html";
        	}
        else{
        	$(window).dag("登陆失败。");
        }
    },
    init:function(){
         $("#logins").click(function(){
            post_login.Username=$("#Username").val();
            post_login.Password=$("#Password").val();
            sumbit_ajax.post_ajax("../login",post_login.list(),post_login.callback);
         });
        }
}
/**
 * click点击事件
 */
post_login.init();
