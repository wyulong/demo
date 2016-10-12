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
	href="${pageContext.request.contextPath}/static/css/plugins/ztree/metroStyle/metroStyle.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/static/css/plugins/bootstrap-table/bootstrap-table.min.css"
	rel="stylesheet">
</head>

<body class="gray-bg" style="overflow: hidden">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-md-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title navy-bg">
						<h5>组织机构列表</h5>
						<div class="ibox-tools">
							<!-- <button class="collapse-link btn btn-xs btn-warning" id="add">新增</button>
							<button class="collapse-link btn btn-xs btn-danger" id="edit">编辑</button>
							<button class="collapse-link btn btn-xs btn-success" id="delete">删除</button> -->
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i></a>
						</div>
					</div>
					<div class="ibox-content">
						<div class="wrapper">
							 <ul id="jstree1" class="ztree"></ul>
						</div>
					</div>
				</div>
			</div>
			<!-- <div class="col-md-6">
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

			</div> -->
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
		src="${pageContext.request.contextPath}/static/js/plugins/ztree/jquery.ztree.all.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>

	<script type="text/javascript">
		var setting = {
			async: {
				enable: true,
				url:"${pageContext.request.contextPath}/admin/org/tree.json",
				autoParam:["id", "name=n", "level=lv"],
				otherParam:{"otherParam":"zTreeAsyncTest"},
				dataFilter: filter
			},
			view: {expandSpeed:"",
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom,
				selectedMulti: false
			},
			edit: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeRemove: beforeRemove,
				beforeRename: beforeRename
			}
		};

		function filter(treeId, parentNode, childNodes) {
			if (!childNodes) return null;
			for (var i=0, l=childNodes.length; i<l; i++) {
				childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
			}
			return childNodes;
		}
		function beforeRemove(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("jstree1");
			zTree.selectNode(treeNode);
			return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
		}		
		function beforeRename(treeId, treeNode, newName) {
			if (newName.length == 0) {
				setTimeout(function() {
					var zTree = $.fn.zTree.getZTreeObj("jstree1");
					zTree.cancelEditName();
					alert("节点名称不能为空.");
				}, 0);
				return false;
			}
			return true;
		}

		var newCount = 1;
		function addHoverDom(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
			var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
				+ "' title='add node' onfocus='this.blur();'></span>";
			sObj.after(addStr);
			var btn = $("#addBtn_"+treeNode.tId);
			if (btn) btn.bind("click", function(){
				var zTree = $.fn.zTree.getZTreeObj("jstree1");
				zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
				return false;
			});
		};
		function removeHoverDom(treeId, treeNode) {
			$("#addBtn_"+treeNode.tId).unbind().remove();
		};

		$(document).ready(function(){
			$.fn.zTree.init($("#jstree1"), setting);
			//$("#add").bind("click", add);
			//$("#edit").bind("click", remove);
		});
		
		function add(e) {
			var zTree = $.fn.zTree.getZTreeObj("jstree1");
			var isParent = e.data.isParent;
			var nodes = zTree.getSelectedNodes();
			alert(e.data);
			treeNode = nodes[0];
			addHoverDom("jstree1", treeNode);
		};
	</script>
</body>
</html>