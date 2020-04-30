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
            if (obj.event === 'apply') {
                layer.confirm('确认申请此商铺吗？', function (index) {
                    $.ajax({
                        url: ctx + '/apply/apply/' + data.id,
                        type: "post",
                        success: function (d) {
                            if (d.code == 0) {
                                layer.msg("申请成功！请等待工作人员审批", {
                                    icon: 6
                                });
                            } else {
                                layer.msg("权限不足！", {
                                    icon: 5
                                });
                            }
                        }
                    });
                    layer.close(index);
                });
            }
        });

        //查询
        $(".search_btn").click(function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    })