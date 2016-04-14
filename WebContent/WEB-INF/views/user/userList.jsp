<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base>
<script type="text/javascript">
	$(function() {
		pagination();
	});

	function pagination() {
		$("#pagediv").myPagination({
			currPage : 1,
			pageCount : $("#pageCount").val(),
			pageSize : $("#pageNumber").val(),
			cssStyle : "grayr",
			ajax : {
				on : true,
				callback : "ajaxCallBack",
				url : "${pageContext.request.contextPath}/user/queryUserList",
				dataType : "json",
				param : {
					on : true,
					page : 1,
					pageSize : 2
				}
			}
		});
	}

	function ajaxCallBack(data) {
		alert(data);
		var result = data.resultList;
		$("#pageCount").val(data.pageCount);
		$("#pageNumber").val(data.pageNumber);
		var insetViewData = "";
		$.each(result, function(index, items) {
			//alert(items.id);  
			insetViewData += createTR(items);
		});
		$("table > tbody").html(insetViewData);
	}

	function createTR(obj) {
		var tr = "<tr>";
		tr += "<td>" + obj.userName + "</td>";
		tr += "<td>" + obj.realName + "</td>";
		tr += "<td>" + obj.telephone + "</td>";
		tr += "<td>删除&nbsp;修改</td>";
		tr += "</tr>";
		return tr;
	}
</script>
</head>
<body>
	<table width="100%" border="1px solid" cellspacing="0">
		<thead>
			<tr class="right-nav">
				<td>用户</td>
				<td>姓名</td>
				<td>手机号</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<div id="pagediv"></div>
	<input type="hidden" id="pageCount" value="" />
	<input type="hidden" id="pageNumber" value="" />
</body>