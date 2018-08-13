<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>vetselect_view.jsp</title>
</head>
<body>
<table width="600">
<tr>
	<td colspan="3">수의사 전공별 열람</td>
</tr>
<tr>
	<form action="vetselect" method="get">
	<td>vetselect</td>
	<td>
	   <select name="specialty_id" >         
	     <c:forEach items="${vetselect_view}" var="dto">
	       <option value="${dto.id}"> ${dto.name} </option>
	     </c:forEach>
	   </select>
	 </td>
	 <td> <input type="submit" value="전공검색"></td>
	 </form>
</tr>
<tr>
	<form action="vetselect3" method="get">
	<td>vetselect3</td>
	<td>
	   <select name="specialty_id" >         
	     <c:forEach items="${vetselect_view}" var="dto2">
	       <option value="${dto2.id}"> ${dto2.name} </option>
	     </c:forEach>
	   </select>
	 </td>
	 <td> <input type="submit" value="전공검색"></td>
	 </form>
</tr>

</table>

</body>
</html>