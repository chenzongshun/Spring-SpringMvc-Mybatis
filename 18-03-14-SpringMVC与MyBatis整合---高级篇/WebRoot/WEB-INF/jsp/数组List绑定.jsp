<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<title>查询商品列表</title>
</head>
<body>
		查询条件：
		<table width="100%" border=1>
			<tr>
				<td><input type="submit" value="查询" /></td>
			</tr>
		</table>
	<form action="${pageContext.request.contextPath }/deletes.action" id = "ffform" method="post">
		商品列表：
		<table width="100%" border=1>
			<tr>
				<td>商品名称</td>
				<td>商品价格</td>
				<td>生产日期</td>
				<td>商品描述</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${itemList }" var="item" varStatus="list">
				<tr>
					<td>
						<input type="hidden" name="itemsList[${list.index}].id" value="${item.id}"/>
						<input type="checkbox" name="ids" value="${item.id}"/> 
						<input type="text" name="itemsList[${list.index}].name" value="${item.name}"/>
					</td>
					<td><input type="text" name="itemsList[${list.index}].price" value="${item.price}"/></td>
					<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${item.detail }</td>
					<td><a href="${pageContext.request.contextPath }/itemEdit.action?id=${item.id}">修改</a></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="删除选中的">
		<input type="button" value="修改页面的内容" onclick="updates()">
	</form>
</body>
<script>
	 /* js提交表单决定action位置并提交表单 */
	 function updates() {
	 	var from = document.getElementById("ffform");
		from.action="${pageContext.request.contextPath }/updates.action"
		from.submit();
	}

</script>
</html>