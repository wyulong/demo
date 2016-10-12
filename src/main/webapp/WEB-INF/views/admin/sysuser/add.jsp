<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>用户管理</title>
<meta name="keywords" content=" ">
<meta name="description" content="">
<link rel="shortcut icon" href="favicon.ico">
<link
	href="${pageContext.request.contextPath}/static/css/bootstrap.min14ed.css?v=3.3.6"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/static/css/font-awesome.min93e3.css?v=4.4.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/static/css/plugins/bootstrap-table/bootstrap-table.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/static/css/animate.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/static/css/style.min862f.css?v=4.1.0"
	rel="stylesheet">
</head>
<body class="fixed-sidebar full-height-layout gray-bg">
	<div class="wrapper">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title navy-bg">
						<h5>
							 新增管理员
						</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a>
						</div>
					</div>
					<div class="ibox-content">
					<form role="form">
						<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label class="col-sm-3 control-label">账号</label>
										<div class="col-sm-9">
											<input type="text" name="" class="form-control"
												placeholder="请输入姓名">
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="col-sm-3 control-label">密码</label>
										<div class="col-sm-9">
											<input type="password" class="form-control" name="password"
												placeholder="请输入密码">
										</div>
									</div>
								</div>
								
								<div class="col-md-4">
									<div class="form-group">
										<label class="col-sm-3 control-label" for="-NaN">状态</label>
										<div class="col-sm-9">
											<label class="radio-inline" for="-NaN"> <input
												type="radio" checked="" value="option1" id="-NaN"
												name="optionsRadios">锁定
											</label> <label class="radio-inline" for="-NaN"> <input
												type="radio" value="option2" id="-NaN" name="optionsRadios">启用
											</label>
										</div>
									</div>
								</div>
								</div>
								<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label class="col-sm-3 control-label">联系电话</label>
										<div class="col-sm-9">
											<input type="text" name="" class="form-control"
												placeholder="请输入联系电话">
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="col-sm-3 control-label">姓名</label>
										<div class="col-sm-9">
											<input type="text" name="" class="form-control"
												placeholder="请输入年龄">
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="col-sm-3 control-label">性别</label>
										<div class="col-sm-9">
											<label class="radio-inline"> <input type="radio"
												checked="" value="option1" id="optionsRadios1"
												name="optionsRadios">男
											</label> <label class="radio-inline"> <input type="radio"
												value="option2" id="optionsRadios2" name="optionsRadios">女
											</label>
										</div>
									</div>
								</div>
								</div>
								<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label class="col-sm-3 control-label">组织机构</label>
										<div class="col-sm-9">
											<select class="form-control" name=""></select>
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="col-sm-3 control-label">角色</label>
										<div class="col-sm-9">
											<select class="form-control" name=""></select>
										</div>
									</div>
								</div>
								<!-- <button class="btn btn-primary" type="submit">查询</button> -->
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<!-- End Panel Other -->
	</div>
	<script
		src="${pageContext.request.contextPath}/static/js/jquery.min.js?v=2.1.4"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/bootstrap.min.js?v=3.3.6"></script>
	<%-- <script
		src="${pageContext.request.contextPath}/static/js/content.min.js?v=1.0.0"></script> --%>
	<script
		src="${pageContext.request.contextPath}/static/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/ajax.js"></script>
	<%-- <script
		src="${pageContext.request.contextPath}/static/js/demo/bootstrap-table-demo.min.js"></script> --%>
	<script type="text/javascript"
		src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>
</html>