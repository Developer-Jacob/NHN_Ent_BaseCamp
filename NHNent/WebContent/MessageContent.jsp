<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.MessageDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function deleteMessage(idx,psw) {
		var inputPsw = prompt("비밀번호를 입력하세요");
		if(psw != inputPsw){
			alert("비밀번호가 틀렸습니다.")
		}else{
			location.replace("delete.do");
			alert("삭제 됐습니다.");
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="5" width="500">
		<tr align="center">
			<td colspan="2">내용</td>
		</tr>
		<tr align="center">
			<td>글번호</td>
			<td>${msg.idx}</td>
		</tr>
		<tr align="center">
			<td>이름</td>
			<td>${msg.user}</td>
		</tr>
		<tr align="center">
			<td>작성일</td>
			<td>${msg.time}</td>
		</tr>
		<tr align="center">
			<td>제목</td>
			<td>${msg.title}</td>
		</tr>
		<tr align="center" height="300">
			<td colspan="2">${msg.content} </td>
		</tr>
	</table>
	<table>
		<tr>
			<td><input type="button" value="수정"
				onclick="location.href='modifyForm.do?idx=${msg.idx}'"></td>
			<td><input type="button" value="삭제" onclick="deleteMessage('${msg.idx},${msg.password}')"></td>
			<td><input type="button" value="목록" onclick="location.replace('list.do')"></td>
		</tr>
	</table>
</body>
</html>