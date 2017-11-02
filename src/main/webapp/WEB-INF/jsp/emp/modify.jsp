<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify.jsp</title>

<c:if test="${false}">
<link rel="stylesheet" href="../../css/bootstrap.css">
<link rel="stylesheet" href="../../css/animate.css">
</c:if>
</head>
<body>
	<div class="panel-heading">Modify Page</div>
	<div class="panel-body">

    <form id='f1'>

		<div class="form-group">
			<label>사원 번호</label> 
			<input class="form-control" name="empno" value="${vo.empno}" readonly="readonly" />
		</div>

		<div class="form-group">
			<label>사원명</label> 
			<input class="form-control" name="ename" value="${vo.ename}" />
			<p class="help-block">ename text here.</p>
		</div>

		<div class="form-group">
			<label>성별</label>
			<input class="form-control" name="gender" value="${vo.gender.name()}" readonly="readonly"/>
		</div>
		
		<div class="form-group">
			<label>직급</label> <input class="form-control" name="job"
				value="${vo.job}" />
		</div>
		
		<div class="form-group">
			<label>입사일</label> <input class="form-control" name="hiredate" value=<fmt:formatDate value="${vo.hiredate}" pattern="MM/dd/yyyy"/> readonly="readonly" ></input>
		</div>

		<div class="form-group">
			<label>매니저</label>
			<input class="form-control" name="mgr" value="${vo.mgr == null ? '없음' : vo.mgr.ename}" />
			<p class="help-block">해당 매니저의 사원 번호 입력</p>
		</div>
		
		<div class="form-group">
			<label>월급</label> <input class="form-control" name="sal"
				value="${vo.sal}" />
		</div>
		
		<div class="form-group">
			<label>상여급</label> <input class="form-control" name="comm"
				value="${vo.comm}"/>
		</div>
		
		<div class="form-group">
			<label>부서 번호</label> <input class="form-control" name="dept"
				value="${vo.dept.deptno}"/>
		</div>
		
		<input type='hidden' name="page" value="${pageVO.page}">
		<input type='hidden' name="size" value="${pageVO.size}">
		<input type='hidden' name="type" value="${pageVO.type}">
		<input type='hidden' name="keyword" value="${pageVO.keyword}">
		
		</form>

		<div class="pull-right">
		
		  <a href="#" class="btn btn-warning modbtn">Modify</a>
		  <a href="#" class="btn btn-danger delbtn">Delete</a>
		  <a href="/emp/list?page=${pageVO.page}&size=${pageVO.size}&type=${pageVO.type}&keyword=${pageVO.keyword}&empno=${emp.empno}" 
		  	  class="btn btn-primary">Cancel & Go List</a> 
		</div>

	</div>

	<script type="text/javascript">
	$(document).ready(function(){
	
		var formObj = $("#f1");
		
		$(".delbtn").click(function(){
			
			formObj.attr("action","delete");
			formObj.attr("method", "post");
			
			formObj.submit();
		});
		
		$(".modbtn").click(function(){
			
			formObj.attr("action","modify");
			formObj.attr("method", "post");
			
			formObj.submit();
		});
		
	});	
	</script>


</body>
</html>