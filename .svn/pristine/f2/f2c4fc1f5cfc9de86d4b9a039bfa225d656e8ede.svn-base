<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/shopStruts/js/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="/shopStruts/js/bootstrap-3.3.5-dist/js/jquery.min.js"></script>
<script src="/shopStruts/js/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container" style="width: 500px; margin-top: 20px; background: #fff; padding: 20px;">
		<h3 class="text-center">修改商品</h3> <br>
		<form action="/shopStruts/updateShoppingInfo" method="post" class="form-horizontal" enctype="multipart/form-data">
			<input type="hidden" class="form-control" name="id" value="${updateShopping.id}">
			
			<div class="form-group" style="margin-top: 20px;">
				<label for="name" class="col-md-3 control-label">商品名称:</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" name="name" value="${updateShopping.name}">
				</div>
			</div>

			<div class="form-group" style="margin-top: 20px;">
				<label for="price" class="col-md-3 control-label">商品价格:</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" name="price"  value="${updateShopping.price}">
				</div>
			</div>

			<div class="form-group" style="margin-top: 20px;">
				<label for="brand" class="col-md-3 control-label">商品品牌:</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" name="brand"  value="${updateShopping.brand}">
				</div>
			</div>
			
			<div class="form-group" style="margin-top: 20px;">
				<label for="createDate" class="col-md-3 control-label">生产日期:</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" name="createDate"  value="${updateShopping.createDate}">
				</div>
			</div>
			
			<div class="form-group" style="margin-top: 20px;">
				<label for="description" class="col-md-3 control-label">商品描述:</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" name="description"  value="${updateShopping.description}">
				</div>
			</div>
			
			<div class="form-group" style="margin-top: 20px;">
				<label for="categoryName" class="col-md-3 control-label">类别名称:</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" name="categoryName"  value="${updateShopping.categoryName}">
				</div>
			</div>
			
			<div class="form-group" style="margin-top: 20px;">
				<label for="imgs" class="col-md-3 control-label">上传图片:</label>
				<div class="col-sm-9">
					<input type="file" name="imgs">
				</div>
			</div>
	
			<div class="form-group" style="margin-top: 20px;width:428px;margin-left: 32px;">
				<input type="reset"  class="btn btn-primary btn-block" >
				<input  type="submit" class="btn btn-primary btn-block" >
			</div>
			
		</form>
	</div>
</body>
</html>