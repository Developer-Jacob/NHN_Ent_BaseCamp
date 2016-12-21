<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Input Form</title>
</head>
<body>
 	<form action="input" method="post">
 	<p>
 	Email address:	<input type="text" name="user" value="${param.user}">
 	</p>
 	Password:		<input type="password" name="password" value="${param.password}">
 	<p>
 	Contents
 	</p>
 	<p>
 	<textarea name="content" rows="20" cols="30" >${param.password}</textarea>
 	</p>
 	<input type="submit" value="ok">
 	</form>
</body>
</html>