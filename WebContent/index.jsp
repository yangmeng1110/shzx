<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
		<form action="${pageContext.request.contextPath}/login.jsp" name="MAINFORM" method="POST">
		</form>
	</body>
	<script type="text/javascript">
	if(window.parent){
		document.MAINFORM.target = "_parent";
	}
	document.MAINFORM.submit();
	</script>
</html>
