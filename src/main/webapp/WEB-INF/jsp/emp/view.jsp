<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view.jsp</title>

<c:if test="${false}">
<link rel="stylesheet" href="../../css/bootstrap.css">
<link rel="stylesheet" href="../../css/animate.css">
</c:if>
</head>
<body>
	<div class="panel-heading">View Page</div>
	<div class="panel-body">

		<div class="form-group">
			<label>사원 번호</label> 
			<input class="form-control" name="empno" value="${vo.empno}" readonly="readonly" />
		</div>

		<div class="form-group">
			<label>사원명</label> 
			<input class="form-control" name="ename" value="${vo.ename}" readonly="readonly" />
		</div>

		<div class="form-group">
			<label>성별</label>
			<textarea class="form-control" name='gender' readonly="readonly">${vo.gender.name() == 'M' ? '남자' : '여자'}</textarea>
		</div>
		
		<div class="form-group">
			<label>직급</label> 
			<input class="form-control" name="job" value="${vo.job}" readonly="readonly" />
		</div>
		
		<div class="form-group">
			<label>매니저</label> 
			<input class="form-control" name="mgr" value="${vo.mgr == null ? '없음' : vo.mgr.ename}" readonly="readonly" />
		</div>
		
		<div class="form-group">
			<label>입사일</label> 
			<input class="form-control" name="hiredate" value="${vo.hiredate}" readonly="readonly" />
		</div>
		
		<div class="form-group">
			<label>월급</label> 
			<input class="form-control" name="sal" value="${vo.sal}" readonly="readonly" />
		</div>
		
		<div class="form-group">
			<label>상여급</label>
			<input class="form-control" name="comm" value="${vo.comm}" readonly="readonly" />
		</div>
		
		<div class="form-group">
			<label>부서 번호</label>
			<input class="form-control" name="dept" value="${vo.dept.deptno}" readonly="readonly" />
		</div>	

		<div class="pull-right">
			<a href="/emp/modify?page=${pageVO.page}&size=${pageVO.size}&type=${pageVO.type}&keyword=${pageVO.keyword}&empno=${vo.empno}" class="btn btn-default">Modify/Delete</a> 
			<a href="/emp/list?page=${pageVO.page}&size=${pageVO.size}&type=${pageVO.type}&keyword=${pageVO.keyword}&empno=${vo.empno}" class="btn btn-primary">Go List</a> 
		</div>

	</div>

</body>
</html>

