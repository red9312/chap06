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
			<label>ID</label> 
			<input class="form-control" name="id" value="${vo.id}" readonly="readonly" />
		</div>

		<div class="form-group">
			<label>지역 이름</label> 
			<input class="form-control" name="name" value="${vo.name}" />
			<p class="help-block">name text here.</p>
		</div>

		<div class="form-group">
			<label>행정 구역</label>
			<textarea class="form-control"  name='district'>${vo.district}</textarea>
			<p class="help-block">district text here.</p>
		</div>
		
		<div class="form-group">
			<label>인구</label> 
			<input class="form-control" name="population" value="${vo.population}" />
			<p class="help-block">name text here.(숫자만 입력가능)</p>
		</div>
		
		<div class="form-group">
			<label>국가 코드</label> 
			<input class="form-control" name="country" value="${vo.country.code}" />
			<p class="help-block">name text here.</p>
		</div>
		
		<input type='hidden' name="page" value="${pageVO.page}">
		<input type='hidden' name="size" value="${pageVO.size}">
		<input type='hidden' name="type" value="${pageVO.type}">
		<input type='hidden' name="keyword" value="${pageVO.keyword}">
		
		</form>

		<div class="pull-right">
		
		  <a href="#" class="btn btn-warning modbtn">Modify</a>
		  <a href="#" class="btn btn-danger delbtn">Delete</a>
		  <a href="/city/list?page=${pageVO.page}&size=${pageVO.size}&type=${pageVO.type}&keyword=${pageVO.keyword}&id=${city.id}" 
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