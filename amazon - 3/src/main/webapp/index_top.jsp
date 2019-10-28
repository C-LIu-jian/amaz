
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	double num = Math.random();
%>

<div id="header">
	<div class="login_menu">
		<div class="login_container">
			<c:set value="${sessionScope.user }" var="user"></c:set>
			<ul class="m_left">
				<li><a href="login.jsp" class="c_red">请登录</a>&nbsp;&nbsp;&nbsp;</li>
				<li><a href="register.jsp">请注册</a></li>
			</ul>

			<ul class="m_right">
				<li><img src="images/icon_3.png"><a
					href="${pageContext.request.contextPath}/shopping.jsp" class="c_red">购物车</a></li>
				<li><img src="images/icon_4.png"><a
					href="javascript:AddFavorite('我的网站',location.href)">收藏</a></li>
				<li><img src="images/icon_2.png"><a href="${pageContext.request.contextPath}/Comment.do?param=login">留言</a></li>
				<li><img src="images/icon_1.png"><a href="${pageContext.request.contextPath}/index">首页</a></li>
			</ul>
		</div>
	</div>
	<div class="logo_search">
		<div class="logo">
			<img src="images/LOGO.png">
		</div>
		<div class="search">
			<input type="text" placeholder="输入宝贝" id="qname" />
			<button class="query_button"  id="btn">搜索</button>
		</div>
	</div>
	<div class="nav_bar">
		<div class="nav_bar_container">
			<ul>
				<li><a href="#">商品名称</a></li>
				<li><a href="#">商品名称</a></li>
				<li><a href="#">商品名称</a></li>
				<li><a href="#">商品名称</a></li>
			</ul>
			<ul>
				<li><a href="">用户 : ${user.uname}</a></li>
				<li><a href="#">我的订单</a></li>
				<li><a href="#">推出</a></li>
			</ul>
		</div>
	</div>
</div>

<%--搜索事件--%>
  <script>
	  $(function () {
		  $("#btn").click(function () {
			 $("#qname").val();
			  window.location="${pageContext.request.contextPath}/Product.do?param=SE&qname="+$("#qname").val();
			 })
		  })


  </script>
