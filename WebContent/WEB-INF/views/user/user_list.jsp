<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>list</title>
<%@include file="../include/global.jsp" %>
<script type="text/javascript">
</script>
</head>
<body>
	<div class="input-box">
				<label for="userName" class="label">用户名：</label>
				<input type="text" name="userName" class="search" id="userName"/>
				<label for="userName" class="label">姓名：</label>
				<input type="text" name="userName" class="search" id="realName"/>
				<label class="label"></label>
				<button type="button" class="btn1" onclick="click_search();">搜索</button>
	</div>
	<div id="div1" style="background:#fff; height:100%; width:100%; padding-bottom: 20px;">
		<div class="data_Form" id="data"></div>
	</div>
	<div id="dlg" style="display: none;"><span></span></div>
</body>
<script type="text/javascript">
$(function(){
	loadGrid();
});

function loadGrid(){
	$("#data").datagrid({
		//title:'申请人列表',
		//width:1000,
		url:'${pageContext.request.contextPath }/user/queryUserList',
		loadMsg:'数据正在加载，请稍候......',
		striped: true, //隔行变色 
        nowrap: true, //false:折行  
        iconCls:'icon-search', 
        fitColumns:true,//自适应表格宽度
        singleSelect:true,//只会选取一行
        rownumbers:true,//显示行号
        pageList:[15,30,40],
        pageSize:15,
        pageNumber:1,
        columns:[[
        	{title:'用户名',field:'userName',align:'center',width:50},
            {title:'手机号',field:'telephone',align:'center',width:50},
            {title:'姓名',field:'realName',align:'center',width:50}
        ]],
		 pagination: true,//显示分页,
         //工具栏
         toolbar:[
              {text:'增加',iconCls:'icon-add',handler:function(){click_add();}},
              {text:'删除',iconCls:'icon-remove',handler:function(){click_delete();}},    
              {text:'修改',iconCls:'icon-edit',handler:function(){click_update();}}   
              ]   
	});
}

function click_delete(){
	var rows = $("#data").datagrid('getSelections');
	if(rows != null && rows != ''){
		var id = rows[0].id;
		$.messager.confirm('删除用户','确定要删除用户？',function(r){
			if(r){
			CommonAjaxJson(
					'${pageContext.request.contextPath}/user/deleteUserInfo',
					'id='+id, 
					function(data){
						messageTip(data);
						loadGrid();
					});
			}
		});
	}
	return;
}

function click_update(){
	var rows = $("#data").datagrid('getSelections');
	if(rows != null && rows != ''){
		var userName = rows[0].userName;
		Dialog.open({
			Title:'用户修改',
			URL:'${pageContext.request.contextPath}/user/toUpdateUserInfo?userName='+userName,
			Drag:false,
			Height:200,
			Width:400
		});
	}
	return; 
}

function click_add(){
	Dialog.open({
		Title:'新增用户',
		URL:'${pageContext.request.contextPath}/user/toAddUserInfo',
		Drag:false,
		Height:200,
		Width:400
	});
}

function click_search(){
	var queryParams = $("#data").datagrid('options').queryParams;
	queryParams.userName = $("#userName").val();
	queryParams.realName = $("#realName").val();
	$("#data").datagrid('options').queryParams = queryParams; 
	loadGrid();
}

</script>