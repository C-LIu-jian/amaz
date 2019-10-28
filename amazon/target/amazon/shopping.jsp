<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>亚马逊- 购物车</title>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/adv.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/scripts/adv.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/index.js"></script>
    <script type="text/javascript" src="scripts/shopping.js"></script>
</head>
<body>
<%@ include file="index_top.jsp" %>

<div id="position" class="wrap">
    您现在的位置：<a href="index.jsp">亚马逊</a> &gt; 购物车
</div>
<div class="wrap">
    <div id="shopping">
        <c:choose>
            <c:when test="${empty sessionScope.cart or fn:length(sessionScope.cart.cartItems) eq 0}">
                ${sessionScope.ShoppingCart.cart} 购物车<br>
                ${sessionScope.ShoppingCart.cart.CartItem}
                <img src="images/shop.jpg"/>
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <th>商品名称</th>
                        <th>商品价格</th>
                        <th>购买数量</th>
                        <th>操作</th>
                    </tr>
                    <!-- 根据用户购物车生成列表 -->

                    <c:forEach items="${sessionScope.cart.cartItems}" var="CartItem">
                        <tr id="product_id_1"> class="thumb"
                            <td ><img src="${CartItem.product.img_source}"/></td>
                            <td >￥${CartItem.product.price}</td>
                            <td>
                                <input type="button" value=" - " width="3px" >
                                <input type="text" name="number" value="" style="width:20px;text-align:center;vertical-align:middle"/>
                                <input type="button" value=" + " width="2px"></td>
                            <td><a href="#" value="${CartItem.product.id}">删除</a></td>
                        </tr>
                    </c:forEach>
                </table>
			  <div class="button"><input type="submit" value=""/></div> <%--	 按钮--%>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<div id="footer">
    Copyright &copy; 2018 上海海文 All Rights Reserved.
</div>
     <script>
         $(function () {
             $("a").click(function () {
             var Id=$(this).attr("value")
                 $.post(
                     "${pageContext.request.contextPath}/Shopping.do",
                     {param:"remove",id:Id},
                     function (data) {
                         if (data=="true"){
                            location.reload();
                         }
                     }
                 )
             })
         })
	 </script>
</body>
</html>

