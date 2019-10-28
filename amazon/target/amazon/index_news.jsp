<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="newsList">
    <h2>新闻动态</h2>
    <div>
        <ul class="one">
<%--       加载新闻--%>
        </ul>
    </div>
</div>
<script>
    $(function () {
        $.post(
            "${pageContext.request.contextPath}/news.do",
            {param:"newsAll"},
            function(data) {
              $.each(data,function (i,news) {
                  $(".one").append("<li><a href='#'>"+news.title+"<a></li>")
              })
            }
        )

    })

</script>