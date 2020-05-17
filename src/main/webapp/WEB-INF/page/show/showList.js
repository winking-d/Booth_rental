layui.config({
    base: "js/"
}).use(['form', 'element', 'layer', 'jquery'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        element = layui.element,
        $ = layui.jquery;

    //信息统计
    $.get(ctx + "/show/infoStatis",
        function (data) {
            $(".applyCount").text(data.applyCount);
            $(".orderingCount").text(data.orderingCount);
            $(".orderedCount").text(data.orderedCount);
            $(".income").text(data.income);
        }
    );

    //数据展示
    var posList = [
        'left', 'right', 'top', 'bottom',
        'inside',
        'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
        'insideTopLeft', 'insideTopRight', 'insideBottomLeft', 'insideBottomRight'
    ];
    var app = {};
    app.configParameters = {
        rotate: {
            min: -90,
            max: 90
        },
        align: {
            options: {
                left: 'left',
                center: 'center',
                right: 'right'
            }
        },
        verticalAlign: {
            options: {
                top: 'top',
                middle: 'middle',
                bottom: 'bottom'
            }
        },
        position: {
            options: echarts.util.reduce(posList, function (map, pos) {
                map[pos] = pos;
                return map;
            }, {})
        },
        distance: {
            min: 0,
            max: 100
        }
    };

    app.config = {
        rotate: 90,
        align: 'left',
        verticalAlign: 'middle',
        position: 'insideBottom',
        distance: 15,
        onChange: function () {
            var labelOption = {
                normal: {
                    rotate: app.config.rotate,
                    align: app.config.align,
                    verticalAlign: app.config.verticalAlign,
                    position: app.config.position,
                    distance: app.config.distance
                }
            };
            myChart.setOption({
                series: [{
                    label: labelOption
                }, {
                    label: labelOption
                }, {
                    label: labelOption
                }, {
                    label: labelOption
                }]
            });
        }
    };


    var labelOption = {
        show: true,
        position: app.config.position,
        distance: app.config.distance,
        align: app.config.align,
        verticalAlign: app.config.verticalAlign,
        rotate: app.config.rotate,
        formatter: '{c}  {name|{a}}',
        fontSize: 16,
        rich: {
            name: {
                textBorderColor: '#fff'
            }
        }
    };
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('info'));
    myChart.showLoading({
        text: '正在努力加载中...'
    });

    var type = [];
    var shopCount = [];
    var applyCount = [];
    var orderCount = [];
    var income = [];

    // 同步执行
    $.ajaxSettings.async = false;
    // 加载数据
    $.get(ctx + '/show/dataShow', function (json) {
        type = json.type;
        shopCount = json.shopCount;
        applyCount = json.applyCount;
        orderCount = json.orderCount;
        income = json.income;
    });


    option = {
        color: ['#003366', '#006699', '#4cabce', '#e5323e'],
        title: {
            text: '各类型商铺数据',
            subtext: '实时统计',
            x: 'center'
        },
        grid: {
            x: 150,
            y: 100,
            x2: 150,
            y2: 120,
            borderWidth: 10
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['商铺', '申请', '订单', '收入(万元)']
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        xAxis: [
            {
                type: 'category',
                axisTick: {show: true},
                data: type,
                axisLabel: {
                    interval: 0,
                    textStyle:{
                        fontsize:14
                    }
                }

            }
        ],
        yAxis: [
            {
                type: 'value',
            }
        ],
        series: [
            {
                name: '商铺',
                type: 'bar',
                barGap: 0,
                label: labelOption,
                data: shopCount
            },
            {
                name: '申请',
                type: 'bar',
                label: labelOption,
                data: applyCount
            },
            {
                name: '订单',
                type: 'bar',
                label: labelOption,
                data: orderCount
            },
            {
                name: '收入(万元)',
                type: 'bar',
                label: labelOption,
                data: income
            },
        ],
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    myChart.hideLoading();
});
