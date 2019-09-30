<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="/logout">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li id="active"><a href="/billlist">账单管理</a></li>
                <li><a href="/supplierlist">供应商管理</a></li>
                <li><a href="/userlist">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="/logout">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>账单管理页面 >> 信息查看</span>
        </div>
        <div class="providerView">
            <p><strong>订单编号：</strong><span>${bill.id}</span></p>
            <p><strong>商品名称：</strong><span>${bill.product}</span></p>
<%--            <p><strong>商品单位：</strong><span>${bill.id}</span></p>--%>
<%--            <p><strong>商品数量：</strong><span>${bill.id}</span></p>--%>
            <p><strong>总金额：</strong><span>${bill.amount}</span></p>
            <p><strong>供应商：</strong><span>${bill.supplier}</span></p>
            <p><strong>是否付款：</strong><span>${bill.pay}</span></p>
            <p><strong>创建日期：</strong><span>${bill.date}</span></p>

            <a href="/billlist">返回</a>
        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>