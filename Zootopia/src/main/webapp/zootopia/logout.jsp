<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.invalidate();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<script type="text/javascript">
alert("로그아웃에 성공하였습니다.");
location.href="login.jsp";
</script>
</body>
</html>