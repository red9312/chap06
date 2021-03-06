<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="sitemesh" tagdir="/WEB-INF/tags/sitemesh"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><sitemesh:write property="title" /></title>
<link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.css">
<link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap-theme.css">
<link rel="stylesheet" href="/webjars/animate.css/3.5.2/animate.css">

<script type="text/javascript" src="/webjars/jquery/1.11.1/jquery.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/3.3.7/js/bootstrap.js"></script>

<script type="text/javascript" src="/webjars/chartjs/2.6.0/Chart.bundle.js"></script>
<sitemesh:write property="head" />

<c:if test="${false}">
   <link rel="stylesheet" href="../css/animate.css">
   <link rel="stylesheet" href="../css/bootstrap.css">
</c:if>

</head>
<body class="container">
   <header class="page-header">
		<h1>
       	###Web Project <small>for Spring MVC + JPA (jsp)</small>
		</h1>
   </header>

	<div class="panel-body pull-right">
		<h3>
			<a class="label label-default " href="/boards/list">Thymeleaf</a>
			<a class="label label-default " href="/board/list">jsp</a>
		</h3>
	</div>

	<div>
	   <table class="table table-striped table-bordered table-hover" id="dataTables-example">
         <thead>
            <tr>
               <th><a href="http://localhost:8080/board/list">Board</a></th>
               <th><a href="http://localhost:8080/city/list">City</a></th>
               <th><a href="http://localhost:8080/country/list">Country</a></th>
               <th><a href="http://localhost:8080/dept/list">Dept</a></th>
               <th><a href="http://localhost:8080/emp/list">Emp</a></th>
            </tr>
         </thead>
      </table>
	</div>
	
   <section class="panel panel-default">
         <sitemesh:write property="body" />
   </section>

   <footer><center><p>&copy; 2017.CBH.Table<p></footer>

</body>
</html>