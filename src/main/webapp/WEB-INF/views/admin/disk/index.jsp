<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理-磁盘文件管理</title>
<link rel="shortcut icon" href="favicon.ico">
<link href="${pageContext.request.contextPath}/static/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/css/animate.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/css/style.min862f.css?v=4.1.0" rel="stylesheet">
 <link href="${pageContext.request.contextPath}/static/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
         
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>文件列表</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>    
                        </div>
                    </div>
                    <div class="ibox-content">
                    	 <div class="row">
                            <div class="col-sm-4 m-b-xs">
                                	当前目录：${result.currentDir} 文件：${result.totalFiles} 目录：${result.totalFolders}
									<a type="button" href="index?parent=${parent}" class="btn btn-sm btn-primary"> 返回上级目录 </a>  
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th>名称</th>
                                        <th>所在目录</th>
                                        <th>修改时间</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="stu" items="${result.files}">
	                                    <tr>
	                                        <td>
	                                            <input type="checkbox" checked class="i-checks" name="input[]">
	                                        </td>
	                                        <c:if test="${stu.file==false}">
	                                        	<td><a href="index?parent=${stu.fileFullPath}">${stu.fileName}</a></td>
	                                        </c:if>
	                                        <c:if test="${stu.file==true}">
	                                        	<td>${stu.fileName}</td>
	                                        </c:if>
	                                        <td><span class="pie">${stu.fileFullPath}</span>
	                                        </td>
	                                        <td>${stu.modifiedDate}</td>
	                                        <td>
	                                        	<button class="btn btn-sm btn-danger" onclick='del(encodeURI("${stu.fileFullPath}"))'><i class="glyphicon glyphicon-remove text-default"></i>删除</button>
	                                        </td>
	                                    </tr>
                                   </c:forEach>  
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
            </div>

        </div>
    </div>
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js?v=3.3.6"></script>
     <script src="${pageContext.request.contextPath}/static/js/plugins/sweetalert/sweetalert.min.js"></script>
    <script type="text/javascript">
    
    function del(file){
		swal({
	        title: "您确定要删除此文件吗？",
	        text: "删除后将无法恢复，请谨慎操作！",
	        type: "warning",
	        showCancelButton: true,
	        confirmButtonColor: "#DD6B55",
	        confirmButtonText: "删除",
	        closeOnConfirm: false
	    }, function () {
	    	//$.axs('${pageContext.request.contextPath}/admin/dict/del?id='+id, '', successfn);
	    	alert("暂时不开放删除功能");
	    });
	}
    
    function successfn(e){
		if(e.code==0){
			swal("删除成功！", e.data, "success");
		}else{
			swal("删除失败！", e.data, "fail");
		}
		window.location.reload();
	}
    
    </script>
</body>
</html>