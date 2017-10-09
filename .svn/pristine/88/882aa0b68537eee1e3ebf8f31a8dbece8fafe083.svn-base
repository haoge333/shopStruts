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
	<div class="container" style="margin-bottom:53px">
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" style="padding-lefe:30px;padding-right:30px">
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
				<c:forEach var="user" items="${page.pageUser}">
					<tr>
						<td class="col-md-3">${user.id}</td>
						<td class="col-md-3">${user.name}</td>
						<td class="col-md-3">${user.role}</td>
						<td class="col-md-3"><a class="text-success" href="${pageContext.request.contextPath}/updateUser?id=${user.id}&&searchName=${searchName}">修改&nbsp&nbsp&nbsp</a>
							                 <a class="text-danger"  href="${pageContext.request.contextPath}/deleteUser?id=${user.id}&&searchName=${searchName}">删除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="4" class="text-center">
						<form action="${pageContext.request.contextPath}/pageUser?searchName=${searchName}" class="form-inline"  method="post">
							<ul class="pagination">
								<c:if test="${page.pageIndex!=1}">
									<li><a href="${pageContext.request.contextPath}/pageUser?pageIndex=1&searchName=${searchName}">首页</a></li>
									<li><a href="${pageContext.request.contextPath}/pageUser?pageIndex=${page.pageIndex-1}&searchName=${searchName}">&laquo;</a></li>
								</c:if>
								<c:forEach var="i" begin="1" end="${page.totalPage}">
									<c:if test="${page.pageIndex!=i}">
										<li><a href="${pageContext.request.contextPath}/pageUser?pageIndex=${i}&searchName=${searchName}">${i}</a></li>
									</c:if>
									<c:if test="${page.pageIndex==i}">
										<li class="active"><a href="#">${i}<span class="sr-only">(current)</span></a></li>
									</c:if>
								</c:forEach>
								<c:if test="${page.pageIndex!=page.totalPage}">
									<li><a href="${pageContext.request.contextPath}/pageUser?pageIndex=${page.pageIndex+1}&searchName=${searchName}">&raquo;</a></li>
									<li><a href="${pageContext.request.contextPath}/pageUser?pageIndex=${page.totalPage}&searchName=${searchName}">末页</a></li>
								</c:if>
								<li><input type="text" name="pageIndex" size="2" class="form-control"></li>
								<li><select name="pageSize" class="form-control">
										<option value="10">10</option>
										<option value="15">15</option>
										<option value="20">20</option>
								</select></li>
								<li><input type="submit" value="跳转" class="form-control"></li>
								<li><span>共 ${page.totalPage}页</span></li>
							</ul>
						</form>
					</th>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>