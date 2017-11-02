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

		<form action="/dept/register" method="post">

			<div class="form-group">
				<label>부서 번호</label> 
				<p class="help-block">부서 번호를 입력하세요(숫자만 입력가능)</p>
				<input class="form-control" name="deptno" value="${vo.deptno}" />
			</div>

			<div class="form-group">
				<label>부서 이름</label>
				<textarea class="form-control" name='dname'>${vo.dname}</textarea>
			</div>

			<div class="form-group">
				<label>지역</label> 
				<input class="form-control" name="loc" value="${vo.loc}" />
			</div>
			<button type="submit" class="btn btn-default">Submit Button</button>
			<button type="reset" class="btn btn-primary">Reset Button</button>
		</form>

	</div>

</body>
</html>