<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="model.MessageDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MessageList</title>
</head>
<body>
	<table border="1">
		<tr align="center" height="20">
			<td width="70">번호</td>
			<td width="100">제목</td>
			<td width="100">작성자</td>
			<td width="100">시간</td>
		</tr>
		<%
		ArrayList<MessageDTO> list = (ArrayList<MessageDTO>)request.getAttribute("list");
		if(list!=null){
					for(MessageDTO dto : list){
		%>
		<tr align="center">
			<td><%=dto.getId() %></td>
			<td ><%=dto.getTitle() %></td>
			<td><%=dto.getUser()%></td>
			<td><%=dto.getTime()%></td>
		</tr>
		<%
					}
		}
	%>
	</table>
	<p>
		<input type = "button" value="글쓰기" onclick="location.href='input.do'">
	</p>
</body>
</html>