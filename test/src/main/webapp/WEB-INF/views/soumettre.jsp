<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajout de la taglib form de spring  -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">Formulaire d'ajout du client</h1>

	<form:form method="POST" action="soumettreForm"
		commandName="clientForm">
		<!-- commandName ou  modelAttribute -->
		<table>
			<tr>
				<td><form:label path="nom">Nom: </form:label></td>
				<td><form:input path="nom"/></td>
			</tr>
			<tr>
				<td><form:label path="prenom">Prenom: </form:label></td>
				<td><form:input path="prenom"/></td>
			</tr>
			<tr>
				<td><form:label path="age">Age: </form:label></td>
				<td><form:input path="age"/></td>
			</tr>
			<tr>
				<td><form:label path="mail">Mail: </form:label></td>
				<td><form:input path="mail"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="value"/></td>
			</tr>
		</table>
	</form:form>

</body>
</html>