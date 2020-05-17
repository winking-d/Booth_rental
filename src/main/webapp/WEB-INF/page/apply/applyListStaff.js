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
                var shopNumber = $('#shopNumber'),
                    userName = $('#userName'),
                    applyState = $('#applyState option:selected');
                //执行重载
                table.reload(
                    'applyList',
                    {
                        page: {
                            curr: 1
                            //重新从第 1 页开始
                        },
                        where: {
                            //key: {
                            shopNumber: shopNumber
                                .val(),
                            userName: userName
                                .val(),
                            applyState: applyState
                                .val()
                            //}
                        }
                    });
            }
        };

        //加载页面数据
        table.render({
            id: 'applyList',
            elem: '#applyList',
            url: ctx + '/apply/getApplies', //数据接口
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
                    field: 'shopnumber',
                    title: '商铺号'
                },
                {
                    field: 'username',
                    title: '租户名'
                },
                {
                    field: 'phone',
                    title: '联系方式'
                },
                {
                    field: 'creattime',
                    title: '申请时间'
                },
                {
                    field: 'state',
                    title: '当前状态',
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

        //监听工具条
        table.on('tool(applyList)', function (obj) {
            var data = obj.data;
            if (data.state !=="0"){
                layer.msg("请操作处于“申请中”状态的数据！");
                return;
            }
            if (obj.event === 'adopt') {
                layer.confirm('此操作将自动拒绝此商铺的其他申请，确认租户已缴纳租金并通过此申请吗？', function (index) {
                    $.ajax({
                        url: ctx + '/apply/passApply/' + data.id,
                        type: "post",
                        success: function (d) {
                            if (d.code == 0) {
                                layer.msg("通过成功！已生成相应订单", {
                                    icon: 6
                                });
                                $(".search_btn").click();
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