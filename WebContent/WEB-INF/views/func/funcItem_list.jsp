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
		url:'${pageContext.request.contextPath }/funcItem/queryFuncItemList',
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
        	{title:'功能项',field:'funcName',align:'center',width:50},
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
			CommonAjaxJson(
					'${pageContext.request.contextPath}/funcItem/validateFuncGroup',
					'id='+id, 
					function(data){
						if("2" == data){
							$.messager.alert("提示","功能项下有功能组，不能删除!","warning");
							return;
						}
						delete_funcItem(id);
					});
	}
	return;
}

function delete_funcItem(id){
	$.messager.confirm('删除功能项','确定要删除功能项？',function(r){
		if(r){
		CommonAjaxJson(
				'${pageContext.request.contextPath}/funcItem/deleteFuncItem',
				'id='+id, 
				function(data){
					messageTip(data);
					loadGrid();
				});
		}
	});
}


function click_update(){
	var rows = $("#data").datagrid('getSelections');
	if(rows != null && rows != ''){
		var id = rows[0].id;
		Dialog.open({
			Title:'修改功能项',
			URL:'${pageContext.request.contextPath}/funcItem/toUpdateFuncItem?id='+id,
			Drag:false,
			Height:150,
			Width:400
		});
	}
	return; 
}

function click_add(){
	Dialog.open({
		Title:'新增功能项',
		URL:'${pageContext.request.contextPath}/funcItem/toAddFuncItem',
		Drag:false,
		Height:150,
		Width:400
	});
}

</script>