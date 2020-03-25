<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2020/3/11
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>编辑商铺信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all"/>
    <script>
        var ctx = "${ctx}";
    </script>
    <style type="text/css">
        .layui-form-item .layui-inline {
            width: 33.333%;
            float: left;
            margin-right: 0;
        }

        @media ( max-width: 1240px) {
            .layui-form-item .layui-inline {
                width: 100%;
                float: none;
            }
        }
    </style>
</head>
<body class="childrenBody">
<form class="layui-form" style="padding: 3% 10% 0 10%">
    <!-- 管理员id -->
    <input type="hidden" name="id" value="${shop.id }" id="id"/>
    <div class="layui-form-item">
        <label class="layui-form-label">商铺号</label>
        <div class="layui-input-block">
            <input type="text" id="shopNumber" name="shopNumber" class="layui-input shopName"
                   lay-verify="required" placeholder="请输入商铺号(如 1#101 指 1层101)" value="${shop.shopNumber}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商铺面积</label>
        <div class="layui-input-block">
            <input type="text" id="shopSize" class="layui-input shopName"
                   lay-verify="required|number" placeholder="请输入商铺面积(㎡)" name="shopSize" value="${shop.shopSize}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商铺类型</label>
        <div class="layui-input-block">
            <select id="shopType" name="shopType">
                <option value="">请选择商铺类型</option>
                <option value="01">服饰</option>
                <option value="02">餐饮</option>
                <option value="03">影院</option>
                <option value="04">KTV</option>
                <option value="05">超市</option>
            </select>
        </div>
    </div>
    <input type="hidden" name="shopState" value="${shop.shopState }" id="shopState"/>
    <div class="layui-form-item">
        <label class="layui-form-label">商铺租金</label>
        <div class="layui-input-block">
            <input type="text" id="shopRent" name="shopRent" class="layui-input shopName"
                   lay-verify="required|number" placeholder="请输入商铺租金（￥/月）" value="${shop.shopRent}">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="updShop">立即保存</button>
        </div>
    </div>
</form>
<script>
    var shopType = "${shop.shopType}"
</script>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/page/shop/editShop.js"></script>
</body>
</html>
