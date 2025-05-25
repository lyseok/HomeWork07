<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>peopleDetail</title>
</head>
<body>

<main class="container mt-5">
	<h4>회원 정보 조회</h4>
	<table class="table table-bordered">
		<tr>
			<th>아이디</th>
			<td>${person.id}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${person.name}</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>${person.gender}</td>
		</tr>
		<tr>
			<th>나이</th>
			<td>${person.age}</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${person.address}</td>
		</tr>
	</table>
	<c:url value="/people/edit" var="editURL">
		<c:param name="who" value="${person.id }"></c:param>
	</c:url>
	<a href="${editURL }">회원 정보 수정</a><br />
	<c:url value="/people/delete" var="deleteURL">
		<c:param name="who" value="${person.id }"></c:param>
	</c:url>
	<a href="${deleteURL }">회원 정보 삭제</a>
</main>

</body>
</html>