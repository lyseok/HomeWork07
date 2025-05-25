<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>peopleDetail</title>
</head>
<body>

	<main class="container mt-5">
		<h4>회원 정보 등록</h4>

		<div class="card">
			<div class="card-header">
				<h5>Form controls</h5>
			</div>
			<div class="card-body">
				<div class="row">

					<form method="post" enctype="application/x-www-form-urlencoded">

						<div class="form-group">
							<label class="form-label" for="id">ID</label><input type="text"
								id="id" name="id" class="form-control" placeholder="ID" required
								value="${person.id }">
						</div>
						<span class="text-danger">${errors.id }</span>
						
						<div class="form-group">
							<label class="form-label" for="name">이름</label><input type="text"
								id="name" name="name" class="form-control" placeholder="이름"
								required value="${person.name }">
						</div>
						<span class="text-danger">${errors.name }</span>
						
						<div class="form-group">
							<label class="form-label" for="gender">성별</label>
							<select 
								id="gender" name="gender" class="form-control"
								required value="${person.gender }">
								<option value="M">Male</option>
								<option value="F">Female</option>
							</select>
						</div>
						<span class="text-danger">${errors.gender }</span>
						
						<div class="form-group">
							<label class="form-label" for="age">나이</label><input
								type="number" id="age" name="age" class="form-control"
								placeholder="나이" required value="${person.age }">
						</div>
						<span class="text-danger">${errors.age }</span>
						
						<div class="form-group">
							<label class="form-label" for="address">주소</label><input
								type="text" id="address" name="address" class="form-control"
								placeholder="주소" required value="${person.address }">
						</div>
						<span class="text-danger">${errors.address }</span>
						
						<div>
							<button type="submit" class="btn btn-primary mb-4">Submit</button>
							<button type="reset" class="btn btn-danger mb-4">Reset</button>
						</div>

					</form>

				</div>
			</div>
		</div>

	</main>

</body>
</html>