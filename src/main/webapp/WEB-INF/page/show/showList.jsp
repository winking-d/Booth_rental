<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2020/5/15
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: ZhongRJ
  Date: 2020/5/12
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>数据统计</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${ctx}/css/font_eolqem241z66flxr.css"
          media="all" />
    <link rel="stylesheet" href="${ctx}/css/main.css" media="all" />
    <script type="text/javascript" src="${ctx}/js/echarts.js"></script>
    <script>
        var ctx = "${ctx}";
    </script>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title">
    <legend>信息统计</legend>
</fieldset>
<div>
    <table class="layui-table">
        <colgroup>
            <col width="150">
            <col width="200">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th><strong>统计</strong></th>
            <th><strong>数据</strong></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>待处理申请数</td>
            <td class="applyCount"></td>
        </tr>
        <tr>
            <td>进行中订单数</td>
            <td class="orderingCount"></td>
        </tr>
        <tr>
            <td>已完成点单数</td>
            <td class="orderedCount"></td>
        </tr>
        <tr>
            <td>收入（万 元）</td>
            <td class="income"></td>
        </tr>
        </tbody>
    </table>
</div>
<fieldset class="layui-elem-field layui-field-title">
    <legend>数据展示</legend>
</fieldset>
<div id="info" style="width: 1300px; height: 570px;"></div>

<script type="text/javascript" src="${ctx}/layui/layui.js"></script>
<script type="text/javascript" src="${ctx}/page/show/showList.js"></script>
</body>
</html>

