layui.config({base: "js/"}).use(
    ['table'],
    function () {
        const table = layui.table;
        //加载页面数据
        table.render({
            id: 'applyList',
            elem: '#applyList',
            url: ctx + '/apply/getAppliesByUser', //数据接口
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
                }]],
            page: true
            , where: {timestamp: (new Date()).valueOf()}
            //开启分页
        });
    })