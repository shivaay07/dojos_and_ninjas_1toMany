<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/new/ninja" method="post" modelAttribute="ninja">
		<p>
			<form:label path="dojo">Dojo:</form:label>
			<form:errors path="dojo"/>
			<form:select path="dojo">
				<c:forEach items="${newDojos}" var="nD">
					<form:option value="${nD.id}"><c:out value="${nD.name}"/></form:option>
				</c:forEach>
			</form:select>		
		</p>
		<p>
			<form:label path="firstName">First Name:</form:label>
			<form:errors path="firstName"/>
			<form:input path="firstName"/>	
		</p>
		<p>
			<form:label path="lastName">Last Name:</form:label>
			<form:errors path="lastName"/>
			<form:input path="lastName"/>	
		</p>
		<p>
			<form:label path="age">Age:</form:label>
			<form:errors path="age"/>
			<form:input type= "number" path="age"/>	
		</p>
		<input type="submit" value="Create"/>
	</form:form>
	<c:forEach items="${allNinjas}" var="aN">
		<ul>
			<li>"${aN.dojo.name}"</li>
			<li>"${aN.firstName}"</li>
			<li>"${aN.lastName}"</li>
			<li>"${aN.age}"</li>
		</ul>		
	</c:forEach>
</body>
</html>