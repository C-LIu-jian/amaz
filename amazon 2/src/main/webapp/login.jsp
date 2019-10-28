<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 登录</title>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/index.js"></script>
  <script>

	  $(function () {
		$("#button").click(function () {
			var name =$("#name").val();
			var pwd =$("#password").val();
			var veCode =$("#veCode").val();
			$.post("${pageContext.request.contextPath}/user.do",{
				param:"login",
				name:name,
				pwd:pwd,
				veryCode:veCode
			},function(data) {
              if (data.login==true){
				  $("#char").html("登陆成功");
			  }else{
              	$("#char").html(data.info).css("color","red");
			  }
			})
		})
		  //给超链接注册一个单击事件
		  $("#refresh").click(function () {
			  $("#imgCode").attr("src","${pageContext.request.contextPath}/code?timestamp=" + new Date().getTime());
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
			<div id="char"></div>
			<h1>欢迎回到亚马逊</h1>
<%--			<form id="loginForm" method="post" action="login" onsubmit="return loginCheck()">--%>
				<table>
					<tr>
						<td class="field">用户名：</td>
						<td><input class="text" type="text" name="userName"  id="name" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">登录密码：</td>
						<td><input class="text" type="password"  name="passWord" id="password" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><a href="retrieve_password.jsp">忘记密码</a></td>
		
					</tr>
					<tr>           
						<td class="field">验证码：</td>
						<td><input class="text" type="text" name="veryCode" id="veCode" onfocus="FocusItem(this)" onblur="CheckItem(this);" maxlength="4"/>
							<img id="imgCode" src="${pageContext.request.contextPath}/code"/>
							<a href="#" id="refresh">看不清 换张图</a>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-green"><input type="button" name="button" id="button" value="立即登录" /></label></td>
					</tr>
				</table>
<%--			</form>--%>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2018  上海海文 All Rights Reserved
</div>
</body>
</html>
