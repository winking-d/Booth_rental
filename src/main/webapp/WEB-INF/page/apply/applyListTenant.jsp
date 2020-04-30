<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2020/4/20
  Time: 18:07
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
<div class="layui-form">
    <table id="applyList" lay-filter="applyList"></table>
</div>
<script type="text/html" id="stateTpl">
    {{#  if(d.state === '0'){ }}
    <span style="color: #01aaed;">申请中</span>
    {{#  } else if(d.state === '1'){ }}
    <span style="color: #2bff3f;">申请成功</span>
    {{#  } else if(d.state === '2'){ }}
    <span style="color: #FF5722;">申请失败</span>
    {{#  } }}
</script>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/page/apply/applyListTenant.js"></script>
</body>
</html>

