<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
    <meta name="keywords" content="cc-Framework---------------powered by wuche">
    <meta name="description" content="cc-Framework---------------powered by wuche">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/plugins/iCheck/custom.css" rel="stylesheet">	
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>
<body class="gray-bg">
<shiro:authenticated>
<%
String base = request.getContextPath();
response.sendRedirect(base + "/admin/index");
%>
</shiro:authenticated>
    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">钓</h1>

            </div>
            <h3>钓鱼比赛管理系统</h3>
	
            <form class="m-t" role="form" id="loginForm" action="${pageContext.request.contextPath}/admin/login" method="post">
            <input type="hidden" name="captchaId" value="${captchaId}" />
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="用户名" name="username" required="true">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="密码" name="password" required="true">
                </div>
                <div class="form-group">
                	<div class="row">
                		<div class="col-md-12">
                			<div class="row">
                				<div class="col-md-8">
                					<input type="text" placeholder="验证码" class="form-control" id="captcha" name="captcha"  required="true" />
                				</div>
                				<div class="col-md-4">
                					<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/admin/common/captcha?captchaId=${captchaId}" title="title" />
                				</div>
                			</div>
                		</div>
                	</div>
				</div>
				<div class="rorm-group"> 
					<div class="row">
						<div class="col-md-4">
							<div class="checkbox i-checks">
	                             <input type="checkbox" id="rememberMe" value="true" name="rememberMe">记住我
	                    	</div>
	                    </div>
					</div>
				</div>
                <p style="color:red">${msg}</p>
                <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
               <!--  <p class="text-muted text-center"> <a href="login.html#"><small>忘记密码了？</small></a> | <a href="register.html">注册一个新账号</a>
                </p> -->

            </form>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js?v=3.3.6"></script>
   	<script src="${pageContext.request.contextPath}/static/js/plugins/iCheck/icheck.min.js"></script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    
    
     <script type="text/javascript">
        $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
        
        $('#captchaImage').click(function(){
        	$('#captchaImage').attr("src", "${pageContext.request.contextPath}/admin/common/captcha?captchaId=${captchaId}&timestamp=" + (new Date()).valueOf());
        });
        
        $('#loginForm').submit(function(){
        	var rsaKey = new RSAKey();
			rsaKey.setPublic(b64tohex("${modulus}"), b64tohex("${exponent}"));
			var enPassword = hex2b64(rsaKey.encrypt($('#password').val()));
			$('#password').val(enPassword);
			$('#loginForm').submit();
        });
     </script>
</body>
</html>