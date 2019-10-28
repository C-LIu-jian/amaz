<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊-首页</title>
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/index.js"></script>
	<script>
		$(function () {
			$.post(
					"${pageContext.request.contextPath}/Product.do",
					{param:"load",pageNo:1},
					function (data) {
						$.each(data,function (i,category) {
							$(".start").append("<a href=''>"+category.name+"</a><br>");
						})
					}
			)

		})
        //分页
        function go(pageNo) {
            window.location = "${pageContext.request.contextPath}/Product.do?param=load&pageNo="+ pageNo ;
            return false;
        }
        //点击商品
        function two(id) {
			$.post("${pageContext.request.contextPath}/Cook.do",{Id:id},function (data) {})  //商品记录
           window.location="${pageContext.request.contextPath}/Product.do?param=productAllId&id="+id;

		}
	</script>
</head>
<body>
	<%@ include file="index_top.jsp"%>
	<div id="middle">
		<div class="p_left">
			<!--商品分类-->
			<%@ include file="index_product_sort.jsp"%>
			<!--浏览记录-->
            <%@include file="browsing.jsp"%>
		</div>

		<div class="p_center">
			<div id="wrapper">
				<div id="focus">
					<ul>
						<
<%--						<li><a href="#"><img src="images/T1.jpg" /></a></li>--%>
			            <li><a href="#"><img src="images/T1.jpg" /></a></li>
						<li><a href="#"><img src="images/T2.jpg" /></a></li>
						<li><a href="#"><img src="images/T3.jpg" /></a></li>
						<li><a href="#"><img src="images/T4.jpg" /></a></li>
						<li><a href="#"><img src="images/T5.jpg" /></a></li>
					</ul>
				</div>
			</div>
			<div class="p_list">
				<div class="p_info">
					<img src="images/icon_sale.png" />商品列表
				</div>
			</div>

			<ul class="product2">
				<C:forEach items="${requestScope.paging.products}" var="product">
				<li>
						<dl>
							<dt>
								<a href="javascript:two('${product.id}')">
								<img src="${product.img_source}" /></a>
							</dt>
							<dd class="title">
								<a href="javascript:two('${product.id}')" >${product.name}</a>
							</dd>
							<dd class="price">￥${product.price}</dd>
						</dl>
					</li>
				</C:forEach>
			</ul>
            <a href=javascript:go('1')>首页</a>&nbsp;&nbsp;<a href="javascript:go('${paging.prePage} ')">上一页</a>&nbsp;&nbsp;
            ${paging.pageNo} /${paging.totalPages}&nbsp;&nbsp;<a href="javascript:go('${paging.nextPage} ')">下一页</a>&nbsp;&nbsp;<a href="javascript:go('${paging.totalPages} ')">尾页</a>
		</div>

		<div id="p_right">
<%--			加载新闻--%>
	          <%@ include file="index_news.jsp"%>
			 <%@ include file="hotproduct.jsp"%>
		</div>
	</div>

	<div id="foot">Copyright © 2018 上海海文 All Rights Reserved.</div>

</body>
</html>

