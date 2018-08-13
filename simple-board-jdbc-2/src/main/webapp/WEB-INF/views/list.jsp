<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List.jsp</title>
</head>
<body>

<table width="600" cellpadding="0" cellspacing="0" border="1">

<tr>
	<td>번호</td>
	<td>이름</td>
	<td>내용</td>
	<td>삭제</td>
</tr>

<c:forEach items="${list}" var="dto">
	<tr>
		<td>${dto.bId}</td>
		<td>${dto.bName}</td>
		<td>${dto.bContent}</td>
		<td><a href="delete?bId=${dto.bId}">삭제</a>	</td>
	</tr>
</c:forEach>

<tr>
	<td colspan="5"><a href="write_view">글작성</a></td>
</tr>

</table>
</body>
</html>