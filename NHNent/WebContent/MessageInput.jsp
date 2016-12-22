<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function formCheck() {
		var user = document.forms[0].user.value;
		var password = document.forms[0].password.value;
		var title = document.forms[0].title.value;
		var content = document.forms[0].content.value;
		if (user == null || user == "") {
			alert("이메일을 입력하세요.");
			document.forms[0].user.focus();
			return false;
		}
		if (password == null || password == "") {
			alert("비밀번호를 입력하세요.");
			document.forms[0].user.focus();
			return false;
		}
		if (title == null || title == "") {
			alert("제목을 입력하세요.");
			document.forms[0].user.focus();
			return false;
		}
		if (content == null || content == "") {
			alert("내용을 입력하세요.");
			document.forms[0].user.focus();
			return false;
		}
	}
</script>
<title>Input Form</title>
</head>
<body>
	<form action=complete.do method="post" onsubmit="return formCheck()">
		<p>
			Email address : <input type="text" name="user" value="${param.user}">
		</p>
		Password : <input type="password" name="password"
			value="${param.password}">
		<p>
			Title : <input type="text" name="title" ${param.title}>
		</p>
		<p>Contents</p>
		<p>
			<textarea name="content" rows="20" cols="30">${param.content}</textarea>
		</p>
		<input type="submit" value="ok">
	</form>

</body>
</html>