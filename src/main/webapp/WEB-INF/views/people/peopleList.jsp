<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PeopleList</title>
</head>
<body>

<main class="container mt-5">
	<h4>회원 목록 조회</h4>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>주소</th>				
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty peopleList }">
				<tr>
					<td colspan="4">회원이 존재하지 않습니다</td>
				</tr>
			</c:if>
			<c:if test="${not empty peopleList }">
				<c:forEach items="${peopleList }" var="people">
				<c:url value="/people/detail" var="detailURL">
					<c:param name="who" value="${people.id }"></c:param>
				</c:url>
					<tr>
						<td>
							<a href="${detailURL }">${people.name }</a>
						</td>
						<td>${people.gender }</td>
						<td>${people.age }</td>
						<td>${people.address }</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	
</main>

</body>
</html>