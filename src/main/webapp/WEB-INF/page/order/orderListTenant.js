layui.config({base: "js/"}).use(
    ['form', 'layer', 'jquery', 'table', 'laydate'],
    function () {
        var form = layui.form, table = layui.table, layer = parent.layer === undefined ? layui.layer
            : parent.layer, laydate = layui.laydate;
        $ = layui.jquery;
        nowTime = new Date().valueOf();
        max = null;
        laydate.render({
            elem: '#dateTime'
            , range: true
        });
        active = {
            search: function () {
                var shopNumber = $('#shopNumber'),
                    orderState = $('#orderState option:selected'),
                    dateTime = $('#dateTime');
                //执行重载
                table.reload(
                    'orderList',
                    {
                        page: {
                            curr: 1
                            //重新从第 1 页开始
                        },
                        where: {
                            shopNumber: shopNumber
                                .val(),
                            orderState: orderState
                                .val(),
                            dateTime: dateTime
                                .val()
                        }
                    });
            }
        };

        //加载页面数据
        table.render({
            id: 'orderList',
            elem: '#orderList',
            url: ctx + '/order/getOrderListTenant', //数据接口
            limit: 10,//每页默认数
            limits: [10, 20, 30, 40],
            cols: [[ //表头
                {
                    type: 'checkbox'
                },
                {
                    field: 'uuid',
                    title: 'ID',
                    width: 60
                },
                {
                    field: 'shopId',
                    title: '商铺id',
                    hide: true
                },
                {
                    field: 'shopNumber',
                    title: '商铺号'
                },
                {
                    field: 'startTime',
                    title: '开始时间'
                },
                {
                    field: 'endTime',
                    title: '到期时间'
                },
                {
                    field: 'payRent',
                    title: '收缴租金',
                },
                {
                    field: 'orderState',
                    title: '订单状态',
                    templet: '#stateTpl'
                },
                {
                    title: '操作',
                    toolbar: '#barEdit'
                }]],
            page: true
            , where: {timestamp: (new Date()).valueOf()}
            //开启分页
        });
        table.on('tool(orderList)', function (obj) {
            var data = obj.data;
            layer.open({
                type: 2,
                title: "命名商铺",
                area: ['300px', '200px'],
                content: ctx + "/order/updateName/"+ data.shopId //这里content是一个普通的String
            })
        });
        //查询
        $(".search_btn").click(function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    })