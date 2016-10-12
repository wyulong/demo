<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>权限管理</title>
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
						<h5>新增权限</h5>
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
										<label class="col-sm-4 control-label">父权限：</label>
										<div class="col-sm-8">
											<select class="form-control" name="">
												<option>菜单</option>
												<option>按钮</option>
												<option>其他</option>
											</select> <span class="help-block m-b-none"></span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 control-label">权限名称：</label>
										<div class="col-sm-8">
											<input type="text" name="" class="form-control"
												placeholder="请输入权限名称"> <span
												class="help-block m-b-none"></span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 control-label">类型：</label>
										<div class="col-sm-8">
											<select class="form-control" name="">
												<option>菜单</option>
												<option>按钮</option>
												<option>其他</option>
											</select> <span class="help-block m-b-none"></span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 control-label">权限编码：</label>
										<div class="col-sm-8">
											<input type="text" name="" class="form-control"
												placeholder="请输入权限编码"> <span
												class="help-block m-b-none"></span>

										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="col-sm-4 control-label">排序：</label>
										<div class="col-sm-8">
											<input type="text" name="" class="form-control"
												placeholder="请输入排序"> <span
												class="help-block m-b-none"></span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 control-label">状态：</label>
										<div class="col-sm-8">
											<select class="form-control" name="">
												<option>有效</option>
												<option>无效</option>
											</select> <span class="help-block m-b-none"></span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 control-label">描述：</label>
										<div class="col-sm-8">
											 <textarea class="form-control" rows="3"></textarea><span
												class="help-block m-b-none"></span>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
								<div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button type="button" id="submit" class="btn btn-w-m btn-primary"><i class="fa fa fa-check"></i>保存</button>
                                    <button class="btn btn-w-m btn-danger" id="cancel" type="button"><i class="fa fa-times"></i>取消
                    </button>
                                </div>
                            </div>
                            </div>
							</div>
						</form>
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