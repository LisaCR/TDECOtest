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
	<form:form method="POST" action="soumettreFormAjout" commandName="categorieForm">
		<table>

<tr>
	<td>${categorieForm.idCategorie}</td>
				<td><form:input path="idCategorie" type="hidden" /></td>

			<tr>
				<td><form:label path="nomCategorie">Description: </form:label></td>
				<td><form:input path="nomCategorie" /></td>
				<td><form:errors path="nomCategorie" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td><form:label path="description">Quantité: </form:label></td>
				<td><form:input path="description" /></td>
				<td><form:errors path="description" cssStyle="color:red"/></td>
			</tr>
<%--  			<tr>
				<td><form:label path="categorie">Catégorie: </form:label></td>
				<td><form:input path="categorie" /></td>
				<td><form:errors path="categorie" cssStyle="color:red"/></td>

			</tr> --%>


			<tr>
				<td><input type="submit" value="ajouter" /></td>
			</tr>


		</table>
	</form:form>
</body>
</html>