<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户</title>
<%@include file="../include/global.jsp" %>
</head>
<body>
	<form id="from" action="">
		<div style="margin-top: 5%;">
			<input type="hidden" name="id" value="${resultObject.id }"/>
			<div class="input-box">
				<label for="userName" class="label">用户名：</label>
				<input type="text" readonly="readonly" name="userName" class="input" value="${resultObject.userName }" />
				<span class="error-text"></span>
			</div>
			<div class="input-box">
					<label for="realName" class="label">姓名：</label>
					<input type="text" name="realName" class="input" value="${resultObject.realName }"/>
					<span class="error-text"></span>
			</div>
			<div class="input-box">
					<label for="telephone" class="label">手机号：</label>
					<input type="text" name="telephone" class="input"  value="${resultObject.telephone }"/>
					<span class="error-text"></span>
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
	function click_submit(){
		CommonAjaxJson(
				'${pageContext.request.contextPath}/user/updateUserInfo',
				 $("#from").serialize(), 
				 function(data){
					window.parent.frames[0].messageTip(data);
					window.parent.frames[0].loadGrid();
					closeDialog();
					
		});
	}
	
</script>
</html>