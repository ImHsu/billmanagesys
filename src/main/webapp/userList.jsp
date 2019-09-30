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
                    <li ><a href="/billlist">账单管理</a></li>
                    <li><a href="/supplierlist">供应商管理</a></li>
                    <li><a href="/userlist">用户管理</a></li>
                    <li><a href="/password.jsp">密码修改</a></li>
                    <li><a href="/logout">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
                <form action="/usersearch" method="post">
                <span>用户名：</span>
                <input type="text" name="name" placeholder="请输入用户名"/>
                <input style="width:100px ; height:35px" type="submit" value="查询"/>
                <a href="/userAdd.jsp">添加用户</a>
                </form>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">电话</th>
                    <th width="10%">用户类型</th>
                    <th width="30%">操作</th>
                </tr>


                <c:forEach items="${list}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.sex}</td>
                        <td>${user.age}</td>
                        <td>${user.phone}</td>
                        <td>${user.userclass}</td>
                        <td>
<%--                            <a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/users?method=edit&id=${user.id}">修改</a>--%>
<%--                            <a class="btn btn-danger btn-sm del" href="#" onclick="del('${user.id}')" >删除</a>--%>
                            <a href="/userview?id=${user.id}"><img src="img/read.png" alt="查看" title="查看"/></a>
                            <a href="/useredit?id=${user.id}"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                            <a href="/userdelete?id=${user.id}" class="removeUser"><img src="img/schu.png" alt="删除" title="删除"/></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </section>





<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

    <footer class="footer">
    </footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>