<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<%
	pageContext.setAttribute("newLine", "\n");
%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/add" method="post">
		<table border="1" width="500">
			<tr>
				<td>Name</td><td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Content</td><td colspan=2><textarea name="content" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=2 align=right><input type="submit" VALUE=" Write "></td>
			</tr>
		</table>
	</form>
	<br>
	
	<c:set var="count" value="${fn:length(list)}" />
	<c:forEach items="${list }" var="vo" varStatus="status" >
		<table width="510" border="1">
			<tr>
				<td>[${count - status.index}]</td>
				<td>${vo.name }</td>
				<td>${vo.regDate }</td>
				<td><a href="/del?idx=${vo.idx }">삭제</a></td>
			</tr>
			<tr>
				<td>${fn:replace(vo.content, newLine, "<br>") }</td>
			</tr>
		</table>
		<br>
	</c:forEach>
</body>
</html>