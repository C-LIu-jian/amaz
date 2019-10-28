<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="hot_sale">
	<h2>热卖推荐</h2>
	<ul class="pro">
<%--	加载热卖商品--%>
	</ul>
</div>
  <script>
	  $(function () {
		$.post(
		  "${pageContext.request.contextPath}/Product.do",{param:"best"},
				  function (data) {
					  $.each(data,function (i,product) {
						var html ="<li><dl><dt>";
                           html+="<a href='${pageContext.request.contextPath}/Product.do?param=productAllId&id="+product.id+"' target='_self'> <img src='"+product.img_source+"'/>"+product.name+"</a></dt>";
                           html+=" <dd class='p_name'><a href='${pageContext.request.contextPath}/Product.do?param=productAllId&id="+product.id+"' target='_self'>"+product.description+"</a></dd>";
                           html+=" <dd class='price'>￥"+product.price+"</dd></dl></li>";
                          $(".pro").append(html);
					  })
				  })
	  })





  </script>