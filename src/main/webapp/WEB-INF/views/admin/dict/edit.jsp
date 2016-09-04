<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>新增字典</title>
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
	<link href="${pageContext.request.contextPath}/static/css/plugins/toastr/toastr.min.css" rel="stylesheet">
</head>
<body class="fixed-sidebar full-height-layout gray-bg">
	<div class="wrapper">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title navy-bg">
						<h5>
							编辑字典
						</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a>
						</div>
					</div>
					<div class="ibox-content">
						 <form class="form-horizontal m-t" id="commentForm" method="post">
						 	<input type="hidden" name="id" value="${dict.id}" />
                            <div class="form-group">
                                <label class="col-sm-3 control-label">上级字典：</label>
                                 <div class="col-sm-8">
                                 <select class="form-control m-b" name="parentId">
                                 	<c:if test="${empty parentId}">
									   <option value="0">--无--</option>
									</c:if>
                                 	<c:forEach items="${list}" var="item" varStatus="status">  
									     <option value="${item.id}">${item.name}</option>
									</c:forEach>  
                                  </select>
                                  </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">中文名称：</label>
                                <div class="col-sm-8">
                                    <input id="name" type="text" class="form-control" name="name" value="${dict.name}" required="true" aria-required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">英文名称：</label>
                                <div class="col-sm-8">
                                    <input id="nameEn" type="text" class="form-control" name="nameEn" value="${dict.nameEn}" required="true" aria-required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">字典编码：</label>
                                <div class="col-sm-8">
                                    <input id="bianma" type="text" class="form-control" name="bianma" value="${dict.bianma}" required="true" aria-required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">排序：</label>
                                <div class="col-sm-8">
                                    <input id="orderBy" type="text" value="0" class="form-control" name="orderBy" value="${dict.orderBy}"  required="true" aria-required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button type="button" id="submit" class="btn btn-w-m btn-primary"><i class="fa fa fa-check"></i>保存</button>
                                    <button class="btn btn-w-m btn-danger" id="cancel" type="button"><i class="fa fa-times"></i>取消
                    </button>
                                </div>
                            </div>
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
	<script
		src="${pageContext.request.contextPath}/static/js/ajax.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/ajax.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/plugins/toastr/toastr.min.js"></script>
	<%-- <script
		src="${pageContext.request.contextPath}/static/js/demo/bootstrap-table-demo.min.js"></script> --%>
	<script type="text/javascript"
		src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
	<script type="text/javascript">
		var successfn = function success(e){
			if(e.flag){
			    toastr.success(e.msg, "");
				document.reload();
			}else{
				toastr.error(e.msg, "");
			}
		}
		var errorfn = function errorfn(e){
			alert(e.data);
		}
		$(function(){
			$('#submit').click(function(e){
				//$("#commentForm").submit();
				var data = $("#commentForm").serialize();
				$.ax("${pageContext.request.contextPath}/admin/dict/edit", data, true, "POST", "json", successfn, errorfn);
			});
			$('#cancel').click(function(){
				window.location.href="${pageContext.request.contextPath}/admin/dict/index";
				return;
			});
		});
	</script>
</body>
</html>