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

		<form action="/emp/register" method="post">

			<div class="form-group">
				<label>사원 번호</label> 
				<p class="help-block">사원 번호를 입력하세요(숫자만 입력가능)</p>
				<input class="form-control" name="empno" value="${vo.empno}" />
			</div>

			<div class="form-group">
				<label>사원 이름</label>
				<textarea class="form-control" name='ename'>${vo.ename}</textarea>
			</div>

			<div class="form-group">
				<label>성별</label>
				<p class="help-block">성별을 입력하세요(M, F만 입력가능)</p>
				<textarea class="form-control" name='gender'>${vo.gender}</textarea>
			</div>
			
			<div class="form-group">
				<label>직급</label> 
				<input class="form-control" name="job"	value="${vo.job}" />
			</div>
			
			<div class="form-group">
				<label>매니저</label> <input class="form-control" name="mgr"
					value="${vo.mgr == null ? '없음' : vo.mgr.ename}"/>
			</div>
			
			<div class="form-group">
				<label>입사일</label> 
				<p class="help-block">형식(mm/dd/yyyy)</p>
				<input class="form-control" name="hiredate"
					value="${vo.hiredate}" />
			</div>
			
			<div class="form-group">
				<label>월급</label> <input class="form-control" name="sal"
					value="${vo.sal}" />
			</div>
			
			<div class="form-group">
				<label>상여금</label> <input class="form-control" name="comm"
					value="${vo.comm}" />
			</div>
			
			<div class="form-group">
				<label>부서번호</label><input class="form-control" name="dept"
					value="${vo.dept}"/>
			</div>		
			
			<button type="submit" class="btn btn-default">Submit Button</button>
			<button type="reset" class="btn btn-primary">Reset Button</button>
		</form>

	</div>

</body>
</html>