<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="p_category">
	<h2>商品分类</h2>
		<ul>
			<li class="start">
			</li>
				<dd>
					<a href=""></a>
				</dd>
		</ul>
</div>

<script>
   $(function () {
	  $.post(
	  	"${pageContext.request.contextPath}/Category.do",
			  {param:"start"},
			  function (data) {
				$.each(data,function (i,category) {
				 $(".start").append("<a href=''>"+category.name+"</a><br>");
				})
			  }
	  )
   })



</script>