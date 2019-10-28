<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="p_category">
	<h2>商品分类</h2>
		<ul class="start">
</ul>
</div>

<script>
   $(function () {
	  $.post(
	  	"${pageContext.request.contextPath}/Category.do",
			  {param:"start"},
			  function (data) {
				$.each(data,function (i,category) {
					// 一级分类
				 $(".start").append("<h6>&emsp;<a href='${pageContext.request.contextPath}/Product.do?param=major&parent="
						 +category.id+"'>" +category.name+"</a><h6>");
				  $.each(category.categories,function (i,categorys) {
				  	// 二级分类
					  $(".start").append("&emsp;&emsp;&emsp;<a href='${pageContext.request.contextPath}/Product.do?param=minor&parent="
							  +categorys.id+"'>"+categorys.name+"</a><br>");
				  })
				})
			  }


	  )
   })

</script>