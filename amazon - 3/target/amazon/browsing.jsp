<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.huwa.entity.Product" %>
<%@ page import="com.huwa.serviceImpl.ProductServiceImpl" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/21
  Time: 1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        $(function () {
            $.post(
                "${pageContext.request.contextPath}/Cook.do",
                {},
                function (data) {})
        })
    </script>
</head>
<body>
   <%

   %>



            <div class="pre_look">
                <h3>最近浏览</h3>
                <c:forEach items="${list}" var="product">
                <dl>
                    <dt>
                        <img style="width: 54px; height: 54px;" src="${product.img_source}" />
                    </dt>
                    <dd>
                        <a href="">${product.name}</a>
                    </dd>
                </dl>
                </c:forEach>
            </div>

</body>
</html>
