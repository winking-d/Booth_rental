<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2020/5/7
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ include file="/WEB-INF/page/include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>商铺列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
    <meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57 GMT">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${ctx }/css/font_eolqem241z66flxr.css"
          media="all"/>
    <link rel="stylesheet" href="${ctx }/css/list.css" media="all"/>
    <script type="text/javascript">
        var ctx = "${ctx}";
    </script>
</head>
<body class="childrenBody">
<blockquote class="layui-elem-quote news_search">
    <form class="layui-form">
        <div>
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" id="shopNumber" name="shopNumber" value="" placeholder="请输入商铺号"
                           class="layui-input search_input">
                </div>
                <div class="layui-input-inline layui-form" style="width: 186.5px">
                    <select name="orderState" id="orderState">
                        <option value="">请选择订单状态</option>
                        <option value="0">进行中</option>
                        <option value="1">已完成</option>
                    </select>
                </div>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="dateTime" name="dateTime" value=""
                           placeholder="请选择到期时间范围" class="layui-input search_input">
                </div>
                <a class="layui-btn search_btn" style="padding: 0 31.6px;" lay-submit="" data-type="search" lay-filter="search">查询</a>
                <button type="reset" class="layui-btn layui-btn-normal" style="margin: 0;padding: 0 31.6px;">重置</button>
            </div>
        </div>
    </form>
</blockquote>
<div class="layui-form">
    <table id="orderList" lay-filter="orderList"></table>
</div>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/html" id="stateTpl">
    {{#  if(d.orderState === '0'){ }}
    <span style="color: #01AAED;">进行中</span>
    {{#  } else if(d.orderState === '1'){ }}
    <span style="color: #FF5722;">已完成</span>
    {{#  } }}
</script>
<script type="text/javascript" src="${ctx }/page/order/orderList.js"></script>
</body>
</html>

