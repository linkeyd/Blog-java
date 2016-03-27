/**
 * Created by sherry on 15-5-5.
 */

/**
 * 时间显示
 */
(function ($) {
    $.fn.now_time = function(options) { //定义插件的名称，这里为userCp
        var now_time=new Date();
        var mon=now_time.getMonth()+1;
        var day;
        switch (now_time.getDay())
        {
            case 1:
                day="周一";
                break;
            case 2:
                day="周二";
                break;
            case 3:
                day="周三";
                break;
            case 4:
                day="周四";
                break;
            case 5:
                day="周五";
                break;
            case 6:
                day="周六";
                break;
            case 7:
                day="周日";
                break;
        }
        $(this).html(now_time.getYear()+1900+'年 '+mon+"月"+now_time.getDate()+"日 "+day)
    }
})(jQuery);




/**
 *
 * @type 统计图JS
 */
function statistocs(){
    require.config({
        paths: {
            echarts: 'build/dist'
        }
    });

    require(
        [
            'echarts',
            'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
        ],
        function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = ec.init(document.getElementById('main'));

            var option = {
                title : {
                    text: '网站统计',
                    subtext: 'David'
                },
                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:['访问','信息','文章']
                },
                toolbox: {
                    show : true,
                    feature : {
//                            mark : {show: true},
//                            dataView : {show: true, readOnly: false},
//                            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
//                            restore : {show: true},
//                            saveAsImage : {show: true}
                    }
                },
                calculable : true,
                xAxis : [
                    {
                        type : 'category',
                        boundaryGap : false,
                        data : ['周一','周二','周三','周四','周五','周六','周日']
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'访问',
                        type:'line',
                        smooth:true,
                        itemStyle: {normal: {areaStyle: {type: 'default'}}},
                        data:[5, 2, 21, 50, 80, 55, 71]
                    },
                    {
                        name:'信息',
                        type:'line',
                        smooth:true,
                        itemStyle: {normal: {areaStyle: {type: 'default'}}},
                        data:[3, 18, 43, 79, 39, 30, 10]
                    },
                    {
                        name:'文章',
                        type:'line',
                        smooth:true,
                        itemStyle: {normal: {areaStyle: {type: 'default'}}},
                        data:[13, 11, 6, 23, 12, 9, 2]
                    }
                ]
            };

            // 为echarts对象加载数据
            myChart.setOption(option);
        }
    );
}
/**
 *
 * @type 日历JS
 */

function time(){
    var mydate=new Date();
    mon=mydate.getMonth()+1;
    time=mydate.getYear()+1900+"-"+mon+"-"+mydate.getDate();
    $('.form_date').datetimepicker({
        format: 'yyyy-mm-dd',
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        startDate: time,
        todayHighlight: 1,
        startView: 2,
        minView: 2
    });
    $(".remove").click(function(){
        $(".time").val("");
    })
}
