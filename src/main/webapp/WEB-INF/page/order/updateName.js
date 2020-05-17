var $;
var form;
layui.config({
    base: "js/"
}).use(['form', 'layer', 'jquery', 'laydate'], function () {
    var layer = parent.layer === undefined ? layui.layer : parent.layer,
        laydate = layui.laydate;
    $ = layui.jquery;
    form = layui.form;
    form.on("submit(updShop)", function (data) {
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});
        var msg;
        $.ajax({
            type: "post",
            url: ctx + "/order/updateShopName",
            data: data.field,
            dataType: "json",
            success: function (d) {
                if (d.code == 0) {
                    msg = "修改成功！";
                } else {
                    msg = d.msg;
                }
            }
        });
        setTimeout(function () {
            top.layer.close(index);
            top.layer.msg(msg);
            layer.closeAll("iframe");
            // 刷新父页面
            parent.location.reload();
        }, 2000);
        return false;
    })

})