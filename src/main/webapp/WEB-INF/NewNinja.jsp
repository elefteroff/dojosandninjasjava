<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <div class="container">
	   <h3>New Ninja</h3>
		<form:form method="post" action="/newNinja" modelAttribute="ninja">
		<form:errors path="*" />
				<p>Dojo:</p>
				<form:select path="dojo">
					<c:forEach var="i" items="${dojo }">
						<option value="${i.id }">${i.dojoName }</option>
					</c:forEach>
				</form:select>
		
			<p>
				First Name:
				<form:input path="firstName"/>
			</p>
			<p>
				Last Name:
				<form:input path="lastName"/>
			</p>
			<p>
				Age:
				<form:input type="number" path="age"/>
			</p>
			<button>Create</button>
		</form:form>
	</div>
</body>
</html>

