<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta>
<title>首页</title>
<link href="/shopStruts/js/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="/shopStruts/js/bootstrap-3.3.5-dist/js/jquery.min.js"></script>
<script src="/shopStruts/js/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/shopStruts/js/upload/plupload.full.min.js"></script>
<style>
img {
	width: 60px;
	hight: 50px;
}
</style>
</head>
	<div class="container" style="margin-bottom:53px">
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" style="padding-lefe:30px;padding-right:30px">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">小商店管理系统</a>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="${pageContext.request.contextPath}/addShoppingForm">添加商品</a></li>
					<li><a href="${pageContext.request.contextPath}/pageUser">客户列表</a></li>
					<li><a href="${pageContext.request.contextPath}/listToAjax">商品展示</a></li>
				</ul>

				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="请输入查询索引信息">
					</div>
					<button type="submit" class="btn btn-default">查询</button>
				</form>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">欢迎 <span style="color: red">${loginUser.name}</span>登录 </a></li>
					<li class="dropdown"><a href="user?method=quitUser">退出系统</a></li>
				</ul>
			</div>
		</nav>
	</div>
	
	<div class="container text-center">
		<table class="table table-hover text-center table-bordered" style="background: #eee">
			<thead>
				<tr>
					<th class="text-center">编号</th>
					<th class="text-center">名称</th>
					<th class="text-center">图片</th>
					<th class="text-center">价格</th>
					<th class="text-center">品牌</th>
					<th class="text-center">生产日期</th>
					<th class="text-center">商品描述</th>
					<th class="text-center">类别名称</th>
					<td class="text-center">操作</td>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="shop" items="${listShopping}">
					<tr>
						<td>${shop.id}</td>
						<td>${shop.name}</td>
						<td><img src="/shopStruts/image/${shop.imgsFileName}"></td>
						<td>${shop.price}</td>
						<td>${shop.brand}</td>
						<td>${shop.createDate}</td>
						<td>${shop.description}</td>
						<td>${shop.categoryName}</td>
						<td><a class="text-success" href="${pageContext.request.contextPath}/updateShopping?id=${shop.id}">修改&nbsp&nbsp&nbsp</a>
							<a class="text-danger"  href="${pageContext.request.contextPath}/deleteShopping?id=${shop.id}">删除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>