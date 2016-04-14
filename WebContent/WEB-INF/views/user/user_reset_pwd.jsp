<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<%@include file="../include/global.jsp" %>
</head>
<body>
	<form id="form1" action="">
		<div style="margin-top: 5%;">
			<div class="input-box">
				<label for="userName" class="label">用户名：</label>
				<input type="text" name="userName" class="input" id="userName" readonly="readonly"/>
				<span class="error-text" id="error"></span>
			</div>
			<div class="input-box">
					<label for="password" class="label">新密码：</label>
					<input type="text" name="password" class="input"/>
					<span class="error-text" id="error"></span>
			</div>
			<div class="input-box">
					<label for="confirm_password" class="label">确认密码：</label>
					<input type="text" name="confirm_password" class="input"/>
					<span class="error-text" id="error"></span>
			</div>
			<div class="input-box">
				<label class="label"></label>
				<button type="button" class="btn" onclick="click_submit();">确定</button>
				<button type="button" class="btn" onclick="closeDialog();">取消</button>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	jQuery.validator.addMethod("mobileValidate",function(value,element){
		var regex= /^1[3|4|5|8][0-9]\d{8}$/; 
		 return regex.test(value) || this.optional(element); 
		},"手机号不合法");

	$(function(){
		$("#form1").validate({
			rules:{
				"userName":{required:true},
				"realName":{required:true,maxlength:5},
				"telephone":{required:true,mobileValidate:true}
			},
			messages:{
				"userName":{required:"不能为空!"},
				"realName":{required:"不能为空!",maxlength:"3个字以内!"},
				"telephone":{required:"不能为空!"}				
			},
			errorPlacement:function(error,element){
				error.appendTo(element.parent().children("#error"))
			},
			submitHandler:function(form){
				CommonAjaxJson(
						'${pageContext.request.contextPath}/user/addUserInfo',
						 $("#form1").serialize(), 
						 function(data){
							window.parent.frames[0].messageTip(data);
							window.parent.frames[0].loadGrid();
							closeDialog();
				});
			}
		});
	});
	
  function click_submit(){
	  
		$("#form1").submit();
	}
</script>
</html>