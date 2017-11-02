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
			<label>부서 번호</label> 
			<input class="form-control" name="deptno" value="${vo.deptno}" readonly="readonly" />
		</div>

		<div class="form-group">
			<label>부서명</label> 
			<input class="form-control" name="dname" value="${vo.dname}" readonly="readonly" />
		</div>

		<div class="form-group">
			<label>지역</label>
			<textarea class="form-control" name='loc' readonly="readonly">${vo.loc}</textarea>
		</div>

		<div class="pull-right">
			<a href="/dept/modify?page=${pageVO.page}&size=${pageVO.size}&type=${pageVO.type}&keyword=${pageVO.keyword}&deptno=${vo.deptno}" class="btn btn-default">Modify/Delete</a> 
			<a href="/dept/list?page=${pageVO.page}&size=${pageVO.size}&type=${pageVO.type}&keyword=${pageVO.keyword}&deptno=${vo.deptno}" class="btn btn-primary">Go List</a> 
		</div>

	</div>

</body>
</html>

