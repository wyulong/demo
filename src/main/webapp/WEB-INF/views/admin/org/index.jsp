<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理-主页</title>
<link rel="shortcut icon" href="favicon.ico">
<link
	href="${pageContext.request.contextPath}/static/css/bootstrap.min14ed.css?v=3.3.6"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/static/css/font-awesome.min93e3.css?v=4.4.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/static/css/animate.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/static/css/style.min862f.css?v=4.1.0"
	rel="stylesheet">
	<link href="${pageContext.request.contextPath}/static/css/plugins/jsTree/style.min.css" rel="stylesheet">
</head>

<body class="gray-bg" style="overflow: hidden">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-md-4">
				<div class="ibox float-e-margins">
					<div class="ibox-title navy-bg">
						<h5>组织机构列表</h5>
						<div class="ibox-tools">
							<button class="collapse-link btn btn-xs btn-warning">新增</button>
							<button class="collapse-link btn btn-xs btn-danger">编辑</button>
							<button class="collapse-link btn btn-xs btn-success">删除</button>
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i></a>
						</div>
					</div>
					<div class="ibox-content">
						<div class="wrapper">
						    <div id="jstree1">
                             
                        </div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-8">
				<div class="ibox float-e-margins">
					<div class="ibox-title navy-bg">
						<h5>组织机构管理</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a>
						</div>
					</div>
					<div class="ibox-content">
						<div class="example-wrap">
							<div class="example">
								<div class="btn-group hidden-xs" id="toolbar" role="group">
						<button type="button" class="btn btn-outline btn-default">
							<i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
						</button>
						<button type="button" class="btn btn-outline btn-default">
							<i class="glyphicon glyphicon-heart" aria-hidden="true"></i>
						</button>
						<button type="button" class="btn btn-outline btn-default">
							<i class="glyphicon glyphicon-trash" aria-hidden="true"></i>
						</button>
					</div>
								 <table id="listTable" data-click-to-select="true" />
								</table>
							</div>
						</div>
					</div>
				</div>
			
			</div>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/static/js/jquery.min.js?v=2.1.4"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/bootstrap.min.js?v=3.3.6"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/plugins/layer/layer.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/hplus.min.js?v=4.1.0"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/contabs.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/plugins/pace/pace.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/plugins/jsTree/jstree.min.js"></script>
		
		<script type="text/javascript">
		
		var ay_mssys = 
		    [
		        {
			        "id": "1",
			        "text": "民事案由(2008版)",
			        "state": {
					            "opened": true,          //展示第一个层级下面的node
					            "disabled": true         //该根节点不可点击
			       			 },
			        "children": 
			        			[
						        	{
						            "id": "2",
						            "text": "人格权纠纷",
						            "children": 
						            			[
									            	{
										                "id": "3",
										                "text": "人格权纠纷",
										                "children": [
										                	{
											                    "id": "4",
											                    "text": "生命权、健康权、身体权纠纷",
											                    "children": 
											                    			[
											                    				{
															                        "id": "5",
															                        "text": "道路交通事故人身损害赔偿纠纷"
														                   		 },
														                   		{
																                        "id": "15",
																                        "text": "道路交通赔偿纠纷"
															                   		 }
														                   	]
														    }
														 ]
													}
												]
									},
									{
							            "id": "7",
							            "text": "人格权纠纷",
							            "children": 
							            			[
										            	{
											                "id": "8",
											                "text": "人格权纠纷",
											                "children": [
											                	{
												                    "id": "9",
												                    "text": "生命权、健康权、身体权纠纷",
												                    "children": 
												                    			[
												                    				{
																                        "id": "10",
																                        "text": "道路交通事故人身损害赔偿纠纷"
															                   		 }
															                   	]
															    }
															 ]
														}
													]
										}
								]
					}
			];
		
		$(function(){
			$("#jstree1").jstree({
	            'core' : {
	                "multiple" : false,
	                "checkbox" : {
	                    "keep_selected_style" : false
	                  },
	                'data' : ay_mssys,
	                'dblclick_toggle': false          //禁用tree的双击展开
	            },
	            "plugins" : ["checkbox"] 
			});
	//core：整个jstree显示的核心，里面包括多种项配置：
	//data： 这里是使用json格式的数据；还可以使用html或者ajax请求等
	//plugins： 这个jstree引用了哪些插件
	//multiple : false  不可多选
			
		});
		</script>
</body>
</html>