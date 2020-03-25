layui.config({base: "js/"}).use(
    ['form', 'layer', 'jquery', 'table', 'laydate'],
    function () {
        var form = layui.form, table = layui.table, layer = parent.layer === undefined ? layui.layer
            : parent.layer, laydate = layui.laydate;
        $ = layui.jquery;
        nowTime = new Date().valueOf();
        max = null;
        active = {
            search: function () {
                var shopNumber = $('#shopNumber'), shopType = $('#shopType option:selected'),
                    shopState = $('#shopState option:selected'),
                    shopSizeMin = $("#shopSizeMin"), shopSizeMax = $("#shopSizeMax");
                //执行重载
                table.reload(
                    'shopList',
                    {
                        page: {
                            curr: 1
                            //重新从第 1 页开始
                        },
                        where: {
                            //key: {
                            shopNumber: shopNumber
                                .val(),
                            shopType: shopType
                                .val(),
                            shopState: shopState
                                .val(),
                            shopSizeMin: shopSizeMin
                                .val(),
                            shopSizeMax: shopSizeMax
                                .val()
                            //}
                        }
                    });
            }
        };

        var start = laydate.render({
            elem: '#createTimeStart',
            type: 'datetime',
            max: nowTime,
            btns: ['clear', 'confirm'],
            done: function (value, date) {
                endMax = end.config.max;
                end.config.min = date;
                end.config.min.month = date.month - 1;
            }
        });
        var end = laydate.render({
            elem: '#createTimeEnd',
            type: 'datetime',
            max: nowTime,
            done: function (value, date) {
                if ($.trim(value) == '') {
                    var curDate = new Date();
                    date = {
                        'date': curDate.getDate(),
                        'month': curDate.getMonth() + 1,
                        'year': curDate.getFullYear()
                    };
                }
                start.config.max = date;
                start.config.max.month = date.month - 1;
            }
        });

        //加载页面数据
        table.render({
            id: 'shopList',
            elem: '#shopList',
            url: ctx + '/shop/getShopList', //数据接口
            limit: 10,//每页默认数
            limits: [10, 20, 30, 40],
            cols: [[ //表头
                {
                    type: 'checkbox'
                },
                {
                    field: 'id',
                    title: 'ID',
                    width: 60
                },
                {
                    field: 'shopNumber',
                    title: '商铺号'
                },
                {
                    field: 'shopName',
                    title: '商铺名'
                },
                {
                    field: 'shopSize',
                    title: '商铺面积（㎡）'
                },
                {
                    field: 'shopType',
                    title: '商铺类型',
                    templet: '#typeTpl'
                },
                {
                    field: 'shopState',
                    title: '商铺状态',
                    templet: '#stateTpl'
                },
                {
                    field: 'shopRent',
                    title: '租金（元/月）'
                },
                // {
                //     field : 'createTime',
                //     title : '注册日期',
                //     templet : '<div>{{ formatTime(d.createTime,"yyyy-MM-dd hh:mm:ss")}}</div>'
                // },
                {
                    title: '操作',
                    toolbar: '#barEdit'
                }]],
            page: true
            , where: {timestamp: (new Date()).valueOf()}
            //开启分页
        });

        //监听工具条
        table.on('tool(shopList)', function (obj) {
            var data = obj.data;
            if (obj.event === 'del') {
                layer.confirm('真的删除此行么', function (index) {
                    $.ajax({
                        url: ctx + '/shop/delShopById/' + data.id,
                        type: "post",
                        success: function (d) {
                            if (d.code == 0) {
                                obj.del();
                            } else {
                                layer.msg("权限不足！", {
                                    icon: 5
                                });
                            }
                        }
                    });
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                layer.open({
                    type: 2,
                    title: "编辑商铺",
                    area: ['400px', '350px'],
                    content: ctx + "/shop/editShop/"+ data.id //这里content是一个普通的String
                })
            }

        });

        //查询
        $(".search_btn").click(function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        //添加商铺
        $(".shopAdd_btn").click(function () {
            var index = layui.layer.open({
                title: "添加商铺",
                type: 2,
                content: ctx + "/shop/addShop",
                success: function (layero, index) {
                }
            });
            //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
            $(window).resize(function () {
                layui.layer.full(index);
            });
            layui.layer.full(index);
        });

        //批量删除
        $(".batchDel")
            .click(
                function () {
                    var checkStatus = table
                        .checkStatus('shopList'), data = checkStatus.data, shopStr = '';
                    if (data.length > 0) {
                        $.each(data, function (n, value) {
                            shopStr += value.id + ',';
                        });
                        shopStr = shopStr
                            .substring(0, shopStr.length - 1);
                        layer
                            .confirm(
                                '确定删除<strong>'
                                + data.length
                                + '</strong>条数据吗？',
                                function (index) {
                                    //调用删除接口
                                    $.ajax({
                                        url: ctx
                                            + '/shop/delShops/'
                                            + shopStr,//接口地址
                                        type: "get",
                                        success: function (d) {
                                            if (d.code == 0) {
                                                //删除成功，刷新父页面
                                                parent.location
                                                    .reload();
                                            } else {
                                                layer
                                                    .msg(
                                                        "权限不足，联系超管！",
                                                        {
                                                            icon: 5
                                                        });
                                            }
                                        }
                                    })
                                });
                    } else {
                        layer.msg("请选择需要删除的用户");
                    }
                });
        form.render();
    });

//格式化时间
function formatTime(datetime, fmt) {
    if (datetime == null || datetime == 0) {
        return "";
    }
    if (parseInt(datetime) == datetime) {
        if (datetime.length == 10) {
            datetime = parseInt(datetime) * 1000;
        } else if (datetime.length == 13) {
            datetime = parseInt(datetime);
        }
    }
    datetime = new Date(datetime);
    var o = {
        "M+": datetime.getMonth() + 1, //月份
        "d+": datetime.getDate(), //日
        "h+": datetime.getHours(), //小时
        "m+": datetime.getMinutes(), //分
        "s+": datetime.getSeconds(), //秒
        "q+": Math.floor((datetime.getMonth() + 3) / 3), //季度
        "S": datetime.getMilliseconds()
        //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (datetime.getFullYear() + "")
            .substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1,
                (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
                    .substr(("" + o[k]).length)));
    return fmt;
}