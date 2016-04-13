<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="overflow:hidden;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理系统</title>
</head>
<%@include file="./include/global.jsp" %>
<link href="${pageContext.request.contextPath}/js/sdmenu/sdmenu.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/sdmenu/sdmenu.js"></script>
<script type="text/javascript">
		var myMenu;
		window.onload = function() {
			myMenu = new SDMenu("main_menu");
			myMenu.speed = 20; // Menu expand speed
			myMenu.remember = true; // Record Menu Status 
			myMenu.markCurrent = true; // Highlight the Menu 
			myMenu.init(); 
			if(myMenu.submenus[0]){
				myMenu.expandMenu(myMenu.submenus[0]); 
			}
		};
	
	function clickLink(url){
		var hf = "${pageContext.request.contextPath}"+"/"+url;
		$("#iframe").attr("src",hf);
	}
	
	$(function(){
		var winH = $(window).height();
		$("#content").height(winH - 80 - 30 - 5);
		$("#iframe").height(winH - 80 - 30 - 5 - 51);
	});
	
</script>
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
				<li><a href="${pageContext.request.contextPath }/login/logOut">退出</a></li>
			</ul>
		</div>
	</div>
	<div id="content">
		<div class="left_menu">
				 <c:if test="${not empty items}">
					<div style="float: left; OVERFLOW-Y: auto; height:auto;width: 100%;" id="main_menu" class="sdmenu">
						<c:forEach var="item" items="${items}" varStatus="status">
							<div class="collapsed">
								<span>${item.funcName }</span>
								<c:if test="${not empty groups}">
									<c:forEach var="group" items="${groups }">
										<c:if test="${item.id eq group.funcId }">
											<a href='javascript:clickLink("${group.groupUrl}")'>${group.groupName }</a> 
										</c:if>
									</c:forEach>
								</c:if>
							</div>
						</c:forEach>
					</div>
			</c:if>
		</div>
		<div class="m-right">
			<div class="right-nav">
				<ul>
					<li style="margin-left: 25px;">您当前的位置：</li>
					<li><a href="#">系统公告</a></li>
					<li>></li>
					<li><a href="#">最新公告</a></li>
				</ul>
				<div id="tips">
					<span style="vertical-align: middle;"></span>
				</div>
			</div>
			<div class="main">
				<iframe id="iframe" src="${pageContext.request.contextPath}/welcome.jsp" width="100%" height="100%" frameborder=0 scrolling=auto>
				</iframe>
			</div>
		</div>
	</div>
	<div id="footer">
		<p>
			Copyright© 2015 版权所有 京ICP备001号
		</p>
	</div>
</body>
</html>
