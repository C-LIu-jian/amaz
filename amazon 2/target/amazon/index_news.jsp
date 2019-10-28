<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<div class="newsList">
    <h2>新闻动态</h2>
    <ul>
        <c:forEach items="${requestScope.list}" var="news">
            <li><a href="news.do?param=newsId&id=${news.id}">${news.title}</a></li>
        </c:forEach>
    </ul>
</div>
