<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.css"/>" />

<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Formulaire ajout/Edit</h1>
	<form:form method="POST" action="soumettreFormAjout" commandName="adminForm">
		<table>

<tr>
	<td>${adminForm.id}</td>
				<td><form:input path="id" type="hidden" /></td>

			</tr>
			<tr>
				<td><form:label path="nom">Nom: </form:label></td>
				<td><form:input path="nom" /></td>
				<td><form:errors path="nom" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td><form:label path="password">Password: </form:label></td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" cssStyle="color:red"/></td>
			</tr>


			<tr>
				<td><input type="submit" value="ajouter" /></td>
			</tr>


		</table>
	</form:form>
</body>
</html>