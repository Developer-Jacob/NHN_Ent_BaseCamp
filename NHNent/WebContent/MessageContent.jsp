<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.MessageDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MessageDTO msg = (MessageDTO)request.getAttribute("msg");
		%>
	<table border="5" width="500" >
		<tr align="center">
			<td colspan="2">내용</td>
		</tr>
		<tr align="center">
			<td>글번호</td>
			<td><%=msg.getIdx() %></td>
		</tr>
		<tr align="center">
			<td>이름</td>
			<td><%=msg.getUser() %></td>
		</tr>
		<tr align="center">
			<td>작성일</td>
			<td><%=msg.getTime() %></td>
		</tr>
		<tr align="center">
			<td>제목</td>
			<td><%=msg.getTitle() %></td>
		</tr>
		<tr align="center" height="300">
			<td colspan="2"><%=msg.getContents() %></td>
		</tr>
	</table>
	<table >
		<tr>
			<td><input type = "button" value="수정" onclick="location.href='modifyForm.do?idx=<%=msg.getIdx() %>'"></td>
			<td><input type = "button" value="삭제" onclick="location.href='update.do'"></td>
			<td ><input type = "button" value="목록" onclick="location.href='list.do'"></td>
		</tr>
	</table>
</body>
</html>