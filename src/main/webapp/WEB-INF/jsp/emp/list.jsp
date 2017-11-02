<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>

<!-- list xxx -->
<c:if test="${false}">
	<link rel="stylesheet" href="../../css/bootstrap.css">
	<link rel="stylesheet" href="../../css/animate.css">
</c:if>
</head>
<body>
	<div class="panel-heading ">List Page</div>

	<div class="panel-body pull-right">
		<h3>
			<a class="label label-default " href="/emp/register">Register</a>
		</h3>
	</div>

	<div class="panel-body">
		<c:set var="result" value="${pageMaker.result}" />
		<div>
			<table class="table table-striped table-bordered table-hover"
				id="dataTables-example">
				<thead>
					<tr>
						<th>empno</th>
						<th>ename</th>
						<th>gender</th>
						<th>job</th>
						<th>mgr</th>
						<th>hiredate</th>
						<th>sal</th>
						<th>comm</th>
						<th>deptno</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="emp" items="${result.content}">
						<tr class="odd gradeX">
							<td>${emp.empno}</td>
							<td><a href='${emp.empno}' class='empLink'>${emp.ename}</a></td>
							<td>
							<c:choose>
								<c:when test="${emp.gender.name()=='M'}">남자</c:when>
								<c:when test="${emp.gender.name()=='F'}">여자</c:when>
							</c:choose>
							</td>
							<td>${emp.job}</td>
							<td>${emp.mgr.ename != null ? emp.mgr.ename : '없음'}</td>
<%-- 							<c:if test="${emp.mgr==null}"> --%>
<!-- 								<td class="btn btn-info">없음</td> -->
<%-- 							</c:if> --%>
<%-- 							<c:if test="${emp.mgr!=null}"> --%>
<%-- 								<td class="btn btn-primary">${emp.mgr.ename}</td> --%>
<%-- 							</c:if> --%>
							<td>${emp.hiredate}</td>
<%-- 							<td><fmt:formatDate value="${emp.hiredate}" pattern="yyyy MM dd"/></td> --%>
<%-- 							<td>${emp.sal}</td> --%>
							<td><fmt:formatNumber value="${emp.sal}" pattern="#,###.00"></fmt:formatNumber></td>
							<td>${emp.comm}</td>
							<td>${emp.dept.deptno}</td>
							</tr>
					</c:forEach>
				</tbody>
			</table>

			<div>
				<select id='searchType'>
					<option>--</option>
					<option value='eno' ${pageVO.type =='eno' ? 'selected' : ''}>empno</option>
					<option value='n' ${pageVO.type =='n' ? 'selected' : ''}>ename</option>
					<option value='dno' ${pageVO.type =='dno' ? 'selected' : ''}>dno</option>
				</select> <input type='text' id='searchKeyword' value="${pageVO.keyword}">
				<button id='searchBtn'>Search</button>
			</div>

		</div>

		<nav>

			<div>

				<ul class="pagination">
					<c:if test="${pageMaker.prevPage != null}">
						<li class="page-item">
							<a href="${pageMaker.prevPage.pageNumber + 1}">
								 PREV ${pageMaker.prevPage.pageNumber + 1}
							</a>
						</li>
					</c:if>
					
					<c:forEach var="p" items="${pageMaker.pageList}">
						<li class="page-item ${p.pageNumber == pageMaker.currentPageNum -1 ? 'active' : ''} ">
							<a href="${p.pageNumber +1} ">${p.pageNumber+1} </a>
						</li>
					</c:forEach>

					<c:if test="${pageMaker.nextPage != null}">
					<li class="page-item">
						<a	href="${pageMaker.nextPage.pageNumber + 1} ">
						 	NEXT ${pageMaker.nextPage.pageNumber + 1} 
						</a>
					</li>
					</c:if>
				</ul>
			</div>
		</nav>

	</div>
	
	<form id='f1' action="/emp/list" method="get">
      <input type='hidden' name='page' value="${pageMaker.currentPageNum}">
      <input type='hidden' name='size' value="${pageMaker.currentPage.pageSize}">
      <input type='hidden' name='type' value="${pageVO.type}">
      <input type='hidden' name='keyword' value="${pageVO.keyword}">
   </form>
   
     <script type="text/javascript">
   
      $(window).load(function(){
         
         var msg = "${msg}";
         
         if(msg =='success') {
            alert("정상적으로 처리되었습니다.");
            var stateObj = { msg: "" };
         }

      });
   
      $(document).ready(function() {
         var formObj = $("#f1");

         $(".pagination a").click(function(e) {

            e.preventDefault();

            formObj.find('[name="page"]').val($(this).attr('href'));

            formObj.submit();
         });
         
         $(".empLink").click(function(e){
            
            e.preventDefault(); 
            
            var empNo = $(this).attr("href");
            
            formObj.attr("action", "/emp/view");
            formObj.append("<input type='hidden' name='empno' value='" + empNo +"'>" );
            
            formObj.submit();
            
         });
         
         $("#searchBtn").click(function(e){
            
            var typeStr = $("#searchType").find(":selected").val();
            var keywordStr = $("#searchKeyword").val();
            
            console.log(typeStr, "" , keywordStr);
            
            formObj.find("[name='type']").val(typeStr);
            formObj.find("[name='keyword']").val(keywordStr);
            formObj.find("[name='page']").val("1");
            formObj.submit();
         });

      });
   </script>

</body>
</html>