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
		if (!user.match("^(\w+)@(\w+)[.](\w+)$")) {
			alert("이메일 형식을 확인하세요.");
			document.forms[0].user.focus();
			return false;
		}
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
	<form action=insert.do method="post" onsubmit="return formCheck()">
		<table border="5" width="500">
			<tr align="center">
				<td colspan="2">글쓰기</td>
			</tr>
			<tr align="center">
				<td>이메일주소</td>
				<td><input style="width: 97%; height: 100%" type="text"
					name="user" ></td>
			</tr>
			<tr align="center">
				<td>비밀번호</td>
				<td><input style="width: 97%; height: 100%" type="password"
					name="password" ></td>
			</tr>
			<tr align="center"> 
				<td>제목</td>
				<td><input style="width: 97%; height: 100%;" type="text"
					name="title" ></td>
			</tr>
			<tr align="center">
				<td height="300" colspan="2"><textarea
						style="width: 98%; height: 100%" name="content"></textarea></td>
			</tr>
		</table>
		<p>
			<input type="submit" value="등록">
		</p>
	</form>

</body>
</html>