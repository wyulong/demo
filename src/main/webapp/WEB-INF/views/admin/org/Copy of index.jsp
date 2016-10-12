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
<link
	href="${pageContext.request.contextPath}/static/css/plugins/jsTree/style.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/static/css/plugins/bootstrap-table/bootstrap-table.min.css"
	rel="stylesheet">
</head>

<body class="gray-bg" style="overflow: hidden">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-md-6">
				<div class="ibox float-e-margins">
					<div class="ibox-title navy-bg">
						<h5>组织机构列表</h5>
						<div class="ibox-tools">
							<button class="collapse-link btn btn-xs btn-warning" id="add">新增</button>
							<button class="collapse-link btn btn-xs btn-danger" id="edit">编辑</button>
							<button class="collapse-link btn btn-xs btn-success" id="delete">删除</button>
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i></a>
						</div>
					</div>
					<div class="ibox-content">
						<div class="wrapper">
							<div id="jstree1"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="ibox float-e-margins">
					<div class="ibox-title navy-bg">
						<h5>用户管理——目前先放一个表格</h5>
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
	<script
		src="${pageContext.request.contextPath}/static/js/plugins/jsTree/jstree.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>

	<script type="text/javascript">
		$(function(){
			$("#jstree1").jstree({
	            'core' : {
	                "multiple" : false,
	                  'data' : {
	                	    'url' : function (node) {
	                	      return node.id === '#' ?
	                	        '${pageContext.request.contextPath}/admin/org/tree.json':'${pageContext.request.contextPath}/admin/org/tree.json';
	                	    },
	                	    'data' : function (node) {
	                	      return { 'id' : node.id };
	                	    }
	                  },
	                'dblclick_toggle': false          //禁用tree的双击展开
	            },
	            "plugins" : [ "contextmenu", "dnd", "search",
	                          "state", "types", "wholerow"],
                 "types" : {
                	    "#" : {
                	      "max_children" : 1,
                	      "max_depth" : 4,
                	      "valid_children" : ["root"]
                	    },
                	    "root" : {
                	      "icon" : "/static/3.3.2/assets/images/tree_icon.png",
                	      "valid_children" : ["default"]
                	    },
                	    "default" : {
                	      "valid_children" : ["default","file"]
                	    }
                	   // "file" : 
                	  }
			});
	//core：整个jstree显示的核心，里面包括多种项配置：
	//data： 这里是使用json格式的数据；还可以使用html或者ajax请求等
	//plugins： 这个jstree引用了哪些插件
	//multiple : false  不可多选
	
			//1.初始化Table
			var oTable = new TableInit();
			oTable.Init();

			//2.初始化Button的点击事件
			var oButtonInit = new ButtonInit();
			oButtonInit.Init();
			
			$('#add').click(function(){
				demo_create();
			});
			
			$('#edit').click(function(){
				demo_rename();
			});
			
			$('#delete').click(function(){
				demo_delete();
			});
		});
		
		
		
		function demo_create() {
			var ref = $('#jstree1').jstree(true),
				sel = ref.get_selected();
			if(!sel.length) { return false; }
			sel = sel[0];
			sel = ref.create_node(sel,{"id":111,"status":null,"text":"新增","icon":"glyphicon glyphicon-file","children":[]},'last',function(e){
				alert(e);
			});
			if(sel) {
				ref.edit(sel);
			}
		};
		function demo_rename() {
			var ref = $('#jstree1').jstree(true),
				sel = ref.get_selected();
			if(!sel.length) { return false; }
			sel = sel[0];
			ref.edit(sel);
		};
		function demo_delete() {
			var ref = $('#jstree1').jstree(true),
				sel = ref.get_selected();
			if(!sel.length) { return false; }
			ref.delete_node(sel);
		};

		
		
		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table
			oTableInit.Init = function() {
				$('#listTable')
						.bootstrapTable(
								{
									url : '${pageContext.request.contextPath}/admin/org/list.json?parentId=', //请求后台的URL（*）
									method : 'get', //请求方式（*）
									toolbar : '#toolbar', //工具按钮用哪个容器
									striped : true, //是否显示行间隔色
									cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
									pagination : true, //是否显示分页（*）
									sortable : false, //是否启用排序
									sortOrder : "asc", //排序方式
									queryParams : oTableInit.queryParams,//传递参数（*）
									sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
									pageNumber : 1, //初始化加载第一页，默认第一页
									pageSize : 10, //每页的记录行数（*）
									pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*）
									//search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
									strictSearch : true,
									showColumns : true, //是否显示所有的列
								//	showRefresh : true, //是否显示刷新按钮
									minimumCountColumns : 2, //最少允许的列数
									clickToSelect : true, //是否启用点击选中行
									height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
									uniqueId : "id", //每一行的唯一标识，一般为主键列
									//showToggle : true, //是否显示详细视图和列表视图的切换按钮
									cardView : false, //是否显示详细视图
									detailView : false, //是否显示父子表
								 	responseHandler:responseHandler,
									columns : [{
										checkbox : true
									},{
										field : 'icon',
										title : '图标'
									}, {
										field : 'name',
										title : '名称'
									}, {
										field : 'address',
										title : '地址'
									}]
								});
			};

			//得到查询的参数
			oTableInit.queryParams = function(params) {
				var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					limit : params.limit, //页面大小
					offset : params.offset, //页码
					departmentname : $("#txt_search_departmentname").val(),
					statu : $("#txt_search_statu").val()
				};
				return temp;
			};
			return oTableInit;
		};

		var ButtonInit = function() {
			var oInit = new Object();
			var postdata = {};

			oInit.Init = function() {
				//初始化页面上面的按钮事件
			};

			return oInit;
		};
		
		function responseHandler(data) {
			var pageData = data.rows;
			for (var i = 0; i < pageData.length; i++) {
				pageData[i].icon = "<i class='glyphicon "+pageData[i].icon+"' aria-hidden='true'></i>";
				/* pageData[i].ops = '';
				if(pageData[i].parentId == 0){
					pageData[i].ops+="<a class='btn btn-info btn-sm' href='${pageContext.request.contextPath}/admin/dict/index?parentId="+pageData[i].id+"' id='cancel' type='button'>查看 </a>";
				}
				pageData[i].ops+="<a class='btn btn-warning btn-sm' id='cancel' type='button' href='${pageContext.request.contextPath}/admin/dict/edit?id="+pageData[i].id+"&parentId="+pageData[i].parentId+"' >编辑</a>";
				if(pageData[i].parentId == 0){
					pageData[i].ops+="<a class='btn btn-primary btn-sm' id='cancel' type='button' href='${pageContext.request.contextPath}/admin/dict/add?parentId="+pageData[i].id+"'>新增子项</a>";
				}
				 */
			}
			return {
				"total" : data.total,
				"rows" : pageData
			}
		}
		</script>
</body>
</html>