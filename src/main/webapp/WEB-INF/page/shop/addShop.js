var $;
var $form;
var form;
layui.config({
    base : "js/"
}).use(['form','layer','jquery',],function(){
    var layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,laydate = layui.laydate;
    $ = layui.jquery;
    form = layui.form;

    $("#shopNumber").blur(function(){
        $.ajax({
            type: "post",
            url: ctx+"/user/checkShopByNumber?number="+$("#shopNumber").val(),
            success:function(data){
                if(data.code!=0){
                    top.layer.msg(data.msg);
                    $("#shopNumber").val("");
                    $("#shopNumber").focus();
                }
            }
        });
    });

    form.on("submit(addShop)",function(data){
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        var msg,flag=false;
        $.ajax({
            type: "post",
            url: ctx+"/shop/insShop",
            async:false,
            data:data.field,
            dataType:"json",
            success:function(d){
                if(d.code==0){
                    msg="商铺添加成功！";
                    flag=true;
                    $("#auf")[0].reset();
                }else{
                    msg=d.msg;
                }
            }
        });
        setTimeout(function(){
            top.layer.close(index);
            if(flag){
                top.layer.msg(msg,{icon: 1});
            }else{
                top.layer.msg(msg,{icon: 5});
            }
            //layer.closeAll("iframe");
            //刷新父页面
            //parent.location.reload();
        },2000);
        return false;
    })

})