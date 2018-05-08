<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	pageContext.setAttribute("basePath", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页</title>
<!-- 引入jqury -->
<script type="text/javascript"
	src="${basePath }/static/js/jquery-3.2.1.min.js"></script>

<!-- 引入bootstrap -->
<link
	href="${basePath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${basePath}/static/css/signin.css" rel="stylesheet">
<link href="${basePath}/static/css/reset.css" rel="stylesheet">
<script src="${basePath}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

<style type="text/css">
body {
	background: url(./static/img/bgpic2.jpg);
	background-size: 100%;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<div class="signin-container">
		<div class="title">
			<div>
				<img alt="title" src="./static/img/title.png"
					style="width: 100%; height: auto;">
			</div>
		</div>
		<div class="mid">
			<div class="left">
				<img alt="left" src="./static/img/left.jpg"
					style="width: 100%; height: 100%;" />
			</div>
			<div class="right">
				<div class="logintitle">
					<h3>登录/Login</h3>
				</div>
				<div class="form">
					<form name="loginform" id="loginform" method="post" action=""
						onsubmit="check()">
						<div style="margin-top: 25px;">
							<input name="username" id="username" type="text"
								placeholder="用户名" />
						</div>
						<div style="margin-top: 20px;">
							<input name="password" id="password" type="password"
								placeholder="密码" value="" />
						</div>
						<div style="margin-top: 20px;">
							<!-- class="signin-vali" -->
							<input type="text" name="checkcode" value="" placeholder="验证码"
								id="code" /> <img id="imagecode" alt="验证码"
								src="<%=request.getContextPath()%>/servlet/ImageServlet" /> <a
								href="javascript:reloadCode();"><font color="red">看不清</font></a><br>
							<br>
						</div>
						<div style="margin-top: 20px;">
							<input type="radio" name="act" class="actItem" value="stu"
								checked="checked" />学生 <input type="radio" name="act"
								class="actItem" value="teacher" />教师 <input type="radio"
								name="act" class="actItem" value="admin" />管理员
						</div>
						<div class="log">
							<input type="submit" value="登录" id="login_btn"
								class="button default login-btn" />

						</div>
						<div class="res">
							<input type="button" value="重置" id="reset_btn"
								class="button default reset-btn" onclick="reset()" />
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="footer">
			<div class="contain">
				<span>&nbsp;</span><br /> <span>&nbsp;</span><br /> <span>&nbsp;</span><br />
				<span><font size="4" color="blue">帮助指南：</font></span><br /> <span><font
					size="4" color="blue">1、遗忘密码，请带上证件去本人所在二级学院办公室，请教学秘书老师修改。</font></span><br />
				<span><font size="4" color="blue">2、默认用户名为s+学号，初始密码为登录名。</font></span><br />
			</div>
		</div>
	</div>
	<script src="${basePath}/static/js/index.js"></script>
	<script type="text/javascript">
		// 验证码能变换
		function reloadCode() {
			var time = new Date().getTime();
			document.getElementById("imagecode").src = "${basePath}/servlet/ImageServlet?d="
					+ time; // 让看不清能通过时间的不同起作用
		}
	</script>
</body>
</html>