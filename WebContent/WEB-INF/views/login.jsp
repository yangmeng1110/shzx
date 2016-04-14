<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>登录</title>
<link href="${pageContext.request.contextPath}/css/login2.css" rel="stylesheet" type="text/css" />
<style>body{height:100%;overflow:hidden;}</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
</head>
<body>
	<h1>
		简洁大气快速登录模板<sup>TM</sup>
	</h1>
	<div class="login" style="margin-top: 50px;">
		<div class="web_qr_login" id="web_qr_login" style="display: block; height: 250px;">
			<div class="web_login" id="web_login">
				<div class="login-box">
					<div class="login_form">
						<form id="login_form"  class="loginForm">
							<!-- token 防止表单重复提交 -->
<%-- 							<input type="hidden" name="token" value="${token }"/> --%>
							<div class="uinArea" id="uinArea">
								<label class="input-tips" for="u">帐号：</label>
								<div class="inputOuter" id="uArea">
									<input type="text" id="un" name="userName" class="inputstyle" />
								</div>
							</div>
							<div class="pwdArea" id="pwdArea">
								<label class="input-tips" for="p">密码：</label>
								<div class="inputOuter" id="pArea">
									<input type="password" id="pwd" name="password" class="inputstyle" />
								</div>
							</div>
							<div style="padding-left: 50px; margin-top: 20px;">
							</div>
							<div style="padding-left: 50px; margin-top: 10px;">
								<input type="button" value="登 录" style="width: 150px;"class="button_blue" onclick="ajaxSubmit();"/>
								<div style="margin-left: 2px;text-align: center;padding-top: 10px;">
									<span id="msg" style="color:red;font-size: 12px;"></span>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="jianyi">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>
<script type="text/javascript">
$(document).ready(function() {
	
	$("#un").focus(function(){
		$("#msg").text("");
	}).blur(function(){
		var userName = $("#un").val();
		if(userName == null || userName.trim().length == 0){
			$("#msg").text("*用户名不能为空");
		}
	});
	$("#pwd").focus(function(){
		$("#msg").text("");
	}).blur(function(){
		var userName = $("#pwd").val();
		if(userName == null || userName.trim().length == 0){
			$("#msg").text("*密码不能为空");
		}
	});
});

function ajaxSubmit(){
		  var userName = $.trim($("#un").val());
			var password = $.trim($("#pwd").val());
			if(userName==""||userName==null){
				$("#msg").html("*请输入用户名");
				return; 
			}
			if(password==""||password==null){
				$("#msg").text("*请输入密码");
				return; 
			}
			
			$.ajax({
		        type: "POST",
		        url: "${pageContext.request.contextPath}/login/doLogin",
		        data: $("#login_form").serialize(),
		        dataType: "json",
		        success: function(data){
		        	if(data==0){
		        		$("#msg").text("*用户名或则密码错误");
		        	}else{
		        		window.location.href="${pageContext.request.contextPath}/func/funcMain";
		        	}           
		        }
		     });
}
 
/*  $(document).keydown(function(event){
	 if(event.keyCode = 13){
		 ajaxSubmit();
	 }
 }); */

</script>
</body>
</html>