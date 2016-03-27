/**
 * Created by linwei on 2015/6/10.
 */

(function($){
    $.fn.dag=function(contenct){

        $("body").prepend('<div class="dag"> <div class="dag_hint"> <p class="dag_conten"></p> <button type="button" class="dag_button">确定</button> </div> </div>');
        $(".dag_conten").html(contenct);
        $(".dag_button").click(function(){
            close();
        });
        $(".dag_hint").fadeIn("slow");
        setTimeout(close,1500);

        function close(){
            $(".dag_hint").fadeOut(300,function(){$(".dag").fadeOut(300,function(){$(this).remove()})});
        }

    }
})(jQuery);