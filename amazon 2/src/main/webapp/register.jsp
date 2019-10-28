<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>亚马逊 - 注册页</title>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/adv.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/scripts/adv.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/index.js"></script>

    <script>
        $(function () {
            var $sex = $("input[name='sex']:checked").val();   //获取性别
            $("#btn").click(function () {
                $.post(
                    "${pageContext.request.contextPath}/user.do",
                    {
                        param: "register",
                        name: $("#name").val(),
                        pwd: $("#passWord").val(),
                        sex: $sex,
                        birthday: $("#birthday").val(),
                        identity: $("#identity").val(),
                        email: $("#email").val(),
                        mobile: $("#mobile").val(),
                        address: $("#address").val(),
                        veryCode: $("#veCode").val(),
                    },
                    function (data) {
                        alert(data)
                    if (data =true){
                        window.location.href ="${pageContext.request.contextPath}/result.jsp";

                    }else {
                        $("clear").html(data.info).css("color","red")
                    }
                    }
                    //register name pwd sex  birthday  identity  email mobil veCode
                )
            })
             $("#refresh").click(function () {
                $("#veryCode").attr("src","${pageContext.request.contextPath}/code?timestamp=" + new Date().getTime())
             })
        })


    </script>


</head>
<body>
<%@ include file="index_top.jsp" %>

<div id="register" class="wrap">
    <div class="shadow">
        <em class="corner lb"></em>
        <em class="corner rt"></em>
        <div class="box">
            <h1>欢迎注册亚马逊</h1>
            <ul class="steps clearfix">
                <li class="current"><em></em>填写注册信息</li>
                <li class="last"><em></em>注册成功</li>
            </ul>
<%--            <form id="regForm" method="post" action="register" onsubmit="return checkForm(this)">--%>
                <table>
                    <tr>
                        <td class="field">用户名：</td>
                        <td><input  class="text" type="text" name="userName" maxlength="15" id="name"/><span id="uName"></span></td>
                    </tr>
<%--                    onfocus="FocusItem(this)" onblur="CheckItem(this);"--%>
                    <tr>
                        <td class="field">登录密码：</td>
                        <td><input class="text" type="password" id="passWord" name="passWord" /><span></span></td>
                    </tr>
<%--                    onfocus="FocusItem(this)" onblur="CheckItem(this);"--%>
                    <tr>
                        <td class="field">确认密码：</td>
                        <td><input class="text" type="password" name="rePassWord" /><span></span></td>
                    </tr>
<%--                    onfocus="FocusItem(this)" onblur="CheckItem(this);"--%>
                    <tr>
                        <td class="field">性别：</td>
                        <td><input type="radio" name="sex" style="border:0px;" checked="checked" value="0"/>男
                            <input type="radio" name="sex" style="border:0px;" value="1"/>女<span></span></td>
                    </tr>
                    <tr>
                        <td class="field">出生日期：</td>
                        <td><input class="text" type="text" name="birthday" id="birthday"/><span></span></td>
                    </tr>
<%--                    onfocus="FocusItem(this)" onblur="CheckItem(this);"--%>
                    <tr>
                        <td class="field">身份证：</td>
                        <td><input class="text" type="text" name="identity" id="identity"/><span></span></td>
                    </tr>
<%--                    onfocus="FocusItem(this)" onblur="CheckItem(this);"--%>
                    <tr>
                        <td class="field">电子邮件：</td>
                        <td><input class="text" type="text" name="email"  id="email"/><span id="uemail"></span></td>
                    </tr>
<%--                    onfocus="FocusItem(this)" onblur="CheckItem(this);" onmouseout="checkEmail()"--%>
                    <tr>
                        <td class="field">手机：</td>
                        <td><input class="text" type="text" name="mobile"  id="mobile"/><span></span></td>
                    </tr>
<%--                    onfocus="FocusItem(this)" onblur="CheckItem(this);"--%>
                    <tr>
                        <td class="field">地址：</td>
                        <td><input class="text" type="text" name="address"  id="address"/><span></span></td>
                    </tr>
<%--                    onfocus="FocusItem(this)" onblur="CheckItem(this);"--%>
                    <tr>
                        <td class="field">验证码：</td>
                        <td><input class="text verycode" type="text" name="veryCode" maxlength="4" id="veCode"/>
<%--                            onfocus="FocusItem(this)" onblur="CheckItem(this);"--%>
                            <img id="veryCode" src="${pageContext.request.contextPath}/code"/>
                            <a href="#" id="refresh">看不清 换张图</a><span id="Code"></span></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="button" name="button" value="提交注册" id="btn"/>
                        </td>
                    </tr>
                </table>
<%--            </form>--%>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2018 上海海文 All Rights Reserved. 京ICP证1000001号
</div>
<%--<label class="ui-green">--%>
</body>
</html>

