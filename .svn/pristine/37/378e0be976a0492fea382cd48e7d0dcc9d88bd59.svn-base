<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta>
<title>首页</title>
<link href="/shopStruts/js/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/shopStruts/js/bootstrap-3.3.5-dist/js/jquery.min.js"></script>
<script src="/shopStruts/js/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<style>
#box {
	width: 1200px;
}
</style>
</head>
<body id="box" class="container">
	<div class="container">
		<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-header">
				<div class="navbar-header">
					<h4>小商店管理系统</h4>
				</div>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="${pageContext.request.contextPath}/addUserForm">添加客户</a></li>
					<li><a href="${pageContext.request.contextPath}/listShopping">商品列表</a></li>
				</ul>

				<form class="navbar-form navbar-left" role="search" action="${pageContext.request.contextPath}/pageUser" method="post">
					<div class="form-group">
						<input type="text" class="form-control" name="searchName"  placeholder="请输入查询索引信息" value='${searchName}'>
					</div>
					<button type="submit" class="btn btn-default">查询</button>
				</form>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">欢迎 <span style="color: red">${loginUser.name}</span>登录 </a></li>
					<li><a href="#">联系我们</a></li>
					<li class="dropdown"><a href="user?method=quitUser">退出系统</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="container text-center">
		<table class="table table-hover text-center table-bordered " style="background: #eee">
			<thead>
				<tr>
					<td>编号</td>
					<td>姓名</td>
					<td>角色</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${listUser}">
					<tr>
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.role}</td>
						<td><a href="${pageContext.request.contextPath}/updateUser?id=${user.id}">修改</a>
							<a href="${pageContext.request.contextPath}/deleteUser?id=${user.id}">删除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>