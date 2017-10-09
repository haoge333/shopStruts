<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	<div class="container" style="width: 500px; margin-top: 150px; background: #fff; padding: 20px;">
		<h3 class="text-center">修改用户</h3> <br>
		<form action="/shopStruts/updateInfo" method="post" class="form-horizontal">
			<input type="hidden" class="form-control" name="id" value="${updateUser.id}">
			<input type="hidden" class="form-control" name="searchName" value="${searchName}">
			
			<div class="form-group" style="margin-top: 20px;">
				<label for="name" class="col-md-2 control-label">姓名:</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" name="name" value="${updateUser.name}">
				</div>
			</div>

			<div class="form-group" style="margin-top: 20px;">
				<label for="password" class="col-md-2 control-label">密码:</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" name="password" value="${updateUser.password}">
				</div>
			</div>

			<div class="form-group" style="margin-top: 20px;">
				<label for="role" class="col-md-2 control-label">角色:</label>
				<div class="col-sm-9">
					<input type="role" class="form-control" name="role" value="${updateUser.role}">
				</div>
			</div>

			<button type="submit" class="btn btn-primary btn-block" style="margin: 20px 0px">修改</button>
		</form>
	</div>
</body>
</html>