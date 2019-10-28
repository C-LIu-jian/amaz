<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 产品列表</title>
	<link href="${pageContext.request.contextPath}/css/index.css"
		  rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/adv.css"
		  rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/style.css"
		  rel="stylesheet" type="text/css" />
	<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js"
			type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/scripts/adv.js"
			type="text/javascript"></script>
	<script type="text/javascript"
			src="${pageContext.request.contextPath}/scripts/function.js"></script>
	<script type="text/javascript"
			src="${pageContext.request.contextPath}/scripts/index.js"></script>
	<script type="text/javascript" src="scripts/product_view.js"></script>
</head>;
<body>
	<%@ include file="index_top.jsp"%>
<%--	导航屑--%>
	<div id="position" class="wrap">您现在的位置：<a href="#">亚马逊</a> &gt; <a href="#">图书音像</a> &gt; 图书
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
			<%@ include file="index_product_sort.jsp"%>
			<div class="spacer"></div>
			<div class="last-view">




			</div>
		</div>
		<div class="main">
			<div class="product-list">
				<h2>全部商品</h2>
				<div class="clear"></div>

                   <c:forEach  items="${list}" var="product">
						<dl>
							<dt>
								<a href="#" target="_self"><img src="${product.img_source}" /></a>
							</dt>
							<dd class="title">
								<a href="#" target="_self">商品名称 : ${product.name}</a>
							</dd>
							<dd class="price">￥${product.price}</dd>
						</dl>
				   </c:forEach>
			</div>
	</div>
	<div id="footer">Copyright &copy; 2018 上海海文 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>

