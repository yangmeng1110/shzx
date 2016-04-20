<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增功能项</title>
<%@include file="../include/global.jsp" %>
</head>
<body>
	<form id="form1" action="">
		<div style="margin-top: 5%;">
			<div class="input-box">
				<label for="funcName" class="label">名称：</label>
				<input type="text" name="funcName" class="input" id="funcName"/>
				<span class="error-text"  id="error"></span>
			</div>
			<div class="input-box">
					<label for="funcSort" class="label">排序号：</label>
					<input type="text" name="funcSort" class="input"/>
					<span class="error-text"  id="error"></span>
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

	$(function(){
		$("#form1").validate({
			rules:{
				"funcName":{required:true,
					remote:{
						url:'${pageContext.request.contextPath}/funcItem/validateFuncName',
						type:'post',
						data:{
							funcName:function(){
								return $("#funcName").val();
							}
						}
					}	
				},
				"funcSort":{required:true,maxlength:2,digits:true},
			},
			messages:{
				"funcName":{required:"不能为空!",remote:'名称重复!'},
				"funcSort":{required:"不能为空!",maxlength:"2个数字以内!",digits:'输入整数!'},
			},
			errorPlacement:function(error,element){
				error.appendTo(element.parent().children("#error"))
			},
			submitHandler:function(form){
				CommonAjaxJson(
						'${pageContext.request.contextPath}/funcItem/addFuncItem',
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