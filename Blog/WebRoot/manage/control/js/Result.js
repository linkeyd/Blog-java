/**
 * Created by linwei on 2015/6/11.
 */
function CloseAll(){
    $("#close").click(function(){
        $("form *").val("");
    });
    $("#insert").click(function(){
        $("form *").val("");
    });
    $("#alter").click(function(){
        $("form *").val("");
    });
}

function display(){
    $("#Edit").live('click',function(){
        $("#insert").css({"display":"none"});
        $("#alter").css({"display":"inline-block"});
    });
    $("#append").click(function(){
        $("#insert").css({"display":"inline-block"});
        $("#alter").css({"display":"none"});
    })
}
CloseAll();
display();
