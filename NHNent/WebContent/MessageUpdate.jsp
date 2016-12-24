<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.MessageDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function formCheck(psw) {
		
		var password = document.forms[0].password.value;
		var title = document.forms[0].title.value;
		var content = document.forms[0].content.value;
		if (password == null || password == "") {
			alert("비밀번호를 입력하세요.");
			document.forms[0].password.focus();
			return false ;
		}
		if (password != psw) {
			alert("비밀번호가 틀렸습니다.");
			document.forms[0].password.clear();
			document.forms[0].password.focus();
			return false ;
		}
		if (title == null || title == "") {
			alert("제목을 입력하세요.");
			document.forms[0].title.focus();
			return false ;
		}
		if (content == null || content == "") {
			alert("내용을 입력하세요.");
			document.forms[0].content.focus();
			return false ;
		}
		alert("수정 되었습니다.");
	}
</script>
</head>
<body>
	<%
				MessageDTO msg = (MessageDTO) request.getAttribute("msg");
	%>
	<form action=update.do method="post" onsubmit="return formCheck('<%=msg.getPassword()%>')">
	<input type="hidden" name="idx" value=<%=msg.getIdx()%>>
		<table border="5" width="500">
			<tr align="center">
				<td colspan="2">수정</td>
			</tr>
			<tr align="center">
				<td>글번호</td>
				<td><%=msg.getIdx()%></td>
			</tr>
			<tr align="center">
				<td>이름</td>
				<td><%=msg.getUser()%></td>
			</tr>

			<tr align="center">
				<td>제목</td>
				<td><input style="width: 97%; height: 100%;" type="text"
					name="title" value="${param.title}"></td>
			</tr>
			<tr align="center">
				<td>비밀번호</td>
				<td><input style="width: 97%; height: 100%;" type="password"
					name="password"></td>
			</tr>
			<tr align="center">
				<td height="300" colspan="2"><textarea
						style="width: 98%; height: 100%" name="content">${param.content}</textarea></td>
			</tr>
		</table>
		<p>
			<input type="submit" value="수정" >
			<input type="button" value="취소" onclick="location.href='list.do'">
		</p>
	</form>
</body>
</html>