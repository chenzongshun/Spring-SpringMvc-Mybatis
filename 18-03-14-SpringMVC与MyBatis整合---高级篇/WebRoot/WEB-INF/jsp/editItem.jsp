<%@page import="javax.swing.filechooser.FileSystemView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>
</head>
<script type="text/javascript">
	$(function(){
		var parames = '{"id": 1,"name": "测试商品","price": 99.9,"detail": "测试商品描述","pic": "123456.jpg"}';
		$.ajax({
			url : "${pageContext.request.contextPath }/json.action",
			contentType : "application/json;charset=utf-8", // 传送给服务器的格式，由于post与get提交并没有这个参数，所以仅能用$.ajax()
			dataType : "json", // 回调的格式
			data : parames,
			type : "post",
			success : function(data) {
				/* alert(data.name) */
				/* 弹窗好麻烦，直接改掉网页标签的名字得了 */
				document.title = data.name;
			}
		})
	})
</script>
<body> 
	<!-- 上传图片是需要指定属性 enctype="multipart/form-data" -->
	<!-- <form id="itemForm" action="" method="post" enctype="multipart/form-data"> -->
	<form id="itemForm"	action="${pageContext.request.contextPath }/updateitem.action" method="post"  enctype="multipart/form-data"  >
		<input type="hidden" name="items.id" value="${item.id }" /> 修改商品信息：
		<table width="100%" border=1>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="items.name" value="${item.name }" /></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="items.price" value="${item.price }" /></td>
			</tr>
			<tr>
				<td>商品生产日期</td>
				<%-- <td><input type="text" name="items.createtime" value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>" /></td> --%>
				<%-- <td><input type="text" name="items.createtime" value="${item.createtime}"  /></td>  --%>
				
				<td><%-- <input type="text" name="items.createtime" value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>" /> --%></td> 
			</tr>
			<tr>
				<td>商品图片</td>
				<td>
					<c:if test="${item.pic !=null}">
						<img src="/pic/${item.pic}" width=100 height=100/>
						<br/>
					</c:if>
					<input type="file"  name="pictureFile"/> <!-- name和服务器端的接口名一定要一致 -->
				</td>
			</tr>
			<tr>
				<td>商品简介</td>
				<td><textarea rows="3" cols="30" name="items.detail">${item.detail }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>