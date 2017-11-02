<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register.jsp</title>

<c:if test="${false}">
<link rel="stylesheet" href="../../css/bootstrap.css">
<link rel="stylesheet" href="../../css/animate.css">
</c:if>
</head>
<body>
	<div class="panel-heading">Register Page</div>
	<div class="panel-body">

		<form action="/city/register" method="post">

			<div class="form-group">
				<label>ID</label> 
				<p class="help-block">ID를 입력하세요(숫자만 입력가능), 기존에 있던 ID 입력 불가능(기본키임)</p>
				<input class="form-control" name="id" value="${vo.id}" />
			</div>

			<div class="form-group">
				<label>도시 이름</label>
				<p class="help-block">도시이름을 입력하세요</p>
				<textarea class="form-control" name='name'>${vo.name}</textarea>
			</div>

			<div class="form-group">
				<label>행정 구역</label>
				<p class="help-block">행정구역을 입력하세요</p>
				<input class="form-control" name="district" value="${vo.district}" />
			</div>
			
			<div class="form-group">
				<label>인구</label>
				<p class="help-block">인구를 입력하세요(숫자만 입력가능)</p>
				<input class="form-control" name="population" value="${vo.population}" />
			</div>
			
			<div class="form-group">
				<label>국가 코드</label>
				<p class="help-block">국가 코드를 입력하세요(단, 국가코드가 country테이블에 존재해야하고, 영어 대문자 3개로 이뤄짐)</p>
				<input class="form-control" name="country" value="${vo.country}" />
			</div>
			
			<button type="submit" class="btn btn-default">Submit Button</button>
			<button type="reset" class="btn btn-primary">Reset Button</button>
		</form>

	</div>

</body>
</html>