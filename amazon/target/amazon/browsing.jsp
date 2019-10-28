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
     Cookie[] cookies= request.getCookies();
     boolean flag = false;//默认没有找到指定名字的cookie
       List<Product> list = new ArrayList<>();
       if (cookies !=null && cookies.length >0){
            for (Cookie cookie : cookies){
                if (cookie.getName().equals("hisTroyId")){
                    flag=true;
                    String value =cookie.getValue();
                    String[] ids= value.split("-");
                    for (String id : ids){
                        Long Id=Long.parseLong(id);
                       list.add(new ProductServiceImpl().productOne(Id));
                    }
                }
            }
       }
       request.setAttribute("list",list);
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
