<!DOCTYPE>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理系统</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/menu.js"></script>
</head>
<body>
	<div class="top"></div>
	<div id="header">
		<div class="logo">***后台管理系统</div>
		<div class="navigation">
			<ul>
				<li>欢迎您！</li>
				<li><a href="">${user.realName }</a></li>
				<li><a href="">修改密码</a></li>
				<li><a href="">设置</a></li>
				<li><a href="">退出</a></li>
			</ul>
		</div>
	</div>
	<div id="content">
		<div class="left_menu">
			<ul id="nav_dot">
			 <c:forEach var="item" items="${items }">
					<li>
						<h4 class="M1">
							<span></span>
							${item.funcName }
						</h4>
						<c:forEach var="group" items="${groups }">
							<c:if test="${item.id eq group.funcId }">
								<div class="list-item none">
									<a href='javascript:clickLink("${group.groupUrl}")'>${group.groupName }</a> 
								</div>
							</c:if>
						</c:forEach>
					</li>
				 </c:forEach>
			</ul>
		</div>
		<div class="m-right">
			<div class="right-nav">
				<ul>
					<li><img src="${pageContext.request.contextPath}/images/home.png"></li>
					<li style="margin-left: 25px;">您当前的位置：</li>
					<li><a href="#">系统公告</a></li>
					<li>></li>
					<li><a href="#">最新公告</a></li>
				</ul>
			</div>
			<div class="main">
				<iframe id="iframe" src="${pageContext.request.contextPath}/welcome.jsp" width="100%" height="98%" frameborder=0 border=0 scrolling=auto>
				</iframe>
			</div>
		</div>
	</div>
	<div class="bottom"></div>
	<div id="footer">
		<p>
			Copyright© 2015 版权所有 京ICP备001号
		</p>
	</div>
	<script>
		navList(12);
	</script>
</body>
<script type="text/javascript">
	function clickLink(url){
		var hf = "${pageContext.request.contextPath}"+"/"+url;
		$("#iframe").attr("src",hf);
	}
</script>
</html>
